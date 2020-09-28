import {Component, OnInit} from '@angular/core';
import {IStudent} from '../../../Model/student';
import {StudentService} from '../../../Service/student.service';
import {ActivatedRoute} from '@angular/router';
import {ICustomer} from '../../../Model/customer';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {
  students: ICustomer[];
  student: ICustomer;
  temp: '';
  p: 0;
  id = 0;

  constructor(
    private studentService: StudentService,
  ) {}

  ngOnInit() {
    this.getAllStudent();
  }

  getAllStudent() {
    this.studentService.getAllStudent().subscribe(data => {
        console.log(data);
        this.students = data;
      }, error => {
        console.log('Get Data Thất Bại ');
      }, () => {
        console.log('Get Data Thành Công');
      }
    );
  }

  setId(id) {
    this.id = id;
    console.log(this.id);
  }

  deleteStudent() {
    this.studentService.deleteStudent(this.id).subscribe(data => {
      alert('Delete Success !! ID :' + this.id);
      this.getAllStudent();
    });
  }

}
