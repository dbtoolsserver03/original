import 'package:flutter/material.dart';
import 'package:photo_view/photo_view.dart';

class HeroPage extends StatefulWidget {
  final Map arguments;
  const HeroPage({super.key, required this.arguments});

  @override
  State<HeroPage> createState() => _HeroPageState();
}

class _HeroPageState extends State<HeroPage> {
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.pop(context);
      },
      child: Hero(
        tag: widget.arguments["imageUrl"],
        child: Scaffold(
          backgroundColor: Colors.black,
          body: Center(
            child: AspectRatio(
              aspectRatio: 16 / 9,
              child: PhotoView(
                imageProvider: NetworkImage(widget.arguments["imageUrl"]),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
