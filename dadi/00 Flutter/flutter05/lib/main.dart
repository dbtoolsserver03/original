import 'package:flutter/material.dart';

void main(){
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: const Text("你好Flutter")),
        body:Column(
          children:const [
             MyApp(),
             MyButton(),
             MyText()
          ]
        )
      ),
    )
  );
}


class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(
          child:Container(
            margin: const EdgeInsets.fromLTRB(0, 60, 0, 0),
            alignment: Alignment.center,  //配置Container容器内元素的方位
            width: 200,
            height: 200,
            // transform:Matrix4.translationValues(0, -40, 0),// 位移
            // transform:Matrix4.rotationZ(0.2),// 旋转
            transform:Matrix4.skewY(.2),
            decoration:BoxDecoration(
              color: Colors.yellow,  //背景颜色
              border: Border.all(   //边框
                color: Colors.red,
                width: 2
              ),
              borderRadius:BorderRadius.circular(10),  //配置圆角 也可以实现圆形
              boxShadow: const[   //配置阴影效果
                BoxShadow(
                  color:Colors.blue,
                  blurRadius:20.0
                )
              ],
              // LinearGradient 背景线性渐变 RadialGradient径向渐变
              gradient:const LinearGradient(
                colors:[
                  Colors.red,Colors.yellow
                ]
              )

            ) ,
            child: const Text("你好Flutter",style: TextStyle(
              color: Colors.black,
              fontSize: 20
            ),),
          ) ,
     );
  }
}


class MyButton extends StatelessWidget {
  const MyButton({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      alignment: Alignment.center,
      width: 200,
      height: 40,
      // margin: const EdgeInsets.all(10),   //四周margin
      margin: const EdgeInsets.fromLTRB(0, 40, 0, 0),
      // padding: const EdgeInsets.fromLTRB(40, 0, 0, 0),
      decoration: BoxDecoration(
        color: Colors.blue,
        borderRadius:BorderRadius.circular(20)
      ),
      child: const Text("按钮",style: TextStyle(
        color: Colors.white,
        fontSize: 20
      )),
    );
  }
}




class MyText extends StatelessWidget {
  const MyText({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 200,
      height: 200,
      margin: const EdgeInsets.fromLTRB(0, 40, 0, 0),
      decoration: const BoxDecoration(
        color: Colors.yellow
      ),
      child: const Text(
        "你好我是Flutter你好我是Flutter你好我是Flutter你好我是Flutter你好我是Flutter",
        textAlign: TextAlign.left,
        overflow: TextOverflow.ellipsis,   //溢出显示几个点
        maxLines: 1,
        style: TextStyle(
          fontSize: 20,
          fontWeight:FontWeight.w900,
          color: Colors.red,
          fontStyle:FontStyle.italic,
          letterSpacing:2,
          decoration:TextDecoration.underline,
          decorationColor: Colors.black,
          decorationStyle: TextDecorationStyle.dashed

        ),

      ),
    );
  }
}