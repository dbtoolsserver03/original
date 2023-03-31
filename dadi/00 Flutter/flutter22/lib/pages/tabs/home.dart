import 'package:flutter/material.dart';
import '../search.dart';
import '../form.dart';
import '../news.dart';
class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return  Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          ElevatedButton(onPressed: (){
             //跳转路由
              Navigator.of(context).push(
                MaterialPageRoute(builder: (BuildContext context) { 
                  return const SearchPage();
                 })
              );
          }, child: const Text("搜索")),
          const SizedBox(height: 20),
          ElevatedButton(onPressed: (){
             //跳转路由
              Navigator.of(context).push(
                MaterialPageRoute(builder: (BuildContext context) { 
                  return const FormPage();
                 })
              );
          }, child: const Text("跳转到表单")),
          const SizedBox(height: 20),
          ElevatedButton(onPressed: (){
             //跳转路由
              Navigator.of(context).push(
                MaterialPageRoute(builder: (BuildContext context) { 
                  return const NewsPage(title: "我是标题",aid: 12,);
                 })
              );
          }, child: const Text("跳转传值"))
        ],
      ),
    );
  }
}