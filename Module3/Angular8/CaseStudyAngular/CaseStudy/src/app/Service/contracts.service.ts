import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContractsService {
  public API = ' http://localhost:3000/contracts';

  constructor(public http: HttpClient) {
  }

  getAllContracts(): Observable<any> {
    return this.http.get(this.API);
  }
  addNewContract(contract): Observable<any> {
    return this.http.post(this.API, contract);
  }

  updateContract(contract): Observable<any> {
    return this.http.put(`${this.API}/${contract.id}`, contract);
  }

  deleteContract(id: number): Observable<any> {
    return this.http.delete(`${this.API}/${id}`);
  }
}
