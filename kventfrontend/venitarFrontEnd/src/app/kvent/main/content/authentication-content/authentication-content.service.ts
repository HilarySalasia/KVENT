import {SitesessionServiceService} from '../../services/sitesession-service.service';
import {Injectable} from '@angular/core';

@Injectable()
export class AuthenticationContentService {
  constructor(private ssS: SitesessionServiceService) {
  }

  logout(): void {
    this.ssS.removeUser();
  }

  login(userId: number, userToken: string): void {
    this.ssS.setUserId(userId.toString());
    this.ssS.setUserToken(userToken);
    this.ssS.setUserState('true');
    console.log('Local Storage: ', localStorage);
  }

}
