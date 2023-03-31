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
        body: const MyHomePage(),
      ),
    );
  }
}

// ignore: must_be_immutable
class MyHomePage extends StatelessWidget { 
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: listData.length,
      itemBuilder: (context,i){
        return ListTile(
          leading: Image.network(listData[i]["imageUrl"]),
          title: Text(listData[i]["title"]),
          subtitle:Text(listData[i]["author"]) ,
        );
      }
    );
  }
}
