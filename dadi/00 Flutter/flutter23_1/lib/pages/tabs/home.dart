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
          }, child: const Text("基本路由跳转")),

          ElevatedButton(onPressed: (){
             Navigator.pushNamed(context, "/news");
          }, child: const Text("命名路由跳转news")),
         
         
        ],
      ),
    );
  }
}