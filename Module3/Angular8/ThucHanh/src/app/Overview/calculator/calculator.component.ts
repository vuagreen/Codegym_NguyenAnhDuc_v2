import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  oneput: number;
  twoput: number;
  opera = '+';
  output: number;

  changeOneput(value) {
    this.oneput = Number(value);
  }

  changeTwo(value) {
    this.twoput = Number(value);
  }

  changeOpera(value) {
    this.opera = value;
  }

  Caculator() {
    switch (this.opera) {
      case '+':
        this.output = this.oneput + this.twoput;
        break;
      case '-':
        this.output = this.oneput - this.twoput;
        break;
      case '*':
        this.output = this.oneput * this.twoput;
        break;
      case '/':
        this.output = this.oneput / this.twoput;
        break;
    }
  }

  constructor() { }

  ngOnInit() {
  }

}
