import 'package:flutter/material.dart';
import './res/listData.dart';
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
    var tempList=listData.map((value){
        return Container(
            decoration: BoxDecoration(
              border: Border.all(
                color: Colors.black26
              )
            ),
            child: Column(
              children: [
                Image.network(value["imageUrl"]),
                const SizedBox(height: 10),
                Text(value["title"],style: const TextStyle(
                  fontSize: 18
                ))
              ],
            ),
        );
    }); 
    return tempList.toList();
  }

  @override
  Widget build(BuildContext context) {
    return GridView.count(  
      padding:const EdgeInsets.all(10),
      crossAxisSpacing:10,      //水平子Widget之间间 距
      mainAxisSpacing: 10,     //垂直子Widget之间间 距
      crossAxisCount:2,   //一行显示多少个元素
      childAspectRatio:1,  //宽高比
      children: _initGridViewData(),
    );
  }
}
