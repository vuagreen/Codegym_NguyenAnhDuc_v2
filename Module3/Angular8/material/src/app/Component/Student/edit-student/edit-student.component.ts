import {Component, OnInit} from '@angular/core';
import {IStudent} from '../../../Model/student';
import {StudentService} from '../../../Service/student.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {
  editStudentForm: FormGroup;
  student: IStudent;

  constructor(
    private studentService: StudentService,
    private  formBuilder: FormBuilder,
    private  activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.editStudentForm = this.formBuilder.group(
      {
        tenSV: ['', [Validators.required, Validators.pattern(/^([A-Z])[a-z]+[[\ ][A-Z][a-z]+]*$/)]],
        tenNhom: ['', [Validators.required]],
        tenDeTai: ['', [Validators.required]],
        gvhd: ['', [Validators.required]],
        email: ['', [Validators.required, Validators.email]],
        soDienThoai: ['', [Validators.required, Validators.pattern(/^(090|091|([\(][\+]84[\)]90)|([\(][\+]84[\)]91))[0-9]{7}$/)]],
        id: ['']
      }
    );
    this.findById();
  }

  findById() {
    this.activatedRoute.params.subscribe(data => {
      this.studentService.findById(data.id).subscribe(data2 => {
        this.editStudentForm.patchValue(data2);
        console.log(data2);
      });
    });
  }

  editStudent() {
    this.student = this.editStudentForm.value;
    this.studentService.updateStudent(this.student).subscribe(data => {
      console.log(this.student);
      console.log(this.student.id);
    });
  }

}
