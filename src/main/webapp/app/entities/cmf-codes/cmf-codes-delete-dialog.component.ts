import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICMFCodes } from 'app/shared/model/cmf-codes.model';
import { CMFCodesService } from './cmf-codes.service';

@Component({
  selector: 'jhi-cmf-codes-delete-dialog',
  templateUrl: './cmf-codes-delete-dialog.component.html'
})
export class CMFCodesDeleteDialogComponent {
  cMFCodes: ICMFCodes;

  constructor(protected cMFCodesService: CMFCodesService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.cMFCodesService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'cMFCodesListModification',
        content: 'Deleted an cMFCodes'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-cmf-codes-delete-popup',
  template: ''
})
export class CMFCodesDeletePopupComponent implements OnInit, OnDestroy {
  protected ngbModalRef: NgbModalRef;

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ cMFCodes }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(CMFCodesDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.cMFCodes = cMFCodes;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate(['/cmf-codes', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate(['/cmf-codes', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          }
        );
      }, 0);
    });
  }

  ngOnDestroy() {
    this.ngbModalRef = null;
  }
}
