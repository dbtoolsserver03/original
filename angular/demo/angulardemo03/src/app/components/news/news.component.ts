import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {


  public title="我是新闻组件";
  msg="我是一个新闻组件的MSG";
  
  private username:string="张三"; // 在模板里不可以访问private属性

  // 推荐写法
  public student:any="我是一个学生的属性（数据）";

  public userinfo:any={
    username:"张三obj",
    age:'20'
  }

  public message:any;
/*
option + shift + a  块注释 

public      共有 * （默认）  可以在这个类里面使用，也可以在类外面使用
protected   保护类型        只有在当前类和它的子类里面可以访问
private     私有            只有在当前类才可以访问这个属性

VIEW02   9：48
*/

public content="<h2>我是一个html标签</h2>";


// 定义数组

// 偷懒写法
public arr=['111','222','333'];

// 推辞
public list:any[]=['我是第1个新闻','我是第2个新闻','我是第3个新闻'];

public itmes:Array<string>=['我是第11个新闻','我是第22个新闻','我是第33个新闻'];

public userlist:any[]=[
  {
    username:'张三',
    age:20
  },{
    username:'李四',
    age:21
  },{
    username:'王五',
    age:40
  },{
    username:'赵六',
    age:50
  }
]
public cars:any[]=[
  {
    cate:'BMW',
    list:[
      {
        title:"BMW x1",
        price:'30w'
      },{
        title:"BMW x2",
        price:'32w'
      },{
        title:"BMW x3",
        price:'33w'
      }
    ]
  },{
    cate:'AUDI',
    list:[
      {
        title:"AUDI Q1",
        price:'20w'
      },{
        title:"AUDI Q2",
        price:'22w'
      },{
        title:"AUDI Q3",
        price:'23w'
      }
    ]
  }
]

  constructor() {
    this.message="这是给属性赋值 改变属性值";
    console.log(this.msg);
    this.msg="我是改变后的MSG值";
  }

  ngOnInit(): void {
  }

}
