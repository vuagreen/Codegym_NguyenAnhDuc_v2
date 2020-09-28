import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ContractsService} from '../Service/contracts.service';
import {IContract} from '../Model/contract';
import {ICustomer} from '../Model/customer';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {SeachService} from '../Service/seach.service';
import {CustomValidatorService} from '../Service/custom-validator.service';
import {CustomerService} from '../Service/customer.service';
import {ServicesService} from '../Service/services.service';
import {IService} from '../Model/service';
import {IEmployee} from '../Model/employee';
import {EmployeeService} from '../Service/employee.service';


@Component({
  selector: 'app-table-contract',
  templateUrl: './table-contract.component.html',
  styleUrls: ['./table-contract.component.css']
})
export class TableContractComponent implements OnInit {
  // tslint:disable-next-line:variable-name
  validation_messages = this.customValidatorService.validation_messages;
  term = '';
  time1: string;
  time2: string;
  p = 0;
  total = 100;
  now = new Date();
  public contracts: IContract[];
  public contract: IContract = {
    id: 0,
    empId: {
      empId: 'KH-4466',
      fullName: '',
      position: '',
      academicLevel: '',
      part: '',
      birthday: '',
      idCard: '',
      salary: '',
      email: '',
      phoneNumber: '',
      address: '',
      id: 0
    },
    cusId: {
      fullName: '',
      cusId: 'KH-4466',
      typeCustomer: '',
      birthday: '',
      idCard: '',
      email: '',
      phoneNumber: '',
      address: '',
      id: 0
    },
    serId: {
      id: 0,
      serId: 'DV-4466',
      serviceName: '',
      area: 0,
      numberOfFloors: 0,
      maximumNumberOfPeople: 0,
      rentalCosts: 0,
      rentalTypeCode: 0,
      status: ''
    },
    startDate: '',
    endDate: '',
    deposit: '',
    total: ''
  };
  public formAddNewContract: FormGroup;
  public employees: IEmployee[];
  public employee: IEmployee = {
    empId: 'KH-4466',
    fullName: '',
    position: '',
    academicLevel: '',
    part: '',
    birthday: '',
    idCard: '',
    salary: '',
    email: '',
    phoneNumber: '',
    address: '',
    id: 0
  };
  lock = false;
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

  constructor(
    public router: Router,
    public contractsService: ContractsService,
    public servicesService: ServicesService,
    public customerService: CustomerService,
    public formBuilder: FormBuilder,
    public seachService: SeachService,
    public customValidatorService: CustomValidatorService,
    public employeeService: EmployeeService
  ) {


  }

  ngOnInit() {
    this.getAllCustomer();
    this.getAllService();
    this.getAllEmployee();
    this.getAllContract();
    this.formAddNewContract = this.formBuilder.group(
      {
        cusId: ['', [Validators.required]],
        empId: ['', [Validators.required]],
        serId: ['', [Validators.required]],
        startDate: ['', [Validators.required, this.customValidatorService.validatorStartDate]],
        endDate: ['', [Validators.required, this.customValidatorService.validatorEndDate]],
        deposit: ['', [Validators.required]],
        total: ['', [Validators.required]],
        id: ['']
      }
    );
  }

  onChange() {
    // tslint:disable-next-line:prefer-const
    this.time1 = this.formAddNewContract.get('startDate').value;
    this.time2 = this.formAddNewContract.get('endDate').value;
    this.total = this.formAddNewContract.get('serId').value.rentalCosts;
  }

  setterm(value) {
    this.term = value;
  }

  resetOb() {
    this.contract.endDate = '';
    this.contract.startDate = '';
    this.contract = {
      id: 0,
      empId: {
        empId: 'KH-4466',
        fullName: '',
        position: '',
        academicLevel: '',
        part: '',
        birthday: '',
        idCard: '',
        salary: '',
        email: '',
        phoneNumber: '',
        address: '',
        id: 0
      },
      cusId: {
        fullName: '',
        cusId: 'KH-4466',
        typeCustomer: '',
        birthday: '',
        idCard: '',
        email: '',
        phoneNumber: '',
        address: '',
        id: 0
      },
      serId: {
        id: 0,
        serId: 'DV-4466',
        serviceName: '',
        area: 0,
        numberOfFloors: 0,
        maximumNumberOfPeople: 0,
        rentalCosts: 0,
        rentalTypeCode: 0,
        status: ''
      },
      startDate: this.now.getFullYear() + '-0' + this.now.getMonth() + '-' + this.now.getDate(),
      endDate: this.now.getFullYear() + '-0' + this.now.getMonth() + '-' + (this.now.getDate() + 1),
      deposit: '',
      total: ''
    };
  }

  getAllContract() {
    this.term = this.seachService.getSeach();
    this.contractsService.getAllContracts().subscribe(data => {
        this.contracts = data;
        console.log(this.contracts);
      },
      error1 => {
        console.log('Lỗi không lấy được dữ liệu');
      },
      () => {
        console.log('Load Data success !!');
      });

  }

  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(data => {
        this.customers = data;
        console.log(this.customers);
      },
      error1 => {
        console.log('Lỗi không lấy được dữ liệu');
      },
      () => {
        console.log('Load Data success !!');
      });

  }

  getAllService() {
    this.servicesService.getAllService().subscribe(data => {
        this.services = data;
        console.log(this.services);
      },
      error1 => {
        console.log('Lỗi không lấy được dữ liệu');
      },
      () => {
        console.log('Load Data success !!');
      });

  }

  getAllEmployee() {
    this.employeeService.getAllEmployee().subscribe(data => {
        this.employees = data;
        console.log(this.employees);
      },
      error1 => {
        console.log('Lỗi không lấy được dữ liệu');
      },
      () => {
        console.log('Load Data success !!');
      });

  }

  addNewContract() {
    this.contractsService.addNewContract(this.formAddNewContract.value).subscribe(data => {
      console.log('Add New Customer Sucess!!');
      this.getAllContract();

    });
    this.resetOb();
  }

  updateContract() {
    console.log(this.formAddNewContract.value);
    this.contractsService.updateContract(this.formAddNewContract.value).subscribe(data => {
      console.log('Update Customer Sucess!!');
      this.getAllContract();

    });
    this.resetOb();
  }

  deleteContract(id) {
    this.contractsService.deleteContract(id).subscribe(
      () => {
        this.contracts = this.contracts.filter(
          t => t.id !== id
        );
        alert('delete Success !!  ID : ' + id);
        this.getAllContract();

      }
    );
  }

  setContract(contract) {
    this.contract = contract;
    this.lock = false;
  }

  setContractView(contract) {
    this.contract = contract;
    console.log(this.formAddNewContract);
    this.lock = true;
  }
}
