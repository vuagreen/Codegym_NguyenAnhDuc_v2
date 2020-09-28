import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ICustomer} from '../../Model/customer';
import {CustomerService} from '../../Service/customer.service';
import {StudentService} from '../../Service/student.service';

@Component({
  selector: 'app-recover',
  templateUrl: './recover.component.html',
  styleUrls: ['./recover.component.css']
})
export class RecoverComponent implements OnInit {
  recoverMailForm: FormGroup;
  recoverInfoForm: FormGroup;
  customer: ICustomer;
  email: {
    email: string;
  };
  formmailStatus = true;
  recoverCodeMailForm: FormGroup;

  constructor(private customerService: CustomerService,
              private  formBuilder: FormBuilder
  ) {
  }

  ngOnInit() {
    this.recoverMailForm = this.formBuilder.group(
      {
        email: ['', [Validators.required, Validators.pattern(/^[a-z][a-z0-9_\.]{5,32}@[a-z0-9]{2,}(\.[a-z0-9]{2,4}){1,2}$/)]]
      }
    );
    this.recoverCodeMailForm = this.formBuilder.group(
      {
        code: ['', [Validators.required]]
      }
    );
    this.recoverInfoForm = this.formBuilder.group(
      {
        id: ['', [Validators.required]],
        name: ['', [Validators.required]],
        idCard: ['', [Validators.required]],
        phoneNumber: ['', [Validators.required]],
        question: ['', [Validators.required]],
        email: ['', [Validators.required]],
        answer: ['', [Validators.required]],
        status: ['', [Validators.required]],
      }
    );
  }

  sendMailRecover() {
    console.log('Đang Gửi Email');
    console.log(this.recoverMailForm.value);
    this.formmailStatus = false;
    this.email = this.recoverMailForm.value;
    this.customerService.sendMailRecover(this.email).subscribe(data => {
        console.log('Gửi Mail Thành Công');
      }
    );
  }

  sendInfoRecover() {
    console.log('Đang Gửi Info');
    this.customer = this.recoverInfoForm.value;
    console.log(this.customer);
    // this.customerService.sendInfoRecover(this.customer).subscribe(data => {
    //   console.log('Gửi Info Thành Công');
    // });
  }
}
