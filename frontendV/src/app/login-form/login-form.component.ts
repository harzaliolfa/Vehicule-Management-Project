import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login-form',
  imports: [CommonModule, FormsModule],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css',
  standalone: true
})
export class LoginFormComponent {


constructor(public router :Router,private auth : AuthService){}
	active: string = "login";
  firstName: string = "";
  lastName: string = "";
  login: string = "";
  password: string = "";


  onSubmitLogin(): void {
    this.auth.login({"login": this.login, "password": this.password})
  }



}
