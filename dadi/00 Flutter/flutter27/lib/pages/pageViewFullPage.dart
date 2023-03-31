import 'package:flutter/material.dart';

class PageViewFullPage extends StatefulWidget {
  const PageViewFullPage({super.key});

  @override
  State<PageViewFullPage> createState() => _PageViewFullPageState();
}

class _PageViewFullPageState extends State<PageViewFullPage> {
  List<Widget> list = [];

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    for (var i = 0; i < 10; i++) {
      list.add(Center(
          child: Text("第${i + 1}屏", style: const TextStyle(fontSize: 60))));
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Full Page'),
      ),
      body: PageView(
        scrollDirection: Axis.vertical,
        onPageChanged: (index) {
          print(index);
          if (index + 2 == list.length) {
            setState(() {
              for (var i = 0; i < 10; i++) {
                list.add(Center(
                    child: Text("第${i + 1}屏",
                        style: const TextStyle(fontSize: 60))));
              }
            });
          }
        },
        children: list,
      ),
    );
  }
}
