import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {VideosContentComponent} from './kvent/main/content/videos-content/videos-content.component';
import {ContentModule} from './kvent/main/content/content.module';
import {ContentContentComponent} from './kvent/main/content/content-content.component';
import {LoadingScreenComponent} from './kvent/main/loadingScreen/loading-screen/loading-screen.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'loadingScreen', component: LoadingScreenComponent}
  // {path: 'content', component: ContentContentComponent,
  //   loadChildren: () => import('./kvent/main/content/content.module').then(m => m.ContentModule), pathMatch: 'full'}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,
    // { enableTracing: true }
    )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
