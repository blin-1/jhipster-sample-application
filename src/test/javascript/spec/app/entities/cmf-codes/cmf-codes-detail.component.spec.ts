/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { CMFCodesDetailComponent } from 'app/entities/cmf-codes/cmf-codes-detail.component';
import { CMFCodes } from 'app/shared/model/cmf-codes.model';

describe('Component Tests', () => {
  describe('CMFCodes Management Detail Component', () => {
    let comp: CMFCodesDetailComponent;
    let fixture: ComponentFixture<CMFCodesDetailComponent>;
    const route = ({ data: of({ cMFCodes: new CMFCodes(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplicationTestModule],
        declarations: [CMFCodesDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CMFCodesDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CMFCodesDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.cMFCodes).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
