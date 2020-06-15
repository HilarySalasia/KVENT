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
import {FormErrorComponent} from './kvent/shared/form-error-component/form-error-component';
import {SharedModule} from './kvent/shared/shared.module';
import {SitesessionServiceService} from './kvent/main/services/sitesession-service.service';
import {GoogleService} from './kvent/main/services/extServices/google.service';
import {HeaderService} from './kvent/main/header/header.service';
import {MainService} from './kvent/main/services/main-service.service';
import {SetupService} from './kvent/main/services/setup.service';
import {BusinessService} from './kvent/main/services/business.service';



@NgModule({
    declarations: [
        AppComponent,
        NavigationComponent,
        FooterComponent,
        NavigationComponent,
        ExpansionComponent,
        ContentContentComponent,
        LoadingScreenComponent,
        HeaderComponent,

    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ContentModule,
    FontAwesomeModule,
    AdsenseModule.forRoot(),
    SharedModule
  ],
    providers: [LoadingScreenService, SitesessionServiceService, GoogleService, HeaderService,
      MainService, SetupService, BusinessService,
        {provide: HTTP_INTERCEPTORS, useClass: LoaderInterceptor, multi: true}
    ],
  exports: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
