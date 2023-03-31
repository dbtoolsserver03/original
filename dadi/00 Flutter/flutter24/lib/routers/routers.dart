import 'package:flutter/cupertino.dart';
/*
配置ios风格的路由
1、删掉material.dart引入cupertino.dart
   import 'package:flutter/cupertino.dart';

2、把 MaterialPageRoute替换成 CupertinoPageRoute
*/

import '../pages/tabs.dart';
import '../pages/shop.dart';
import '../pages/user/login.dart';
import '../pages/user/registerFirst.dart';
import '../pages/user/registerSecond.dart';
import '../pages/user/registerThird.dart';
//1、配置路由
Map routes = {
  "/": (contxt) => const Tabs(),   
  "/login": (contxt) => const LoginPage(),   
  "/registerFirst": (contxt) => const RegisterFirstPage(),   
  "/registerSecond": (contxt) => const RegisterSecondPage(),   
  "/registerThird": (contxt) => const RegisterThirdPage(),   
  "/shop": (contxt, {arguments}) => ShopPage(arguments: arguments),
};

//2、配置onGenerateRoute  固定写法  这个方法也相当于一个中间件，这里可以做权限判断
var onGenerateRoute = (RouteSettings settings) { 
  final String? name = settings.name; //  /news 或者 /search
  final Function? pageContentBuilder = routes[name];                          //  Function = (contxt) { return const NewsPage()}

  if (pageContentBuilder != null) {
    if (settings.arguments != null) {
      final Route route = CupertinoPageRoute(
          builder: (context) =>
              pageContentBuilder(context, arguments: settings.arguments));
      return route;
    } else {
      final Route route =
          CupertinoPageRoute(builder: (context) => pageContentBuilder(context));

      return route;
    }
  }
  return null;
};
