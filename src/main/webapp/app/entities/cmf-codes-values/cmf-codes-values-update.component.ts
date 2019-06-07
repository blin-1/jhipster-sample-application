import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { ICMFCodesValues, CMFCodesValues } from 'app/shared/model/cmf-codes-values.model';
import { CMFCodesValuesService } from './cmf-codes-values.service';

@Component({
  selector: 'jhi-cmf-codes-values-update',
  templateUrl: './cmf-codes-values-update.component.html'
})
export class CMFCodesValuesUpdateComponent implements OnInit {
  cMFCodesValues: ICMFCodesValues;
  isSaving: boolean;

  editForm = this.fb.group({
    id: [],
    codeValKey: [null, [Validators.required]],
    codeTableKey: [null, [Validators.required]],
    codeClassfctnTypeCode: [null, [Validators.required, Validators.maxLength(20)]],
    srcSysCode: [null, [Validators.required, Validators.maxLength(20)]],
    lifecycleStatusCode: [null, [Validators.required, Validators.maxLength(20)]],
    codeColValCode: [null, [Validators.maxLength(256)]],
    descColValText: [null, [Validators.maxLength(800)]],
    effDate: [],
    endDate: [],
    commentText: [null, [Validators.maxLength(800)]],
    nameColValName: [null, [Validators.maxLength(512)]],
    createDate: [],
    createUserId: [null, [Validators.required, Validators.maxLength(20)]],
    updDate: [],
    updUserId: [null, [Validators.required, Validators.maxLength(20)]]
  });

  constructor(protected cMFCodesValuesService: CMFCodesValuesService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ cMFCodesValues }) => {
      this.updateForm(cMFCodesValues);
      this.cMFCodesValues = cMFCodesValues;
    });
  }

  updateForm(cMFCodesValues: ICMFCodesValues) {
    this.editForm.patchValue({
      id: cMFCodesValues.id,
      codeValKey: cMFCodesValues.codeValKey,
      codeTableKey: cMFCodesValues.codeTableKey,
      codeClassfctnTypeCode: cMFCodesValues.codeClassfctnTypeCode,
      srcSysCode: cMFCodesValues.srcSysCode,
      lifecycleStatusCode: cMFCodesValues.lifecycleStatusCode,
      codeColValCode: cMFCodesValues.codeColValCode,
      descColValText: cMFCodesValues.descColValText,
      effDate: cMFCodesValues.effDate != null ? cMFCodesValues.effDate.format(DATE_TIME_FORMAT) : null,
      endDate: cMFCodesValues.endDate != null ? cMFCodesValues.endDate.format(DATE_TIME_FORMAT) : null,
      commentText: cMFCodesValues.commentText,
      nameColValName: cMFCodesValues.nameColValName,
      createDate: cMFCodesValues.createDate != null ? cMFCodesValues.createDate.format(DATE_TIME_FORMAT) : null,
      createUserId: cMFCodesValues.createUserId,
      updDate: cMFCodesValues.updDate != null ? cMFCodesValues.updDate.format(DATE_TIME_FORMAT) : null,
      updUserId: cMFCodesValues.updUserId
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const cMFCodesValues = this.createFromForm();
    if (cMFCodesValues.id !== undefined) {
      this.subscribeToSaveResponse(this.cMFCodesValuesService.update(cMFCodesValues));
    } else {
      this.subscribeToSaveResponse(this.cMFCodesValuesService.create(cMFCodesValues));
    }
  }

  private createFromForm(): ICMFCodesValues {
    const entity = {
      ...new CMFCodesValues(),
      id: this.editForm.get(['id']).value,
      codeValKey: this.editForm.get(['codeValKey']).value,
      codeTableKey: this.editForm.get(['codeTableKey']).value,
      codeClassfctnTypeCode: this.editForm.get(['codeClassfctnTypeCode']).value,
      srcSysCode: this.editForm.get(['srcSysCode']).value,
      lifecycleStatusCode: this.editForm.get(['lifecycleStatusCode']).value,
      codeColValCode: this.editForm.get(['codeColValCode']).value,
      descColValText: this.editForm.get(['descColValText']).value,
      effDate: this.editForm.get(['effDate']).value != null ? moment(this.editForm.get(['effDate']).value, DATE_TIME_FORMAT) : undefined,
      endDate: this.editForm.get(['endDate']).value != null ? moment(this.editForm.get(['endDate']).value, DATE_TIME_FORMAT) : undefined,
      commentText: this.editForm.get(['commentText']).value,
      nameColValName: this.editForm.get(['nameColValName']).value,
      createDate:
        this.editForm.get(['createDate']).value != null ? moment(this.editForm.get(['createDate']).value, DATE_TIME_FORMAT) : undefined,
      createUserId: this.editForm.get(['createUserId']).value,
      updDate: this.editForm.get(['updDate']).value != null ? moment(this.editForm.get(['updDate']).value, DATE_TIME_FORMAT) : undefined,
      updUserId: this.editForm.get(['updUserId']).value
    };
    return entity;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICMFCodesValues>>) {
    result.subscribe((res: HttpResponse<ICMFCodesValues>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}
