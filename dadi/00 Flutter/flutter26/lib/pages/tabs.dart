import 'package:flutter/material.dart';
import './tabs/home.dart';
import './tabs/category.dart';
import './tabs/message.dart';
import './tabs/setting.dart';
import './tabs/user.dart';

class Tabs extends StatefulWidget {
  const Tabs({super.key});

  @override
  State<Tabs> createState() => _TabsState();
}

class _TabsState extends State<Tabs> {
  int _currentIndex = 0;
  final List<Widget> _pages = const [
    HomePage(),
    CategoryPage(),
    MessagePage(),
    SettingPage(),
    UserPage()
  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Flutter App")),
      drawer: Drawer(
        child: Column(
          children: [
            Row(
              children:  [
                Expanded(
                    flex: 1,
                    child: UserAccountsDrawerHeader(
                      accountName: const Text("itying"),
                      accountEmail: const Text("itying@qq.com"),
                      otherAccountsPictures:[
                        Image.network("https://www.itying.com/images/flutter/1.png"),
                           Image.network("https://www.itying.com/images/flutter/2.png"),
                           Image.network("https://www.itying.com/images/flutter/3.png"),
                      ],
                      currentAccountPicture:const CircleAvatar(
                        backgroundImage:NetworkImage("https://www.itying.com/images/flutter/3.png")
                      ),
                      decoration: const BoxDecoration(
                          image: DecorationImage(
                            fit: BoxFit.cover,
                              image: NetworkImage(
                                  "https://www.itying.com/images/flutter/2.png"))),
                    ))
              ],
            ),
            const ListTile(
              leading: CircleAvatar(
                child: Icon(Icons.people),
              ),
              title: Text("个人中心"),
            ),
            const Divider(),
            const ListTile(
              leading: CircleAvatar(
                child: Icon(Icons.settings),
              ),
              title: Text("系统设置"),
            ),
            const Divider(),
          ],
        ),
      ),
      endDrawer: const Drawer(
        child: Text("右侧侧边栏"),
      ),
      body: _pages[_currentIndex],

      bottomNavigationBar: BottomNavigationBar(
          fixedColor: Colors.red, //选中的颜色
          // iconSize:35,           //底部菜单大小
          currentIndex: _currentIndex, //第几个菜单选中
          type: BottomNavigationBarType.fixed, //如果底部有4个或者4个以上的菜单的时候就需要配置这个参数
          onTap: (index) {
            //点击菜单触发的方法
            //注意
            setState(() {
              _currentIndex = index;
            });
          },
          items: const [
            BottomNavigationBarItem(icon: Icon(Icons.home), label: "首页"),
            BottomNavigationBarItem(icon: Icon(Icons.category), label: "分类"),
            BottomNavigationBarItem(icon: Icon(Icons.message), label: "消息"),
            BottomNavigationBarItem(icon: Icon(Icons.settings), label: "设置"),
            BottomNavigationBarItem(icon: Icon(Icons.people), label: "用户")
          ]),
      floatingActionButton: Container(
        height: 60, //调整FloatingActionButton的大小
        width: 60,
        padding: const EdgeInsets.all(5),
        margin: const EdgeInsets.only(top: 5), //调整FloatingActionButton的位置
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(30),
        ),
        child: FloatingActionButton(
            backgroundColor: _currentIndex == 2 ? Colors.red : Colors.blue,
            child: const Icon(Icons.add),
            onPressed: () {
              setState(() {
                _currentIndex = 2;
              });
            }),
      ),
      floatingActionButtonLocation:
          FloatingActionButtonLocation.centerDocked, //配置浮动按钮的位置
    );
  }
}
