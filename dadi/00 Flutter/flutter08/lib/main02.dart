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
        ListTile(title: Text("我是一个列表")),
        Divider(),
        ListTile(title: Text("我是一个列表")),
        Divider(),
        ListTile(title: Text("我是一个列表")),
        Divider(),
        ListTile(title: Text("我是一个列表")),
        Divider(),
        ListTile(title: Text("我是一个列表")),
        Divider(),
        ListTile(title: Text("我是一个列表")),
        Divider(),
        ListTile(title: Text("我是一个列表")),
        Divider(),
        ListTile(title: Text("我是一个列表")),
        Divider(),
        ListTile(title: Text("我是一个列表")),
        Divider(),
        ListTile(title: Text("我是一个列表")),
        Divider(),
        ListTile(title: Text("我是一个列表")),
        Divider(),
      ],
    );
  }
}
