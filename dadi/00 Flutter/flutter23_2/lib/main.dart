import 'package:flutter/material.dart';
import './pages/tabs.dart';
import './pages/search.dart';
import './pages/news.dart';
import './pages/form.dart';
import './pages/shop.dart';
void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  //1、配置路由
  Map routes={
        "/": (contxt) => const Tabs(),
        "/news": (contxt) => const NewsPage(),
        "/search": (contxt) => const SearchPage(),
        "/form": (contxt,{arguments}) => FormPage(arguments:arguments),
        "/shop": (contxt,{arguments}) => ShopPage(arguments:arguments),
   };

  MyApp({Key? key}) : super(key: key);

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
      //2、配置onGenerateRoute  固定写法
      onGenerateRoute: (RouteSettings settings){    
        // print(settings);
        // print(settings.name);
        // print(settings.arguments);
     
        final String? name = settings.name;   //  /news 或者 /search
        final Function? pageContentBuilder = routes[name];   //  Function = (contxt) { return const NewsPage()} 
        
        if (pageContentBuilder != null) {
          if (settings.arguments != null) {
            final Route route = MaterialPageRoute(
                builder: (context) =>
                    pageContentBuilder(context, arguments: settings.arguments));
            return route;
          } else {
            final Route route = MaterialPageRoute(
                builder: (context) => pageContentBuilder(context));
           
            return route;
          }
        }
        return null;
      },
     
    );
  }
}
