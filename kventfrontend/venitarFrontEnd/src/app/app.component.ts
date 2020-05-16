import { Component } from '@angular/core';
import {NavigationCancel, NavigationEnd, NavigationError, NavigationStart, Router, RouterEvent} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'venitarFrontEnd';
  showOverlay: boolean = true;
constructor(private router: Router) {
  this.router.events.subscribe((event: RouterEvent) => {
    this.navigationInterceptor(event);
    console.log('Event: ', event);
  });
}


navigationInterceptor(event: RouterEvent): void {
  if (event instanceof NavigationStart) {
  this.showOverlay = true;
  console.log('showOverlay: ', this.showOverlay);
}

if (event instanceof NavigationEnd) {
  this.showOverlay = false;
  console.log('showOverlay: ', this.showOverlay);
}


if (event instanceof NavigationCancel) {
  this.showOverlay = false;
}

if (event instanceof NavigationError) {
  this.showOverlay = false;
}

}

}
