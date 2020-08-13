import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {LoadingScreenService} from '../main/loadingScreen/loading-screen/loading-screen.service';
import {Observable} from 'rxjs';
import {finalize} from 'rxjs/operators';
import {Injectable} from '@angular/core';

@Injectable()
export class LoaderInterceptor implements HttpInterceptor {
  constructor(public loaderService: LoadingScreenService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.loaderService.show();
    return next.handle(req).pipe(
      finalize(() => this.loaderService.hide())
    );
  }
}
