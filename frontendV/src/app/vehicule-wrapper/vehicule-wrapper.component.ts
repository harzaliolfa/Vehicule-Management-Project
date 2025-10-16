import { Component, EventEmitter, Output, Input } from '@angular/core';
import { VehiculeEditComponent } from '../vehicule-edit/vehicule-edit.component';
import { VehiculeDisplayComponent } from '../vehicule-display/vehicule-display.component';
import { Vehicule } from '../models/vehicule';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-vehicule-wrapper',
  imports: [VehiculeEditComponent, VehiculeDisplayComponent, CommonModule],
  templateUrl: './vehicule-wrapper.component.html',
  styleUrl: './vehicule-wrapper.component.css',
  standalone: true,
})
export class VehiculeWrapperComponent {
  @Input() vehicule: Vehicule = new Vehicule(0, '', '', '', 0);
  @Output() removeItemEvent = new EventEmitter();
  editable: boolean = false;

  handleEditClick(): void {
    this.editable = true;
  }

  handleSaveEdition(vehicule: Vehicule): void {
    this.editable = false;
    this.vehicule = this.vehicule;
  }
}
