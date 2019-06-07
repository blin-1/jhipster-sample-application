import { Moment } from 'moment';
import { ICMFCodesValues } from 'app/shared/model/cmf-codes-values.model';

export interface ICMFCodesMap {
  id?: number;
  codeValKey?: number;
  codeValRltdKey?: number;
  mapTypeCode?: string;
  effDate?: Moment;
  endDate?: Moment;
  commentText?: string;
  createDate?: Moment;
  createUserId?: string;
  updDate?: Moment;
  updUserId?: string;
  cMFCodeValues?: ICMFCodesValues;
  cMFCodeValuesRltd?: ICMFCodesValues;
}

export class CMFCodesMap implements ICMFCodesMap {
  constructor(
    public id?: number,
    public codeValKey?: number,
    public codeValRltdKey?: number,
    public mapTypeCode?: string,
    public effDate?: Moment,
    public endDate?: Moment,
    public commentText?: string,
    public createDate?: Moment,
    public createUserId?: string,
    public updDate?: Moment,
    public updUserId?: string,
    public cMFCodeValues?: ICMFCodesValues,
    public cMFCodeValuesRltd?: ICMFCodesValues
  ) {}
}
