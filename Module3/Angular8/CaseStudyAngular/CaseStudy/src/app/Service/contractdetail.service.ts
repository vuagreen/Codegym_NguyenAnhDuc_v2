import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContractdetailService {
  public API = ' http://localhost:3000/contractDetail';

  constructor(public http: HttpClient) {
  }

  getAllContractDetail(): Observable<any> {
    return this.http.get(this.API);
  }
}
