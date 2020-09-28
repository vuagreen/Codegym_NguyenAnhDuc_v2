import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MenuComponent} from './Component/menu/menu.component';
import {SideBarComponent} from './Component/side-bar/side-bar.component';
import {TableListComponent} from './table-customer/table-list.component';
import {TableEmployeeComponent} from './table-employee/table-employee.component';
import {TableServiceComponent} from './table-service/table-service.component';
import {TableContractComponent} from './table-contract/table-contract.component';
import {HttpClientModule} from '@angular/common/http';
import {TableContractDetailComponent} from './table-contract-detail/table-contract-detail.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    SideBarComponent,
    TableListComponent,
    TableEmployeeComponent,
    TableServiceComponent,
    TableContractComponent,
    TableContractDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
