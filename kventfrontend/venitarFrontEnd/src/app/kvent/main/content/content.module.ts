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


@NgModule({
  declarations: [
    EventsContentComponent,
    HomeContentComponent,
    PicturesContentComponent,
    VideosContentComponent,
    UploadMixComponent,
    UploadPicturesComponent,
    UploadVideosComponent
  ],
  // imports: [
  //   BrowserModule,
  //   AppRoutingModule
  // ],
  providers: [],
  imports: [
    CommonModule
  ],
  // bootstrap: []
})
export class ContentModule { }
