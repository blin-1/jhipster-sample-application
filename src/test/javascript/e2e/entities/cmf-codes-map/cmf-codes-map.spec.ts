/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, protractor, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { CMFCodesMapComponentsPage, CMFCodesMapDeleteDialog, CMFCodesMapUpdatePage } from './cmf-codes-map.page-object';

const expect = chai.expect;

describe('CMFCodesMap e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let cMFCodesMapUpdatePage: CMFCodesMapUpdatePage;
  let cMFCodesMapComponentsPage: CMFCodesMapComponentsPage;
  let cMFCodesMapDeleteDialog: CMFCodesMapDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load CMFCodesMaps', async () => {
    await navBarPage.goToEntity('cmf-codes-map');
    cMFCodesMapComponentsPage = new CMFCodesMapComponentsPage();
    await browser.wait(ec.visibilityOf(cMFCodesMapComponentsPage.title), 5000);
    expect(await cMFCodesMapComponentsPage.getTitle()).to.eq('CMF Codes Maps');
  });

  it('should load create CMFCodesMap page', async () => {
    await cMFCodesMapComponentsPage.clickOnCreateButton();
    cMFCodesMapUpdatePage = new CMFCodesMapUpdatePage();
    expect(await cMFCodesMapUpdatePage.getPageTitle()).to.eq('Create or edit a CMF Codes Map');
    await cMFCodesMapUpdatePage.cancel();
  });

  it('should create and save CMFCodesMaps', async () => {
    const nbButtonsBeforeCreate = await cMFCodesMapComponentsPage.countDeleteButtons();

    await cMFCodesMapComponentsPage.clickOnCreateButton();
    await promise.all([
      cMFCodesMapUpdatePage.setCodeValKeyInput('5'),
      cMFCodesMapUpdatePage.setCodeValRltdKeyInput('5'),
      cMFCodesMapUpdatePage.setMapTypeCodeInput('mapTypeCode'),
      cMFCodesMapUpdatePage.setEffDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      cMFCodesMapUpdatePage.setEndDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      cMFCodesMapUpdatePage.setCommentTextInput('commentText'),
      cMFCodesMapUpdatePage.setCreateDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      cMFCodesMapUpdatePage.setCreateUserIdInput('createUserId'),
      cMFCodesMapUpdatePage.setUpdDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      cMFCodesMapUpdatePage.setUpdUserIdInput('updUserId'),
      cMFCodesMapUpdatePage.cMFCodeValuesSelectLastOption(),
      cMFCodesMapUpdatePage.cMFCodeValuesRltdSelectLastOption()
    ]);
    expect(await cMFCodesMapUpdatePage.getCodeValKeyInput()).to.eq('5', 'Expected codeValKey value to be equals to 5');
    expect(await cMFCodesMapUpdatePage.getCodeValRltdKeyInput()).to.eq('5', 'Expected codeValRltdKey value to be equals to 5');
    expect(await cMFCodesMapUpdatePage.getMapTypeCodeInput()).to.eq(
      'mapTypeCode',
      'Expected MapTypeCode value to be equals to mapTypeCode'
    );
    expect(await cMFCodesMapUpdatePage.getEffDateInput()).to.contain(
      '2001-01-01T02:30',
      'Expected effDate value to be equals to 2000-12-31'
    );
    expect(await cMFCodesMapUpdatePage.getEndDateInput()).to.contain(
      '2001-01-01T02:30',
      'Expected endDate value to be equals to 2000-12-31'
    );
    expect(await cMFCodesMapUpdatePage.getCommentTextInput()).to.eq(
      'commentText',
      'Expected CommentText value to be equals to commentText'
    );
    expect(await cMFCodesMapUpdatePage.getCreateDateInput()).to.contain(
      '2001-01-01T02:30',
      'Expected createDate value to be equals to 2000-12-31'
    );
    expect(await cMFCodesMapUpdatePage.getCreateUserIdInput()).to.eq(
      'createUserId',
      'Expected CreateUserId value to be equals to createUserId'
    );
    expect(await cMFCodesMapUpdatePage.getUpdDateInput()).to.contain(
      '2001-01-01T02:30',
      'Expected updDate value to be equals to 2000-12-31'
    );
    expect(await cMFCodesMapUpdatePage.getUpdUserIdInput()).to.eq('updUserId', 'Expected UpdUserId value to be equals to updUserId');
    await cMFCodesMapUpdatePage.save();
    expect(await cMFCodesMapUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await cMFCodesMapComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last CMFCodesMap', async () => {
    const nbButtonsBeforeDelete = await cMFCodesMapComponentsPage.countDeleteButtons();
    await cMFCodesMapComponentsPage.clickOnLastDeleteButton();

    cMFCodesMapDeleteDialog = new CMFCodesMapDeleteDialog();
    expect(await cMFCodesMapDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this CMF Codes Map?');
    await cMFCodesMapDeleteDialog.clickOnConfirmButton();

    expect(await cMFCodesMapComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
