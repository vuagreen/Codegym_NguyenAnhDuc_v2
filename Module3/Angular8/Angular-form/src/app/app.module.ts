import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodoComponent } from './todo/todo.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { SignInComponent } from './sign-in/sign-in.component';
import { TimelinesComponent } from './timelines/timelines.component';
import { NameEditorComponent } from './name-editor/name-editor.component';
import { ControlMessagesComponent } from './control-messages/control-messages.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    SignInComponent,
    TimelinesComponent,
    NameEditorComponent,
    ControlMessagesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
