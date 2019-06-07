import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICMFCodesValues } from 'app/shared/model/cmf-codes-values.model';

@Component({
  selector: 'jhi-cmf-codes-values-detail',
  templateUrl: './cmf-codes-values-detail.component.html'
})
export class CMFCodesValuesDetailComponent implements OnInit {
  cMFCodesValues: ICMFCodesValues;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ cMFCodesValues }) => {
      this.cMFCodesValues = cMFCodesValues;
    });
  }

  previousState() {
    window.history.back();
  }
}
