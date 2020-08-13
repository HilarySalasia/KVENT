import {environment} from '../../../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Picture} from '../models/picture';
import {Observable} from 'rxjs';
import {Country} from '../models/country';
import {County} from '../models/county';
import {Company} from '../models/company';
import {Currency} from '../models/currency';
import {Event} from '../models/event';
import {Mixes} from '../models/mixes';
import {Injectable} from '@angular/core';

@Injectable()
export class BusinessService {
  public baseURL = environment.backend.baseURL;
  public httpOptions =  new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token',
  });

  constructor(private http: HttpClient) {
    console.log('HttpReq: ', this.http);
  }

  public addCurrency(currency: Currency): Observable<Currency> {
    return this.http.post<Currency>(this.baseURL + '/Kvent/bus/addCurrency', currency, {headers: this.httpOptions});
  }

  public getCurrencies(): Observable<Currency[]> {
    return this.http.get<Currency[]>(this.baseURL + '/Kvent/bus/currencies', {headers: this.httpOptions});
  }

  public addEvent(event: Event): Observable<Event> {
    console.log('Event: ', event);
    return this.http.post<Event>(this.baseURL + '/Kvent/bus/addEvent', event, {headers: this.httpOptions});
  }

  public getEvents(): Observable<Event[]> {
    return this.http.get<Event[]>(this.baseURL + '/Kvent/bus/events', {headers: this.httpOptions});
  }
}
