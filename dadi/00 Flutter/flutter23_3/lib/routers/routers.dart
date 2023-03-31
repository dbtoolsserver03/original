import 'package:flutter/material.dart';
import '../pages/tabs.dart';
import '../pages/search.dart';
import '../pages/news.dart';
import '../pages/form.dart';
import '../pages/shop.dart';

//1、配置路由
Map routes = {
  "/": (contxt) => const Tabs(),
  "/news": (contxt) => const NewsPage(),
  "/search": (contxt) => const SearchPage(),
  "/form": (contxt, {arguments}) => FormPage(arguments: arguments),
  "/shop": (contxt, {arguments}) => ShopPage(arguments: arguments),
};

//2、配置onGenerateRoute  固定写法  这个方法也相当于一个中间件，这里可以做权限判断
var onGenerateRoute = (RouteSettings settings) { 
  final String? name = settings.name; //  /news 或者 /search
  final Function? pageContentBuilder = routes[name];                          //  Function = (contxt) { return const NewsPage()}

  if (pageContentBuilder != null) {
    if (settings.arguments != null) {
      final Route route = MaterialPageRoute(
          builder: (context) =>
              pageContentBuilder(context, arguments: settings.arguments));
      return route;
    } else {
      final Route route =
          MaterialPageRoute(builder: (context) => pageContentBuilder(context));

      return route;
    }
  }
  return null;
};
