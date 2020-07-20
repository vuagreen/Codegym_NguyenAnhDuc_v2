import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './Component/menu/menu.component';
import { SideBarComponent } from './Component/side-bar/side-bar.component';
import { TableListComponent } from './table-list/table-list.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    SideBarComponent,
    TableListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
