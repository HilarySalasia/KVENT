import {HeaderComponent} from './header.component';
import {Injectable} from '@angular/core';
import {User} from '../models/user';
import {Observable, of} from 'rxjs';
import {AudioDets} from '../models/audioDets';
import {share} from 'rxjs/operators';

@Injectable()
export class HeaderService {
  private _userDetails: User = <User> {};
  state: boolean;
  sendTitle;
  sendSubTitle;
  audioDetails: AudioDets = <AudioDets> {};

  get userDetails() {
    return this._userDetails;
  }

  set userDetails(value: User) {
    this._userDetails = value;
  }

  constructor() {
  }

  public getUserDetails(): Observable<User> {
    // console.log('userDets0: ', this.userDetails);
    return of(this.userDetails);
  }

  public setUserDetails(user: User) {
    // console.log('userDets: ', user);
    this.userDetails = user;
  }

  public setTitle(title: string) {
    this.sendTitle = title;
  }

  public setSubTitle(subTitle: string) {
    this.sendSubTitle = subTitle;
  }

  public getTitle() {
    return this.sendTitle === null ? 'Loading Title' : this.sendTitle;
  }

  public getSubTitle() {
    return this.sendSubTitle;
  }

  public setAudioDetails(audioDets: AudioDets) {
    this.audioDetails = audioDets;
  }

  public getAudioDetails(): Observable<AudioDets> {
    return of(this.audioDetails);
  }
}
