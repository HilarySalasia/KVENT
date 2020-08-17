import {Company} from './company';
import {Currency} from './currency';

export interface Event {
  company:	Company;
  currency:	Currency;
  eventCapacity:	string;
  eventCost:	string;
  eventEndDate:	Date;
  eventId:	number;
  eventLocLatitude:	string;
  eventLocLongitude:	string;
  eventLocation:	string;
  eventStartDate:	Date;
  eventTitle:	string;
  userId:	number;
}
