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
  bool flag = true;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      floatingActionButton: FloatingActionButton(
        child: const Icon(Icons.add),
        onPressed: () {
          setState(() {
            flag = !flag;
          });
        },
      ),
      appBar: AppBar(
        title: const Text('Title'),
      ),
      body: Center(
        child: Container(
          alignment: Alignment.center,
          width: 300,
          height: 300,
          color: Colors.blue,
          child: AnimatedDefaultTextStyle(
            duration: const Duration(seconds: 1),
            style: TextStyle(fontSize: flag ? 20 : 50, color: Colors.black),
            child: const Text("你好Flutter"),
          ),
        ),
      ),
    );
  }
}
