import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {VideosContentComponent} from './videos-content/videos-content.component';
import {EventsContentComponent} from './events-content/events-content.component';
import {HomeContentComponent} from './home-content/home-content.component';
import {PicturesContentComponent} from './pictures-content/pictures-content.component';
import {UploadMixComponent} from './upload-mix/upload-mix.component';
import {UploadPicturesComponent} from './upload-pictures/upload-pictures.component';
import {AuthenticationContentComponent} from './authentication-content/authentication-content.component';
import {CreateEventContentComponent} from './events-content/create-event-content/create-event-content.component';


const routes: Routes = [
  { path: 'upload/mix', component: UploadMixComponent },
  { path: 'upload/picture', component: UploadPicturesComponent },
  { path: 'events', component: EventsContentComponent },
  { path: 'pictures', component: PicturesContentComponent },
  { path: 'videos', component: VideosContentComponent},
  { path: 'authenticate/:transc', component: AuthenticationContentComponent},
  { path: 'createEvent', component: CreateEventContentComponent },
  { path: 'home', component: HomeContentComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContentRoutingModule { }
