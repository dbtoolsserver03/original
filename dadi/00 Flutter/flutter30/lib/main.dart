import 'dart:async';

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

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final _globalKey = GlobalKey<AnimatedListState>();
  bool flag = true;
  List<String> list = ["第一条", "第二条"];

  Widget _buildItem(index) {
    return ListTile(
      key: ValueKey(index),
      title: Text(list[index]),
      trailing: IconButton(
        icon: const Icon(Icons.delete),
        onPressed: () {
          //执行删除
          _deleteItem(index);
        },
      ),
    );
  }

  _deleteItem(index) {   
    if (flag == true) {
      flag = false;
      //执行删除
      _globalKey.currentState!.removeItem(index, (context, animation) {
        //animation的值是从1到0
        var removeItem = _buildItem(index);
        list.removeAt(index); //数组中删除数据
        return ScaleTransition(
          // opacity: animation,
          scale: animation,
          child: removeItem, //删除的时候执行动画的元素
        );
      });
      //解决快速删除的bug
      Timer.periodic(const Duration(milliseconds: 500), (timer) {
        flag = true;
        timer.cancel();
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Title'),
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {
          list.add("我是新增的数据");
          _globalKey.currentState!.insertItem(list.length - 1);
        },
      ),
      body: AnimatedList(
          key: _globalKey,
          initialItemCount: list.length,
          itemBuilder: ((context, index, animation) {
             //animation的值是从0到1
            return FadeTransition(
              opacity: animation,
              child: _buildItem(index),
            );
          })),
    );
  }
}
