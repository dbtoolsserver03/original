import 'package:flutter/material.dart';
import '../search.dart';

class CategoryPage extends StatefulWidget {
  const CategoryPage({super.key});

  @override
  State<CategoryPage> createState() => _CategoryPageState();
}

class _CategoryPageState extends State<CategoryPage> {
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
        
        ],
      ),
    );
  }
}