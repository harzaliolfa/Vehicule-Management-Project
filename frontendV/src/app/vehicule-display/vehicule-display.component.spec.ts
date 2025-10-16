import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiculeDisplayComponent } from './vehicule-display.component';

describe('VehiculeDisplayComponent', () => {
  let component: VehiculeDisplayComponent;
  let fixture: ComponentFixture<VehiculeDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VehiculeDisplayComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehiculeDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
