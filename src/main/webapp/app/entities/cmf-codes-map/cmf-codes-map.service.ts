import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICMFCodesMap } from 'app/shared/model/cmf-codes-map.model';

type EntityResponseType = HttpResponse<ICMFCodesMap>;
type EntityArrayResponseType = HttpResponse<ICMFCodesMap[]>;

@Injectable({ providedIn: 'root' })
export class CMFCodesMapService {
  public resourceUrl = SERVER_API_URL + 'api/cmf-codes-maps';

  constructor(protected http: HttpClient) {}

  create(cMFCodesMap: ICMFCodesMap): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(cMFCodesMap);
    return this.http
      .post<ICMFCodesMap>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(cMFCodesMap: ICMFCodesMap): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(cMFCodesMap);
    return this.http
      .put<ICMFCodesMap>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<ICMFCodesMap>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<ICMFCodesMap[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(cMFCodesMap: ICMFCodesMap): ICMFCodesMap {
    const copy: ICMFCodesMap = Object.assign({}, cMFCodesMap, {
      effDate: cMFCodesMap.effDate != null && cMFCodesMap.effDate.isValid() ? cMFCodesMap.effDate.toJSON() : null,
      endDate: cMFCodesMap.endDate != null && cMFCodesMap.endDate.isValid() ? cMFCodesMap.endDate.toJSON() : null,
      createDate: cMFCodesMap.createDate != null && cMFCodesMap.createDate.isValid() ? cMFCodesMap.createDate.toJSON() : null,
      updDate: cMFCodesMap.updDate != null && cMFCodesMap.updDate.isValid() ? cMFCodesMap.updDate.toJSON() : null
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
      res.body.forEach((cMFCodesMap: ICMFCodesMap) => {
        cMFCodesMap.effDate = cMFCodesMap.effDate != null ? moment(cMFCodesMap.effDate) : null;
        cMFCodesMap.endDate = cMFCodesMap.endDate != null ? moment(cMFCodesMap.endDate) : null;
        cMFCodesMap.createDate = cMFCodesMap.createDate != null ? moment(cMFCodesMap.createDate) : null;
        cMFCodesMap.updDate = cMFCodesMap.updDate != null ? moment(cMFCodesMap.updDate) : null;
      });
    }
    return res;
  }
}
