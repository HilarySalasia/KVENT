import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {User} from '../../models/user';
import {DatePipe} from '@angular/common';
import {Country} from '../../models/country';
import {County} from '../../models/county';
import {Ward} from '../../models/ward';
import {Town} from '../../models/town';
import {Credentials} from '../../models/credentials';
import {mergeMap} from 'rxjs/operators';
import {forkJoin, of, pipe} from 'rxjs';
import {MainService} from '../../services/main-service.service';
import {Md5} from 'ts-md5';
import {Login} from '../../models/login';
import {HeaderComponent} from '../../header/header.component';
import {AuthenticationContentService} from './authentication-content.service';
// import * as fs from 'fs';

@Component({
  selector: 'app-authentication-content',
  templateUrl: './authentication-content.component.html',
  styleUrls: ['./authentication-content.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AuthenticationContentComponent implements OnInit {
   transc;
   actDiv: boolean;
   passCode: string;
   confPassCode: string;
   user: User = <User> {country: {},  county: {},  ward: {},  town: {},  credentials: {}};
   countries: Country[]  = [];
   counties: County[]  = [];
   wards: Ward[]  = [];
   towns: Town[] = [];
   login: Login = <Login> {};
   date: Date;
   minDate: Date;
   maxDate: Date;
   // fs = require('fs');
   dir = './tmp';
   username: string;
   password: string;
   allowedLogin: Login = <Login> {};
   matchError: String = 'Passwords Don\'t Match!!';

  constructor(private route: ActivatedRoute,
              private cdr: ChangeDetectorRef,
              private mainService: MainService,
              private router: Router,
              private acs: AuthenticationContentService) { }

  ngOnInit(): void {
    this.rangeDates();
    this.loadData();

  }

  rangeDates() {
    this.date = new Date();
    const maxYear = this.date.getFullYear() - 18;
    const minYear = this.date.getFullYear() - 80;
    this.maxDate = new Date(maxYear, this.date.getMonth(), this.date.getDate());
    this.minDate = new Date(minYear, this.date.getMonth(), this.date.getDate());
    console.log('Max Date: ', this.maxDate);
    console.log('Min Date: ', this.minDate);
    this.cdr.detectChanges();
  }

  load() {
    this.actDiv = false;
    if (this.transc === 'login') {
      this.actDiv = false;
      this.cdr.detectChanges();
    } else if (this.transc === 'signup') {
      this.actDiv = true;
      this.cdr.detectChanges();
    }  else if (this.transc === 'update details') {
      this.actDiv = true;
      this.cdr.detectChanges();
    }
  }

  loadData() {
    this.route.paramMap
      .subscribe((params) => {
      this.transc = params.get('transc');
      this.transc === 'signup' ? this.loadSignUp() : null;
      this.load();
      this.cdr.detectChanges();
    });
  }

  loadSignUp() {
    this.mainService.getCountries()
      .pipe(
      mergeMap(countries => {
        const $counties = this.mainService.getCounties();
        const $wards = this.mainService.getWards();
        const $towns = this.mainService.getTowns();
        return forkJoin(of(countries), $counties, $wards, $towns);
      })
    ).subscribe(([countries, counties, wards, towns]) => {
      this.countries = countries;
      this.counties = counties;
      this.wards = wards;
      this.towns = towns;
      this.cdr.detectChanges();
    });
  }

  signUpUser() {
    const md5 = new Md5();
    this.user.credentials.passCode = md5.appendStr(this.confPassCode).end().toString();
    this.user.fullName = this.user.firstName + ' ' + this.user.middleName + ' ' + this.user.surname;
    this.mainService.addUser(this.user)
      .subscribe(x => {
        this.user = <User> {country: {},  county: {},  ward: {},  town: {},  credentials: {}};
        this.confPassCode = null;
        this.passCode = null;
        this.cdr.detectChanges();
      });
  }

  loginUser() {
    const md5 = new Md5();
    const encryPass = md5.appendStr(this.password).end().toString();
    this.mainService.loginUser(this.username, encryPass).subscribe(login => {
      console.log(login);
      this.allowedLogin = login;

      if (login.loginUser != null) {
        this.acs.login(login.loginUser, login.loginToken);
        this.router.navigate(['/']).then(() => {window.location.reload();});
      }

      this.cdr.detectChanges();
    });
  }


}
