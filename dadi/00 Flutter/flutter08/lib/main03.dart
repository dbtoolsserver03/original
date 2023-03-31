import 'package:flutter/material.dart';
import './ityingFont.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        primarySwatch: Colors.yellow,
      ),
      home: Scaffold(
        appBar: AppBar(title: const Text("Flutter ICON")),
        body: const MyHomePage(),
      ),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return ListView(
      children: const <Widget>[
        ListTile(leading: Icon(Icons.home), title: Text("首页")),
        Divider(),
        ListTile(
          leading: Icon(Icons.assignment, color: Colors.red),
          title: Text("全部订单"),
        ),
        Divider(),
        ListTile(
          leading: Icon(Icons.payment, color: Colors.green),
          title: Text("待付款"),
        ),
        ListTile(
          leading: Icon(Icons.favorite, color: Colors.lightGreen),
          title: Text("我的收藏"),
          trailing:Icon(Icons.chevron_right_sharp) ,
        ),
        Divider(),
        ListTile(
          leading: Icon(Icons.people, color: Colors.black54),
          title: Text("在线客服"),
          trailing:Icon(Icons.chevron_right_sharp) ,
        ),
        Divider(),
      ],
    );
  }
}
