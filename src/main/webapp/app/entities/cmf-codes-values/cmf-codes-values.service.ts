import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICMFCodesValues } from 'app/shared/model/cmf-codes-values.model';

type EntityResponseType = HttpResponse<ICMFCodesValues>;
type EntityArrayResponseType = HttpResponse<ICMFCodesValues[]>;

@Injectable({ providedIn: 'root' })
export class CMFCodesValuesService {
  public resourceUrl = SERVER_API_URL + 'api/cmf-codes-values';

  constructor(protected http: HttpClient) {}

  create(cMFCodesValues: ICMFCodesValues): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(cMFCodesValues);
    return this.http
      .post<ICMFCodesValues>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(cMFCodesValues: ICMFCodesValues): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(cMFCodesValues);
    return this.http
      .put<ICMFCodesValues>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<ICMFCodesValues>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<ICMFCodesValues[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(cMFCodesValues: ICMFCodesValues): ICMFCodesValues {
    const copy: ICMFCodesValues = Object.assign({}, cMFCodesValues, {
      effDate: cMFCodesValues.effDate != null && cMFCodesValues.effDate.isValid() ? cMFCodesValues.effDate.toJSON() : null,
      endDate: cMFCodesValues.endDate != null && cMFCodesValues.endDate.isValid() ? cMFCodesValues.endDate.toJSON() : null,
      createDate: cMFCodesValues.createDate != null && cMFCodesValues.createDate.isValid() ? cMFCodesValues.createDate.toJSON() : null,
      updDate: cMFCodesValues.updDate != null && cMFCodesValues.updDate.isValid() ? cMFCodesValues.updDate.toJSON() : null
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.effDate = res.body.effDate != null ? moment(res.body.effDate) : null;
      res.body.endDate = res.body.endDate != null ? moment(res.body.endDate) : null;
      res.body.createDate = res.body.createDate != null ? moment(res.body.createDate) : null;
      res.body.updDate = res.body.updDate != null ? moment(res.body.updDate) : null;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((cMFCodesValues: ICMFCodesValues) => {
        cMFCodesValues.effDate = cMFCodesValues.effDate != null ? moment(cMFCodesValues.effDate) : null;
        cMFCodesValues.endDate = cMFCodesValues.endDate != null ? moment(cMFCodesValues.endDate) : null;
        cMFCodesValues.createDate = cMFCodesValues.createDate != null ? moment(cMFCodesValues.createDate) : null;
        cMFCodesValues.updDate = cMFCodesValues.updDate != null ? moment(cMFCodesValues.updDate) : null;
      });
    }
    return res;
  }
}
