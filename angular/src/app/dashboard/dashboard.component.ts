import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { IncidentService } from '../services/incident.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  incidents !: any[];
  ngOnInit(): void {
    this.getIncidents()
      
  }

  constructor(private FB:FormBuilder, private incidentService:IncidentService, private route: Router){

  }

  getIncidents() {
    this.incidentService.getAllIncidents().subscribe(
      (response : any) =>{
        console.log(response.incidents)
        this.incidents = response.incidents;
      }
    )
  }


}
