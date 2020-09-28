import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  API = 'http://localhost:8080/customers';

  constructor(private http: HttpClient) {
  }


  getAllStudent(): Observable<any> {
    return this.http.get(this.API);
  }

  addNewStudent(student): Observable<any> {
    return this.http.post(this.API, student);
  }

  findById(id): Observable<any> {
    return this.http.get(`${this.API}/${id}`);
  }

  updateStudent(student): Observable<any> {
    return this.http.put(`${this.API}/${student.id}`, student);
  }

  deleteStudent(id) {
    return this.http.delete(`${this.API}/${id}`);

  }
}

