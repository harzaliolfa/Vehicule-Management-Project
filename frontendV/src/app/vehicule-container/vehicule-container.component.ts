import { Component } from '@angular/core';
import { AxiosService } from '../services/axios.service';
import { VehiculeDisplayComponent } from '../vehicule-display/vehicule-display.component';
import { NgFor } from '@angular/common';
import { VehiculeInputComponent } from '../vehicule-input/vehicule-input.component';
import { VehiculeWrapperComponent } from '../vehicule-wrapper/vehicule-wrapper.component';
import { Vehicule} from '../models/vehicule';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-vehicule-container',
  imports: [NgFor, VehiculeInputComponent, VehiculeWrapperComponent],
  templateUrl: './vehicule-container.component.html',
  styleUrl: './vehicule-container.component.css'
})
export class VehiculeContainerComponent {
    data: string[] = [];

    title = '';
  vehicules: Vehicule[] = [];
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http
      .get<Vehicule[]>('http://localhost:8080/vehicules')
      .subscribe((data) => (this.vehicules = data));
      
  }

  appendData(newVehicule: any): void {
    this.vehicules.push(newVehicule);
  }

  removeItem(vehiculeId: number): void {
    this.http.delete('http://localhost:8080/vehicules/' + vehiculeId).subscribe(
      (data) =>
        // we're doing this filtering because the delted elemnt is deleted in the db but
        // still has it in memory inside the vehicules array,which is what’s being displayed on the page
        (this.vehicules = this.vehicules.filter(
          (vehicule: Vehicule) => vehicule.id != vehiculeId
        ))
    );
  }
}
