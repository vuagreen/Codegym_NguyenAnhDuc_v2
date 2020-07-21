import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }


  onSubmit(formSignIn) {
    console.log(formSignIn);
    throw new Error('FORM IN INVALID');
  }
}
