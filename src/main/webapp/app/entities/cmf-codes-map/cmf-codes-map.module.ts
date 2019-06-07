import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from 'app/shared';
import {
  CMFCodesMapComponent,
  CMFCodesMapDetailComponent,
  CMFCodesMapUpdateComponent,
  CMFCodesMapDeletePopupComponent,
  CMFCodesMapDeleteDialogComponent,
  cMFCodesMapRoute,
  cMFCodesMapPopupRoute
} from './';

const ENTITY_STATES = [...cMFCodesMapRoute, ...cMFCodesMapPopupRoute];

@NgModule({
  imports: [JhipsterSampleApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    CMFCodesMapComponent,
    CMFCodesMapDetailComponent,
    CMFCodesMapUpdateComponent,
    CMFCodesMapDeleteDialogComponent,
    CMFCodesMapDeletePopupComponent
  ],
  entryComponents: [CMFCodesMapComponent, CMFCodesMapUpdateComponent, CMFCodesMapDeleteDialogComponent, CMFCodesMapDeletePopupComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationCMFCodesMapModule {}
