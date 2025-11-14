import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClient, provideHttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Vehicule } from './models/vehicule';
import { VehiculeDisplayComponent } from './vehicule-display/vehicule-display.component';
import { VehiculeInputComponent } from './vehicule-input/vehicule-input.component';
import { VehiculeWrapperComponent } from './vehicule-wrapper/vehicule-wrapper.component';
import { HeaderComponent } from './header/header.component';
import { AuthComponent } from './auth/auth.component';
import { LoginContentComponent } from './login-content/login-content.component';

@Component({
  selector: 'app-root',
  imports: [
    CommonModule,
    HeaderComponent,
    LoginContentComponent
    
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  standalone: true
})
export class AppComponent {
  title = 'frontendV';
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
