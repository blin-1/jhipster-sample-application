import { browser, ExpectedConditions, element, by, ElementFinder } from 'protractor';

export class CMFCodesComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-cmf-codes div table .btn-danger'));
  title = element.all(by.css('jhi-cmf-codes div h2#page-heading span')).first();

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

export class CMFCodesUpdatePage {
  pageTitle = element(by.id('jhi-cmf-codes-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));
  codeTableKeyInput = element(by.id('field_codeTableKey'));
  codeEntyNameInput = element(by.id('field_codeEntyName'));
  codeEntyDefinitionTextInput = element(by.id('field_codeEntyDefinitionText'));
  codeTableNameInput = element(by.id('field_codeTableName'));
  codeAttrbNameInput = element(by.id('field_codeAttrbName'));
  descAttrbNameInput = element(by.id('field_descAttrbName'));
  codeColNameInput = element(by.id('field_codeColName'));
  descColNameInput = element(by.id('field_descColName'));
  commentTextInput = element(by.id('field_commentText'));
  nameAttrbNameInput = element(by.id('field_nameAttrbName'));
  nameColNameInput = element(by.id('field_nameColName'));
  createDateInput = element(by.id('field_createDate'));
  createUserIdInput = element(by.id('field_createUserId'));
  updDateInput = element(by.id('field_updDate'));
  updUserIdInput = element(by.id('field_updUserId'));

  async getPageTitle() {
    return this.pageTitle.getText();
  }

  async setCodeTableKeyInput(codeTableKey) {
    await this.codeTableKeyInput.sendKeys(codeTableKey);
  }

  async getCodeTableKeyInput() {
    return await this.codeTableKeyInput.getAttribute('value');
  }

  async setCodeEntyNameInput(codeEntyName) {
    await this.codeEntyNameInput.sendKeys(codeEntyName);
  }

  async getCodeEntyNameInput() {
    return await this.codeEntyNameInput.getAttribute('value');
  }

  async setCodeEntyDefinitionTextInput(codeEntyDefinitionText) {
    await this.codeEntyDefinitionTextInput.sendKeys(codeEntyDefinitionText);
  }

  async getCodeEntyDefinitionTextInput() {
    return await this.codeEntyDefinitionTextInput.getAttribute('value');
  }

  async setCodeTableNameInput(codeTableName) {
    await this.codeTableNameInput.sendKeys(codeTableName);
  }

  async getCodeTableNameInput() {
    return await this.codeTableNameInput.getAttribute('value');
  }

  async setCodeAttrbNameInput(codeAttrbName) {
    await this.codeAttrbNameInput.sendKeys(codeAttrbName);
  }

  async getCodeAttrbNameInput() {
    return await this.codeAttrbNameInput.getAttribute('value');
  }

  async setDescAttrbNameInput(descAttrbName) {
    await this.descAttrbNameInput.sendKeys(descAttrbName);
  }

  async getDescAttrbNameInput() {
    return await this.descAttrbNameInput.getAttribute('value');
  }

  async setCodeColNameInput(codeColName) {
    await this.codeColNameInput.sendKeys(codeColName);
  }

  async getCodeColNameInput() {
    return await this.codeColNameInput.getAttribute('value');
  }

  async setDescColNameInput(descColName) {
    await this.descColNameInput.sendKeys(descColName);
  }

  async getDescColNameInput() {
    return await this.descColNameInput.getAttribute('value');
  }

  async setCommentTextInput(commentText) {
    await this.commentTextInput.sendKeys(commentText);
  }

  async getCommentTextInput() {
    return await this.commentTextInput.getAttribute('value');
  }

  async setNameAttrbNameInput(nameAttrbName) {
    await this.nameAttrbNameInput.sendKeys(nameAttrbName);
  }

  async getNameAttrbNameInput() {
    return await this.nameAttrbNameInput.getAttribute('value');
  }

  async setNameColNameInput(nameColName) {
    await this.nameColNameInput.sendKeys(nameColName);
  }

  async getNameColNameInput() {
    return await this.nameColNameInput.getAttribute('value');
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

export class CMFCodesDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-cMFCodes-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-cMFCodes'));

  async getDialogTitle() {
    return this.dialogTitle.getText();
  }

  async clickOnConfirmButton(timeout?: number) {
    await this.confirmButton.click();
  }
}
