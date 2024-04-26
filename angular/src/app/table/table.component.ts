import { Component, OnInit } from '@angular/core';
import { IncidentService } from '../services/incident.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrl: './table.component.css'
})
export class TableComponent implements OnInit{
  listIncidents : any[] =[] ;
  incident : any;

  constructor(private incidentService : IncidentService) {

  }
  ngOnInit(): void {
    this.incidentService.getAllIncidents().subscribe(
      (response : any) => {
        console.log(response);
        this.listIncidents= response;
      }
    )
  }

  addIncident() {
    this.incidentService.addIncident(this.incident).subscribe(
      (response : any) => {
        console.log(response)
        this.listIncidents.push(response.incident)
      }
    )
  }



}
