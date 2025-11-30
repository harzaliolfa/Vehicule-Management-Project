import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClient, provideHttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Vehicule } from './models/vehicule';
import { VehiculeDisplayComponent } from './vehicule-display/vehicule-display.component';
import { VehiculeInputComponent } from './vehicule-input/vehicule-input.component';
import { VehiculeWrapperComponent } from './vehicule-wrapper/vehicule-wrapper.component';
import { HeaderComponent } from './header/header.component';
import { WelcomeContentComponent } from './welcome-content/welcome-content.component';

@Component({
  selector: 'app-root',
  imports: [CommonModule, HeaderComponent, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  standalone: true,
})
export class AppComponent {
  
}
