import { Component, OnInit } from '@angular/core';
import { AppConfig } from 'src/app/config/app.config';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  pageTitle: any;
  
  constructor() {}

  ngOnInit() {
    this.pageTitle = AppConfig.title
  }

}
