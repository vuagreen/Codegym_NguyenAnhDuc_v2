import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MaterialModule} from './material.module';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {NgxPaginationModule} from 'ngx-pagination';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ListStudentComponent } from './Component/Student/list-student/list-student.component';
import { EditStudentComponent } from './Component/Student/edit-student/edit-student.component';
import { MenuComponent } from './Component/menu/menu.component';
import { LoginComponent } from './Component/login/login.component';
import { RecoverComponent } from './Component/recover/recover.component';

@NgModule({
  declarations: [
    AppComponent,
    ListStudentComponent,
    EditStudentComponent,
    MenuComponent,
    LoginComponent,
    RecoverComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
