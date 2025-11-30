import { Component, EventEmitter, Input, Output } from '@angular/core';

import { ChangeDetectionStrategy } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Vehicule } from '../models/vehicule';
import { HttpClient } from '@angular/common/http';
import { VehiculeInputComponent } from "../vehicule-input/vehicule-input.component";

@Component({
  selector: 'app-vehicule-display',
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './vehicule-display.component.html',
  styleUrl: './vehicule-display.component.css',
  standalone: true,
})
export class VehiculeDisplayComponent {
  @Input() vehicule: Vehicule = new Vehicule(0, '', '', '', 0);

  @Output() editItemEvent = new EventEmitter();

  @Output() removeItemEvent = new EventEmitter();
}
