import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {VideosContentComponent} from './videos-content/videos-content.component';
import {EventsContentComponent} from './events-content/events-content.component';
import {HomeContentComponent} from './home-content/home-content.component';
import {PicturesContentComponent} from './pictures-content/pictures-content.component';


const routes: Routes = [
  { path: 'events', component: EventsContentComponent },
  { path: 'pictures', component: PicturesContentComponent },
  {path: 'videos', component: VideosContentComponent},
  { path: 'home', component: HomeContentComponent }
  // {path: '', component: HomeContentComponent, children: [
  //     { path: 'events', component: EventsContentComponent },
  //     { path: 'pictures', component: PicturesContentComponent },
  //     {path: 'videos', component: VideosContentComponent}] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContentRoutingModule { }
