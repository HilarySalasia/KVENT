import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';

@Injectable()
export class LoadingScreenService {

  constructor() { }
  isLoading = new Subject<boolean>();
  show() {
    this.isLoading.next(true);
  }
  hide() {
    setInterval(() => {
      this.isLoading.next(false);
    }, 3000);
  }

}
