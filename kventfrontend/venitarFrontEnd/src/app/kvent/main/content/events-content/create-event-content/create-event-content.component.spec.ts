import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateEventContentComponent } from './create-event-content.component';

describe('CreateEventContentComponent', () => {
  let component: CreateEventContentComponent;
  let fixture: ComponentFixture<CreateEventContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateEventContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateEventContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
