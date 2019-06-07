import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';
import { ICMFCodesMap, CMFCodesMap } from 'app/shared/model/cmf-codes-map.model';
import { CMFCodesMapService } from './cmf-codes-map.service';
import { ICMFCodesValues } from 'app/shared/model/cmf-codes-values.model';
import { CMFCodesValuesService } from 'app/entities/cmf-codes-values';

@Component({
  selector: 'jhi-cmf-codes-map-update',
  templateUrl: './cmf-codes-map-update.component.html'
})
export class CMFCodesMapUpdateComponent implements OnInit {
  cMFCodesMap: ICMFCodesMap;
  isSaving: boolean;

  cmfcodevalues: ICMFCodesValues[];

  cmfcodevaluesrltds: ICMFCodesValues[];

  editForm = this.fb.group({
    id: [],
    codeValKey: [null, [Validators.required]],
    codeValRltdKey: [null, [Validators.required]],
    mapTypeCode: [null, [Validators.required, Validators.maxLength(20)]],
    effDate: [],
    endDate: [],
    commentText: [null, [Validators.maxLength(800)]],
    createDate: [],
    createUserId: [null, [Validators.required, Validators.maxLength(20)]],
    updDate: [],
    updUserId: [null, [Validators.required, Validators.maxLength(20)]],
    cMFCodeValues: [],
    cMFCodeValuesRltd: []
  });

  constructor(
    protected jhiAlertService: JhiAlertService,
    protected cMFCodesMapService: CMFCodesMapService,
    protected cMFCodesValuesService: CMFCodesValuesService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ cMFCodesMap }) => {
      this.updateForm(cMFCodesMap);
      this.cMFCodesMap = cMFCodesMap;
    });
    this.cMFCodesValuesService
      .query({ 'cMFCodesMapId.specified': 'false' })
      .pipe(
        filter((mayBeOk: HttpResponse<ICMFCodesValues[]>) => mayBeOk.ok),
        map((response: HttpResponse<ICMFCodesValues[]>) => response.body)
      )
      .subscribe(
        (res: ICMFCodesValues[]) => {
          if (!this.cMFCodesMap.cMFCodeValues || !this.cMFCodesMap.cMFCodeValues.id) {
            this.cmfcodevalues = res;
          } else {
            this.cMFCodesValuesService
              .find(this.cMFCodesMap.cMFCodeValues.id)
              .pipe(
                filter((subResMayBeOk: HttpResponse<ICMFCodesValues>) => subResMayBeOk.ok),
                map((subResponse: HttpResponse<ICMFCodesValues>) => subResponse.body)
              )
              .subscribe(
                (subRes: ICMFCodesValues) => (this.cmfcodevalues = [subRes].concat(res)),
                (subRes: HttpErrorResponse) => this.onError(subRes.message)
              );
          }
        },
        (res: HttpErrorResponse) => this.onError(res.message)
      );
    this.cMFCodesValuesService
      .query({ 'cMFCodesMapId.specified': 'false' })
      .pipe(
        filter((mayBeOk: HttpResponse<ICMFCodesValues[]>) => mayBeOk.ok),
        map((response: HttpResponse<ICMFCodesValues[]>) => response.body)
      )
      .subscribe(
        (res: ICMFCodesValues[]) => {
          if (!this.cMFCodesMap.cMFCodeValuesRltd || !this.cMFCodesMap.cMFCodeValuesRltd.id) {
            this.cmfcodevaluesrltds = res;
          } else {
            this.cMFCodesValuesService
              .find(this.cMFCodesMap.cMFCodeValuesRltd.id)
              .pipe(
                filter((subResMayBeOk: HttpResponse<ICMFCodesValues>) => subResMayBeOk.ok),
                map((subResponse: HttpResponse<ICMFCodesValues>) => subResponse.body)
              )
              .subscribe(
                (subRes: ICMFCodesValues) => (this.cmfcodevaluesrltds = [subRes].concat(res)),
                (subRes: HttpErrorResponse) => this.onError(subRes.message)
              );
          }
        },
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  updateForm(cMFCodesMap: ICMFCodesMap) {
    this.editForm.patchValue({
      id: cMFCodesMap.id,
      codeValKey: cMFCodesMap.codeValKey,
      codeValRltdKey: cMFCodesMap.codeValRltdKey,
      mapTypeCode: cMFCodesMap.mapTypeCode,
      effDate: cMFCodesMap.effDate != null ? cMFCodesMap.effDate.format(DATE_TIME_FORMAT) : null,
      endDate: cMFCodesMap.endDate != null ? cMFCodesMap.endDate.format(DATE_TIME_FORMAT) : null,
      commentText: cMFCodesMap.commentText,
      createDate: cMFCodesMap.createDate != null ? cMFCodesMap.createDate.format(DATE_TIME_FORMAT) : null,
      createUserId: cMFCodesMap.createUserId,
      updDate: cMFCodesMap.updDate != null ? cMFCodesMap.updDate.format(DATE_TIME_FORMAT) : null,
      updUserId: cMFCodesMap.updUserId,
      cMFCodeValues: cMFCodesMap.cMFCodeValues,
      cMFCodeValuesRltd: cMFCodesMap.cMFCodeValuesRltd
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const cMFCodesMap = this.createFromForm();
    if (cMFCodesMap.id !== undefined) {
      this.subscribeToSaveResponse(this.cMFCodesMapService.update(cMFCodesMap));
    } else {
      this.subscribeToSaveResponse(this.cMFCodesMapService.create(cMFCodesMap));
    }
  }

  private createFromForm(): ICMFCodesMap {
    const entity = {
      ...new CMFCodesMap(),
      id: this.editForm.get(['id']).value,
      codeValKey: this.editForm.get(['codeValKey']).value,
      codeValRltdKey: this.editForm.get(['codeValRltdKey']).value,
      mapTypeCode: this.editForm.get(['mapTypeCode']).value,
      effDate: this.editForm.get(['effDate']).value != null ? moment(this.editForm.get(['effDate']).value, DATE_TIME_FORMAT) : undefined,
      endDate: this.editForm.get(['endDate']).value != null ? moment(this.editForm.get(['endDate']).value, DATE_TIME_FORMAT) : undefined,
      commentText: this.editForm.get(['commentText']).value,
      createDate:
        this.editForm.get(['createDate']).value != null ? moment(this.editForm.get(['createDate']).value, DATE_TIME_FORMAT) : undefined,
      createUserId: this.editForm.get(['createUserId']).value,
      updDate: this.editForm.get(['updDate']).value != null ? moment(this.editForm.get(['updDate']).value, DATE_TIME_FORMAT) : undefined,
      updUserId: this.editForm.get(['updUserId']).value,
      cMFCodeValues: this.editForm.get(['cMFCodeValues']).value,
      cMFCodeValuesRltd: this.editForm.get(['cMFCodeValuesRltd']).value
    };
    return entity;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICMFCodesMap>>) {
    result.subscribe((res: HttpResponse<ICMFCodesMap>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackCMFCodesValuesById(index: number, item: ICMFCodesValues) {
    return item.id;
  }
}
