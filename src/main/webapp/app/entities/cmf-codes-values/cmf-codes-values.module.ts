import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from 'app/shared';
import {
  CMFCodesValuesComponent,
  CMFCodesValuesDetailComponent,
  CMFCodesValuesUpdateComponent,
  CMFCodesValuesDeletePopupComponent,
  CMFCodesValuesDeleteDialogComponent,
  cMFCodesValuesRoute,
  cMFCodesValuesPopupRoute
} from './';

const ENTITY_STATES = [...cMFCodesValuesRoute, ...cMFCodesValuesPopupRoute];

@NgModule({
  imports: [JhipsterSampleApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    CMFCodesValuesComponent,
    CMFCodesValuesDetailComponent,
    CMFCodesValuesUpdateComponent,
    CMFCodesValuesDeleteDialogComponent,
    CMFCodesValuesDeletePopupComponent
  ],
  entryComponents: [
    CMFCodesValuesComponent,
    CMFCodesValuesUpdateComponent,
    CMFCodesValuesDeleteDialogComponent,
    CMFCodesValuesDeletePopupComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationCMFCodesValuesModule {}
