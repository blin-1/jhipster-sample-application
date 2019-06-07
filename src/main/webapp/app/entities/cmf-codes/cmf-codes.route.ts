import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { CMFCodes } from 'app/shared/model/cmf-codes.model';
import { CMFCodesService } from './cmf-codes.service';
import { CMFCodesComponent } from './cmf-codes.component';
import { CMFCodesDetailComponent } from './cmf-codes-detail.component';
import { CMFCodesUpdateComponent } from './cmf-codes-update.component';
import { CMFCodesDeletePopupComponent } from './cmf-codes-delete-dialog.component';
import { ICMFCodes } from 'app/shared/model/cmf-codes.model';

@Injectable({ providedIn: 'root' })
export class CMFCodesResolve implements Resolve<ICMFCodes> {
  constructor(private service: CMFCodesService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ICMFCodes> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<CMFCodes>) => response.ok),
        map((cMFCodes: HttpResponse<CMFCodes>) => cMFCodes.body)
      );
    }
    return of(new CMFCodes());
  }
}

export const cMFCodesRoute: Routes = [
  {
    path: '',
    component: CMFCodesComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'CMFCodes'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: CMFCodesDetailComponent,
    resolve: {
      cMFCodes: CMFCodesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodes'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: CMFCodesUpdateComponent,
    resolve: {
      cMFCodes: CMFCodesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodes'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: CMFCodesUpdateComponent,
    resolve: {
      cMFCodes: CMFCodesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodes'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const cMFCodesPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: CMFCodesDeletePopupComponent,
    resolve: {
      cMFCodes: CMFCodesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodes'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
