import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API = 'http://localhost:3000/customers';
  constructor(
    public http: HttpClient
  ) {}

  getAllCustomer(): Observable<any> {
    return this.http.get(this.API);
  }
}
