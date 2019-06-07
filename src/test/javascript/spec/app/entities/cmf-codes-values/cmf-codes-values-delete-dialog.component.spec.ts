/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { CMFCodesValuesDeleteDialogComponent } from 'app/entities/cmf-codes-values/cmf-codes-values-delete-dialog.component';
import { CMFCodesValuesService } from 'app/entities/cmf-codes-values/cmf-codes-values.service';

describe('Component Tests', () => {
  describe('CMFCodesValues Management Delete Component', () => {
    let comp: CMFCodesValuesDeleteDialogComponent;
    let fixture: ComponentFixture<CMFCodesValuesDeleteDialogComponent>;
    let service: CMFCodesValuesService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplicationTestModule],
        declarations: [CMFCodesValuesDeleteDialogComponent]
      })
        .overrideTemplate(CMFCodesValuesDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CMFCodesValuesDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CMFCodesValuesService);
      mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
      mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));
    });
  });
});
