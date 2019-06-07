/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { CMFCodesDeleteDialogComponent } from 'app/entities/cmf-codes/cmf-codes-delete-dialog.component';
import { CMFCodesService } from 'app/entities/cmf-codes/cmf-codes.service';

describe('Component Tests', () => {
  describe('CMFCodes Management Delete Component', () => {
    let comp: CMFCodesDeleteDialogComponent;
    let fixture: ComponentFixture<CMFCodesDeleteDialogComponent>;
    let service: CMFCodesService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplicationTestModule],
        declarations: [CMFCodesDeleteDialogComponent]
      })
        .overrideTemplate(CMFCodesDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CMFCodesDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CMFCodesService);
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
