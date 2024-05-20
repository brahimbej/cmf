import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { TableComponent } from './table/table.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { AjoutIncidentComponent } from './ajout-incident/ajout-incident.component';
import { AjoutIncidentFormComponent } from './ajout-incident-form/ajout-incident-form.component';
import { ListRapportComponent } from './list-rapport/list-rapport.component';
import { AddRapportComponent } from './add-rapport/add-rapport.component';
import { CrudUsersComponent } from './crud-users/crud-users.component';
import { NotFoundComponent } from './not-found/not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    DashboardComponent,
    NavbarComponent,
    TableComponent,
    SidebarComponent,
    AjoutIncidentComponent,
    AjoutIncidentFormComponent,
    ListRapportComponent,
    AddRapportComponent,
    CrudUsersComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
