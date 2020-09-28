import {Component} from '@angular/core';
import * as RecordRTC from 'recordrtc';
import {DomSanitizer} from '@angular/platform-browser';
import {BrandService} from './Overview/service/brand.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private record;
  private recording = false;
  private url;
  private error;
  title: 'record';

  constructor(private domSanitizer: DomSanitizer, private brandService: BrandService) {
  }

  sanitize(url: string) {
    console.log(url);
    return this.domSanitizer.bypassSecurityTrustUrl(url);
  }

  /**
   * Start recording.
   */
  initiateRecording() {
    this.recording = true;
    const mediaConstraints = {
      video: false,
      audio: true
    };
    navigator.mediaDevices
      .getUserMedia(mediaConstraints)
      .then(this.successCallback.bind(this), this.errorCallback.bind(this));
  }

  /**
   * Will be called automatically.
   */
  successCallback(stream) {
    // tslint:disable-next-line:prefer-const
    let options = {
      mimeType: 'audio/wav',
      numberOfAudioChannels: 1
    };
    // Start Actuall Recording
    // tslint:disable-next-line:prefer-const
    let StereoAudioRecorder = RecordRTC.StereoAudioRecorder;
    this.record = new StereoAudioRecorder(stream, options);
    this.record.record();
  }

  /**
   * Stop recording.
   */
  stopRecording() {
    this.recording = false;
    this.record.stop(this.processRecording.bind(this));
  }

  testText() {
    this.brandService.TextToSpeech().subscribe(data => {
      this.url = '';
      this.url = data.async;
      console.log('success');
      console.log(data);
      console.log(this.url);
    });
  }
  processRecording(blob) {
    console.log(blob);
    this.brandService.SpeechToText(blob).subscribe(data => {
      console.log(data);
    });
    // this.url = URL.createObjectURL(blob);
  }

  errorCallback(error) {
    this.error = 'Can not play audio in your browser';
  }
}
