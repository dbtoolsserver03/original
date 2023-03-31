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
    return SizedBox(
      height: 120,
      child: ListView(
        scrollDirection: Axis.horizontal, //水平列表
        padding: const EdgeInsets.all(10),
        children: <Widget>[
          Container(
            width: 120,
            decoration: const BoxDecoration(color: Colors.white),
            child: Column(
              children: [
                   SizedBox(
                    height: 80,
                    child: Image.network("https://www.itying.com/images/flutter/1.png",fit: BoxFit.cover,),
                   ),
                   const Text("文字")
              ],
            ),
          ),
          Container(
            width: 120,
            decoration: const BoxDecoration(color: Colors.yellow),
          ),
          Container(
            height: 120,
            width: 120,
            decoration: const BoxDecoration(color: Colors.orange),
          ),
          Container(
            width: 120,
            decoration: const BoxDecoration(color: Colors.black),
          ),
          Container(
            width: 120,
            decoration: const BoxDecoration(color: Colors.blue),
          ),
          Container(
            width: 120,
            decoration: const BoxDecoration(color: Colors.red),
          ),
          Container(
            width: 120,
            decoration: const BoxDecoration(color: Colors.pink),
          ),
          Container(
            width: 120,
            decoration: const BoxDecoration(color: Colors.blueGrey),
          ),
        ],
      ),
    );
  }
}
