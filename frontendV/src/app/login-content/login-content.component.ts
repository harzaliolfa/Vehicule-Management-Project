import { Component } from '@angular/core';
import { LoginFormComponent } from '../login-form/login-form.component';
import { AxiosService } from '../services/axios.service';
import { HttpClient } from '@angular/common/http';
import {User} from '../models/User'
import { ButtonsComponent } from '../buttons/buttons.component';
import { AuthComponent } from "../auth/auth.component";
import { WelcomeContentComponent } from '../welcome-content/welcome-content.component';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-login-content',
  imports: [LoginFormComponent, ButtonsComponent, AuthComponent, WelcomeContentComponent, CommonModule],
  templateUrl: './login-content.component.html',
  styleUrl: './login-content.component.css'
})
export class LoginContentComponent {

  componentToShow: string = "welcome";
  constructor(private axiosService : AxiosService ){}

  showComponent(componentToShow: string) :void{
      this.componentToShow = componentToShow;
      console.log("switched to " ,componentToShow)
  }

  onLogin(input : any): void{
    this.axiosService.request(
      "POST",
      "/login",
      {
        login: input.login,
        password: input.password
      }
    ).then(response => {
      this.axiosService.setAuthToken(response.data.token);
      this.componentToShow = "vehicules";
    })
    this.showComponent("ve")
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
    ).then(response => {
      this.axiosService.setAuthToken(response.data.token);
      this.componentToShow = "messages";
    })
    console.log("user registered")
  }
}
