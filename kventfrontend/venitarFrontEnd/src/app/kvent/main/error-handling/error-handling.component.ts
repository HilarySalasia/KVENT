import { Component, OnInit } from '@angular/core';
import { ErrorHandlingService } from './error-handling.service';
import { Error } from '../models/error';

@Component({
  selector: 'app-error-handling',
  templateUrl: './error-handling.component.html',
  styleUrls: ['./error-handling.component.scss']
})
export class ErrorHandlingComponent implements OnInit {
  errors: Error [] = [];
  constructor(private errorHandlingService: ErrorHandlingService
    ) { }

  ngOnInit(): void {
    // $('#brandModal').modal('show');
    this.errors = this.errorHandlingService.errors;
  }

}
