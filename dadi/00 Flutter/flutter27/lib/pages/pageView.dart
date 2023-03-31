import 'package:flutter/material.dart';

class PageViewPage extends StatefulWidget {
  const PageViewPage({super.key});

  @override
  State<PageViewPage> createState() => _PageViewPageState();
}

class _PageViewPageState extends State<PageViewPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Title'),
      ),
      body: PageView(
        scrollDirection:Axis.vertical,   //配置PageView滑动的方向,默认是水平方向
        children: [
        
           Center(
            child: Text("第1屏",style: Theme.of(context).textTheme.headline1,)
          ),
           Center(
            child: Text("第2屏",style: Theme.of(context).textTheme.headline1,)
          ),
           Center(
            child: Text("第3屏",style: Theme.of(context).textTheme.headline1,)
          ),
          Center(
            child: Text("第4屏",style: Theme.of(context).textTheme.headline1,)
          ),
           Center(
            child: Text("第5屏",style: Theme.of(context).textTheme.headline1,)
          ),
           Center(
            child: Text("第6屏",style: Theme.of(context).textTheme.headline1,)
          ),
           Center(
            child: Text("第7屏",style: Theme.of(context).textTheme.headline1,)
          ),
        ],
      ),
    );
  }
}