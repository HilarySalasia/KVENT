import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './kvent/main/footer/footer.component';
import {HeaderComponent} from './kvent/main/header/header.component';
import {NavigationComponent} from './kvent/main/navigation/navigation.component';
import { ExpansionComponent } from './kvent/main/expansion/expansion.component';
import {ContentContentComponent} from './kvent/main/content/content-content.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {ContentModule} from './kvent/main/content/content.module';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import { LoadingScreenComponent } from './kvent/main/loadingScreen/loading-screen/loading-screen.component';
import {AdsenseModule} from 'ng2-adsense';
import {LoadingScreenService} from './kvent/main/loadingScreen/loading-screen/loading-screen.service';
import {LoaderInterceptor} from './kvent/shared/loader.interceptor';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavigationComponent,
    FooterComponent,
    HeaderComponent,
    NavigationComponent,
    ExpansionComponent,
    ContentContentComponent,
    LoadingScreenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ContentModule,
    FontAwesomeModule,
    AdsenseModule.forRoot()
  ],
  providers: [LoadingScreenService,
    { provide: HTTP_INTERCEPTORS, useClass: LoaderInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
