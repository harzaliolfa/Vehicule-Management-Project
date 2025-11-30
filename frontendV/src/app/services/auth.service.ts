import { Injectable } from '@angular/core';
import { AxiosService } from './axios.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private axiosService: AxiosService, private router: Router) {}

  isLoggedIn() {
    return !!localStorage.getItem('token');
  }

  login(credentails: { login: string; password: string }): Promise<any> {
    return this.axiosService
      .request('POST', '/login', credentails)
      .then((response) => {
        const token = response.data.token;
        localStorage.setItem('token', token);
        this.axiosService.setAuthToken(token);
        // Redirect after successful login
        this.router.navigate(['/vehicules']);
        return response;
      });
  }

  register(input: any): Promise<any> {
    return this.axiosService
      .request('POST', '/register', {
        firstName: input.firstName,
        lastName: input.lastName,
        login: input.login,
        password: input.password,
      })
      .then((response) => {
        const token = response.data.token;
        localStorage.setItem('token', token);
        this.axiosService.setAuthToken(response.data.token);
        console.log('user registered');
        return response;
      });
  }

  
  logout() {
    localStorage.removeItem('token');
    this.axiosService.setAuthToken(null);
  }
}
