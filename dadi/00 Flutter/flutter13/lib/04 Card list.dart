import 'package:flutter/material.dart';
import "./res/listData.dart";
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        appBar: AppBar(title: const Text("Flutter App")),
        body: const LayoutDemo(),
      ),
    );
  }
}

class LayoutDemo extends StatelessWidget {
  const LayoutDemo({Key? key}) : super(key: key);

  List<Widget> _initCardData(){

    var tempList  = listData.map((value){
        return Card(
          shape: RoundedRectangleBorder(
            borderRadius:BorderRadius.circular(10)
          ),
          elevation: 20,
          margin: const EdgeInsets.all(10),
          child: Column(
            children: [
              AspectRatio(
                aspectRatio: 16 / 9,
                child: Image.network(
                    value["imageUrl"],
                    fit: BoxFit.cover),
              ),
              ListTile(
                leading: ClipOval(
                  child:Image.network(
                    value["imageUrl"],
                    fit: BoxFit.cover,
                    height: 40,
                    width: 40,
                ),
                ),
                title: Text(value["title"]),
                subtitle: Text(value["author"]),
              )
            ],
          ),
        );
    });

    // tempList (Card,Card)

    return tempList.toList();
    
  }

  @override
  Widget build(BuildContext context) {
    return ListView(
      children: _initCardData(),
    );
  }
}
