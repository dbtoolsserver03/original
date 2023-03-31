import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        appBar: AppBar(title: const Text("Flutter App")),
        body: const LayoutDemo(),
      ),
    );
  }
}

class LayoutDemo extends StatelessWidget {
  const LayoutDemo({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return ListView(
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            ElevatedButton(
                onPressed: () {
                  print("ElevatedButton");
                },
                child: const Text("普通按钮")),
            TextButton(onPressed: () {}, child: const Text("文本按钮")),
            OutlinedButton(onPressed:() {}, child: const Text("边框按钮")),  
            IconButton(onPressed: () {}, icon: const Icon(Icons.thumb_up))
          ],
        ),
        const SizedBox(
          height: 20,
        ),
        Row(mainAxisAlignment: MainAxisAlignment.spaceAround, children: [
          ElevatedButton.icon(
              onPressed: () {},
              icon: const Icon(Icons.send),
              label: const Text("发送")),
          TextButton.icon(
              onPressed: () {},
              icon: const Icon(Icons.info),
              label: const Text("消息")),
          OutlinedButton.icon(
              onPressed: null,
              icon: const Icon(Icons.add),
              label: const Text("增加"))
        ]),
        const SizedBox(
          height: 20,
        ),
        Row(mainAxisAlignment: MainAxisAlignment.spaceAround, children: [
          ElevatedButton(
              style: ButtonStyle(
                  backgroundColor: MaterialStateProperty.all(Colors.red), //背景颜色
                  foregroundColor:
                      MaterialStateProperty.all(Colors.white) //文字图标颜色
                  ),
              onPressed: () {
                print("ElevatedButton");
              },
              child: const Text("普通按钮")),
        ]),
        const SizedBox(
          height: 20,
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            Container(
              height: 60,
              width: 140,
              child: ElevatedButton(
                onPressed: () {},
                child: const Text("大按钮"),
              ),
            ),
            SizedBox(
              height: 40,
              width: 100,
              child: ElevatedButton.icon(
                onPressed: () {},
                icon: const Icon(Icons.search),
                label: const Text("搜索"),
              ),
            )
          ],
        ),
        const SizedBox(
          height: 20,
        ),
        Row(
          children: [
            Expanded(
                flex: 1,
                child: Container(
                  margin: const EdgeInsets.all(20),
                  height: 50,
                  child: ElevatedButton(
                    onPressed: () {},
                    style: ButtonStyle(
                        backgroundColor: MaterialStateProperty.all(
                            const Color.fromARGB(220, 245, 71, 71)),
                        foregroundColor:
                            MaterialStateProperty.all(Colors.white)),
                    child: const Text("登录"),
                  ),
                ))
          ],
        ),
        const SizedBox(
          height: 20,
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            ElevatedButton(
                style: ButtonStyle(
                    shape: MaterialStateProperty.all(//圆角
                        RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(12)))),
                onPressed: () {},
                child: const Text("圆角")),
            SizedBox(
              height: 80,
              width: 80,
              child: ElevatedButton(
                  style: ButtonStyle(
                      shape: MaterialStateProperty.all(//圆形
                          const CircleBorder(
                              side: BorderSide(width:2,color: Colors.yellow)))),
                  onPressed: () {},
                  child: const Text("圆形")),
            ),
          ],
        ),
        const SizedBox(height: 20),
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            OutlinedButton(
              style: ButtonStyle(
                side: MaterialStateProperty.all(  //修改边框颜色
                 const  BorderSide(width:1,color: Colors.red)
                )
              ),
              onPressed: (){}, 
              child: const Text("带边框的按钮")
            )
          ],
        )
      ],
    );
  }
}
