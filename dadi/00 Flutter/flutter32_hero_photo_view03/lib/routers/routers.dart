import 'package:flutter/cupertino.dart';
import '../pages/tabs.dart';
import '../pages/hero.dart';

final Map<String,Function> routes = {
  '/': (contxt) => const Tabs(), 
  '/hero': (contxt,{arguments}) => HeroPage(arguments:arguments), 
};

var onGenerateRoute = (RouteSettings settings) {
  // 统一处理
  final String? name = settings.name;
  final Function? pageContentBuilder = routes[name];
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
