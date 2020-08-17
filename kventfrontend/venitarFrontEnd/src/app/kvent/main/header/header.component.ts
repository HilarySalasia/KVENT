import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import DateTimeFormat = Intl.DateTimeFormat;
import {DatePipe} from '@angular/common';
import {Router} from '@angular/router';
import {Login} from '../models/login';
import {MainService} from '../services/main-service.service';
import {User} from '../models/user';
import {Country} from '../models/country';
import {County} from '../models/county';
import {Ward} from '../models/ward';
import {Town} from '../models/town';
import {Credentials} from '../models/credentials';
import {AuthenticationContentService} from '../content/authentication-content/authentication-content.service';
import {SitesessionServiceService} from '../services/sitesession-service.service';
import {HeaderService} from './header.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  picHardLink;
  dateNow: Date = new Date();
  private _loginState: boolean;
  private _loginId: number;
  private _userDetails: User;


  user: User = <User> {country: {},  county: {},  ward: {},  town: {},  credentials: {}}
  title;
  subtitle;
  // checkToken(token: String): boolean {
  //
  // }

  @Output()
  get loginState(): boolean {
    return this._loginState;
  }

  set loginState(value: boolean) {
    this._loginState = value;
  }

  @Output()
  get loginId(): number {
    return this._loginId;
  }

  set loginId(value: number) {
    this._loginId = value;
  }


  constructor(private router: Router,
              private mainService: MainService,
              private acs: AuthenticationContentService,
              private ssS: SitesessionServiceService,
              private headerService: HeaderService) {
    setInterval(() => {
      this.dateNow = new Date();
    }, 1);
  }



  ngOnInit() {
    this.loginId = this.ssS.getUserId();
    this._loginState = this.ssS.checkUserState();
    this.picHardLink = 'assets/TempContent/Pictures/Logo1.png';
    // tslint:disable-next-line:no-unused-expression
    this._loginState ? this.getUserDetails(this._loginId) : null;
    this.title = this.headerService.getTitle();
    this.headerService.setUserDetails(this.user);
  }

  accessProcedure(procType: string) {
    if (procType === 'login' || procType === 'signup') {
      console.log('ProcType: ', procType);
      this.router.navigate(['authenticate', procType]);
    } else {
      this.logoutUser();
    }
  }

  getUserDetails(userId: number) {
    this.mainService.getUserById(userId)
      .subscribe(user => {
        this.user = user;
        this.headerService.setUserDetails(user);
      });
  }

  logoutUser() {
    this.acs.logout();
    this.router.navigate(['home']).then(() => {window.location.reload(); });
  }

  getTitle() {
    return this.headerService.getTitle();
  }
}
