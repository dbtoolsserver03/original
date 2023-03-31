import { Component, OnInit ,Input} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {


  //接收你组件传过来的数据
  @Input() title:any;
  @Input() msg:any;
  @Input() run:any;
  @Input() home:any;
  constructor() { }

  ngOnInit(): void {
  }

  getParentRun() {
    //执行父组件的run方法
    this.run();
    console.log('--');
    this.home.run();
  }
}
