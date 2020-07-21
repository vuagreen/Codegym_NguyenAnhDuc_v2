import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableContractComponent } from './table-contract.component';

describe('TableContractComponent', () => {
  let component: TableContractComponent;
  let fixture: ComponentFixture<TableContractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableContractComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
