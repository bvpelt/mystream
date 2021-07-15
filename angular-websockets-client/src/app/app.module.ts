import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {Route, RouterModule} from '@angular/router';
import { AuthorInfoComponent } from './author/author-info/author-info.component';
import { AuthorPageComponent } from './author/author-page/author-page.component';

const routes: Route[] = [
  {path: '', redirectTo: 'posts', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    AuthorInfoComponent,
    AuthorPageComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
