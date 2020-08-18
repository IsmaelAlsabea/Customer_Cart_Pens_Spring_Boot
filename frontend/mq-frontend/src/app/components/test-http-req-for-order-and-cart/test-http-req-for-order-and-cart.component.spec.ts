import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestHttpReqForOrderAndCartComponent } from './test-http-req-for-order-and-cart.component';

describe('TestHttpReqForOrderAndCartComponent', () => {
  let component: TestHttpReqForOrderAndCartComponent;
  let fixture: ComponentFixture<TestHttpReqForOrderAndCartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestHttpReqForOrderAndCartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestHttpReqForOrderAndCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
