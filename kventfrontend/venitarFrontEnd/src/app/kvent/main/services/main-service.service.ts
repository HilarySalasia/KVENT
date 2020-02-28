import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Mixes} from "../models/mixes";
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor(private http: HttpClient) { }
  public getAllMixes(): Observable<Mixes[]> {
    const allMixesUrl = environment.links.getAllMixes;
    console.log('AllUrl: ', allMixesUrl);
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token',
      })
    };

    return this.http.get<Mixes[]>('/Kvent/api/getAllMixes', httpOptions);
  }
}
