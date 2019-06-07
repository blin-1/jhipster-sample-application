/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { CMFCodesValuesDetailComponent } from 'app/entities/cmf-codes-values/cmf-codes-values-detail.component';
import { CMFCodesValues } from 'app/shared/model/cmf-codes-values.model';

describe('Component Tests', () => {
  describe('CMFCodesValues Management Detail Component', () => {
    let comp: CMFCodesValuesDetailComponent;
    let fixture: ComponentFixture<CMFCodesValuesDetailComponent>;
    const route = ({ data: of({ cMFCodesValues: new CMFCodesValues(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplicationTestModule],
        declarations: [CMFCodesValuesDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CMFCodesValuesDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CMFCodesValuesDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.cMFCodesValues).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
