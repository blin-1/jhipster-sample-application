import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICMFCodes } from 'app/shared/model/cmf-codes.model';

@Component({
  selector: 'jhi-cmf-codes-detail',
  templateUrl: './cmf-codes-detail.component.html'
})
export class CMFCodesDetailComponent implements OnInit {
  cMFCodes: ICMFCodes;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ cMFCodes }) => {
      this.cMFCodes = cMFCodes;
    });
  }

  previousState() {
    window.history.back();
  }
}
