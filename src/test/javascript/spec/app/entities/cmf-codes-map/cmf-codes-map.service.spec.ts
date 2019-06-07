/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { CMFCodesMapService } from 'app/entities/cmf-codes-map/cmf-codes-map.service';
import { ICMFCodesMap, CMFCodesMap } from 'app/shared/model/cmf-codes-map.model';

describe('Service Tests', () => {
  describe('CMFCodesMap Service', () => {
    let injector: TestBed;
    let service: CMFCodesMapService;
    let httpMock: HttpTestingController;
    let elemDefault: ICMFCodesMap;
    let expectedResult;
    let currentDate: moment.Moment;
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = {};
      injector = getTestBed();
      service = injector.get(CMFCodesMapService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new CMFCodesMap(
        0,
        0,
        0,
        'AAAAAAA',
        currentDate,
        currentDate,
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        currentDate,
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            effDate: currentDate.format(DATE_TIME_FORMAT),
            endDate: currentDate.format(DATE_TIME_FORMAT),
            createDate: currentDate.format(DATE_TIME_FORMAT),
            updDate: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );
        service
          .find(123)
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject({ body: elemDefault });
      });

      it('should create a CMFCodesMap', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            effDate: currentDate.format(DATE_TIME_FORMAT),
            endDate: currentDate.format(DATE_TIME_FORMAT),
            createDate: currentDate.format(DATE_TIME_FORMAT),
            updDate: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            effDate: currentDate,
            endDate: currentDate,
            createDate: currentDate,
            updDate: currentDate
          },
          returnedFromService
        );
        service
          .create(new CMFCodesMap(null))
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp));
        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject({ body: expected });
      });

      it('should update a CMFCodesMap', async () => {
        const returnedFromService = Object.assign(
          {
            codeValKey: 1,
            codeValRltdKey: 1,
            mapTypeCode: 'BBBBBB',
            effDate: currentDate.format(DATE_TIME_FORMAT),
            endDate: currentDate.format(DATE_TIME_FORMAT),
            commentText: 'BBBBBB',
            createDate: currentDate.format(DATE_TIME_FORMAT),
            createUserId: 'BBBBBB',
            updDate: currentDate.format(DATE_TIME_FORMAT),
            updUserId: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            effDate: currentDate,
            endDate: currentDate,
            createDate: currentDate,
            updDate: currentDate
          },
          returnedFromService
        );
        service
          .update(expected)
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp));
        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject({ body: expected });
      });

      it('should return a list of CMFCodesMap', async () => {
        const returnedFromService = Object.assign(
          {
            codeValKey: 1,
            codeValRltdKey: 1,
            mapTypeCode: 'BBBBBB',
            effDate: currentDate.format(DATE_TIME_FORMAT),
            endDate: currentDate.format(DATE_TIME_FORMAT),
            commentText: 'BBBBBB',
            createDate: currentDate.format(DATE_TIME_FORMAT),
            createUserId: 'BBBBBB',
            updDate: currentDate.format(DATE_TIME_FORMAT),
            updUserId: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            effDate: currentDate,
            endDate: currentDate,
            createDate: currentDate,
            updDate: currentDate
          },
          returnedFromService
        );
        service
          .query(expected)
          .pipe(
            take(1),
            map(resp => resp.body)
          )
          .subscribe(body => (expectedResult = body));
        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a CMFCodesMap', async () => {
        const rxPromise = service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
