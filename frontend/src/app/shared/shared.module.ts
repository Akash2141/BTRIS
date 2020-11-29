import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { HeaderComponent } from './header/header.component'
import { IonicModule } from '@ionic/angular';


@NgModule({
  declarations: [
    HeaderComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    IonicModule.forRoot(),
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    HeaderComponent
  ]
})
export class SharedModule { }
