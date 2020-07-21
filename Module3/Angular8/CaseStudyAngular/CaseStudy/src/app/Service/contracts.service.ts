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
}
