import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'cmf-codes',
        loadChildren: './cmf-codes/cmf-codes.module#JhipsterSampleApplicationCMFCodesModule'
      },
      {
        path: 'cmf-codes-values',
        loadChildren: './cmf-codes-values/cmf-codes-values.module#JhipsterSampleApplicationCMFCodesValuesModule'
      },
      {
        path: 'cmf-codes-map',
        loadChildren: './cmf-codes-map/cmf-codes-map.module#JhipsterSampleApplicationCMFCodesMapModule'
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ],
  declarations: [],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationEntityModule {}
