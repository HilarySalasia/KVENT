import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormErrorComponentComponent } from './form-error-component.component';

describe('FormErrorComponentComponent', () => {
  let component: FormErrorComponentComponent;
  let fixture: ComponentFixture<FormErrorComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormErrorComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormErrorComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
