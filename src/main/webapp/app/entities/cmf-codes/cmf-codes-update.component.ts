import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { ICMFCodes, CMFCodes } from 'app/shared/model/cmf-codes.model';
import { CMFCodesService } from './cmf-codes.service';

@Component({
  selector: 'jhi-cmf-codes-update',
  templateUrl: './cmf-codes-update.component.html'
})
export class CMFCodesUpdateComponent implements OnInit {
  cMFCodes: ICMFCodes;
  isSaving: boolean;

  editForm = this.fb.group({
    id: [],
    codeTableKey: [null, [Validators.required]],
    codeEntyName: [null, [Validators.required, Validators.maxLength(128)]],
    codeEntyDefinitionText: [null, [Validators.required, Validators.maxLength(800)]],
    codeTableName: [null, [Validators.required, Validators.maxLength(64)]],
    codeAttrbName: [null, [Validators.required, Validators.maxLength(128)]],
    descAttrbName: [null, [Validators.required, Validators.maxLength(128)]],
    codeColName: [null, [Validators.required, Validators.maxLength(64)]],
    descColName: [null, [Validators.required, Validators.maxLength(64)]],
    commentText: [null, [Validators.required, Validators.maxLength(800)]],
    nameAttrbName: [null, [Validators.required, Validators.maxLength(128)]],
    nameColName: [null, [Validators.required, Validators.maxLength(30)]],
    createDate: [],
    createUserId: [null, [Validators.required, Validators.maxLength(20)]],
    updDate: [],
    updUserId: [null, [Validators.required, Validators.maxLength(20)]]
  });

  constructor(protected cMFCodesService: CMFCodesService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ cMFCodes }) => {
      this.updateForm(cMFCodes);
      this.cMFCodes = cMFCodes;
    });
  }

  updateForm(cMFCodes: ICMFCodes) {
    this.editForm.patchValue({
      id: cMFCodes.id,
      codeTableKey: cMFCodes.codeTableKey,
      codeEntyName: cMFCodes.codeEntyName,
      codeEntyDefinitionText: cMFCodes.codeEntyDefinitionText,
      codeTableName: cMFCodes.codeTableName,
      codeAttrbName: cMFCodes.codeAttrbName,
      descAttrbName: cMFCodes.descAttrbName,
      codeColName: cMFCodes.codeColName,
      descColName: cMFCodes.descColName,
      commentText: cMFCodes.commentText,
      nameAttrbName: cMFCodes.nameAttrbName,
      nameColName: cMFCodes.nameColName,
      createDate: cMFCodes.createDate != null ? cMFCodes.createDate.format(DATE_TIME_FORMAT) : null,
      createUserId: cMFCodes.createUserId,
      updDate: cMFCodes.updDate != null ? cMFCodes.updDate.format(DATE_TIME_FORMAT) : null,
      updUserId: cMFCodes.updUserId
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const cMFCodes = this.createFromForm();
    if (cMFCodes.id !== undefined) {
      this.subscribeToSaveResponse(this.cMFCodesService.update(cMFCodes));
    } else {
      this.subscribeToSaveResponse(this.cMFCodesService.create(cMFCodes));
    }
  }

  private createFromForm(): ICMFCodes {
    const entity = {
      ...new CMFCodes(),
      id: this.editForm.get(['id']).value,
      codeTableKey: this.editForm.get(['codeTableKey']).value,
      codeEntyName: this.editForm.get(['codeEntyName']).value,
      codeEntyDefinitionText: this.editForm.get(['codeEntyDefinitionText']).value,
      codeTableName: this.editForm.get(['codeTableName']).value,
      codeAttrbName: this.editForm.get(['codeAttrbName']).value,
      descAttrbName: this.editForm.get(['descAttrbName']).value,
      codeColName: this.editForm.get(['codeColName']).value,
      descColName: this.editForm.get(['descColName']).value,
      commentText: this.editForm.get(['commentText']).value,
      nameAttrbName: this.editForm.get(['nameAttrbName']).value,
      nameColName: this.editForm.get(['nameColName']).value,
      createDate:
        this.editForm.get(['createDate']).value != null ? moment(this.editForm.get(['createDate']).value, DATE_TIME_FORMAT) : undefined,
      createUserId: this.editForm.get(['createUserId']).value,
      updDate: this.editForm.get(['updDate']).value != null ? moment(this.editForm.get(['updDate']).value, DATE_TIME_FORMAT) : undefined,
      updUserId: this.editForm.get(['updUserId']).value
    };
    return entity;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICMFCodes>>) {
    result.subscribe((res: HttpResponse<ICMFCodes>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}
