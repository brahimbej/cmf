import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';

import { AjoutIncidentFormComponent } from './ajout-incident-form/ajout-incident-form.component';
import { TableComponent } from './table/table.component';
import { ListRapportComponent } from './list-rapport/list-rapport.component';
import { AddRapportComponent } from './add-rapport/add-rapport.component';
import { CrudUsersComponent } from './crud-users/crud-users.component';
import { NotFoundComponent } from './not-found/not-found.component';


const routes: Routes = [
  {path:"login", component:LoginComponent},

  {path:"dashboard", component:TableComponent},
  {path:"listrapport", component:ListRapportComponent},
  {path:"ajout_incident_form", component:AjoutIncidentFormComponent},
  {path:"ajout_rapport_form", component:AddRapportComponent},
  {path:"all_users", component:CrudUsersComponent},
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: NotFoundComponent }  // Wildcard route for a 404 page

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
