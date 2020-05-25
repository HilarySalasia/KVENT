import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Mixes} from '../models/mixes';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {environment} from '../../../../environments/environment';
import {Company} from '../models/company';
import {Picture} from '../models/picture';
import {Country} from '../models/country';
import {County} from '../models/county';
import {Ward} from '../models/ward';
import {Town} from '../models/town';
import {User} from '../models/user';
import {Login} from '../models/login';

@Injectable({
  providedIn: 'root'
})
export class MainService {
  public allMixesUrl = environment.links.getAllMixes;
  public httpOptions =  new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token',
    });
  constructor(private http: HttpClient) {
    console.log('HttpReq: ', this.http);
  }

  public getAllMixes(): Observable<Mixes[]> {
    return this.http.get<Mixes[]>('/Kvent/api/getAllMixes', {headers: this.httpOptions});
  }

  public getPictureById(picId: Number): Observable<Picture> {
    const params = new HttpParams().set('picId', picId.toString());
    return this.http.get<Picture>('/Kvent/setup/getPictureById', {headers: this.httpOptions, params: params} );
  }

  public getCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>('/Kvent/setup/getCompanies', {headers: this.httpOptions});
  }

  public addMix(mix: Mixes): Observable<Mixes> {
    return this.http.post<Mixes>('/Kvent/api/addMix', mix, {headers: this.httpOptions});
  }

  public addPic(pic: Picture): Observable<Picture> {
    return this.http.post<Picture>('/Kvent/setup/addPicture', pic, {headers: this.httpOptions});
  }

  public getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>('/Kvent/setup/getCountries', {headers: this.httpOptions});
  }

  public getCounties(): Observable<County[]> {
    return this.http.get<County[]>('/Kvent/setup/getCounties', {headers: this.httpOptions});
  }

  public getWards(): Observable<Ward[]> {
    return this.http.get<Ward[]>('/Kvent/setup/getWards', {headers: this.httpOptions});
  }

  public getTowns(): Observable<Town[]> {
    return this.http.get<Town[]>('/Kvent/setup/getTowns', {headers: this.httpOptions});
  }

  public addUser(user: User): Observable<User> {
    return this.http.post<User>('/Kvent/api/addUser', user, {headers: this.httpOptions});
  }

  public loginUser(username: string, password: string): Observable<Login> {
    const params = new HttpParams()
          .set('username', username)
          .set('password', password);
    // const body = new HttpParams({
    //   fromObject: {
    //     'password': password,
    //     'username': username
    //   }
    // });
    console.log('params: ', params);
    return this.http.post<Login>('/Kvent/api/login', null, {headers: this.httpOptions, params: params});
  }
}
