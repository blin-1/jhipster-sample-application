import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from 'app/shared';
import {
  CMFCodesComponent,
  CMFCodesDetailComponent,
  CMFCodesUpdateComponent,
  CMFCodesDeletePopupComponent,
  CMFCodesDeleteDialogComponent,
  cMFCodesRoute,
  cMFCodesPopupRoute
} from './';

const ENTITY_STATES = [...cMFCodesRoute, ...cMFCodesPopupRoute];

@NgModule({
  imports: [JhipsterSampleApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    CMFCodesComponent,
    CMFCodesDetailComponent,
    CMFCodesUpdateComponent,
    CMFCodesDeleteDialogComponent,
    CMFCodesDeletePopupComponent
  ],
  entryComponents: [CMFCodesComponent, CMFCodesUpdateComponent, CMFCodesDeleteDialogComponent, CMFCodesDeletePopupComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationCMFCodesModule {}
