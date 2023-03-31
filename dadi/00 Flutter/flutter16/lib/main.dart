import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const HomePage(),
    );
  }
}

//有状态组件:如果我们想改变页面中的数据的话这个时候就需要用到StatefulWidget
class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final List<String> _list=[];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title:const Text("Flutter App")),
      floatingActionButton: FloatingActionButton(
        child:const Icon(Icons.add),
        onPressed: (){
            //改变数据必须加上setState
            setState(() {
                _list.add("我是一个新增的列表");
            });
        },
      ),
      body: ListView(
        children: _list.map((v){
          return ListTile(
            title: Text(v),
          );
        }).toList(),
      ),
    );
  }
}