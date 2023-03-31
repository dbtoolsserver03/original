//代码块 importM
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(title: const Text("你好Flutter")),
      body: const MyApp(),
    ),
  ));
}

// 代码块  statelessW
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
   return const Center(
        child: Text("你好Flutter 我是一个自定义组件",
            textDirection: TextDirection.ltr,
            style: TextStyle(
                color: Colors.red,
                // color: Color.fromRGBO(244, 244, 123, 1),
                fontSize: 40)),
      );
  }
}
