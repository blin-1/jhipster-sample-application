import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICMFCodesValues } from 'app/shared/model/cmf-codes-values.model';
import { CMFCodesValuesService } from './cmf-codes-values.service';

@Component({
  selector: 'jhi-cmf-codes-values-delete-dialog',
  templateUrl: './cmf-codes-values-delete-dialog.component.html'
})
export class CMFCodesValuesDeleteDialogComponent {
  cMFCodesValues: ICMFCodesValues;

  constructor(
    protected cMFCodesValuesService: CMFCodesValuesService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.cMFCodesValuesService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'cMFCodesValuesListModification',
        content: 'Deleted an cMFCodesValues'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-cmf-codes-values-delete-popup',
  template: ''
})
export class CMFCodesValuesDeletePopupComponent implements OnInit, OnDestroy {
  protected ngbModalRef: NgbModalRef;

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ cMFCodesValues }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(CMFCodesValuesDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.cMFCodesValues = cMFCodesValues;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate(['/cmf-codes-values', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate(['/cmf-codes-values', { outlets: { popup: null } }]);
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
