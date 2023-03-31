import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});
  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, "/shop",
                    arguments: {"title": "shop传值", "aid": 21});
              },
              child: const Text("命名路由传值")),
          const SizedBox(
            height: 20,
          ),
          ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, "/dialog");
              },
              child: const Text("Dialog演示")),
          const SizedBox(
            height: 20,
          ),
          ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, "/pageView");
              },
              child: const Text("PageView演示")),
          const SizedBox(
            height: 20,
          ),
          ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, "/pageViewBuilder");
              },
              child: const Text("PageViewBuilder演示")),
          const SizedBox(
            height: 20,
          ),
          ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, "/pageViewFullPage");
              },
              child: const Text("PageView无限加载")),
          const SizedBox(
            height: 20,
          ),
          ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, "/pageViewSwiper");
              },
              child: const Text("PageViewSwiper")),
        ],
      ),
    );
  }
}
