/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { CMFCodesValuesService } from 'app/entities/cmf-codes-values/cmf-codes-values.service';
import { ICMFCodesValues, CMFCodesValues } from 'app/shared/model/cmf-codes-values.model';

describe('Service Tests', () => {
  describe('CMFCodesValues Service', () => {
    let injector: TestBed;
    let service: CMFCodesValuesService;
    let httpMock: HttpTestingController;
    let elemDefault: ICMFCodesValues;
    let expectedResult;
    let currentDate: moment.Moment;
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = {};
      injector = getTestBed();
      service = injector.get(CMFCodesValuesService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new CMFCodesValues(
        0,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        'AAAAAAA',
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

      it('should create a CMFCodesValues', async () => {
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
          .create(new CMFCodesValues(null))
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp));
        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject({ body: expected });
      });

      it('should update a CMFCodesValues', async () => {
        const returnedFromService = Object.assign(
          {
            codeValKey: 1,
            codeTableKey: 1,
            codeClassfctnTypeCode: 'BBBBBB',
            srcSysCode: 'BBBBBB',
            lifecycleStatusCode: 'BBBBBB',
            codeColValCode: 'BBBBBB',
            descColValText: 'BBBBBB',
            effDate: currentDate.format(DATE_TIME_FORMAT),
            endDate: currentDate.format(DATE_TIME_FORMAT),
            commentText: 'BBBBBB',
            nameColValName: 'BBBBBB',
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

      it('should return a list of CMFCodesValues', async () => {
        const returnedFromService = Object.assign(
          {
            codeValKey: 1,
            codeTableKey: 1,
            codeClassfctnTypeCode: 'BBBBBB',
            srcSysCode: 'BBBBBB',
            lifecycleStatusCode: 'BBBBBB',
            codeColValCode: 'BBBBBB',
            descColValText: 'BBBBBB',
            effDate: currentDate.format(DATE_TIME_FORMAT),
            endDate: currentDate.format(DATE_TIME_FORMAT),
            commentText: 'BBBBBB',
            nameColValName: 'BBBBBB',
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

      it('should delete a CMFCodesValues', async () => {
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
