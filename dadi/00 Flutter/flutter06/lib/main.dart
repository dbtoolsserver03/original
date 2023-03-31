import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
        appBar: AppBar(title: const Text("你好Flutter")), 
        body: Column(
          children:const [
             MyApp(),
             SizedBox(height: 10,),
             Circular(),
             SizedBox(height: 10),
             ClipImage(),
             SizedBox(height: 10),
             LoaclImage()
          ],
        )
    ),
  ));
}

/*
图片地址：
https://www.itying.com/images/201906/goods_img/1120_P_1560842352183.png
https://www.itying.com/themes/itying/images/ionic4.png

*/
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        // alignment: Alignment.centerRight,
        margin: const EdgeInsets.fromLTRB(0, 20, 0, 0),
        height: 150,
        width: 150,
        decoration: const BoxDecoration(
          color: Colors.yellow
        ),
        child: Image.network(
          "https://www.itying.com/themes/itying/images/ionic4.png",
          // alignment:Alignment.centerLeft
          // scale:2
          // fit: BoxFit.cover,
          // repeat:ImageRepeat.repeatY
        ),
      )
    );
  }
}

//实现一个圆形图片
class Circular extends StatelessWidget {
  const Circular({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Container(
        height: 150,
        width: 150,
        decoration: BoxDecoration(
          color: Colors.yellow,
          borderRadius:BorderRadius.circular(75),
          image:const DecorationImage(
            image:NetworkImage("https://www.itying.com/themes/itying/images/ionic4.png"),
            fit:BoxFit.cover
          )
        ),
        
    );
  }
}


//实现一个圆形图片 使用 ClipOval
class ClipImage extends StatelessWidget {
  const ClipImage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ClipOval(
      child: Image.network(
        "https://www.itying.com/images/201906/goods_img/1120_P_1560842352183.png",
        width: 150,
        height: 150,
        fit: BoxFit.cover,
      ),
    );
  }
}



//加载本地图片

class LoaclImage extends StatelessWidget {
  const LoaclImage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 150,
      width: 150,
      decoration: const BoxDecoration(
        color: Colors.yellow,
      ),
      child: Image.asset("images/a.jpeg",fit: BoxFit.cover,),
    );
  }
}
