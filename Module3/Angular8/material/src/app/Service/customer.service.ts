import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  API = 'http://localhost:8080/customers';

  constructor(private http: HttpClient) {
  }


  getAllCustomer(): Observable<any> {
    return this.http.get(this.API);
  }

  addNewCustomer(customer): Observable<any> {
    return this.http.post(this.API, customer);
  }

  findById(id): Observable<any> {
    return this.http.get(`${this.API}/${id}`);
  }

  updateCustomer(customer): Observable<any> {
    return this.http.put(`${this.API}/${customer.id}`, customer);
  }

  deleteCustomer(id) {
    return this.http.delete(`${this.API}/${id}`);
  }

  sendMailRecover(email): Observable<any> {
    const link = this.API + '/recover/email/' + email.email;
    return this.http.get(link);
  }

  sendInfoRecover(customer): Observable<any> {
    const link = this.API + '/recover/info';
    return this.http.post(link, customer);
  }
}
