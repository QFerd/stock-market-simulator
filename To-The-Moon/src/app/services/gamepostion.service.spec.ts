import { TestBed } from '@angular/core/testing';

import { GamepostionService } from './gamepostion.service';

describe('GamepostionService', () => {
  let service: GamepostionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GamepostionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
