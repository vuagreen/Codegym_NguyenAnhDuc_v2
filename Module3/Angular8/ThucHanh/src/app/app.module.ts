import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './Overview/font-size-editor/font-size-editor.component';
import {HttpClientModule} from '@angular/common/http';
import { PetComponent } from './Overview/pet/pet.component';
import { CalculatorComponent } from './Overview/calculator/calculator.component';
import { ColorPickerComponent } from './Overview/color-picker/color-picker.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    CalculatorComponent,
    ColorPickerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
