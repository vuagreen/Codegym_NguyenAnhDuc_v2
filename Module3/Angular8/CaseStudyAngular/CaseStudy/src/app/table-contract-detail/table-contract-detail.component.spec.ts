import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableContractDetailComponent } from './table-contract-detail.component';

describe('TableContractDetailComponent', () => {
  let component: TableContractDetailComponent;
  let fixture: ComponentFixture<TableContractDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableContractDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableContractDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
