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
      home:const Tabs() ,
    );
  }
}


class Tabs extends StatefulWidget {
  const Tabs({super.key});

  @override
  State<Tabs> createState() => _TabsState();
}

class _TabsState extends State<Tabs> {
  int _currentIndex=0;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text("Flutter App")),
        body: const Text("FLutter App"),
        bottomNavigationBar: BottomNavigationBar(
          currentIndex:_currentIndex,
          onTap:(index){
            //注意
           setState(() {
             _currentIndex=index;
           });
          },
          items: const [
          BottomNavigationBarItem(
            icon:Icon(Icons.home),
            label: "首页"
          ),
          BottomNavigationBarItem(
            icon:Icon(Icons.category),
            label: "分类"
          ),
          BottomNavigationBarItem(
            icon:Icon(Icons.settings),
            label: "设置"
          )
        ]),
      );
  }
}