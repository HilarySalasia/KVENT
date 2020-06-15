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

@Injectable()
export class MainService {
  public baseURL = environment.backend.baseURL;
  public httpOptions =  new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token',
    });
  constructor(private http: HttpClient) {
    console.log('HttpReq: ', this.http);
  }

  public getAllMixes(): Observable<Mixes[]> {
    return this.http.get<Mixes[]>(this.baseURL + '/Kvent/api/getMixes', {headers: this.httpOptions});
  }

  public getUserById(userId: number): Observable<User> {
    const params = new HttpParams().set('userId', userId.toString());
    return this.http.get<User>(this.baseURL + '/Kvent/api/getUser', {headers: this.httpOptions, params: params} );
  }

  public getCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>(this.baseURL + '/Kvent/setup/getCompanies', {headers: this.httpOptions});
  }

  public addMix(mix: Mixes): Observable<Mixes> {
    return this.http.post<Mixes>(this.baseURL + '/Kvent/api/addMix', mix, {headers: this.httpOptions});
  }

  public addUser(user: User): Observable<User> {
    return this.http.post<User>(this.baseURL + '/Kvent/api/addUser', user, {headers: this.httpOptions});
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
    return this.http.post<Login>(this.baseURL + '/Kvent/api/login', null,
      {headers: this.httpOptions, params: params});
  }
}
