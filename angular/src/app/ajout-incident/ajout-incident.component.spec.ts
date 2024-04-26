import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutIncidentComponent } from './ajout-incident.component';

describe('AjoutIncidentComponent', () => {
  let component: AjoutIncidentComponent;
  let fixture: ComponentFixture<AjoutIncidentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AjoutIncidentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AjoutIncidentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
