import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-crud-users',
  templateUrl: './crud-users.component.html',
  styleUrl: './crud-users.component.css'
})
export class CrudUsersComponent implements OnInit{
  public users!: any[];
  public editEmployee: any;
  public deleteEmployee: any;

  constructor(private userService: UserService){}

  ngOnInit() {
    this.getUsers();
  }

  public getUsers(): void {
    this.userService.getUsers().subscribe(
      (response: any[]) => {
        this.users = response;
        console.log(this.users);
      },
      (error: any) => {
        alert(error.message);
      }
    );
  }

  public onAddUser(addForm: NgForm): void {
    // document.getElementById('add-employee-form').click();
    this.userService.addUser(addForm.value).subscribe(
      (response: any) => {
        console.log(response);
        this.getUsers();
        addForm.reset();
      },
      (error: any) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateUser(user: any): void {
    this.userService.updateUser(user).subscribe(
      (response: any) => {
        console.log(response);
        this.getUsers();
      },
      (error: any) => {
        alert(error.message);
      }
    );
  }

  public onDeleteUser(userId: number): void {
    this.userService.deleteUser(userId).subscribe(
      (response: void) => {
        console.log(response);
        this.getUsers();
      },
      (error: any) => {
        console.log(error);
        alert(error.message);
      }
    );
  }

  public searchUsers(key: string): void {
    console.log(key);
    const results: any[] = [];
    for (const user of this.users) {
      if (user.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || user.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      ) {
        results.push(user);
      }
    }
    console.log(results)
    this.users = results;
    if (results.length === 0 || !key) {
      this.getUsers();
    }
  }

  public onOpenModal(user: any, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode === 'edit') {
      this.editEmployee = user;
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    if (mode === 'delete') {
      this.deleteEmployee = user;
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }
    if (container != null)
    container.appendChild(button);
    button.click();
  }


}
