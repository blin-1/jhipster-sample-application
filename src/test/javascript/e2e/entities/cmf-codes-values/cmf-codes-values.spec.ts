/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, protractor, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { CMFCodesValuesComponentsPage, CMFCodesValuesDeleteDialog, CMFCodesValuesUpdatePage } from './cmf-codes-values.page-object';

const expect = chai.expect;

describe('CMFCodesValues e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let cMFCodesValuesUpdatePage: CMFCodesValuesUpdatePage;
  let cMFCodesValuesComponentsPage: CMFCodesValuesComponentsPage;
  let cMFCodesValuesDeleteDialog: CMFCodesValuesDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load CMFCodesValues', async () => {
    await navBarPage.goToEntity('cmf-codes-values');
    cMFCodesValuesComponentsPage = new CMFCodesValuesComponentsPage();
    await browser.wait(ec.visibilityOf(cMFCodesValuesComponentsPage.title), 5000);
    expect(await cMFCodesValuesComponentsPage.getTitle()).to.eq('CMF Codes Values');
  });

  it('should load create CMFCodesValues page', async () => {
    await cMFCodesValuesComponentsPage.clickOnCreateButton();
    cMFCodesValuesUpdatePage = new CMFCodesValuesUpdatePage();
    expect(await cMFCodesValuesUpdatePage.getPageTitle()).to.eq('Create or edit a CMF Codes Values');
    await cMFCodesValuesUpdatePage.cancel();
  });

  it('should create and save CMFCodesValues', async () => {
    const nbButtonsBeforeCreate = await cMFCodesValuesComponentsPage.countDeleteButtons();

    await cMFCodesValuesComponentsPage.clickOnCreateButton();
    await promise.all([
      cMFCodesValuesUpdatePage.setCodeValKeyInput('5'),
      cMFCodesValuesUpdatePage.setCodeTableKeyInput('5'),
      cMFCodesValuesUpdatePage.setCodeClassfctnTypeCodeInput('codeClassfctnTypeCode'),
      cMFCodesValuesUpdatePage.setSrcSysCodeInput('srcSysCode'),
      cMFCodesValuesUpdatePage.setLifecycleStatusCodeInput('lifecycleStatusCode'),
      cMFCodesValuesUpdatePage.setCodeColValCodeInput('codeColValCode'),
      cMFCodesValuesUpdatePage.setDescColValTextInput('descColValText'),
      cMFCodesValuesUpdatePage.setEffDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      cMFCodesValuesUpdatePage.setEndDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      cMFCodesValuesUpdatePage.setCommentTextInput('commentText'),
      cMFCodesValuesUpdatePage.setNameColValNameInput('nameColValName'),
      cMFCodesValuesUpdatePage.setCreateDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      cMFCodesValuesUpdatePage.setCreateUserIdInput('createUserId'),
      cMFCodesValuesUpdatePage.setUpdDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      cMFCodesValuesUpdatePage.setUpdUserIdInput('updUserId')
    ]);
    expect(await cMFCodesValuesUpdatePage.getCodeValKeyInput()).to.eq('5', 'Expected codeValKey value to be equals to 5');
    expect(await cMFCodesValuesUpdatePage.getCodeTableKeyInput()).to.eq('5', 'Expected codeTableKey value to be equals to 5');
    expect(await cMFCodesValuesUpdatePage.getCodeClassfctnTypeCodeInput()).to.eq(
      'codeClassfctnTypeCode',
      'Expected CodeClassfctnTypeCode value to be equals to codeClassfctnTypeCode'
    );
    expect(await cMFCodesValuesUpdatePage.getSrcSysCodeInput()).to.eq('srcSysCode', 'Expected SrcSysCode value to be equals to srcSysCode');
    expect(await cMFCodesValuesUpdatePage.getLifecycleStatusCodeInput()).to.eq(
      'lifecycleStatusCode',
      'Expected LifecycleStatusCode value to be equals to lifecycleStatusCode'
    );
    expect(await cMFCodesValuesUpdatePage.getCodeColValCodeInput()).to.eq(
      'codeColValCode',
      'Expected CodeColValCode value to be equals to codeColValCode'
    );
    expect(await cMFCodesValuesUpdatePage.getDescColValTextInput()).to.eq(
      'descColValText',
      'Expected DescColValText value to be equals to descColValText'
    );
    expect(await cMFCodesValuesUpdatePage.getEffDateInput()).to.contain(
      '2001-01-01T02:30',
      'Expected effDate value to be equals to 2000-12-31'
    );
    expect(await cMFCodesValuesUpdatePage.getEndDateInput()).to.contain(
      '2001-01-01T02:30',
      'Expected endDate value to be equals to 2000-12-31'
    );
    expect(await cMFCodesValuesUpdatePage.getCommentTextInput()).to.eq(
      'commentText',
      'Expected CommentText value to be equals to commentText'
    );
    expect(await cMFCodesValuesUpdatePage.getNameColValNameInput()).to.eq(
      'nameColValName',
      'Expected NameColValName value to be equals to nameColValName'
    );
    expect(await cMFCodesValuesUpdatePage.getCreateDateInput()).to.contain(
      '2001-01-01T02:30',
      'Expected createDate value to be equals to 2000-12-31'
    );
    expect(await cMFCodesValuesUpdatePage.getCreateUserIdInput()).to.eq(
      'createUserId',
      'Expected CreateUserId value to be equals to createUserId'
    );
    expect(await cMFCodesValuesUpdatePage.getUpdDateInput()).to.contain(
      '2001-01-01T02:30',
      'Expected updDate value to be equals to 2000-12-31'
    );
    expect(await cMFCodesValuesUpdatePage.getUpdUserIdInput()).to.eq('updUserId', 'Expected UpdUserId value to be equals to updUserId');
    await cMFCodesValuesUpdatePage.save();
    expect(await cMFCodesValuesUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await cMFCodesValuesComponentsPage.countDeleteButtons()).to.eq(
      nbButtonsBeforeCreate + 1,
      'Expected one more entry in the table'
    );
  });

  it('should delete last CMFCodesValues', async () => {
    const nbButtonsBeforeDelete = await cMFCodesValuesComponentsPage.countDeleteButtons();
    await cMFCodesValuesComponentsPage.clickOnLastDeleteButton();

    cMFCodesValuesDeleteDialog = new CMFCodesValuesDeleteDialog();
    expect(await cMFCodesValuesDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this CMF Codes Values?');
    await cMFCodesValuesDeleteDialog.clickOnConfirmButton();

    expect(await cMFCodesValuesComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
