import 'package:flutter/material.dart';
import './pages/tabs.dart';
import './pages/search.dart';
import './pages/news.dart';
import './pages/form.dart';

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
      // home:const Tabs() ,
      initialRoute: "/",
      routes: {
        "/": (contxt) => const Tabs(),
        "/news": (contxt) => const NewsPage(),
        "/search": (contxt) => const SearchPage(),
        "form": (contxt) {
          return const FormPage();
        },
      },
    );
  }
}
