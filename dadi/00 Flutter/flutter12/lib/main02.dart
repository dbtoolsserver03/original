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
    return Center(
      child: Container(
        height: 400,
        width: 300,
        color: Colors.red,
        child: Stack(
          //注意：相对于外部容器进行定位，如果没有外部容器就相对于整个屏幕进行定位
          children: [
            Positioned(
              left: 0,
              bottom: 0,
              child: Container(
              height: 100,
              width: 100,
              color: Colors.yellow,
            )),
            const Positioned(
              top: 190,
              right: 0,
              child: Text("你好Flutter")
            )
          ],
        ),
      ),
    );
  }
}
