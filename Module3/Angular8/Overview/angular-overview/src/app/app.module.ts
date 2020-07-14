import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {studentComponent} from "./Components/student/student.component";
import { CustomerComponent } from './Components/customer/customer.component';

@NgModule({
  declarations: [
    AppComponent,
    studentComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
