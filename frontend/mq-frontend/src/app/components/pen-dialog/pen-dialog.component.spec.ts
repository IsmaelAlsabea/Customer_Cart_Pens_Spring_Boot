import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PenDialogComponent } from './pen-dialog.component';

describe('PenDialogComponent', () => {
  let component: PenDialogComponent;
  let fixture: ComponentFixture<PenDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PenDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PenDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
