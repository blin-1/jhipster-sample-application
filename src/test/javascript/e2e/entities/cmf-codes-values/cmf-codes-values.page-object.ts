import { browser, ExpectedConditions, element, by, ElementFinder } from 'protractor';

export class CMFCodesValuesComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-cmf-codes-values div table .btn-danger'));
  title = element.all(by.css('jhi-cmf-codes-values div h2#page-heading span')).first();

  async clickOnCreateButton(timeout?: number) {
    await this.createButton.click();
  }

  async clickOnLastDeleteButton(timeout?: number) {
    await this.deleteButtons.last().click();
  }

  async countDeleteButtons() {
    return this.deleteButtons.count();
  }

  async getTitle() {
    return this.title.getText();
  }
}

export class CMFCodesValuesUpdatePage {
  pageTitle = element(by.id('jhi-cmf-codes-values-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));
  codeValKeyInput = element(by.id('field_codeValKey'));
  codeTableKeyInput = element(by.id('field_codeTableKey'));
  codeClassfctnTypeCodeInput = element(by.id('field_codeClassfctnTypeCode'));
  srcSysCodeInput = element(by.id('field_srcSysCode'));
  lifecycleStatusCodeInput = element(by.id('field_lifecycleStatusCode'));
  codeColValCodeInput = element(by.id('field_codeColValCode'));
  descColValTextInput = element(by.id('field_descColValText'));
  effDateInput = element(by.id('field_effDate'));
  endDateInput = element(by.id('field_endDate'));
  commentTextInput = element(by.id('field_commentText'));
  nameColValNameInput = element(by.id('field_nameColValName'));
  createDateInput = element(by.id('field_createDate'));
  createUserIdInput = element(by.id('field_createUserId'));
  updDateInput = element(by.id('field_updDate'));
  updUserIdInput = element(by.id('field_updUserId'));

  async getPageTitle() {
    return this.pageTitle.getText();
  }

  async setCodeValKeyInput(codeValKey) {
    await this.codeValKeyInput.sendKeys(codeValKey);
  }

  async getCodeValKeyInput() {
    return await this.codeValKeyInput.getAttribute('value');
  }

  async setCodeTableKeyInput(codeTableKey) {
    await this.codeTableKeyInput.sendKeys(codeTableKey);
  }

  async getCodeTableKeyInput() {
    return await this.codeTableKeyInput.getAttribute('value');
  }

  async setCodeClassfctnTypeCodeInput(codeClassfctnTypeCode) {
    await this.codeClassfctnTypeCodeInput.sendKeys(codeClassfctnTypeCode);
  }

  async getCodeClassfctnTypeCodeInput() {
    return await this.codeClassfctnTypeCodeInput.getAttribute('value');
  }

  async setSrcSysCodeInput(srcSysCode) {
    await this.srcSysCodeInput.sendKeys(srcSysCode);
  }

  async getSrcSysCodeInput() {
    return await this.srcSysCodeInput.getAttribute('value');
  }

  async setLifecycleStatusCodeInput(lifecycleStatusCode) {
    await this.lifecycleStatusCodeInput.sendKeys(lifecycleStatusCode);
  }

  async getLifecycleStatusCodeInput() {
    return await this.lifecycleStatusCodeInput.getAttribute('value');
  }

  async setCodeColValCodeInput(codeColValCode) {
    await this.codeColValCodeInput.sendKeys(codeColValCode);
  }

  async getCodeColValCodeInput() {
    return await this.codeColValCodeInput.getAttribute('value');
  }

  async setDescColValTextInput(descColValText) {
    await this.descColValTextInput.sendKeys(descColValText);
  }

  async getDescColValTextInput() {
    return await this.descColValTextInput.getAttribute('value');
  }

  async setEffDateInput(effDate) {
    await this.effDateInput.sendKeys(effDate);
  }

  async getEffDateInput() {
    return await this.effDateInput.getAttribute('value');
  }

  async setEndDateInput(endDate) {
    await this.endDateInput.sendKeys(endDate);
  }

  async getEndDateInput() {
    return await this.endDateInput.getAttribute('value');
  }

  async setCommentTextInput(commentText) {
    await this.commentTextInput.sendKeys(commentText);
  }

  async getCommentTextInput() {
    return await this.commentTextInput.getAttribute('value');
  }

  async setNameColValNameInput(nameColValName) {
    await this.nameColValNameInput.sendKeys(nameColValName);
  }

  async getNameColValNameInput() {
    return await this.nameColValNameInput.getAttribute('value');
  }

  async setCreateDateInput(createDate) {
    await this.createDateInput.sendKeys(createDate);
  }

  async getCreateDateInput() {
    return await this.createDateInput.getAttribute('value');
  }

  async setCreateUserIdInput(createUserId) {
    await this.createUserIdInput.sendKeys(createUserId);
  }

  async getCreateUserIdInput() {
    return await this.createUserIdInput.getAttribute('value');
  }

  async setUpdDateInput(updDate) {
    await this.updDateInput.sendKeys(updDate);
  }

  async getUpdDateInput() {
    return await this.updDateInput.getAttribute('value');
  }

  async setUpdUserIdInput(updUserId) {
    await this.updUserIdInput.sendKeys(updUserId);
  }

  async getUpdUserIdInput() {
    return await this.updUserIdInput.getAttribute('value');
  }

  async save(timeout?: number) {
    await this.saveButton.click();
  }

  async cancel(timeout?: number) {
    await this.cancelButton.click();
  }

  getSaveButton(): ElementFinder {
    return this.saveButton;
  }
}

export class CMFCodesValuesDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-cMFCodesValues-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-cMFCodesValues'));

  async getDialogTitle() {
    return this.dialogTitle.getText();
  }

  async clickOnConfirmButton(timeout?: number) {
    await this.confirmButton.click();
  }
}
