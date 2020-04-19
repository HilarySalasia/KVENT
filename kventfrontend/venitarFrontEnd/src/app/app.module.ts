import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './kvent/main/footer/footer.component';
import {HeaderComponent} from './kvent/main/header/header.component';
import {NavigationComponent} from './kvent/main/navigation/navigation.component';
import { ExpansionComponent } from './kvent/main/expansion/expansion.component';
import {ContentContentComponent} from './kvent/main/content/content-content.component';
import {HttpClientModule} from '@angular/common/http';
import {ContentModule} from './kvent/main/content/content.module';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavigationComponent,
    FooterComponent,
    HeaderComponent,
    NavigationComponent,
    ExpansionComponent,
    ContentContentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ContentModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
