import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {

  constructor() { }

  name: string = "Tran van teo";
  age: number = 29;
  img: string = "https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.0-9/37422469_1750116951775198_1978236059359641600_o.jpg?_nc_cat=100&_nc_sid=dd9801&_nc_ohc=0JYJI1LQcP0AX91-ZcY&_nc_ht=scontent.fsgn2-6.fna&oh=0e30563f43d67d9b330f2c084581e5c6&oe=5F2BA191";
  mang: string[] = ["aa", "bbb", "cccc"];
  action ={game:"LMHT", book: "ACSIMENT"}
  ngOnInit() {
  }

}
