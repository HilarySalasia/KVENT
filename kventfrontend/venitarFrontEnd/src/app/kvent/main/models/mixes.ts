import {Company} from './company';
import {Picture} from './picture';

export interface Mixes {
  mixId: number;
  mixCompany: Company;
  picture: Picture;
  mixDjName: string;
  mixLink: string;
  mixStatus: string;
  mixTitle: string;
}
