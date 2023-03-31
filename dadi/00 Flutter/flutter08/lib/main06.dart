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
        Container(
          height: 120,
          width: 120,   //宽度是自适应的    设置没有效果
          decoration: const BoxDecoration(
            color: Colors.red
          ),
        ),
        Container(
          height: 120,
           width: 120,
          decoration: const BoxDecoration(
            color: Colors.yellow
          ),
        ),
         Container(
          height: 120,
          decoration: const BoxDecoration(
            color: Colors.orange
          ),
        ), Container(
          height: 120,
          decoration: const BoxDecoration(
            color: Colors.black
          ),
        ), Container(
          height: 120,
          decoration: const BoxDecoration(
            color: Colors.blue
          ),
        ), Container(
          height: 120,
          decoration: const BoxDecoration(
            color: Colors.red
          ),
        ), Container(
          height: 120,
          decoration: const BoxDecoration(
            color: Colors.pink
          ),
        ), Container(
          height: 120,
          decoration: const BoxDecoration(
            color: Colors.blueGrey
          ),
        ),
      ],
    );
  }
}
