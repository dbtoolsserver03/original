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
    return Flex(
      direction:Axis.horizontal,
      children: [
        Expanded(
          flex: 1,
          child: IconContainer(Icons.home),  //这个元素设置宽度是没有效果的
        ),
        Expanded(
          flex: 2,
          child: IconContainer(
            Icons.ac_unit_sharp,
            color: Colors.orange,
          ),         
        ),
      ],
    );
  }
}

//自定义IconContainer
class IconContainer extends StatelessWidget {
  Color color;
  IconData icon;
  IconContainer(this.icon, {Key? key, this.color = Colors.red})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      alignment: Alignment.center,
      height: 100,
      width: 100,
      color: color,
      child: Icon(icon, color: Colors.white, size: 28),
    );
  }
}
