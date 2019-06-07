import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICMFCodesMap } from 'app/shared/model/cmf-codes-map.model';
import { CMFCodesMapService } from './cmf-codes-map.service';

@Component({
  selector: 'jhi-cmf-codes-map-delete-dialog',
  templateUrl: './cmf-codes-map-delete-dialog.component.html'
})
export class CMFCodesMapDeleteDialogComponent {
  cMFCodesMap: ICMFCodesMap;

  constructor(
    protected cMFCodesMapService: CMFCodesMapService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.cMFCodesMapService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'cMFCodesMapListModification',
        content: 'Deleted an cMFCodesMap'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-cmf-codes-map-delete-popup',
  template: ''
})
export class CMFCodesMapDeletePopupComponent implements OnInit, OnDestroy {
  protected ngbModalRef: NgbModalRef;

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ cMFCodesMap }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(CMFCodesMapDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.cMFCodesMap = cMFCodesMap;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate(['/cmf-codes-map', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate(['/cmf-codes-map', { outlets: { popup: null } }]);
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
