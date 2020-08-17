import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadMixComponent } from './upload-mix.component';

describe('UploadMixComponent', () => {
  let component: UploadMixComponent;
  let fixture: ComponentFixture<UploadMixComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadMixComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadMixComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
