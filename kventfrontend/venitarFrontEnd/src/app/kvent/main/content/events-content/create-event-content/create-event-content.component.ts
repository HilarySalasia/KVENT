import { Component, OnInit } from '@angular/core';
import {MainService} from '../../../services/main-service.service';
import {SitesessionServiceService} from '../../../services/sitesession-service.service';
import {Event} from '../../../models/event';
import {GoogleService} from '../../../services/extServices/google.service';
import {HeaderService} from '../../../header/header.service';
import {DomSanitizer} from '@angular/platform-browser';
import {User} from '../../../models/user';
import {Country} from '../../../models/country';
import {County} from '../../../models/county';
import {Ward} from '../../../models/ward';
import {Town} from '../../../models/town';
import {mergeMap} from 'rxjs/operators';
import {forkJoin, of} from 'rxjs';
import {SetupService} from '../../../services/setup.service';
import {BusinessService} from '../../../services/business.service';
import {Company} from '../../../models/company';
import {Currency} from '../../../models/currency';
import {GeoDetails} from '../../../models/extModels/geoDetails';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-event-content',
  templateUrl: './create-event-content.component.html',
  styleUrls: ['./create-event-content.component.scss']
})
export class CreateEventContentComponent implements OnInit {
  private _locLink;
  loginState: boolean;
  userId: number;
  apiKey: string;
  city: string;
  userDetails: User = <User> {country: {},  county: {},  ward: {},  town: {}};
  companies: Company[] = [];
  currencies: Currency[] = [];
  geoLocation: GeoDetails = <GeoDetails> {};

  get locLink() {
    return this._locLink;
  }

  set locLink(value) {
    this._locLink = value;
  }
  event2Create: Event = <Event> {company: {}, currency: {}}
  constructor(private mainService: MainService,
              private ssS: SitesessionServiceService,
              private googleService: GoogleService,
              private headerService: HeaderService,
              private sanitizer: DomSanitizer,
              private setupService: SetupService,
              private businessService: BusinessService,
              private router: Router) { }

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.getFormData();
    this.loginState = this.ssS.checkUserState();
    this.userId = this.ssS.getUserId();
    this.apiKey = this.googleService.gcdKey;
    this.event2Create.userId = this.userId;
    this.headerService.setTitle('Create Event');
    this.getUserDetails();
  }

  createEvent() {
    this.addEvent();
  }

  findLocation(event: any) {
    this.locLink = this.googleService.showLocation(this.event2Create.eventLocation);
  }

  getUserDetails() {
    this.headerService.getUserDetails()
      .subscribe(user => {
        if  (user) {
          this.userDetails = user;
          this.city = this.userDetails.town.townName;
          }
      });
  }

  getFormData() {
    this.businessService.getCurrencies()
      .pipe(
        mergeMap(currencies => {
          const $companies = this.setupService.getCompanies();
          return forkJoin(of(currencies), $companies);
        })
      ).subscribe(([currencies, companies]) => {
        this.companies = companies;
        this.currencies = currencies;
      });
  }

  addEvent() {
    this.googleService.getLocation(this.event2Create.eventLocation)
      .pipe(
        mergeMap( geoLoc => {
          const $createEvent = this.businessService.addEvent(this.event2Create);
          this.event2Create.eventLocLatitude = geoLoc.results[0].geometry.location.lat.toString();
          this.event2Create.eventLocLongitude = geoLoc.results[0].geometry.location.lng.toString();
          return forkJoin($createEvent);
        }))
      .subscribe( ([event]) => {
        event !== null ? this.navEvent() : null;
      });
  }

  navEvent() {
    this.router.navigate(['events']).then();
  }

}
