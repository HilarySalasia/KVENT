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
import {FileUpload} from '../models/fileUpload';
import {ConfigSettings} from '../models/configSettings';

@Injectable()
export class MainService {
  public baseURL = environment.backend.baseURL;
  public httpOptions =  new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token',
    });
  public httpUploadOptions =  new HttpHeaders({
      // 'Content-Type': 'multipart/form-data; boundary=KventUpload',
      'Authorization': 'my-auth-token',
    });

  constructor(private http: HttpClient) {

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

  public uploadFile(mixFile: File, userId: number): Observable<FileUpload> {
    const formData = new FormData();
    formData.append('file', mixFile)
    formData.append('userID', userId.toString());
    // const params = new HttpParams();
    // params.append('userID', userId.toString())
    return this.http.post<FileUpload>(this.baseURL + '/Kvent/api/upload', formData,
      {headers: this.httpUploadOptions});
  }

  public addMix(mix: Mixes): Observable<Mixes> {
    return this.http.post<Mixes>(this.baseURL + '/Kvent/api/addMix', mix,
      {headers: this.httpOptions});
  }

  public addUser(user: User): Observable<User> {
    return this.http.post<User>(this.baseURL + '/Kvent/api/addUser', user, {headers: this.httpOptions});
  }

  public loginUser(username: string, password: string): Observable<Login> {
    const params = new HttpParams()
          .set('username', username)
          .set('password', password);
    return this.http.post<Login>(this.baseURL + '/Kvent/api/login', null,
      {headers: this.httpOptions, params: params});
  }

  public configSetting(): Observable<ConfigSettings> {
    return this.http.get<ConfigSettings>('./assets/kventConfig.json');
  }
}
