import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  public API = ' http://localhost:3000/services';

  constructor(public http: HttpClient) {
  }

  getAllService(): Observable<any> {
    return this.http.get(this.API);
  }

  addNewService(service): Observable<any> {
    return this.http.post(this.API, service);
  }

  updateService(service): Observable<any> {
    return this.http.put(`${this.API}/${service.id}`, service);
  }

  deleteService(id: number): Observable<any> {
    return this.http.delete(`${this.API}/${id}`);
  }
}
