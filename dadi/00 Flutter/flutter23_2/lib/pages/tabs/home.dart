import 'package:flutter/material.dart';
import '../search.dart';

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
                //跳转路由
                Navigator.of(context)
                    .push(MaterialPageRoute(builder: (BuildContext context) {
                  return const SearchPage();
                }));
              },
              child: const Text("基本路由跳转")),
          const SizedBox(
            height: 20,
          ),
          ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, "/news");
              },
              child: const Text("命名路由跳转news")),
          const SizedBox(
            height: 20,
          ),
          ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, "/form",
                    arguments: {"title": "我是命名路由传值", "aid": 20});
              },
              child: const Text("命名路由传值")),
          const SizedBox(
            height: 20,
          ),
          ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, "/shop",
                    arguments: {"title": "shop传值", "aid": 21});
              },
              child: const Text("命名路由传值Shop")),
        ],
      ),
    );
  }
}
