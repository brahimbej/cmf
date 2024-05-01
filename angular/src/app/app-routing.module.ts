import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AjoutIncidentComponent } from './ajout-incident/ajout-incident.component';
import { AjoutIncidentFormComponent } from './ajout-incident-form/ajout-incident-form.component';
import { TableComponent } from './table/table.component';
import { ListRapportComponent } from './list-rapport/list-rapport.component';
import { AddRapportComponent } from './add-rapport/add-rapport.component';

const routes: Routes = [
  {path:"login", component:LoginComponent},
  {path:"dashboard", component:TableComponent},
  {path:"listrapport", component:ListRapportComponent},
  {path:"ajout_incident_form", component:AjoutIncidentFormComponent},
  {path:"ajout_rapport_form", component:AddRapportComponent},
  {path:"", component:HomeComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
