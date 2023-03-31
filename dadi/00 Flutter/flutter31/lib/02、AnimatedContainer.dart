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
      body: Stack(
        children: [
          ListView(
            children: const [
              ListTile(
                title: Text("我是一个列表"),
              )
            ],
          ),
          Positioned(
            left: 0,
            top: 0,
            bottom: 0,
              child: AnimatedContainer(
            duration: const Duration(seconds: 1, milliseconds: 100),
            width: 200,
            height: double.infinity,
            transform: flag
                ? Matrix4.translationValues(-200, 0, 0)
                : Matrix4.translationValues(0, 0, 0),
            color: Colors.yellow,
          ))
        ],
      ),
    );
  }
}
