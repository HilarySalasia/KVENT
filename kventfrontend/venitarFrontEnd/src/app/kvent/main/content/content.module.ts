import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AppRoutingModule} from '../../../app-routing.module';
import {EventsContentComponent} from './events-content/events-content.component';
import {HomeContentComponent} from './home-content/home-content.component';
import {PicturesContentComponent} from './pictures-content/pictures-content.component';
import {VideosContentComponent} from './videos-content/videos-content.component';
import {CommonModule} from '@angular/common';
import { UploadMixComponent } from './upload-mix/upload-mix.component';
import { UploadPicturesComponent } from './upload-pictures/upload-pictures.component';
import { UploadVideosComponent } from './upload-videos/upload-videos.component';
import {ContentRoutingModule} from './content-routing.module';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {FormsModule} from '@angular/forms';
import {AudioComponent} from './audio-component/audio-component.component';


@NgModule({
  declarations: [
    EventsContentComponent,
    HomeContentComponent,
    PicturesContentComponent,
    VideosContentComponent,
    UploadMixComponent,
    UploadPicturesComponent,
    UploadVideosComponent,
    AudioComponent
  ],
  // imports: [
  //   BrowserModule,
  //   AppRoutingModule
  // ],
  providers: [],
  imports: [
    CommonModule,
    ContentRoutingModule,
    FontAwesomeModule,
    FormsModule
  ],
  // bootstrap: []
})
export class ContentModule { }
