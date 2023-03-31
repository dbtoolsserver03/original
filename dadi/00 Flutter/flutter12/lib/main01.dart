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
      home: Scaffold(
        appBar: AppBar(title: const Text("Flutter App")),
        body: const HomePage(),
      ),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {  
    return Stack(
      alignment: Alignment.center,
      children: [
        Container(
          height: 400,
          width: 300,
          color: Colors.red,
        ),

        Container(
          height: 200,
          width: 200,
          color: Colors.yellow,
        ),

        const Text("你好Flutter"),
         const Text("你好Flutter1111")
      ],
    );
  }
}
