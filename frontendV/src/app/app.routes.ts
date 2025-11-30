import { Routes } from '@angular/router';
import { VehiculeDisplayComponent } from './vehicule-display/vehicule-display.component';
import { WelcomeContentComponent } from './welcome-content/welcome-content.component';
import { AuthGuard } from './guards/auth.guard';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { VehiculeContainerComponent } from './vehicule-container/vehicule-container.component';

export const routes: Routes = [

  { path: '', component: WelcomeContentComponent },
  { path: 'login', component: LoginFormComponent },
  { path: 'register', component: RegisterFormComponent },

  { path: 'vehicules', component: VehiculeContainerComponent, canActivate: [AuthGuard] },

  { path: '**', redirectTo: '' }
];
