import {Component, OnInit} from '@angular/core';
import {ContractsService} from '../Service/contracts.service';

@Component({
  selector: 'app-table-contract',
  templateUrl: './table-contract.component.html',
  styleUrls: ['./table-contract.component.css']
})
export class TableContractComponent implements OnInit {
  public contracts;

  constructor(public contractsService: ContractsService) {
  }

  ngOnInit() {
    this.contractsService.getAllContracts().subscribe(data => {
      this.contracts = data;
      console.log(this.contracts);
    });
  }

}
