import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register-form',
  imports: [FormsModule],
  templateUrl: './register-form.component.html',
  styleUrl: './register-form.component.css'
})
export class RegisterFormComponent {

  constructor(private auth : AuthService){}

  active: string = "login";
  firstName: string = "";
  lastName: string = "";
  login: string = "";
  password: string = "";
    onSubmitRegister(): void {
    this.auth.register({"firstName": this.firstName, "lastName": this.lastName, "login": this.login, "password": this.password})
  }
}
