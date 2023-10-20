import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { UserTableComponent } from './user-table/user-table.component';
import { FilterPipe } from './user-table/pipes/filter.pipe';
import {FormsModule} from '@angular/forms';
import { NavComponent } from './nav/nav.component';
import { CardsComponent } from './cards/cards.component';
import {RouterModule, Routes} from '@angular/router';
import { UserInformationComponent } from './user-table/user-information/user-information.component';

const routes: Routes = [
  {path: '',redirectTo: 'table', pathMatch: 'full'},
  {path: 'table', component: UserTableComponent},
  {path: 'cards', component: CardsComponent},
  {path: 'user/information', component: UserInformationComponent},
  {path: 'user/information/:id', component: UserInformationComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    UserTableComponent,
    FilterPipe,
    NavComponent,
    CardsComponent,
    UserInformationComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
