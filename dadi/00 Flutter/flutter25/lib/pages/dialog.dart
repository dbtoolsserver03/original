import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';

class DialogPage extends StatefulWidget {
  const DialogPage({super.key});

  @override
  State<DialogPage> createState() => _DialogPageState();
}

class _DialogPageState extends State<DialogPage> {
  void _alertDialog() async {
    var result = await showDialog(
        barrierDismissible: false, //表示点击灰色背景的时候是否消失弹出框
        context: context,
        builder: (context) {
          return AlertDialog(
            title: const Text("提示信息!"),
            content: const Text("您确定要删除吗"),
            actions: [
              TextButton(
                  onPressed: () {
                    print("ok");
                    Navigator.of(context).pop("ok"); //点击按钮让AlertDialog消失
                  },
                  child: const Text("确定")),
              TextButton(
                  onPressed: () {
                    print("cancel");
                    Navigator.of(context).pop("取消");
                  },
                  child: const Text("取消"))
            ],
          );
        });

    print("-----------");
    print(result);
  }

  void _simpleDialog() async {
    var result = await showDialog(
        barrierDismissible: false, //表示点击灰色背景的时候是否消失弹出框
        context: context,
        builder: (context) {
          return SimpleDialog(
            title: const Text("请选择语言"),
            children: [
              SimpleDialogOption(
                onPressed: () {
                  print("汉语");
                  Navigator.pop(context, "汉语");
                },
                child: const Text("汉语"),
              ),
              const Divider(),
              SimpleDialogOption(
                onPressed: () {
                  print("英语");
                  Navigator.pop(context, "英语");
                },
                child: const Text("英语"),
              ),
              const Divider(),
              SimpleDialogOption(
                onPressed: () {
                  print("日语");
                  Navigator.pop(context, "日语");
                },
                child: const Text("日语"),
              ),
              const Divider(),
            ],
          );
        });

    print("-----------");
    print(result);
  }

  void _modelBottomSheet() async{
    var result =await showModalBottomSheet(
        context: context,
        builder: (context) {
          return SizedBox(
            height: 240,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                ListTile(
                  title: const Text("分享"),
                  onTap: () {
                    print("分享");
                    Navigator.of(context).pop("分享");
                  },
                ),
                const Divider(),
                ListTile(
                  title: const Text("收藏"),
                  onTap: () {
                    print("收藏");
                    Navigator.of(context).pop("收藏");
                  },
                ),
                const Divider(),
                ListTile(
                  title: const Text("取消"),
                  onTap: () {
                    print("取消");
                    Navigator.of(context).pop("取消");
                  },
                ),
                const Divider(),
              ],
            ),
          );
        });
        print(result);
  }

  void _toast() {
    Fluttertoast.showToast(
        msg: "提示信息",
        toastLength: Toast.LENGTH_LONG,   //值针对 android 平台  
        gravity: ToastGravity.CENTER, //方位
        timeInSecForIosWeb: 1,  //提示时间 针对ios 和 web
        backgroundColor: Colors.black, //背景颜色 
        textColor: Colors.white,   //文本颜色 
        fontSize: 16.0  //文本字体大小
    );
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Dialog"),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              ElevatedButton(
                onPressed: _alertDialog,
                child: const Text('alert弹出框-AlertDialog '),
              ),
              const SizedBox(height: 20),
              ElevatedButton(
                onPressed: _simpleDialog,
                child: const Text('select弹出框-SimpleDialog'),
              ),
              const SizedBox(height: 20),
              ElevatedButton(
                onPressed: _modelBottomSheet,
                child: const Text('ActionSheet底部弹出框'),
              ),
              const SizedBox(height: 20),
              ElevatedButton(
                onPressed: _toast,
                child: const Text('Toast'),
              ),
              // fluttertoast
            ],
          ),
        ));
  }
}
