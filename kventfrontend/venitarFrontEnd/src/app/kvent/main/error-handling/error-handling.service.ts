import { Error } from '../models/error';

// tslint:disable-next-line:eofline
export class ErrorHandlingService {
    private _errors: Error[] = [];

    public get errors(): Error[] {
        return this._errors;
    }

    public set errors(value: Error[]) {
        this._errors = value;
    }

}
