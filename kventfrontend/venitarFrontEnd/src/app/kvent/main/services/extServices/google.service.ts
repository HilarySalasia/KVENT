import {Observable} from 'rxjs';
import {Mixes} from '../../models/mixes';
import {GeoDetails} from '../../models/extModels/geoDetails';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {DomSanitizer} from '@angular/platform-browser';

@Injectable()
export class GoogleService {
  get gcdKey(): string {
    return this._gcdKey;
  }

  set gcdKey(value: string) {
    this._gcdKey = value;
  }
  private _gcdKey = 'AIzaSyC_ZADWHRr2uTu90oqw--tn9JxNbwepyJo';
  public httpOptions =  new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token',
  });

  constructor(private http: HttpClient,
              private sanitizer: DomSanitizer) {
  }

  // https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,
  // +Mountain+View,+CA&key=YOUR_API_KEY

  public getLocation(location: string): Observable<GeoDetails> {
    return this.http.get<GeoDetails>('https://maps.googleapis.com/maps/api/geocode/json?address=' + location +
    ',+CA&key=' + this._gcdKey);
  }

  public showLocation(location: string) {
    return this.sanitizer.bypassSecurityTrustResourceUrl( 'https://www.google.com/maps/embed/v1/place?key=' +
      this._gcdKey + '&q=' + location);
  }
}
