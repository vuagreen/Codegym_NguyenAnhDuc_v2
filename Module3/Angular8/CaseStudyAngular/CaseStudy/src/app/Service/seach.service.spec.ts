import { TestBed } from '@angular/core/testing';

import { SeachService } from './seach.service';

describe('SeachService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SeachService = TestBed.get(SeachService);
    expect(service).toBeTruthy();
  });
});
