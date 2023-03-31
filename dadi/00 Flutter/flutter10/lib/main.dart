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

  Widget _initGridViewData(context, index) {
    return Container(
      decoration: BoxDecoration(border: Border.all(color: Colors.black26)),
      child: Column(
        children: [
          Image.network(listData[index]["imageUrl"]),
          const SizedBox(height: 10),
          Text(listData[index]["title"], style: const TextStyle(fontSize: 18))
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return GridView.builder(
        padding: const EdgeInsets.all(10),
        itemCount:listData.length,
        gridDelegate: const SliverGridDelegateWithMaxCrossAxisExtent(
          crossAxisSpacing: 10, //水平子Widget之间间 距
          mainAxisSpacing: 10, //垂直子Widget之间间 距          
          childAspectRatio: 0.9,
          maxCrossAxisExtent: 120, 
        ),
        itemBuilder: _initGridViewData);
  }
}
