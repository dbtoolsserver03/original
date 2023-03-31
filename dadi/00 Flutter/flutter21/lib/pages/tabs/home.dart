import 'package:flutter/material.dart';
import '../../tools/KeepAliveWrapper.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;
  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 8, vsync: this);
    //监听_tabController的改变事件
    _tabController.addListener(() {
      // print(_tabController.index);  
      if (_tabController.animation!.value==_tabController.index){
        print(_tabController.index);    //获取点击或滑动页面的索引值
      }
    });
  }
  //组件销毁的时候触发
  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    //销毁_tabController
    _tabController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: PreferredSize(
        //可以配置appBar的高度
        preferredSize: const Size.fromHeight(40),
        child: AppBar(
          elevation: 0.5,
          backgroundColor: Colors.white,
          title: SizedBox(
            //改TabBar的高度
            height: 30,
            child: TabBar(
              labelStyle: const TextStyle(fontSize: 14),
              isScrollable: true,
              indicatorColor: Colors.red, //底部指示器的颜色
              labelColor: Colors.red,
              unselectedLabelColor: Colors.black, //lable未选中的颜色
              indicatorSize: TabBarIndicatorSize.label,
              controller: _tabController,
              // onTap: (index){   //只能监听点击事件 没法监听滑动
              //   print(index);
              // },
              tabs: const [
                Tab(
                  child: Text("关注"),
                ),
                Tab(
                  child: Text("热门"),
                ),
                Tab(
                  child: Text("视频"),
                ),
                Tab(
                  child: Text("娱乐"),
                ),
                Tab(
                  child: Text("篮球"),
                ),
                Tab(
                  child: Text("深圳"),
                ),
                Tab(
                  child: Text("疫情"),
                ),
                Tab(
                  child: Text("其他"),
                ),
              ],
            ),
          ),
        ),
      ),
      body: TabBarView(controller: _tabController, children: [
        KeepAliveWrapper(  //自定义的缓存组件
            child: ListView(
          children: const [
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关33333注列表1"),
            ),
            ListTile(
              title: Text("我是关33333注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关2注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注2表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关注列表1"),
            ),
            ListTile(
              title: Text("我是关33333注列表1"),
            ),
          ],
        )),
        const Text("我是热门"),
        const Text("视频"),
        const Text("娱乐"),
        const Text("篮球"),
        const Text("深圳"),
        const Text("疫情"),
        const Text("其他"),
      ]),
    );
  }
}
