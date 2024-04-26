import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent  implements OnInit{
  ngOnInit(): void {
  }

  isExpanded: boolean = false;

  toggleSidebar() {
    this.isExpanded = !this.isExpanded;
  }

  

  

}
