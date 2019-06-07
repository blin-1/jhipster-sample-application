import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICMFCodesMap } from 'app/shared/model/cmf-codes-map.model';

@Component({
  selector: 'jhi-cmf-codes-map-detail',
  templateUrl: './cmf-codes-map-detail.component.html'
})
export class CMFCodesMapDetailComponent implements OnInit {
  cMFCodesMap: ICMFCodesMap;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ cMFCodesMap }) => {
      this.cMFCodesMap = cMFCodesMap;
    });
  }

  previousState() {
    window.history.back();
  }
}
