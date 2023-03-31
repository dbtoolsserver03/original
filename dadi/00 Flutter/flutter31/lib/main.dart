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
            height: 220,
            color: Colors.yellow,
            child: AnimatedSwitcher(
                //当子元素改变的时候会触发动画
                transitionBuilder: ((child, animation) {
                  //可以改变动画效果
                  return ScaleTransition(
                    scale: animation,
                    child: FadeTransition(
                      opacity: animation,
                      child: child,
                    ),
                  );
                }),
                duration: const Duration(seconds: 1),
                child: Text(key:UniqueKey(),flag?"你好Flutter":"你好大地老师",style: Theme.of(context).textTheme.headline2,)),
      )),
    );
  }
}
