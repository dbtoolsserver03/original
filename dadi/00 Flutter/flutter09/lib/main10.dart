import 'package:flutter/material.dart';
import "./res/listData.dart";

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
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        appBar: AppBar(title: const Text("Flutter List")),
        body: MyHomePage(),
      ),
    );
  }
}

class MyHomePage extends StatelessWidget {
  List<String> list=[];
  MyHomePage({Key? key}) : super(key: key){
    for (var i = 0; i < 20; i++) {
      list.add("我是第${i}条数据");
    }
  } 

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount:list.length ,
      itemBuilder: (context,index){
        return ListTile(
          title: Text(list[index]),
        );
      }
    );
  }
}
