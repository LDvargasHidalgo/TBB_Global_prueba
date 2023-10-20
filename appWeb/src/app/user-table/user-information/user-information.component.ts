import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-information',
  templateUrl: './user-information.component.html',
  styleUrls: ['./user-information.component.css']
})
export class UserInformationComponent {

  userId: number;
  userData: any;

  constructor(private route: ActivatedRoute, private userService: UserService) { }


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.userId = +params['id']; // Obtiene el ID del parámetro de la ruta y conviértelo a número
      this.getUserData(); // Llama a la función para obtener los datos del usuario
    });
  }

  getUserData(): void {
    this.userService.getUserById(this.userId)
      .subscribe(data => {
        this.userData = data; // Almacena los datos del usuario en la variable userData
      });
    }
}
