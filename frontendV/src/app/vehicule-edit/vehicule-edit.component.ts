import { HttpClient } from '@angular/common/http';
import {
  Component,
  EventEmitter,
  Output,
  ViewChild,
  Input,
} from '@angular/core';
import { NgForm } from '@angular/forms';
import { Vehicule } from '../models/vehicule';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { VehicleService } from '../services/VehiculeService';

@Component({
  selector: 'app-vehicule-edit',
  imports: [FormsModule, MatFormFieldModule, MatInputModule, MatButtonModule],
  templateUrl: './vehicule-edit.component.html',
  styleUrl: './vehicule-edit.component.css',
  standalone: true,
})
export class VehiculeEditComponent {
  @Input() vehicule: Vehicule = new Vehicule(0, '', '', '', 0);
  @Output() editDataEvent = new EventEmitter<Vehicule>();

  constructor(
    private http: HttpClient,
    private vehiculeService: VehicleService
  ) {}

  onSubmit() {
    this.vehiculeService.updateVehicle(this.vehicule).subscribe({
      next: (vehiculeData) => this.editDataEvent.emit(vehiculeData),
      error: (err) => console.error('Update failed:', err),
    });
  }

  // Second way using the post method

  // onSubmit(): void {
  //   this.http
  //     .post<Vehicule>(
  //       'http://localhost:8080/vehicules',
  //       this.vehicule
  //     )
  //     .subscribe((vehiculeData) => this.editDataEvent.emit(vehiculeData));
  // }
}
