import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestChartingComponent } from './test-charting.component';

describe('TestChartingComponent', () => {
  let component: TestChartingComponent;
  let fixture: ComponentFixture<TestChartingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestChartingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestChartingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
