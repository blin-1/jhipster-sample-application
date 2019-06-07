/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { Observable, of } from 'rxjs';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { CMFCodesValuesUpdateComponent } from 'app/entities/cmf-codes-values/cmf-codes-values-update.component';
import { CMFCodesValuesService } from 'app/entities/cmf-codes-values/cmf-codes-values.service';
import { CMFCodesValues } from 'app/shared/model/cmf-codes-values.model';

describe('Component Tests', () => {
  describe('CMFCodesValues Management Update Component', () => {
    let comp: CMFCodesValuesUpdateComponent;
    let fixture: ComponentFixture<CMFCodesValuesUpdateComponent>;
    let service: CMFCodesValuesService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplicationTestModule],
        declarations: [CMFCodesValuesUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(CMFCodesValuesUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CMFCodesValuesUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CMFCodesValuesService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new CMFCodesValues(123);
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
        const entity = new CMFCodesValues();
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
