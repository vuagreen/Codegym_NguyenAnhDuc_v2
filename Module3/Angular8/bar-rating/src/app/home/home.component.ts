import {Component, OnInit} from '@angular/core';
import {Speech} from '@speak-tts';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {RxSpeechRecognitionService, resultList} from '@kamiazya/ngx-speech-recognition/public_api';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],

  providers: [RxSpeechRecognitionService]
})
export class HomeComponent implements OnInit {
  data: any;
  nestedjson: any;
  message = '';

  constructor(private formBuilder: FormBuilder, public service: RxSpeechRecognitionService) {


  }

  ngOnInit() {
    //  this.voicex();

  }

  listen() {
    this.service
      .listen()
      .pipe(resultList)
      .subscribe((list: SpeechRecognitionResultList) => {
        this.message = list.item(0).item(0).transcript;
        console.log('RxComponent:onresult', this.message, list);
      });
  }

  voice() {
    this.voicex();
  }

  voicex() {
    const ut = new SpeechSynthesisUtterance('Speak out');
    speechSynthesis.speak(ut);
  }

  onChangeEvent(ev) {
    console.log(ev.target.value); // should print option1
  }


}
