import { TestBed } from '@angular/core/testing';

import { ContractdetailService } from './contractdetail.service';

describe('ContractdetailService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ContractdetailService = TestBed.get(ContractdetailService);
    expect(service).toBeTruthy();
  });
});
