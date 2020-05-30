import DateTimeFormat = Intl.DateTimeFormat;

export interface Login {
  loginCookie:	string;
  loginDate:	Date;
  loginExpire:	string;
  loginId:	number;
  loginLoggedOut:	string;
  loginToken:	string;
  userId: number;
  loginUser: number;
}
