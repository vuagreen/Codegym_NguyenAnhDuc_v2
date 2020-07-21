import {Component, OnInit} from '@angular/core';
import {ContractdetailService} from '../Service/contractdetail.service';

@Component({
  selector: 'app-table-contract-detail',
  templateUrl: './table-contract-detail.component.html',
  styleUrls: ['./table-contract-detail.component.css']
})
export class TableContractDetailComponent implements OnInit {
  public contractDetails;

  constructor(public contractdetailService: ContractdetailService) {
  }

  ngOnInit() {
    this.contractdetailService.getAllContractDetail().subscribe(data => {
      this.contractDetails = data;
      console.log(this.contractDetails);
    });
  }

}
