import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  bool flag=true;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      floatingActionButton: FloatingActionButton(
        child: const Icon(Icons.add),
        onPressed: (){
          setState(() {
            flag=!flag;
          });
        },
      ),
      appBar: AppBar(
        title: const Text('Title'),
      ),
      body: AnimatedPadding(
        curve: Curves.bounceInOut,
        padding: EdgeInsets.fromLTRB(10, flag?10:500, 0, 0),
        duration: const Duration(seconds: 2),
        child: Container(
          width: 100,
          height: 100,
          color: Colors.red,
        ),
      ),
    );
  }
}