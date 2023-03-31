import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(title: const Text("你好Flutter")),
      body: const Center(
        child: Text("你好Flutter",
            textDirection: TextDirection.ltr,
            style: TextStyle(
                color: Colors.red,
                // color: Color.fromRGBO(244, 244, 123, 1),
                fontSize: 40)),
      ),
    ),
  ));
}
