/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, protractor, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { CMFCodesComponentsPage, CMFCodesDeleteDialog, CMFCodesUpdatePage } from './cmf-codes.page-object';

const expect = chai.expect;

describe('CMFCodes e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let cMFCodesUpdatePage: CMFCodesUpdatePage;
  let cMFCodesComponentsPage: CMFCodesComponentsPage;
  let cMFCodesDeleteDialog: CMFCodesDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load CMFCodes', async () => {
    await navBarPage.goToEntity('cmf-codes');
    cMFCodesComponentsPage = new CMFCodesComponentsPage();
    await browser.wait(ec.visibilityOf(cMFCodesComponentsPage.title), 5000);
    expect(await cMFCodesComponentsPage.getTitle()).to.eq('CMF Codes');
  });

  it('should load create CMFCodes page', async () => {
    await cMFCodesComponentsPage.clickOnCreateButton();
    cMFCodesUpdatePage = new CMFCodesUpdatePage();
    expect(await cMFCodesUpdatePage.getPageTitle()).to.eq('Create or edit a CMF Codes');
    await cMFCodesUpdatePage.cancel();
  });

  it('should create and save CMFCodes', async () => {
    const nbButtonsBeforeCreate = await cMFCodesComponentsPage.countDeleteButtons();

    await cMFCodesComponentsPage.clickOnCreateButton();
    await promise.all([
      cMFCodesUpdatePage.setCodeTableKeyInput('5'),
      cMFCodesUpdatePage.setCodeEntyNameInput('codeEntyName'),
      cMFCodesUpdatePage.setCodeEntyDefinitionTextInput('codeEntyDefinitionText'),
      cMFCodesUpdatePage.setCodeTableNameInput('codeTableName'),
      cMFCodesUpdatePage.setCodeAttrbNameInput('codeAttrbName'),
      cMFCodesUpdatePage.setDescAttrbNameInput('descAttrbName'),
      cMFCodesUpdatePage.setCodeColNameInput('codeColName'),
      cMFCodesUpdatePage.setDescColNameInput('descColName'),
      cMFCodesUpdatePage.setCommentTextInput('commentText'),
      cMFCodesUpdatePage.setNameAttrbNameInput('nameAttrbName'),
      cMFCodesUpdatePage.setNameColNameInput('nameColName'),
      cMFCodesUpdatePage.setCreateDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      cMFCodesUpdatePage.setCreateUserIdInput('createUserId'),
      cMFCodesUpdatePage.setUpdDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
      cMFCodesUpdatePage.setUpdUserIdInput('updUserId')
    ]);
    expect(await cMFCodesUpdatePage.getCodeTableKeyInput()).to.eq('5', 'Expected codeTableKey value to be equals to 5');
    expect(await cMFCodesUpdatePage.getCodeEntyNameInput()).to.eq(
      'codeEntyName',
      'Expected CodeEntyName value to be equals to codeEntyName'
    );
    expect(await cMFCodesUpdatePage.getCodeEntyDefinitionTextInput()).to.eq(
      'codeEntyDefinitionText',
      'Expected CodeEntyDefinitionText value to be equals to codeEntyDefinitionText'
    );
    expect(await cMFCodesUpdatePage.getCodeTableNameInput()).to.eq(
      'codeTableName',
      'Expected CodeTableName value to be equals to codeTableName'
    );
    expect(await cMFCodesUpdatePage.getCodeAttrbNameInput()).to.eq(
      'codeAttrbName',
      'Expected CodeAttrbName value to be equals to codeAttrbName'
    );
    expect(await cMFCodesUpdatePage.getDescAttrbNameInput()).to.eq(
      'descAttrbName',
      'Expected DescAttrbName value to be equals to descAttrbName'
    );
    expect(await cMFCodesUpdatePage.getCodeColNameInput()).to.eq('codeColName', 'Expected CodeColName value to be equals to codeColName');
    expect(await cMFCodesUpdatePage.getDescColNameInput()).to.eq('descColName', 'Expected DescColName value to be equals to descColName');
    expect(await cMFCodesUpdatePage.getCommentTextInput()).to.eq('commentText', 'Expected CommentText value to be equals to commentText');
    expect(await cMFCodesUpdatePage.getNameAttrbNameInput()).to.eq(
      'nameAttrbName',
      'Expected NameAttrbName value to be equals to nameAttrbName'
    );
    expect(await cMFCodesUpdatePage.getNameColNameInput()).to.eq('nameColName', 'Expected NameColName value to be equals to nameColName');
    expect(await cMFCodesUpdatePage.getCreateDateInput()).to.contain(
      '2001-01-01T02:30',
      'Expected createDate value to be equals to 2000-12-31'
    );
    expect(await cMFCodesUpdatePage.getCreateUserIdInput()).to.eq(
      'createUserId',
      'Expected CreateUserId value to be equals to createUserId'
    );
    expect(await cMFCodesUpdatePage.getUpdDateInput()).to.contain('2001-01-01T02:30', 'Expected updDate value to be equals to 2000-12-31');
    expect(await cMFCodesUpdatePage.getUpdUserIdInput()).to.eq('updUserId', 'Expected UpdUserId value to be equals to updUserId');
    await cMFCodesUpdatePage.save();
    expect(await cMFCodesUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await cMFCodesComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last CMFCodes', async () => {
    const nbButtonsBeforeDelete = await cMFCodesComponentsPage.countDeleteButtons();
    await cMFCodesComponentsPage.clickOnLastDeleteButton();

    cMFCodesDeleteDialog = new CMFCodesDeleteDialog();
    expect(await cMFCodesDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this CMF Codes?');
    await cMFCodesDeleteDialog.clickOnConfirmButton();

    expect(await cMFCodesComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
