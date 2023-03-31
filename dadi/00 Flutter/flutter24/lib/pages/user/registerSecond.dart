import 'package:flutter/material.dart';

class RegisterSecondPage extends StatefulWidget {
  const RegisterSecondPage({super.key});

  @override
  State<RegisterSecondPage> createState() => _RegisterSecondPageState();
}

class _RegisterSecondPageState extends State<RegisterSecondPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text("注册第二步")),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Text("注册第二步"),
              const SizedBox(height: 40),
              ElevatedButton(onPressed: () {
              //命名路由跳转
              // Navigator.pushNamed(context, "/registerThird");
              
              //替换路由跳转
              Navigator.of(context).pushReplacementNamed("/registerThird");
              
              }, child: const Text("下一步"))
            ],
          ),
        ));
  }
}
