import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-form-error-component',
  templateUrl: './form-error-component.html',
  styleUrls: ['./form-error-component.scss']
})
export class FormErrorComponent implements OnInit {
  private _errorMessage: string;

  get errorMessage(): string {
    return this._errorMessage;
  }

  @Input()
  set errorMessage(value: string) {
    this._errorMessage = value;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
