import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Vehicule } from '../models/vehicule';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-vehicule-input',
  imports: [FormsModule, MatFormFieldModule, MatInputModule, MatButtonModule],
  templateUrl: './vehicule-input.component.html',
  styleUrl: './vehicule-input.component.css',
})
export class VehiculeInputComponent {
  //this is the object where angular will save the values of all the inputs of the form
  // it got it from the #vehiculeForm = "ngForm"
  @ViewChild('vehiculeForm') vehiculeForm!: NgForm;

  // we're using this output thing because we want to display the new added object in the component
  @Output() newDataEvent = new EventEmitter<Vehicule>();

  constructor(private http: HttpClient) {}

  onSubmit(): void {
    this.http
      .post<Vehicule>(
        'http://localhost:8080/vehicules',
        this.vehiculeForm.value
      )
      .subscribe((vehiculeData) => this.newDataEvent.emit(vehiculeData));
  }
}
