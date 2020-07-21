import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TableListComponent} from './table-customer/table-list.component';
import {TableEmployeeComponent} from './table-employee/table-employee.component';
import {TableServiceComponent} from './table-service/table-service.component';
import {TableContractComponent} from './table-contract/table-contract.component';
import {TableContractDetailComponent} from './table-contract-detail/table-contract-detail.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

const routes: Routes = [
  {path: '', component: TableListComponent},
  {path: 'employee', component: TableEmployeeComponent},
  {path: 'service', component: TableServiceComponent},
  {path: 'contract', component: TableContractComponent},
  {path: 'contractdetail', component: TableContractDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
