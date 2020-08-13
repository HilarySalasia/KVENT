import {environment} from '../../../../environments/environment';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Ward} from '../models/ward';
import {Town} from '../models/town';
import {Picture} from '../models/picture';
import {Country} from '../models/country';
import {County} from '../models/county';
import {Company} from '../models/company';
import {Injectable} from '@angular/core';

@Injectable()
export class SetupService {
  public baseURL = environment.backend.baseURL;
  public httpOptions =  new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token',
  });

  constructor(private http: HttpClient) {
    console.log('HttpReq: ', this.http);
  }

  public addPic(pic: Picture): Observable<Picture> {
    return this.http.post<Picture>(this.baseURL + '/Kvent/setup/addPicture', pic, {headers: this.httpOptions});
  }

  public getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(this.baseURL + '/Kvent/setup/getCountries', {headers: this.httpOptions});
  }

  public getCounties(): Observable<County[]> {
    return this.http.get<County[]>(this.baseURL + '/Kvent/setup/getCounties', {headers: this.httpOptions});
  }

  public getWards(): Observable<Ward[]> {
    return this.http.get<Ward[]>(this.baseURL + '/Kvent/setup/getWards', {headers: this.httpOptions});
  }

  public getTowns(): Observable<Town[]> {
    return this.http.get<Town[]>(this.baseURL + '/Kvent/setup/getTowns', {headers: this.httpOptions});
  }

  public getCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>(this.baseURL + '/Kvent/setup/getCompanies', {headers: this.httpOptions});
  }

  public getPictureById(picId: Number): Observable<Picture> {
    const params = new HttpParams().set('picId', picId.toString());
    return this.http.get<Picture>(this.baseURL + '/Kvent/setup/getPictureById', {headers: this.httpOptions, params: params} );
  }

}
