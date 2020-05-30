import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AppRoutingModule} from '../../../app-routing.module';
import {EventsContentComponent} from './events-content/events-content.component';
import {HomeContentComponent} from './home-content/home-content.component';
import {PicturesContentComponent} from './pictures-content/pictures-content.component';
import {VideosContentComponent} from './videos-content/videos-content.component';
import {CommonModule, DatePipe} from '@angular/common';
import { UploadMixComponent } from './upload-mix/upload-mix.component';
import { UploadPicturesComponent } from './upload-pictures/upload-pictures.component';
import { UploadVideosComponent } from './upload-videos/upload-videos.component';
import {ContentRoutingModule} from './content-routing.module';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {FormsModule} from '@angular/forms';
import {AudioComponent} from './audio-component/audio-component.component';
import { AuthenticationContentComponent } from './authentication-content/authentication-content.component';
import {AppModule} from '../../../app.module';
import {SharedModule} from '../../shared/shared.module';
import {AuthenticationContentService} from './authentication-content/authentication-content.service';



@NgModule({
  declarations: [
    EventsContentComponent,
    HomeContentComponent,
    PicturesContentComponent,
    VideosContentComponent,
    UploadMixComponent,
    UploadPicturesComponent,
    UploadVideosComponent,
    AudioComponent,
    AuthenticationContentComponent,
  ],

  providers: [AuthenticationContentService],
  imports: [
    CommonModule,
    ContentRoutingModule,
    FontAwesomeModule,
    FormsModule,
    SharedModule
  ],
  // bootstrap: [AppModule]
})
export class ContentModule { }
