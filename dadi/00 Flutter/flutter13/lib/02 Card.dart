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
        Card(
          shape: RoundedRectangleBorder(
              //Card的阴影效果
              borderRadius: BorderRadius.circular(10)),
          elevation: 20, //阴影值的深度
          margin: const EdgeInsets.all(10),
          child: Column(
            children: const [
              ListTile(
                title: Text("张三", style: TextStyle(fontSize: 28)),
                subtitle: Text("高级软件工程师"),
              ),
              Divider(),
              ListTile(
                title: Text("电话：152222222"),
              ),
              ListTile(
                title: Text("地址：北京市海淀区 xxx"),
              ),
            ],
          ),
        ),
        Card(
          shape: RoundedRectangleBorder(
              //Card的阴影效果
              borderRadius: BorderRadius.circular(10)),
          elevation: 20,
          margin: const EdgeInsets.all(10),
          // color:Colors.black12,  //背景颜色
          child: Column(
            children: const [
              ListTile(
                title: Text("李四", style: TextStyle(fontSize: 28)),
                subtitle: Text("Flutter高级软件工程师"),
              ),
              Divider(),
              ListTile(
                title: Text("电话：152222222"),
              ),
              ListTile(
                title: Text("地址：北京市海淀区 xxx"),
              ),
            ],
          ),
        ),
         Card(
          shape: RoundedRectangleBorder(
              //Card的阴影效果
              borderRadius: BorderRadius.circular(10)),
          elevation: 20, //阴影值的深度
          margin: const EdgeInsets.all(10),
          child: Column(
            children: const [
              ListTile(
                title: Text("张三", style: TextStyle(fontSize: 28)),
                subtitle: Text("高级软件工程师"),
              ),
              Divider(),
              ListTile(
                title: Text("电话：152222222"),
              ),
              ListTile(
                title: Text("地址：北京市海淀区 xxx"),
              ),
            ],
          ),
        ),
      ],
    );
  }
}
