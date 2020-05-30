import { Component } from '@angular/core';
import {NavigationCancel, NavigationEnd, NavigationError, NavigationStart, Router, RouterEvent} from '@angular/router';
import {LoadingScreenService} from './kvent/main/loadingScreen/loading-screen/loading-screen.service';
import { environment } from './../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Venitar';
  showOverlay: boolean = true;
constructor(private router: Router,
            private loadingService: LoadingScreenService) {
  this.router.events.subscribe((event: RouterEvent) => {
    this.navigationInterceptor(event);
    // console.log('Event: ', event);
    console.log(environment.production);
  });
}


navigationInterceptor(event: RouterEvent): void {
  if (event instanceof NavigationStart) {
    this.loadingService.show();
  // console.log('showOverlay: ', this.showOverlay);
}

if (event instanceof NavigationEnd) {
  this.loadingService.hide();
  // console.log('showOverlay: ', this.showOverlay);
}


if (event instanceof NavigationCancel) {
  this.loadingService.hide();
}

if (event instanceof NavigationError) {
  this.loadingService.hide();
}

}

}
