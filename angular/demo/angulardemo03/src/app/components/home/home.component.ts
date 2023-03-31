import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public picUrl='https://ssl.gstatic.com/ui/v1/icons/mail/rfr/logo_gmail_lockup_default_2x_r2.png';

  public list:any[]=[
    {
      "title":'我是新闻1'
    },{
      "title":'我是新闻2'
    },{
      "title":'我是新闻3'
    },

  ];

  public keywords:any="这是一个默认值";
  public flag:boolean=true;

  public attr:string="green";
  public orderStatus:number=2;//1.已经支付2.支付并确认订单3.已经发货4.已经收货5.无效

  public today:any=new Date();
  public title:string="我是一个TITLE";
  constructor() {

console.log(this.today);

  }

  ngOnInit(): void {
  }

    run(){
      alert("执行自定义方法");
    }
    getData(){
      alert(this.title);
    }
    setData(){
      this.title="我是一个改变后的TITLE";
    }
    keyDown(){
      console.log(11);
    }
    keyDownEvent(e:any){
      if(e.keyCode==13) {
        console.log("按了一个回车");
      } else{
        console.log(e.target.value);
      }
    }

    runEvent(e:any) {
      var dom:any=e.target;
      dom.style.color="red";
    }

    changeKeywords(){
      this.keywords="我是改变后的值";
    }
    getKeywords(){
      console.log(this.keywords);
    }
}
