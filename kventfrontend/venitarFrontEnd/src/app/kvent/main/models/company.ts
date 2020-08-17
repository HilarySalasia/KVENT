import {Country} from './country';

export interface Company {
  companyAddress: string;
  companyId: number;
  companyName: string;
  country: Country;
}

