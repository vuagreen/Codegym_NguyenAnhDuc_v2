import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {CustomerService} from '../Service/customer.service';
import {ICustomer} from '../Model/customer';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {SeachService} from '../Service/seach.service';
import {CustomValidatorService} from '../Service/custom-validator.service';

@Component({
  selector: 'app-table-employee',
  templateUrl: './table-employee.component.html',
  styleUrls: ['./table-employee.component.css']
})
export class TableEmployeeComponent implements OnInit {
  // tslint:disable-next-line:variable-name
  validation_messages = this.customValidatorService.validation_messages;
  term = '';
  p = 0;
  random = 0;
  public randomArray: string[] = ['', ''];
  public customers: ICustomer[];
  public customer: ICustomer = {
    fullName: '',
    cusId: 'KH-4466',
    typeCustomer: '',
    birthday: '',
    idCard: '',
    email: '',
    phoneNumber: '',
    address: '',
    id: 0
  };
  public formAddNewCustomer: FormGroup;
  lock = false;

  constructor(
    public router: Router,
    public customerService: CustomerService,
    public formBuilder: FormBuilder,
    public seachService: SeachService,
    public customValidatorService: CustomValidatorService
  ) {


  }

  ngOnInit() {
    this.getAllCustomer();

    this.formAddNewCustomer = this.formBuilder.group(
      {
        fullName: ['', [Validators.required, Validators.pattern(/^([A-Z])[a-z]+[[\ ][A-Z][a-z]+]*$/)]],
        cusId: ['', [Validators.required, Validators.pattern(/^KH-\d{4}$/)]],
        typeCustomer: ['', [Validators.required]],
        birthday: ['', [Validators.required, this.customValidatorService.validatorAge]],
        idCard: ['', [Validators.required, Validators.pattern(/^\d{9}(\d{3})?$/)]],
        email: ['', [Validators.required, Validators.email]],
        phoneNumber: ['', [Validators.required, Validators.pattern(/^(090|091|([\(][\+]84[\)]90)|([\(][\+]84[\)]91))[0-9]{7}$/)]],
        address: ['', [Validators.required]],
        id: ['']
      }
    );
  }

  setterm(value) {
    this.term = value;
  }

  setCusId() {
    this.random = 4466;
    this.customer.cusId = 'KH-' + this.random;
    while (this.randomArray.indexOf(this.customer.cusId) !== -1) {
      this.random = Math.floor(Math.random() * 9999) + 1000;
      this.customer.cusId = 'KH-' + this.random;
    }
  }


  getAllCode() {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.customers.length; i++) {
      this.randomArray.push(this.customers[i].cusId);
    }
    console.log('random-aray :' + this.randomArray);
  }

  getAllCustomer() {
    this.term = this.seachService.getSeach();
    this.customerService.getAllCustomer().subscribe(data => {
        this.customers = data;
        console.log(this.customers);
      },
      error1 => {
        console.log('Lỗi không lấy được dữ liệu');
      },
      () => {
        console.log('Load Data success !!');
        this.randomArray = [''];
        this.getAllCode();
        this.setCusId();
        console.log('Create Customer-ID success !!' + this.customer.cusId);
      });

  }

  addNewCustomer() {
    this.customerService.addNewCustomer(this.formAddNewCustomer.value).subscribe(data => {
      console.log('Add New Customer Sucess!!');
      this.getAllCustomer();

    });
  }

  updateNewCustomer() {
    console.log(this.formAddNewCustomer.value);
    this.customerService.updateNewCustomer(this.formAddNewCustomer.value).subscribe(data => {
      console.log('Update Customer Sucess!!');
      this.getAllCustomer();

    });
  }

  deleteCustomer(id) {
    this.customerService.deleteCustomer(id).subscribe(
      () => {
        this.customers = this.customers.filter(
          t => t.id !== id
        );
        alert('delete Success !!  ID : ' + id);
        this.getAllCustomer();

      }
    );
  }

  setCustomer(customer) {
    this.customer = customer;
    this.lock = false;
  }

  setCustomerview(customer) {
    this.customer = customer;
    this.lock = true;
  }
}
