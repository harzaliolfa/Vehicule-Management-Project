import { Component, EventEmitter, Input, Output } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';
import { LoginFormComponent } from '../login-form/login-form.component';

@Component({
  selector: 'app-header',
  imports: [NgIf],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {


  constructor(public auth : AuthService, private router : Router){

  }
  @Input() pageTitle! : string;
  @Input() logoSrc! : string

  onLoginClick(){
    this.router.navigate(['/login'])
    console.log("went to login")
  } 

  onRegisterClick(){
    this.router.navigate(['/register'])
  }

  onLogoutClick(){
    this.auth.logout();
    this.router.navigate(['/welcome'])
  }
  redirectToHome(){
     this.router.navigate(['/']);
  }



}
