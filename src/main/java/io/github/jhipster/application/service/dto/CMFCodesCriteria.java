package io.github.jhipster.application.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.BigDecimalFilter;
import io.github.jhipster.service.filter.InstantFilter;

/**
 * Criteria class for the {@link io.github.jhipster.application.domain.CMFCodes} entity. This class is used
 * in {@link io.github.jhipster.application.web.rest.CMFCodesResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cmf-codes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CMFCodesCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private BigDecimalFilter codeTableKey;

    private StringFilter codeEntyName;

    private StringFilter codeEntyDefinitionText;

    private StringFilter codeTableName;

    private StringFilter codeAttrbName;

    private StringFilter descAttrbName;

    private StringFilter codeColName;

    private StringFilter descColName;

    private StringFilter commentText;

    private StringFilter nameAttrbName;

    private StringFilter nameColName;

    private InstantFilter createDate;

    private StringFilter createUserId;

    private InstantFilter updDate;

    private StringFilter updUserId;

    public CMFCodesCriteria(){
    }

    public CMFCodesCriteria(CMFCodesCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.codeTableKey = other.codeTableKey == null ? null : other.codeTableKey.copy();
        this.codeEntyName = other.codeEntyName == null ? null : other.codeEntyName.copy();
        this.codeEntyDefinitionText = other.codeEntyDefinitionText == null ? null : other.codeEntyDefinitionText.copy();
        this.codeTableName = other.codeTableName == null ? null : other.codeTableName.copy();
        this.codeAttrbName = other.codeAttrbName == null ? null : other.codeAttrbName.copy();
        this.descAttrbName = other.descAttrbName == null ? null : other.descAttrbName.copy();
        this.codeColName = other.codeColName == null ? null : other.codeColName.copy();
        this.descColName = other.descColName == null ? null : other.descColName.copy();
        this.commentText = other.commentText == null ? null : other.commentText.copy();
        this.nameAttrbName = other.nameAttrbName == null ? null : other.nameAttrbName.copy();
        this.nameColName = other.nameColName == null ? null : other.nameColName.copy();
        this.createDate = other.createDate == null ? null : other.createDate.copy();
        this.createUserId = other.createUserId == null ? null : other.createUserId.copy();
        this.updDate = other.updDate == null ? null : other.updDate.copy();
        this.updUserId = other.updUserId == null ? null : other.updUserId.copy();
    }

    @Override
    public CMFCodesCriteria copy() {
        return new CMFCodesCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public BigDecimalFilter getCodeTableKey() {
        return codeTableKey;
    }

    public void setCodeTableKey(BigDecimalFilter codeTableKey) {
        this.codeTableKey = codeTableKey;
    }

    public StringFilter getCodeEntyName() {
        return codeEntyName;
    }

    public void setCodeEntyName(StringFilter codeEntyName) {
        this.codeEntyName = codeEntyName;
    }

    public StringFilter getCodeEntyDefinitionText() {
        return codeEntyDefinitionText;
    }

    public void setCodeEntyDefinitionText(StringFilter codeEntyDefinitionText) {
        this.codeEntyDefinitionText = codeEntyDefinitionText;
    }

    public StringFilter getCodeTableName() {
        return codeTableName;
    }

    public void setCodeTableName(StringFilter codeTableName) {
        this.codeTableName = codeTableName;
    }

    public StringFilter getCodeAttrbName() {
        return codeAttrbName;
    }

    public void setCodeAttrbName(StringFilter codeAttrbName) {
        this.codeAttrbName = codeAttrbName;
    }

    public StringFilter getDescAttrbName() {
        return descAttrbName;
    }

    public void setDescAttrbName(StringFilter descAttrbName) {
        this.descAttrbName = descAttrbName;
    }

    public StringFilter getCodeColName() {
        return codeColName;
    }

    public void setCodeColName(StringFilter codeColName) {
        this.codeColName = codeColName;
    }

    public StringFilter getDescColName() {
        return descColName;
    }

    public void setDescColName(StringFilter descColName) {
        this.descColName = descColName;
    }

    public StringFilter getCommentText() {
        return commentText;
    }

    public void setCommentText(StringFilter commentText) {
        this.commentText = commentText;
    }

    public StringFilter getNameAttrbName() {
        return nameAttrbName;
    }

    public void setNameAttrbName(StringFilter nameAttrbName) {
        this.nameAttrbName = nameAttrbName;
    }

    public StringFilter getNameColName() {
        return nameColName;
    }

    public void setNameColName(StringFilter nameColName) {
        this.nameColName = nameColName;
    }

    public InstantFilter getCreateDate() {
        return createDate;
    }

    public void setCreateDate(InstantFilter createDate) {
        this.createDate = createDate;
    }

    public StringFilter getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(StringFilter createUserId) {
        this.createUserId = createUserId;
    }

    public InstantFilter getUpdDate() {
        return updDate;
    }

    public void setUpdDate(InstantFilter updDate) {
        this.updDate = updDate;
    }

    public StringFilter getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(StringFilter updUserId) {
        this.updUserId = updUserId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CMFCodesCriteria that = (CMFCodesCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(codeTableKey, that.codeTableKey) &&
            Objects.equals(codeEntyName, that.codeEntyName) &&
            Objects.equals(codeEntyDefinitionText, that.codeEntyDefinitionText) &&
            Objects.equals(codeTableName, that.codeTableName) &&
            Objects.equals(codeAttrbName, that.codeAttrbName) &&
            Objects.equals(descAttrbName, that.descAttrbName) &&
            Objects.equals(codeColName, that.codeColName) &&
            Objects.equals(descColName, that.descColName) &&
            Objects.equals(commentText, that.commentText) &&
            Objects.equals(nameAttrbName, that.nameAttrbName) &&
            Objects.equals(nameColName, that.nameColName) &&
            Objects.equals(createDate, that.createDate) &&
            Objects.equals(createUserId, that.createUserId) &&
            Objects.equals(updDate, that.updDate) &&
            Objects.equals(updUserId, that.updUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        codeTableKey,
        codeEntyName,
        codeEntyDefinitionText,
        codeTableName,
        codeAttrbName,
        descAttrbName,
        codeColName,
        descColName,
        commentText,
        nameAttrbName,
        nameColName,
        createDate,
        createUserId,
        updDate,
        updUserId
        );
    }

    @Override
    public String toString() {
        return "CMFCodesCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (codeTableKey != null ? "codeTableKey=" + codeTableKey + ", " : "") +
                (codeEntyName != null ? "codeEntyName=" + codeEntyName + ", " : "") +
                (codeEntyDefinitionText != null ? "codeEntyDefinitionText=" + codeEntyDefinitionText + ", " : "") +
                (codeTableName != null ? "codeTableName=" + codeTableName + ", " : "") +
                (codeAttrbName != null ? "codeAttrbName=" + codeAttrbName + ", " : "") +
                (descAttrbName != null ? "descAttrbName=" + descAttrbName + ", " : "") +
                (codeColName != null ? "codeColName=" + codeColName + ", " : "") +
                (descColName != null ? "descColName=" + descColName + ", " : "") +
                (commentText != null ? "commentText=" + commentText + ", " : "") +
                (nameAttrbName != null ? "nameAttrbName=" + nameAttrbName + ", " : "") +
                (nameColName != null ? "nameColName=" + nameColName + ", " : "") +
                (createDate != null ? "createDate=" + createDate + ", " : "") +
                (createUserId != null ? "createUserId=" + createUserId + ", " : "") +
                (updDate != null ? "updDate=" + updDate + ", " : "") +
                (updUserId != null ? "updUserId=" + updUserId + ", " : "") +
            "}";
    }

}
