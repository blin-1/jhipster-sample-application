/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { CMFCodesMapDetailComponent } from 'app/entities/cmf-codes-map/cmf-codes-map-detail.component';
import { CMFCodesMap } from 'app/shared/model/cmf-codes-map.model';

describe('Component Tests', () => {
  describe('CMFCodesMap Management Detail Component', () => {
    let comp: CMFCodesMapDetailComponent;
    let fixture: ComponentFixture<CMFCodesMapDetailComponent>;
    const route = ({ data: of({ cMFCodesMap: new CMFCodesMap(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplicationTestModule],
        declarations: [CMFCodesMapDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CMFCodesMapDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CMFCodesMapDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.cMFCodesMap).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
