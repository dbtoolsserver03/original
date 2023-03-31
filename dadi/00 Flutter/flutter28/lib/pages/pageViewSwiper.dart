import 'dart:async';

import 'package:flutter/material.dart';
import '../widget/swiper.dart';

class PageViewSwiper extends StatefulWidget {
  const PageViewSwiper({super.key});

  @override
  State<PageViewSwiper> createState() => _PageViewSwiperState();
}

class _PageViewSwiperState extends State<PageViewSwiper> {
  List<String> list = [];  
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    list = const [
     "https://www.itying.com/images/flutter/1.png",
     "https://www.itying.com/images/flutter/2.png",
     "https://www.itying.com/images/flutter/3.png",
    ];   
   
  }
  

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('PageViewSwiper'),
      ),
      body:ListView(
        children: [
          Swiper(list: list)
        ],
      ) 
    );
  }
}
