import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthenticationContentComponent } from './authentication-content.component';

describe('AuthenticationContentComponent', () => {
  let component: AuthenticationContentComponent;
  let fixture: ComponentFixture<AuthenticationContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthenticationContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthenticationContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
