import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { NoteComponent } from './note/note.component';
import { FeedbackComponent } from './feedback/feedback.component';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

const appRoutes: Routes = [
  {
    path: 'notes',
    component: NoteComponent
  },
  {
    path: 'feedback',
    component: FeedbackComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    NoteComponent,
    FeedbackComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {enableTracing: true})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
