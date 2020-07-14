import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {
  color = '#00e067';

  changeColor(value) {
    this.color = value;
  }

  constructor() { }

  ngOnInit() {
  }

}
