import 'package:flutter/material.dart';
import './ityingFont.dart';

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
        primarySwatch: Colors.yellow,
      ),
      home: Scaffold(
        appBar: AppBar(title: const Text("Flutter ICON")),
        body: const MyHomePage(),
      ),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return ListView(
      children: const [
        SizedBox(height: 20),
        Icon(
          Icons.home,
          size: 40,
          color: Colors.red,
        ),
        SizedBox(height: 20),
        Icon(Icons.settings),
        SizedBox(height: 20),
        Icon(Icons.search),
        SizedBox(height: 20),
        Icon(Icons.personal_injury_outlined),
        SizedBox(height: 20),
        Icon(
          Icons.category,
          size: 60,
          color: Colors.blue,
        ),
        Icon(
          Icons.category,
          size: 60,
          color: Colors.blue,
        ),
        Icon(
          Icons.shop,
          size: 60,
          color: Colors.red,
        ),
        SizedBox(height: 40),
        Icon(
          ItyingIcon.book,
          size: 40,
          color: Colors.orange,
        ),
        SizedBox(height: 20),
        Icon(
          ItyingIcon.weixin,
          size: 40,
          color: Colors.green,
        ),
        SizedBox(height: 20),
        Icon(
          ItyingIcon.yonghu,
          size: 30,
          color: Colors.black,
        ),
        SizedBox(height: 20),
        Icon(
          ItyingIcon.address
        ),
         SizedBox(height: 20),
        Icon(
          ItyingIcon.category
        ),   
         SizedBox(height: 20),
        Icon(
          ItyingIcon.weixin,
          size: 40,
          color: Colors.green,
        ),
        SizedBox(height: 20),
        Icon(
          ItyingIcon.yonghu,
          size: 30,
          color: Colors.black,
        ),
        SizedBox(height: 20),
        Icon(
          ItyingIcon.address
        ),
         SizedBox(height: 20),
        Icon(
          ItyingIcon.category
        ),         
      ],
    );
  }
}
