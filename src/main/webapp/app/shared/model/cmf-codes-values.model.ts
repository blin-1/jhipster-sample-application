import { Moment } from 'moment';

export interface ICMFCodesValues {
  id?: number;
  codeValKey?: number;
  codeTableKey?: number;
  codeClassfctnTypeCode?: string;
  srcSysCode?: string;
  lifecycleStatusCode?: string;
  codeColValCode?: string;
  descColValText?: string;
  effDate?: Moment;
  endDate?: Moment;
  commentText?: string;
  nameColValName?: string;
  createDate?: Moment;
  createUserId?: string;
  updDate?: Moment;
  updUserId?: string;
}

export class CMFCodesValues implements ICMFCodesValues {
  constructor(
    public id?: number,
    public codeValKey?: number,
    public codeTableKey?: number,
    public codeClassfctnTypeCode?: string,
    public srcSysCode?: string,
    public lifecycleStatusCode?: string,
    public codeColValCode?: string,
    public descColValText?: string,
    public effDate?: Moment,
    public endDate?: Moment,
    public commentText?: string,
    public nameColValName?: string,
    public createDate?: Moment,
    public createUserId?: string,
    public updDate?: Moment,
    public updUserId?: string
  ) {}
}
