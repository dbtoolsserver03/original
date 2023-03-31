import 'dart:async';

import 'package:flutter/material.dart';

class Swiper extends StatefulWidget {
  final double width;
  final double height;
  final List<String> list;
  const Swiper(
      {super.key,
      this.height = 200,
      this.width = double.infinity,
      required this.list});

  @override
  State<Swiper> createState() => _SwiperState();
}

class _SwiperState extends State<Swiper> {
  int _currentIndex = 0;
  List<Widget> pageList = [];
  late PageController _pageController;
  late Timer timer;
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    //数据
    for (var i = 0; i < widget.list.length; i++) {
      pageList.add(ImagePage(
          width: widget.width, height: widget.height, src: widget.list[i]));
    }
    //PageController
    _pageController = PageController(initialPage: 0);

    timer = Timer.periodic(const Duration(seconds: 5), (t) {
      _pageController.animateToPage((_currentIndex + 1) % pageList.length,
          duration: const Duration(milliseconds: 200), curve: Curves.linear);
    });
  }
  
  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    timer.cancel();
    _pageController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: [
        SizedBox(
          height: 200,
          child: PageView.builder(
              controller: _pageController,
              onPageChanged: (index) {
                setState(() {
                  _currentIndex = index % pageList.length;
                });
              },
              itemCount: 1000,
              itemBuilder: (context, index) {
                return pageList[index % pageList.length];
                // index的值是0-1000
                // 0  1  2    0  1  2   0  1 2
              }),
        ),
        Positioned(
            left: 0,
            right: 0, //设置 left:0 right:0就会站满整行
            bottom: 2,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: List.generate(pageList.length, (index) {
                return Container(
                  margin: const EdgeInsets.all(5),
                  width: 10,
                  height: 10,
                  decoration: BoxDecoration(
                      color: _currentIndex == index ? Colors.blue : Colors.grey,
                      shape: BoxShape.circle //圆
                      // borderRadius: BorderRadius.circular(5) //圆
                      ),
                );
              }).toList(),
            ))
      ],
    );
  }
}

class ImagePage extends StatelessWidget {
  final double width;
  final double height;
  final String src;
  const ImagePage(
      {super.key,
      this.width = double.infinity,
      this.height = 200,
      required this.src});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: width,
      height: height,
      child: Image.network(
        src,
        fit: BoxFit.cover,
      ),
    );
  }
}
