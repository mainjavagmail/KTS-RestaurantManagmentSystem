import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../model/user';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  public users : User[];
  constructor(private userService : UserService, private router:Router ) { }

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe(data => {
      this.users = data;
      console.log(this.users);
    })
  }

  detailsClick(user:User){
    console.log(user);
    this.router.navigate(['/user/',user.id]);
  }

}
