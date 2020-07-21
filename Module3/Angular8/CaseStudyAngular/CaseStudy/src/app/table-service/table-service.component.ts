import {Component, OnInit} from '@angular/core';
import {ServicesService} from '../Service/services.service';

@Component({
  selector: 'app-table-service',
  templateUrl: './table-service.component.html',
  styleUrls: ['./table-service.component.css']
})
export class TableServiceComponent implements OnInit {
  public services;

  constructor(public servicesService: ServicesService) {
  }

  ngOnInit() {
    this.servicesService.getAllService().subscribe(data => {
      this.services = data;
      console.log(this.services);
    });
  }

}
