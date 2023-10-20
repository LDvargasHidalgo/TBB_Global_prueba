import { Component } from '@angular/core';
import { UserService } from '../user-table/user.service';
@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent  {
  users: any[];
  filterPost = '';

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      console.log(this.users);
    });
  }

  clearSearch() {
    this.filterPost = '';
  }
}

