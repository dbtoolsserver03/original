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
  MyHomePage({Key? key}) : super(key: key) {
    print(listData);
  }
  //第一种方法
  // List<Widget> _initListData(){
  //   List<Widget> tempList=[];
  //   for (var i = 0; i < listData.length; i++) {
  //       tempList.add(
  //         ListTile(
  //           leading: Image.network("${listData[i]["imageUrl"]}"),
  //           title: Text("${listData[i]["title"]}"),
  //           subtitle: Text("${listData[i]["author"]}"),
  //         )
  //       );
  //   }
  //   return tempList;
  // }

  //第二种方法
  List<Widget> _initListData() {
    var tempList = listData.map((value) {
      return ListTile(
        leading: Image.network("${value["imageUrl"]}"),
        title: Text("${value["title"]}"),
        subtitle: Text("${value["author"]}"),
      );
    });  
    return tempList.toList();
  }

  @override
  Widget build(BuildContext context) {
    return ListView(
      children: _initListData(),
    );
  }
}
