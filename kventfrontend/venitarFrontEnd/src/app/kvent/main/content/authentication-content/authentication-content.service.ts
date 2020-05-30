export class AuthenticationContentService {
  constructor() {
  }

  logout(): void {
    localStorage.setItem('userState', 'false');
    localStorage.removeItem('userID');
    localStorage.removeItem('userToken');
  }

  login(userId: number, userToken: string): void {
    localStorage.setItem('userID', userId.toString());
    localStorage.setItem('userToken', userToken);
    localStorage.setItem('userState', 'true');
    console.log('Local Storage: ', localStorage);
  }
}
