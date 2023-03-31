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
    return GridView.extent(  
      padding:const EdgeInsets.all(10),
      crossAxisSpacing:10,      //水平子Widget之间间 距
      mainAxisSpacing: 10,     //垂直子Widget之间间 距
      maxCrossAxisExtent:250,  //我们通过它可以快速的创建横轴子元素为固定最大长度的的GridView
      childAspectRatio:0.7,  //宽高比
      children: _initGridViewData(),
    );
  }
}
