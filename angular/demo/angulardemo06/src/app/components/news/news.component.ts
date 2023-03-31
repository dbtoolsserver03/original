import { Component, OnInit,ViewChild } from '@angular/core';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {


  @ViewChild('footer') footer:any;
  constructor() { }

  ngOnInit(): void {
  }

  getChildMsg() {
    //获取footer子组件的数据
    console.log(this.footer.msg);
  }

  getChildRun(){
    this.footer.run();
  }
  run(e:any){

    console.log(e);
    console.log("我是父组件的run方法")
  }

}
