import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiculeWrapperComponent } from './vehicule-wrapper.component';

describe('VehiculeWrapperComponent', () => {
  let component: VehiculeWrapperComponent;
  let fixture: ComponentFixture<VehiculeWrapperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VehiculeWrapperComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehiculeWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
