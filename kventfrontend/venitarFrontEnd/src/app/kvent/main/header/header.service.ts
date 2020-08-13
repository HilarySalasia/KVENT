import {HeaderComponent} from './header.component';
import {Injectable} from '@angular/core';
import {User} from '../models/user';
import {Observable, of} from 'rxjs';


export class HeaderService {
  private _userDetails: User = <User> {};
  state: boolean;
  get userDetails() {
    return this._userDetails;
  }

  set userDetails(value: User) {
    this._userDetails = value;
  }

  constructor() {
  }

  public getUserDetails(): Observable<User> {
    console.log('userDets0: ', this.userDetails);
    return of(this.userDetails);
  }

  public setUserDetails(user: User) {
    console.log('userDets: ', user);
    this.userDetails = user;
  }
}
