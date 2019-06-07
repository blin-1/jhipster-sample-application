/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { CMFCodesMapDeleteDialogComponent } from 'app/entities/cmf-codes-map/cmf-codes-map-delete-dialog.component';
import { CMFCodesMapService } from 'app/entities/cmf-codes-map/cmf-codes-map.service';

describe('Component Tests', () => {
  describe('CMFCodesMap Management Delete Component', () => {
    let comp: CMFCodesMapDeleteDialogComponent;
    let fixture: ComponentFixture<CMFCodesMapDeleteDialogComponent>;
    let service: CMFCodesMapService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplicationTestModule],
        declarations: [CMFCodesMapDeleteDialogComponent]
      })
        .overrideTemplate(CMFCodesMapDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CMFCodesMapDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CMFCodesMapService);
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
