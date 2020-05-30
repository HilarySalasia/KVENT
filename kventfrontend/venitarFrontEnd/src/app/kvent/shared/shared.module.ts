
import { NgModule } from '@angular/core';

import {CommonModule, DatePipe} from '@angular/common';

import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {FormsModule} from '@angular/forms';

import {HeaderComponent} from '../main/header/header.component';
import {FormErrorComponent} from './form-error-component/form-error-component';
import {ContentRoutingModule} from '../main/content/content-routing.module';



@NgModule({
  declarations: [
    FormErrorComponent
  ],

  providers: [],
  imports: [
    CommonModule,
    FontAwesomeModule,
    FormsModule
  ],
  exports: [
    FormErrorComponent
  ],
  // bootstrap: [AppModule]
})
export class SharedModule { }
