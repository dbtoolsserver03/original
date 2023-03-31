import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {

  title="我是一个新闻组件--ts"; //默认是public
  constructor() { }

  ngOnInit(): void {
  }

}
