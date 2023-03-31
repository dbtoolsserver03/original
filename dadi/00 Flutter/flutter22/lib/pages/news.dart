import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

//新闻页面接收上个页面穿过来的参数
class NewsPage extends StatefulWidget {
  final String title;
  final int aid;
  const NewsPage({super.key, this.title = "新闻", required this.aid});

  @override
  State<NewsPage> createState() => _NewsPageState();
}

class _NewsPageState extends State<NewsPage> {
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    print(widget.aid);
    print(widget.title);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      floatingActionButton: FloatingActionButton(
        onPressed: () {  
          //返回到上一页
          Navigator.pop(context);
        },
        child: const Icon(Icons.home),
      ),
      appBar: AppBar(
        title: Text(widget.title), //获取NewsPage里面定义的title
      ),
      body: const Center(
        child: Text("新闻页面"),
      ),
    );
  }
}
