import {TestBed} from '@angular/core/testing';

import {MyEntityService} from './my-entity.service';
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('MyEntityService', () => {
  let service: MyEntityService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(MyEntityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
