import { browser, ExpectedConditions, element, by, ElementFinder } from 'protractor';

export class CMFCodesMapComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-cmf-codes-map div table .btn-danger'));
  title = element.all(by.css('jhi-cmf-codes-map div h2#page-heading span')).first();

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

export class CMFCodesMapUpdatePage {
  pageTitle = element(by.id('jhi-cmf-codes-map-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));
  codeValKeyInput = element(by.id('field_codeValKey'));
  codeValRltdKeyInput = element(by.id('field_codeValRltdKey'));
  mapTypeCodeInput = element(by.id('field_mapTypeCode'));
  effDateInput = element(by.id('field_effDate'));
  endDateInput = element(by.id('field_endDate'));
  commentTextInput = element(by.id('field_commentText'));
  createDateInput = element(by.id('field_createDate'));
  createUserIdInput = element(by.id('field_createUserId'));
  updDateInput = element(by.id('field_updDate'));
  updUserIdInput = element(by.id('field_updUserId'));
  cMFCodeValuesSelect = element(by.id('field_cMFCodeValues'));
  cMFCodeValuesRltdSelect = element(by.id('field_cMFCodeValuesRltd'));

  async getPageTitle() {
    return this.pageTitle.getText();
  }

  async setCodeValKeyInput(codeValKey) {
    await this.codeValKeyInput.sendKeys(codeValKey);
  }

  async getCodeValKeyInput() {
    return await this.codeValKeyInput.getAttribute('value');
  }

  async setCodeValRltdKeyInput(codeValRltdKey) {
    await this.codeValRltdKeyInput.sendKeys(codeValRltdKey);
  }

  async getCodeValRltdKeyInput() {
    return await this.codeValRltdKeyInput.getAttribute('value');
  }

  async setMapTypeCodeInput(mapTypeCode) {
    await this.mapTypeCodeInput.sendKeys(mapTypeCode);
  }

  async getMapTypeCodeInput() {
    return await this.mapTypeCodeInput.getAttribute('value');
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

  async cMFCodeValuesSelectLastOption(timeout?: number) {
    await this.cMFCodeValuesSelect
      .all(by.tagName('option'))
      .last()
      .click();
  }

  async cMFCodeValuesSelectOption(option) {
    await this.cMFCodeValuesSelect.sendKeys(option);
  }

  getCMFCodeValuesSelect(): ElementFinder {
    return this.cMFCodeValuesSelect;
  }

  async getCMFCodeValuesSelectedOption() {
    return await this.cMFCodeValuesSelect.element(by.css('option:checked')).getText();
  }

  async cMFCodeValuesRltdSelectLastOption(timeout?: number) {
    await this.cMFCodeValuesRltdSelect
      .all(by.tagName('option'))
      .last()
      .click();
  }

  async cMFCodeValuesRltdSelectOption(option) {
    await this.cMFCodeValuesRltdSelect.sendKeys(option);
  }

  getCMFCodeValuesRltdSelect(): ElementFinder {
    return this.cMFCodeValuesRltdSelect;
  }

  async getCMFCodeValuesRltdSelectedOption() {
    return await this.cMFCodeValuesRltdSelect.element(by.css('option:checked')).getText();
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

export class CMFCodesMapDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-cMFCodesMap-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-cMFCodesMap'));

  async getDialogTitle() {
    return this.dialogTitle.getText();
  }

  async clickOnConfirmButton(timeout?: number) {
    await this.confirmButton.click();
  }
}
