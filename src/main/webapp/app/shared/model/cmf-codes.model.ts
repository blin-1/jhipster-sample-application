import { Moment } from 'moment';

export interface ICMFCodes {
  id?: number;
  codeTableKey?: number;
  codeEntyName?: string;
  codeEntyDefinitionText?: string;
  codeTableName?: string;
  codeAttrbName?: string;
  descAttrbName?: string;
  codeColName?: string;
  descColName?: string;
  commentText?: string;
  nameAttrbName?: string;
  nameColName?: string;
  createDate?: Moment;
  createUserId?: string;
  updDate?: Moment;
  updUserId?: string;
}

export class CMFCodes implements ICMFCodes {
  constructor(
    public id?: number,
    public codeTableKey?: number,
    public codeEntyName?: string,
    public codeEntyDefinitionText?: string,
    public codeTableName?: string,
    public codeAttrbName?: string,
    public descAttrbName?: string,
    public codeColName?: string,
    public descColName?: string,
    public commentText?: string,
    public nameAttrbName?: string,
    public nameColName?: string,
    public createDate?: Moment,
    public createUserId?: string,
    public updDate?: Moment,
    public updUserId?: string
  ) {}
}
