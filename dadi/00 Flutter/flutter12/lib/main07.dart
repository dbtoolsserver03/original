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
    //获取设备的宽度和高度
    // final size = MediaQuery.of(context).size;

    return Column(
      children: [
        SizedBox(
          width: double.infinity,
          height: 40,
          child: Stack(
            children: const [
              Align(
                alignment: Alignment.topLeft,
                child: Text("收藏"),
              ),
              Align(alignment: Alignment.topRight, child: Text("购买")),
            ],
          ),
        ),
         SizedBox(
          width: double.infinity,
          height: 40,
          child: Stack( 
            children: const [
              Positioned(
                left: 10,
                child: Text("收藏"),
              ),
              Positioned(right: 10, child: Text("购买")),
            ],
          ),
        )
      ],
    );
  }
}
