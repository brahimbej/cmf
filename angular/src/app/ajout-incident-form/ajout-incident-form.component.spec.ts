import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutIncidentFormComponent } from './ajout-incident-form.component';

describe('AjoutIncidentFormComponent', () => {
  let component: AjoutIncidentFormComponent;
  let fixture: ComponentFixture<AjoutIncidentFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AjoutIncidentFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AjoutIncidentFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
