import {environment} from '../../../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Transaction} from '../models/transaction';
import {TransactionService} from './transaction.service';
import {Injectable} from '@angular/core';
@Injectable()
export class TransactService {
  public baseURL = environment.backend.baseURL;
  public httpOptions =  new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token',
  });
  public httpUploadOptions =  new HttpHeaders({
    // 'Content-Type': 'multipart/form-data; boundary=KventUpload',
    'Authorization': 'my-auth-token',
  });

  constructor(private transaction: TransactionService) {

  }
  audioTranscId: number;

  public playAudio(transc: Transaction, token: string) {
    this.transaction.makeTransaction(transc, token).subscribe(transcId => {
      this.audioTranscId = transcId;
      // console.log('transaction Code: ', transcId);
    });
  }

  public pauseAudio(transc: Transaction, token: string) {
    this.transaction.makeTransaction(transc, token).subscribe();
  }

  public stopAudio(transc: Transaction, token: string) {
    if (this.audioTranscId) {
      transc.transcRef = this.audioTranscId;
      this.transaction.makeTransaction(transc, token).subscribe();
    }
  }

  public findPausedAudio(token: string) {
    return this.transaction.findPausedAudio(token).subscribe();
  }

  public systLogout(transc: Transaction, token: string) {
    this.transaction.makeTransaction(transc, token).subscribe();
  }
}
