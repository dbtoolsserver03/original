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
        body: const LayoutDemo(),
      ),
    );
  }
}

class LayoutDemo extends StatelessWidget {
  const LayoutDemo({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return ListView(
      padding: const EdgeInsets.all(10),
      children: [
        Row(
          children: [Text("热搜", style: Theme.of(context).textTheme.titleLarge)],
        ),
        const Divider(),
        Wrap(
          spacing: 10,
          runSpacing: 10,
          children: [
            Button("女装", onPressed: () {}),
            Button("笔记本", onPressed: () {}),
            Button("玩具", onPressed: () {}),
            Button("文学", onPressed: () {}),
            Button("女装", onPressed: () {}),
            Button("时尚", onPressed: () {}),
            Button("男装", onPressed: () {}),
            Button("xxxx", onPressed: () {}),
            Button("手机", onPressed: () {})
          ],
        ),
        const SizedBox(height: 10),
        Row(
          children: [
            Text("历史记录", style: Theme.of(context).textTheme.titleLarge)
          ],
        ),
        const Divider(),
        Column(
          children: const [
            ListTile(title: Text("女装")),
            Divider(),
            ListTile(title: Text("手机")),
            Divider(),
            ListTile(title: Text("电脑")),
            Divider(),
          ],
        ),
        const SizedBox(height: 40),
        Padding(
          padding:const EdgeInsets.all(40),
          child: OutlinedButton.icon(
              //自适应
              style: ButtonStyle(
                foregroundColor: MaterialStateProperty.all(Colors.black45)
              ),
              onPressed: () {},
              icon: const Icon(Icons.delete),
              label: const Text("清空历史记录")),
        )
      ],
    );
  }
}

//自定义按钮组件
class Button extends StatelessWidget {
  String text; //按钮的文字
  void Function()? onPressed; //方法
  Button(this.text, {Key? key, required this.onPressed}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      style: ButtonStyle(
          backgroundColor: MaterialStateProperty.all(
              const Color.fromARGB(241, 223, 219, 219)),
          foregroundColor: MaterialStateProperty.all(Colors.black45)),
      onPressed: onPressed,
      child: Text(text),
    );
  }
}
