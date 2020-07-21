import { Component } from '@angular/core';
import {NgModel, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
// @NgModel({import :[
//     //other imprts..
//     ReactiveFormsModule,
//   ]})

export class AppComponent {
  title = 'Angular-form';
}
