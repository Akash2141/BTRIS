import { Component, OnInit } from '@angular/core';
import { AppConfig } from '../config/app.config';

@Component({
  selector: 'app-product',
  templateUrl: './product.page.html',
  styleUrls: ['./product.page.scss'],
})
export class ProductPage implements OnInit {

  sliderConfig: any;
  pageTitle: string;

  constructor() {
    this.setSliderConfig();
  }

  setSliderConfig() {
    this.sliderConfig = {
      loop: false,
      effect: 'slide',

      freeMode: true,
      freeModeSticky: false,

      slidesPerView: 4,
      spaceBetween: 25
    }
  }

  ngOnInit() {
    this.pageTitle = AppConfig.title;
  }

}
