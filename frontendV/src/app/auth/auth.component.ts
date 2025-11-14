import { Component } from '@angular/core';
import { AxiosService } from '../services/axios.service';
import { CommonModule } from '@angular/common';
import { VehiculeDisplayComponent } from '../vehicule-display/vehicule-display.component';

@Component({
  selector: 'app-auth',
  imports: [CommonModule, VehiculeDisplayComponent],
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.css'
})
export class AuthComponent {

    data: string[] = [];
    constructor(private axiosService : AxiosService){}

    ngOnInit() :  void{
      this.axiosService.request(
        "GET",
        "/messages",
        {}
      ).then(
        (response) => this.data = response.data
      )
    }

}

