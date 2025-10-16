import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiculeInputComponent } from './vehicule-input.component';

describe('VehiculeInputComponent', () => {
  let component: VehiculeInputComponent;
  let fixture: ComponentFixture<VehiculeInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VehiculeInputComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehiculeInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
