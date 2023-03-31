import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);  
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        appBar: AppBar(title: const Text("Flutter App")),
        body: const HomePage(),
      ),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  List<Widget> _initGridViewData(){
    List<Widget> tempList=[];
    for (var i = 0; i < 12; i++) {
      tempList.add(
          Container(
            alignment: Alignment.center,
            decoration:const BoxDecoration(
              color: Colors.blue
            ),
            child: Text("第${i}个元素",style:const TextStyle(
              fontSize: 20
            ))
          )
      );
    }
    return tempList;
  }

  @override
  Widget build(BuildContext context) {
    return GridView.count(  
      padding:const EdgeInsets.all(10),
      crossAxisSpacing:10,      //水平子Widget之间间 距
      mainAxisSpacing: 10,     //垂直子Widget之间间 距
      crossAxisCount:3,  //一行的Widget数量
      childAspectRatio:1.2,  //宽高比
      children: _initGridViewData(),
    );
  }
}
