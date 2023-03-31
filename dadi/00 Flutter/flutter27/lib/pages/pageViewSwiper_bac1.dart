import 'package:flutter/material.dart';
import '../widget/image.dart';

class PageViewSwiper extends StatefulWidget {
  const PageViewSwiper({super.key});

  @override
  State<PageViewSwiper> createState() => _PageViewSwiperState();
}

class _PageViewSwiperState extends State<PageViewSwiper> {
  List<Widget> list = [];
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
      body: SizedBox(
        height: 200,
        child: PageView(
          children: list,
        ),
      ),
    );
  }
}
