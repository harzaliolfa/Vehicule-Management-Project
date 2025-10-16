import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehicule } from '../models/vehicule';

@Injectable({ providedIn: 'root' })
export class VehicleService {
  private apiUrl = 'http://localhost:8080/vehicules';

  constructor(private http: HttpClient) {}

  updateVehicle(vehicle: Vehicule) {
    return this.http.put<Vehicule>(`${this.apiUrl}/${vehicle.id}`, vehicle);
  }
}
