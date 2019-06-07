import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { CMFCodesValues } from 'app/shared/model/cmf-codes-values.model';
import { CMFCodesValuesService } from './cmf-codes-values.service';
import { CMFCodesValuesComponent } from './cmf-codes-values.component';
import { CMFCodesValuesDetailComponent } from './cmf-codes-values-detail.component';
import { CMFCodesValuesUpdateComponent } from './cmf-codes-values-update.component';
import { CMFCodesValuesDeletePopupComponent } from './cmf-codes-values-delete-dialog.component';
import { ICMFCodesValues } from 'app/shared/model/cmf-codes-values.model';

@Injectable({ providedIn: 'root' })
export class CMFCodesValuesResolve implements Resolve<ICMFCodesValues> {
  constructor(private service: CMFCodesValuesService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ICMFCodesValues> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<CMFCodesValues>) => response.ok),
        map((cMFCodesValues: HttpResponse<CMFCodesValues>) => cMFCodesValues.body)
      );
    }
    return of(new CMFCodesValues());
  }
}

export const cMFCodesValuesRoute: Routes = [
  {
    path: '',
    component: CMFCodesValuesComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'CMFCodesValues'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: CMFCodesValuesDetailComponent,
    resolve: {
      cMFCodesValues: CMFCodesValuesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodesValues'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: CMFCodesValuesUpdateComponent,
    resolve: {
      cMFCodesValues: CMFCodesValuesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodesValues'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: CMFCodesValuesUpdateComponent,
    resolve: {
      cMFCodesValues: CMFCodesValuesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodesValues'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const cMFCodesValuesPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: CMFCodesValuesDeletePopupComponent,
    resolve: {
      cMFCodesValues: CMFCodesValuesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodesValues'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
