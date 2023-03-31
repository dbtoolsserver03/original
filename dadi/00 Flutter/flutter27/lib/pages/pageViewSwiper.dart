import 'package:flutter/material.dart';
import '../widget/image.dart';

class PageViewSwiper extends StatefulWidget {
  const PageViewSwiper({super.key});

  @override
  State<PageViewSwiper> createState() => _PageViewSwiperState();
}

class _PageViewSwiperState extends State<PageViewSwiper> {
  List<Widget> list = [];
  int _currentIndex=0;
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    list = const [
      ImagePage(
        src: "https://www.itying.com/images/flutter/1.png",
      ),
      ImagePage(
        src: "https://www.itying.com/images/flutter/2.png",
      ),
      ImagePage(
        src: "https://www.itying.com/images/flutter/3.png",
      ),
    ];
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('PageViewSwiper'),
      ),
      body: Stack(
        children: [
          SizedBox(
            height: 200,
            child: PageView.builder(
              onPageChanged: (index){
               /*
              1、刚开始     _currentIndex=0
              2、index=1    _currentIndex=1
              3、index=2    _currentIndex=2
              4、index=3    _currentIndex=0
              5、index=4     _currentIndex=1
              6、index=5     _currentIndex=2
              7、index=6     _currentIndex=0
               */
                setState(() {
                  _currentIndex=index % list.length;
                });
              },
                itemCount: 1000,
                itemBuilder: (context, index) {
                  return list[index % list.length];
                  // index的值是0-1000
                  // 0  1  2    0  1  2   0  1 2
                }),
          ),
          Positioned(
            left: 0,
            right: 0,  //设置 left:0 right:0就会站满整行
            bottom: 2,            
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: List.generate(list.length, (index){
                return Container(
                  margin: const EdgeInsets.all(5),
                  width: 10, height: 10,
                  decoration: BoxDecoration(
                    color: _currentIndex==index?Colors.blue:Colors.grey,
                    shape: BoxShape.circle  //圆
                    // borderRadius: BorderRadius.circular(5) //圆
                  ),
                );
              }).toList(),
          ))
        ],
      ),
    );
  }
}
