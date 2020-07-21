import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../Service/customer.service';

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css']
})
export class TableListComponent implements OnInit {
  public customers;

  constructor(
    public customerService: CustomerService
  ) {}

  ngOnInit() {
    this.customerService.getAllCustomer().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    });
  }

}
