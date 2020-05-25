import DateTimeFormat = Intl.DateTimeFormat;

export interface Login {
  loginCookie:	string;
  loginDate:	DateTimeFormat;
  loginExpire:	string;
  loginId:	number;
  loginLoggedOut:	string;
  loginToken:	string;
}
