/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { Observable, of } from 'rxjs';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { CMFCodesUpdateComponent } from 'app/entities/cmf-codes/cmf-codes-update.component';
import { CMFCodesService } from 'app/entities/cmf-codes/cmf-codes.service';
import { CMFCodes } from 'app/shared/model/cmf-codes.model';

describe('Component Tests', () => {
  describe('CMFCodes Management Update Component', () => {
    let comp: CMFCodesUpdateComponent;
    let fixture: ComponentFixture<CMFCodesUpdateComponent>;
    let service: CMFCodesService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplicationTestModule],
        declarations: [CMFCodesUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(CMFCodesUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CMFCodesUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CMFCodesService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new CMFCodes(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new CMFCodes();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
