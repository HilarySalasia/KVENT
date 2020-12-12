import {environment} from '../../../../environments/environment';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Mixes} from '../models/mixes';
import {Transaction} from '../models/transaction';
import {Injectable} from '@angular/core';
@Injectable()
export class TransactionService {
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

  public getTransactions(token: string): Observable<Transaction[]> {
    const params = new HttpParams().set('token', token);
    return this.http.get<Transaction[]>(this.baseURL + '/Kvent/KvenTransc/getAllTransc',
      {headers: this.httpOptions, params: params});
  }

  public makeTransaction(transc: Transaction, token: string): Observable<any> {
    const params = new HttpParams().set('token', token);
    console.log('token: ', token, 'transaction: ', transc);
    return this.http.post(this.baseURL + '/Kvent/KvenTransc/transact',  transc,
      {headers: this.httpOptions, params: params});
  }

  public findPausedAudio(token: string): Observable<Transaction[]> {
    const params = new HttpParams().set('token', token);
    // console.log('token: ', token, 'transaction: ', transc);
    return this.http.post<Transaction[]>(this.baseURL + '/Kvent/KvenTransc/findPausedAudio',
      {headers: this.httpOptions, params: params});
  }
}
