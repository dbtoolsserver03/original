import 'package:flutter/material.dart';

class PageViewBuilderPage extends StatefulWidget {
  const PageViewBuilderPage({super.key});

  @override
  State<PageViewBuilderPage> createState() => _PageViewBuilderPageState();
}

class _PageViewBuilderPageState extends State<PageViewBuilderPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('PageViewBuilder'),
      ),
      body: PageView.builder(
          scrollDirection:Axis.vertical,  //垂直
          itemCount: 10,
          itemBuilder: (context, index) {
            return Center(
                child: Text(
              "第${index + 1}屏",
              style: Theme.of(context).textTheme.headline1,
            ));
          }),
    );
  }
}
