import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { CMFCodesMap } from 'app/shared/model/cmf-codes-map.model';
import { CMFCodesMapService } from './cmf-codes-map.service';
import { CMFCodesMapComponent } from './cmf-codes-map.component';
import { CMFCodesMapDetailComponent } from './cmf-codes-map-detail.component';
import { CMFCodesMapUpdateComponent } from './cmf-codes-map-update.component';
import { CMFCodesMapDeletePopupComponent } from './cmf-codes-map-delete-dialog.component';
import { ICMFCodesMap } from 'app/shared/model/cmf-codes-map.model';

@Injectable({ providedIn: 'root' })
export class CMFCodesMapResolve implements Resolve<ICMFCodesMap> {
  constructor(private service: CMFCodesMapService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ICMFCodesMap> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<CMFCodesMap>) => response.ok),
        map((cMFCodesMap: HttpResponse<CMFCodesMap>) => cMFCodesMap.body)
      );
    }
    return of(new CMFCodesMap());
  }
}

export const cMFCodesMapRoute: Routes = [
  {
    path: '',
    component: CMFCodesMapComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'CMFCodesMaps'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: CMFCodesMapDetailComponent,
    resolve: {
      cMFCodesMap: CMFCodesMapResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodesMaps'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: CMFCodesMapUpdateComponent,
    resolve: {
      cMFCodesMap: CMFCodesMapResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodesMaps'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: CMFCodesMapUpdateComponent,
    resolve: {
      cMFCodesMap: CMFCodesMapResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodesMaps'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const cMFCodesMapPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: CMFCodesMapDeletePopupComponent,
    resolve: {
      cMFCodesMap: CMFCodesMapResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CMFCodesMaps'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
