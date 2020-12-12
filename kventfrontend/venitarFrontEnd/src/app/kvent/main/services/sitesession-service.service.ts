export class SitesessionServiceService {
  checkUserState(): boolean {
    return localStorage.getItem('userState') === 'true';
  }

  getUserId(): number {
    console.log('UserId: ', +localStorage.getItem('userID'));
    return +localStorage.getItem('userID');
  }

  getUserToken(): string {
    return localStorage.getItem('userToken');
  }

  setUserState(state: string): void {
    localStorage.setItem('userState', state);
  }

  setUserId(userId: string): void {
    localStorage.setItem('userID', userId);
  }

  setUserToken(token: string): void {
    localStorage.setItem('userToken', token);
  }

  removeUser() {
    localStorage.setItem('userState', 'false');
    localStorage.removeItem('userID');
    localStorage.removeItem('userToken');
  }
}
