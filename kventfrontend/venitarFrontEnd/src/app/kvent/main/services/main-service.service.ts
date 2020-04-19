import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Mixes} from '../models/mixes';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {environment} from '../../../../environments/environment';
import {Company} from '../models/company';
import {Picture} from '../models/picture';

@Injectable({
  providedIn: 'root'
})
export class MainService {
  public allMixesUrl = environment.links.getAllMixes;
  public httpOptions =  new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token',
    });
  constructor(private http: HttpClient) { }

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
}
