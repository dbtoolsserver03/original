import 'package:flutter/material.dart';

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
  @override
  Widget build(BuildContext context) {
    return ListView(
      children: [
        Card(
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
                    "https://www.itying.com/images/flutter/3.png",
                    fit: BoxFit.cover),
              ),
              ListTile(
                leading: ClipOval(
                  child:Image.network(
                    "https://www.itying.com/images/flutter/3.png",
                    fit: BoxFit.cover,
                    height: 40,
                    width: 40,
                ),
                ),
                title: const Text("xxxxxxxxx"),
                subtitle: const Text("xxxxxxxxx"),
              )
            ],
          ),
        ),
        Card(
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
                    "https://www.itying.com/images/flutter/3.png",
                    fit: BoxFit.cover),
              ),
              const ListTile(
                leading: CircleAvatar(
                  backgroundImage: NetworkImage("https://www.itying.com/images/flutter/4.png"),
                ),
                title: Text("xxxxxxxxx"),
                subtitle: Text("xxxxxxxxx"),
              )
            ],
          ),
        )
      ],
    );
  }
}
