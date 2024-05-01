import { Component, OnInit } from '@angular/core';
import { RapportService } from '../services/rapport.service';

@Component({
  selector: 'app-list-rapport',
  templateUrl: './list-rapport.component.html',
  styleUrl: './list-rapport.component.css'
})
export class ListRapportComponent implements OnInit {
  listRapports : any[] =[] ;
  rapport : any;

  constructor(private rapportService : RapportService) {

  }
  ngOnInit(): void {
    this.rapportService.getAllRapports().subscribe(
      (response : any) => {
        console.log(response);
        this.listRapports= response;
      }
    )
  }
}
