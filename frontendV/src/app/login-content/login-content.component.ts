import { Component } from '@angular/core';
import { LoginFormComponent } from '../login-form/login-form.component';
import { AxiosService } from '../services/axios.service';
import { HttpClient } from '@angular/common/http';
import {User} from '../models/User'
@Component({
  selector: 'app-login-content',
  imports: [LoginFormComponent],
  templateUrl: './login-content.component.html',
  styleUrl: './login-content.component.css'
})
export class LoginContentComponent {


  constructor(private axiosService : AxiosService ){}

  onLogin(input : any): void{
    this.axiosService.request(
      "POST",
      "/login",
      {
        login: input.login,
        password: input.password
      }
    )
  }

  onRegister(input: any) : void {
    this.axiosService.request(
      "POST",
      "/register",
      {
        firstName: input.firstName,
        lastName: input.lastName,
        login: input.login,
        password: input.password,

      }
    )
  }
}
