import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {HttpModule} from '@angular/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ChartModule, HIGHCHARTS_MODULES} from 'angular-highcharts';
import * as exporting from 'highcharts/modules/exporting.src';
import * as exportdata from 'highcharts/modules/export-data.src';
import {SpeechRecognitionModule} from '@kamiazya/ngx-speech-recognition';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    ChartModule,
    SpeechRecognitionModule.withConfig({lang: 'en-US', interimResults: true, maxAlternatives: 10})
  ],
  providers: [{provide: HIGHCHARTS_MODULES, useFactory: () => [exporting, exportdata]}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
