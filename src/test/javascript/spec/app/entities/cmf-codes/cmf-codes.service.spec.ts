/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { CMFCodesService } from 'app/entities/cmf-codes/cmf-codes.service';
import { ICMFCodes, CMFCodes } from 'app/shared/model/cmf-codes.model';

describe('Service Tests', () => {
  describe('CMFCodes Service', () => {
    let injector: TestBed;
    let service: CMFCodesService;
    let httpMock: HttpTestingController;
    let elemDefault: ICMFCodes;
    let expectedResult;
    let currentDate: moment.Moment;
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = {};
      injector = getTestBed();
      service = injector.get(CMFCodesService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new CMFCodes(
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
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

      it('should create a CMFCodes', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            createDate: currentDate.format(DATE_TIME_FORMAT),
            updDate: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createDate: currentDate,
            updDate: currentDate
          },
          returnedFromService
        );
        service
          .create(new CMFCodes(null))
          .pipe(take(1))
          .subscribe(resp => (expectedResult = resp));
        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject({ body: expected });
      });

      it('should update a CMFCodes', async () => {
        const returnedFromService = Object.assign(
          {
            codeTableKey: 1,
            codeEntyName: 'BBBBBB',
            codeEntyDefinitionText: 'BBBBBB',
            codeTableName: 'BBBBBB',
            codeAttrbName: 'BBBBBB',
            descAttrbName: 'BBBBBB',
            codeColName: 'BBBBBB',
            descColName: 'BBBBBB',
            commentText: 'BBBBBB',
            nameAttrbName: 'BBBBBB',
            nameColName: 'BBBBBB',
            createDate: currentDate.format(DATE_TIME_FORMAT),
            createUserId: 'BBBBBB',
            updDate: currentDate.format(DATE_TIME_FORMAT),
            updUserId: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
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

      it('should return a list of CMFCodes', async () => {
        const returnedFromService = Object.assign(
          {
            codeTableKey: 1,
            codeEntyName: 'BBBBBB',
            codeEntyDefinitionText: 'BBBBBB',
            codeTableName: 'BBBBBB',
            codeAttrbName: 'BBBBBB',
            descAttrbName: 'BBBBBB',
            codeColName: 'BBBBBB',
            descColName: 'BBBBBB',
            commentText: 'BBBBBB',
            nameAttrbName: 'BBBBBB',
            nameColName: 'BBBBBB',
            createDate: currentDate.format(DATE_TIME_FORMAT),
            createUserId: 'BBBBBB',
            updDate: currentDate.format(DATE_TIME_FORMAT),
            updUserId: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign(
          {
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

      it('should delete a CMFCodes', async () => {
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
