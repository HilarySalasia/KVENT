import {Country} from './country';
import {County} from './county';
import {Ward} from './ward';
import {Town} from './town';
import {Credentials} from './credentials';

export interface User {
  username: string;
  email: string;
  firstName: string;
  middleName: string;
  surname: string;
  fullName: string;
  dateOfBirth: Date;
  phyAddr: string;
  country: Country;
  county: County;
  ward: Ward;
  town: Town;
  credentials: Credentials;
}
// country	Country{...}
// county	County{...}
// credentials	Credentials{...}
// dateOfBirth	string($date-time)
// email	string
// firstName	string
// fullName	string
// middleName	string
// phoneNum	string
// phyAddr	string
// surname	string
// town	Town{...}
// userCode	integer($int64)
// ward	Ward{...}
