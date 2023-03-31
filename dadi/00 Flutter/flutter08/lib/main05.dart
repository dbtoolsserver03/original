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
      padding: const EdgeInsets.all(10),
      children: <Widget>[
        Image.network("https://www.itying.com/images/flutter/1.png"),
        Container(
          padding: const EdgeInsets.fromLTRB(0, 6, 0, 0),
          height: 44,
          child: const Text(
            "我是一个标题",
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 22)),
        ),
        Image.network("https://www.itying.com/images/flutter/3.png"),
         Container(
          padding: const EdgeInsets.fromLTRB(0, 6, 0, 0),
          height: 44,
          child: const Text(
            "我是一个标题",
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 22)),
        ),
        Image.network("https://www.itying.com/images/flutter/2.png"),
         Container(
          padding: const EdgeInsets.fromLTRB(0, 6, 0, 0),
          height: 44,
          child: const Text(
            "我是一个标题",
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 22)),
        ),
        Image.network("https://www.itying.com/images/flutter/4.png"),
         Container(
          padding: const EdgeInsets.fromLTRB(0, 6, 0, 0),
          height: 44,
          child: const Text(
            "我是一个标题",
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 22)),
        ),
        Image.network("https://www.itying.com/images/flutter/5.png"),
         Container(
          padding: const EdgeInsets.fromLTRB(0, 6, 0, 0),
          height: 44,
          child: const Text(
            "我是一个标题",
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 22)),
        ),
        Image.network("https://www.itying.com/images/flutter/6.png"),
      ],
    );
  }
}
