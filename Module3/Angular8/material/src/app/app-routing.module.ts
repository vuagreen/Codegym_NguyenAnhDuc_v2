import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListStudentComponent} from './Component/Student/list-student/list-student.component';
import {EditStudentComponent} from './Component/Student/edit-student/edit-student.component';
import {LoginComponent} from './Component/login/login.component';
import {RecoverComponent} from './Component/recover/recover.component';


const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'student', component: ListStudentComponent},
  {path: 'student-edit/:id', component: EditStudentComponent},
  {path: 'student/:id', component: ListStudentComponent},
  {path: 'recover', component: RecoverComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
