import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../Service/employee.service';

@Component({
  selector: 'app-table-employee',
  templateUrl: './table-employee.component.html',
  styleUrls: ['./table-employee.component.css']
})
export class TableEmployeeComponent implements OnInit {
  public employee;

  constructor(public employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.employeeService.getAllEmployee().subscribe(data => {
      this.employee = data;
      console.log(this.employee);
    });
  }

}
