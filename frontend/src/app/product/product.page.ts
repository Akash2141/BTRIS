import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.page.html',
  styleUrls: ['./product.page.scss'],
})
export class ProductPage implements OnInit {

  sliderConfig: any;

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
  }

}
