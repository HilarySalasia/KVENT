import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {VideosContentComponent} from './kvent/main/content/videos-content/videos-content.component';
import {ContentModule} from './kvent/main/content/content.module';
import {ContentContentComponent} from './kvent/main/content/content-content.component';

const routes: Routes = [
  {path: '', redirectTo: '/content', pathMatch: 'full'},
  {path: 'content', component: ContentContentComponent,
    loadChildren: () => import('./kvent/main/content/content.module').then(m => m.ContentModule), pathMatch: 'full'}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
