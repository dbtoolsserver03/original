import 'package:flutter/material.dart';

class PageViewKeepAlive extends StatefulWidget {
  const PageViewKeepAlive({super.key});

  @override
  State<PageViewKeepAlive> createState() => _PageViewKeepAliveState();
}

class _PageViewKeepAliveState extends State<PageViewKeepAlive> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Title'),
      ),
      body: PageView.builder(
        scrollDirection: Axis.vertical,
          itemCount: 10,
          itemBuilder: (context, index) {
            return MyContainer(num: index);
          }),
    );
  }
}

//自定义组件
class MyContainer extends StatefulWidget {
  final int num;
  const MyContainer({super.key, required this.num});

  @override
  State<MyContainer> createState() => _MyContainerState();
}

class _MyContainerState extends State<MyContainer> with AutomaticKeepAliveClientMixin {
  @override
  Widget build(BuildContext context) {
    print(widget.num);  //默认数据是没有缓存,每次滑动都会执行build
    return Center(
        child: Text(
      "第${widget.num}屏",
      style: Theme.of(context).textTheme.headline1,
    ));
  }
  
  @override
  // TODO: implement wantKeepAlive
  bool get wantKeepAlive => true;    //返回true表示缓存页面
}
