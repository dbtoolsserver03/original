/*
ViewChild获取dom节点

1.模板中给dom起一个名字
  <div #mybox>我是一个DOM结点</div>

2.在业务逻辑里引入viewChild
  import { Component, OnInit, ViewChild } from '@angular/core';

3.写在类里面
  @ViewChild('mybox') myBox:any;

4.在生命周期函数里获取dom
  ngAfterViewInit(): void {
*/

import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {

  // 获取dom节点
  @ViewChild('mybox') myBox:any;

  //获取一个组件
  @ViewChild('header') header:any;
  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    //Called after ngAfterContentInit when the component's view has been initialized. Applies to components only.
    //Add 'implements AfterViewInit' to the class.
    console.log(this.myBox);
    this.myBox.nativeElement.style.width="100px";
    this.myBox.nativeElement.style.height="100px";
    this.myBox.nativeElement.style.background="red";
    console.log(this.myBox.nativeElement.innerHTML);


  }
  getChildRun(){
    //调用子组件里面的方法  如果想获得子组件的成员或方法,一定要用viewChild
    this.header.run();
  }
}
