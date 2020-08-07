import {Injectable} from '@angular/core';
import {FormGroup} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class CustomValidatorService {
  // tslint:disable-next-line:variable-name
  public validation_messages = {
    fullname: [
      {type: 'required', message: ' Vui Lòng Nhập Họ Tên'},
      {type: 'pattern', message: 'Tên Không Được Chứa Ký Tự Đặc Biệt và phải Viết Hoa Chữ Cái Đầu'}
    ],
    cusId: [
      {type: 'required', message: 'Mã khách hàng không được để trống'},
      {type: 'pattern', message: 'Mã khách hàng không đúng định dạng KH-XXXX với X là number'}
    ],
    typeCustomer: [
      {type: 'required', message: 'Loại khách không được để trống'},
    ],
    birthday: [
      {type: 'required', message: 'Ngày sinh không được để trống'},
      {type: 'age', message: 'Tuổi trên 18'},
      {type: 'date', message: 'Ngày Làm Hợp Đồng Không Chính Xác'}
    ],
    idCard: [
      {type: 'required', message: 'CMND không được để trống'},
      {type: 'pattern', message: 'CMND không đúng định dạng'}
    ],
    phoneNumber: [
      {type: 'required', message: 'SDT không được để trống'},
      {type: 'pattern', message: 'Số điện thoại không đúng định dạng'}
    ],
    email: [
      {type: 'required', message: 'Email không được để trống'},
      {type: 'email', message: 'Email không đúng định dạng abc@abc.abc'}
    ],
    number: [
      {type: 'required', message: 'Không được để trống'},
      {type: 'email', message: 'Email không đúng định dạng abc@abc.abc'}
    ],
    address: [
      {type: 'required', message: 'Địa chỉ không được để trống'},
    ],
    text: [
      {type: 'required', message: ' Không được để trống'},
    ],
    maximumNumberOfPeople: [
      {type: 'required', message: ' Không được để trống'},
    ],
    area: [
      {type: 'required', message: ' Không được để trống'},
    ]
  };

  constructor() {
  }

  validatorAge(formAddNewCustomer: FormGroup) {
    const now = new Date().valueOf();
    const birtday = new Date(formAddNewCustomer.value).valueOf();
    return (now - birtday) / (365.25 * 24 * 3600 * 1000) < 18 ? {age: true} : null;
  }

  validatorStartDate(formAddNewContract: FormGroup) {
    const now = new Date().valueOf();
    const startDate = new Date(formAddNewContract.value).valueOf();
    return (now === startDate) ? {date: true} : null;
  }
  validatorEndDate(formAddNewContract: FormGroup) {
    const now = new Date().valueOf();
    const startDate = new Date(formAddNewContract.value).valueOf();
    return (now < startDate) ? {date: true} : null;
  }
  }
