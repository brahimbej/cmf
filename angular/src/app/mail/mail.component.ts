import { Component, OnInit } from '@angular/core';
import { IncidentService } from '../services/incident.service';

@Component({
  selector: 'app-mail',
  templateUrl: './mail.component.html',
  styleUrl: './mail.component.css'
})
export class MailComponent implements OnInit{
  listIncidents : any[] =[] ;
  incident : any;

  editIncident:any;

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

  deleteIncident(id:any) {
    this.incidentService.deleteIncident(id).subscribe(
      (response : any) => {
        console.log(response)
        // Find the index of the item with the matching id
      const index = this.listIncidents.findIndex(item => item.id === id);

        // If the item is found (index is not -1), remove it from the array
        if (index !== -1) {
            this.listIncidents.splice(index, 1);
        }

      }
    )
  }

  onUpdateIncident(incident :any) {
    console.log(incident)
    this.incidentService.updateIncident(incident).subscribe(
      (response : any) => {
        this.incidentService.getAllIncidents().subscribe(
          (response : any) => {
            console.log(response);
            this.listIncidents= response;
          }
        )      }
    )
  }

  public onOpenModal(incident: any, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    // if (mode === 'add') {
    //   button.setAttribute('data-target', '#addEmployeeModal');
    // }
    if (mode === 'edit') {
      this.editIncident = incident;
      button.setAttribute('data-target', '#updateIncidentModal');
    }
    // if (mode === 'delete') {
    //   this.deleteEmployee = user;
    //   button.setAttribute('data-target', '#deleteEmployeeModal');
    // }
    if (container != null)
    container.appendChild(button);
    button.click();
  }



}
