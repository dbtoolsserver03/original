import 'package:flutter/material.dart';

class CategoryPage extends StatefulWidget {
  const CategoryPage({super.key});

  @override
  State<CategoryPage> createState() => _CategoryPageState();
}

class _CategoryPageState extends State<CategoryPage> {
  @override
  Widget build(BuildContext context) {
    return ListView(
      children: const [
        ListTile(
          title: Text("我是一个列表"),
        ),
         ListTile(
          title: Text("我是一个列表"),
        ),
         ListTile(
          title: Text("我是一个列表"),
        ),
         ListTile(
          title: Text("我是一个列表"),
        ),
         ListTile(
          title: Text("我是一个列表"),
        ),
         ListTile(
          title: Text("我是一个列表"),
        ),
        
      ],
    );
  }
}