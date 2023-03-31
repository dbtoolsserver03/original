import { Component, OnInit,Output,EventEmitter} from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  public msg="我是子组件footer的msg";

  @Output() private outer = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }

  run(){
    console.log("我是子组件的run方法");
  }
  sendParent(){
    this.outer.emit('我是子组件的数据');
  }
}
