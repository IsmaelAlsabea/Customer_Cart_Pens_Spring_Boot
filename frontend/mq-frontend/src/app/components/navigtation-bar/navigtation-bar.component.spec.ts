import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigtationBarComponent } from './navigtation-bar.component';

describe('NavigtationBarComponent', () => {
  let component: NavigtationBarComponent;
  let fixture: ComponentFixture<NavigtationBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavigtationBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigtationBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
