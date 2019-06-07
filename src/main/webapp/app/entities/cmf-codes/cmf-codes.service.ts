import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICMFCodes } from 'app/shared/model/cmf-codes.model';

type EntityResponseType = HttpResponse<ICMFCodes>;
type EntityArrayResponseType = HttpResponse<ICMFCodes[]>;

@Injectable({ providedIn: 'root' })
export class CMFCodesService {
  public resourceUrl = SERVER_API_URL + 'api/cmf-codes';

  constructor(protected http: HttpClient) {}

  create(cMFCodes: ICMFCodes): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(cMFCodes);
    return this.http
      .post<ICMFCodes>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(cMFCodes: ICMFCodes): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(cMFCodes);
    return this.http
      .put<ICMFCodes>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<ICMFCodes>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<ICMFCodes[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(cMFCodes: ICMFCodes): ICMFCodes {
    const copy: ICMFCodes = Object.assign({}, cMFCodes, {
      createDate: cMFCodes.createDate != null && cMFCodes.createDate.isValid() ? cMFCodes.createDate.toJSON() : null,
      updDate: cMFCodes.updDate != null && cMFCodes.updDate.isValid() ? cMFCodes.updDate.toJSON() : null
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.createDate = res.body.createDate != null ? moment(res.body.createDate) : null;
      res.body.updDate = res.body.updDate != null ? moment(res.body.updDate) : null;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((cMFCodes: ICMFCodes) => {
        cMFCodes.createDate = cMFCodes.createDate != null ? moment(cMFCodes.createDate) : null;
        cMFCodes.updDate = cMFCodes.updDate != null ? moment(cMFCodes.updDate) : null;
      });
    }
    return res;
  }
}
