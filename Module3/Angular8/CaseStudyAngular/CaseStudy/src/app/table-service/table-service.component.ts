import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {CustomerService} from '../Service/customer.service';
import {ServicesService} from '../Service/services.service';
import {ICustomer} from '../Model/customer';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {SeachService} from '../Service/seach.service';
import {CustomValidatorService} from '../Service/custom-validator.service';
import {IService} from '../Model/service';


@Component({
  selector: 'app-table-service',
  templateUrl: './table-service.component.html',
  styleUrls: ['./table-service.component.css']
})
export class TableServiceComponent implements OnInit {
  // tslint:disable-next-line:variable-name
  validation_messages = this.customValidatorService.validation_messages;
  term = '';
  p = 0;
  random = 0;
  public randomArray: string[] = ['', ''];
  public services: IService[];
  public service: IService = {
    id: 0,
    serId: 'DV-4466',
    serviceName: '',
    area: 0,
    numberOfFloors: 0,
    maximumNumberOfPeople: 0,
    rentalCosts: 0,
    rentalTypeCode: 0,
    status: ''
  };
  public formAddNewService: FormGroup;
  lock = false;

  constructor(
    public router: Router,
    public servicesService: ServicesService,
    public formBuilder: FormBuilder,
    public seachService: SeachService,
    public customValidatorService: CustomValidatorService
  ) {


  }

  ngOnInit() {
    this.getAllService();

    this.formAddNewService = this.formBuilder.group(
      {
        serviceName: ['', [Validators.required]],
        serId: ['', [Validators.required, Validators.pattern(/^DV-\d{4}$/)]],
        area: ['', [Validators.required]],
        numberOfFloors: ['', [Validators.required]],
        rentalCosts: ['', [Validators.required]],
        rentalTypeCode: ['', [Validators.required]],
        status: ['', [Validators.required]],
        maximumNumberOfPeople: ['', [Validators.required]],
        id: ['']
      }
    );
  }

  setterm(value) {
    this.term = value;
  }

  setServiceId() {
    this.random = 4466;
    this.service.serId = 'DV-' + this.random;
    while (this.randomArray.indexOf(this.service.serId) !== -1) {
      this.random = Math.floor(Math.random() * 9999) + 1000;
      this.service.serId = 'DV-' + this.random;
    }
  }


  getAllCode() {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.services.length; i++) {
      this.randomArray.push(this.services[i].serId);
    }
    console.log('random-aray :' + this.randomArray);
  }

  getAllService() {
    this.term = this.seachService.getSeach();
    this.servicesService.getAllService().subscribe(data => {
        this.services = data;
        console.log(this.services);
      },
      error1 => {
        console.log('Lỗi không lấy được dữ liệu');
      },
      () => {
        console.log('Load Data success !!');
        this.randomArray = [''];
        this.getAllCode();
        this.setServiceId();
        console.log('Create Service-ID success !!' + this.service.serId);
      });

  }

  addNewService() {
    this.servicesService.addNewService(this.formAddNewService.value).subscribe(data => {
      console.log('Add New Customer Sucess!!');
      this.getAllService();

    });
  }

  updateServicce() {
    console.log(this.formAddNewService.value);
    this.servicesService.updateService(this.formAddNewService.value).subscribe(data => {
      console.log('Update Customer Sucess!!');
      this.getAllService();

    });
  }

  deleteCustomer(id) {
    this.servicesService.deleteService(id).subscribe(
      () => {
        this.services = this.services.filter(
          t => t.id !== id
        );
        alert('delete Success !!  ID : ' + id);
        this.getAllService();

      }
    );
  }

  setService(service) {
    this.service = service;
    this.lock = false;
  }

  setServiceView(service) {
    this.service = service;
    this.lock = true;
  }
}
