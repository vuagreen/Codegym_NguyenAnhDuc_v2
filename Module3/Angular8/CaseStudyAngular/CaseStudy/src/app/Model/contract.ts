import {ICustomer} from './customer';
import {IService} from './service';
import {IEmployee} from './employee';

export interface IContract {
  id: number;
  cusId: ICustomer;
  empId: IEmployee;
  serId: IService;
  startDate: string;
  endDate: string;
  deposit: string;
  total: string;
}
