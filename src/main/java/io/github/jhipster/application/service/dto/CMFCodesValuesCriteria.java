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
 * Criteria class for the {@link io.github.jhipster.application.domain.CMFCodesValues} entity. This class is used
 * in {@link io.github.jhipster.application.web.rest.CMFCodesValuesResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cmf-codes-values?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CMFCodesValuesCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private BigDecimalFilter codeValKey;

    private BigDecimalFilter codeTableKey;

    private StringFilter codeClassfctnTypeCode;

    private StringFilter srcSysCode;

    private StringFilter lifecycleStatusCode;

    private StringFilter codeColValCode;

    private StringFilter descColValText;

    private InstantFilter effDate;

    private InstantFilter endDate;

    private StringFilter commentText;

    private StringFilter nameColValName;

    private InstantFilter createDate;

    private StringFilter createUserId;

    private InstantFilter updDate;

    private StringFilter updUserId;

    public CMFCodesValuesCriteria(){
    }

    public CMFCodesValuesCriteria(CMFCodesValuesCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.codeValKey = other.codeValKey == null ? null : other.codeValKey.copy();
        this.codeTableKey = other.codeTableKey == null ? null : other.codeTableKey.copy();
        this.codeClassfctnTypeCode = other.codeClassfctnTypeCode == null ? null : other.codeClassfctnTypeCode.copy();
        this.srcSysCode = other.srcSysCode == null ? null : other.srcSysCode.copy();
        this.lifecycleStatusCode = other.lifecycleStatusCode == null ? null : other.lifecycleStatusCode.copy();
        this.codeColValCode = other.codeColValCode == null ? null : other.codeColValCode.copy();
        this.descColValText = other.descColValText == null ? null : other.descColValText.copy();
        this.effDate = other.effDate == null ? null : other.effDate.copy();
        this.endDate = other.endDate == null ? null : other.endDate.copy();
        this.commentText = other.commentText == null ? null : other.commentText.copy();
        this.nameColValName = other.nameColValName == null ? null : other.nameColValName.copy();
        this.createDate = other.createDate == null ? null : other.createDate.copy();
        this.createUserId = other.createUserId == null ? null : other.createUserId.copy();
        this.updDate = other.updDate == null ? null : other.updDate.copy();
        this.updUserId = other.updUserId == null ? null : other.updUserId.copy();
    }

    @Override
    public CMFCodesValuesCriteria copy() {
        return new CMFCodesValuesCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public BigDecimalFilter getCodeValKey() {
        return codeValKey;
    }

    public void setCodeValKey(BigDecimalFilter codeValKey) {
        this.codeValKey = codeValKey;
    }

    public BigDecimalFilter getCodeTableKey() {
        return codeTableKey;
    }

    public void setCodeTableKey(BigDecimalFilter codeTableKey) {
        this.codeTableKey = codeTableKey;
    }

    public StringFilter getCodeClassfctnTypeCode() {
        return codeClassfctnTypeCode;
    }

    public void setCodeClassfctnTypeCode(StringFilter codeClassfctnTypeCode) {
        this.codeClassfctnTypeCode = codeClassfctnTypeCode;
    }

    public StringFilter getSrcSysCode() {
        return srcSysCode;
    }

    public void setSrcSysCode(StringFilter srcSysCode) {
        this.srcSysCode = srcSysCode;
    }

    public StringFilter getLifecycleStatusCode() {
        return lifecycleStatusCode;
    }

    public void setLifecycleStatusCode(StringFilter lifecycleStatusCode) {
        this.lifecycleStatusCode = lifecycleStatusCode;
    }

    public StringFilter getCodeColValCode() {
        return codeColValCode;
    }

    public void setCodeColValCode(StringFilter codeColValCode) {
        this.codeColValCode = codeColValCode;
    }

    public StringFilter getDescColValText() {
        return descColValText;
    }

    public void setDescColValText(StringFilter descColValText) {
        this.descColValText = descColValText;
    }

    public InstantFilter getEffDate() {
        return effDate;
    }

    public void setEffDate(InstantFilter effDate) {
        this.effDate = effDate;
    }

    public InstantFilter getEndDate() {
        return endDate;
    }

    public void setEndDate(InstantFilter endDate) {
        this.endDate = endDate;
    }

    public StringFilter getCommentText() {
        return commentText;
    }

    public void setCommentText(StringFilter commentText) {
        this.commentText = commentText;
    }

    public StringFilter getNameColValName() {
        return nameColValName;
    }

    public void setNameColValName(StringFilter nameColValName) {
        this.nameColValName = nameColValName;
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
        final CMFCodesValuesCriteria that = (CMFCodesValuesCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(codeValKey, that.codeValKey) &&
            Objects.equals(codeTableKey, that.codeTableKey) &&
            Objects.equals(codeClassfctnTypeCode, that.codeClassfctnTypeCode) &&
            Objects.equals(srcSysCode, that.srcSysCode) &&
            Objects.equals(lifecycleStatusCode, that.lifecycleStatusCode) &&
            Objects.equals(codeColValCode, that.codeColValCode) &&
            Objects.equals(descColValText, that.descColValText) &&
            Objects.equals(effDate, that.effDate) &&
            Objects.equals(endDate, that.endDate) &&
            Objects.equals(commentText, that.commentText) &&
            Objects.equals(nameColValName, that.nameColValName) &&
            Objects.equals(createDate, that.createDate) &&
            Objects.equals(createUserId, that.createUserId) &&
            Objects.equals(updDate, that.updDate) &&
            Objects.equals(updUserId, that.updUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        codeValKey,
        codeTableKey,
        codeClassfctnTypeCode,
        srcSysCode,
        lifecycleStatusCode,
        codeColValCode,
        descColValText,
        effDate,
        endDate,
        commentText,
        nameColValName,
        createDate,
        createUserId,
        updDate,
        updUserId
        );
    }

    @Override
    public String toString() {
        return "CMFCodesValuesCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (codeValKey != null ? "codeValKey=" + codeValKey + ", " : "") +
                (codeTableKey != null ? "codeTableKey=" + codeTableKey + ", " : "") +
                (codeClassfctnTypeCode != null ? "codeClassfctnTypeCode=" + codeClassfctnTypeCode + ", " : "") +
                (srcSysCode != null ? "srcSysCode=" + srcSysCode + ", " : "") +
                (lifecycleStatusCode != null ? "lifecycleStatusCode=" + lifecycleStatusCode + ", " : "") +
                (codeColValCode != null ? "codeColValCode=" + codeColValCode + ", " : "") +
                (descColValText != null ? "descColValText=" + descColValText + ", " : "") +
                (effDate != null ? "effDate=" + effDate + ", " : "") +
                (endDate != null ? "endDate=" + endDate + ", " : "") +
                (commentText != null ? "commentText=" + commentText + ", " : "") +
                (nameColValName != null ? "nameColValName=" + nameColValName + ", " : "") +
                (createDate != null ? "createDate=" + createDate + ", " : "") +
                (createUserId != null ? "createUserId=" + createUserId + ", " : "") +
                (updDate != null ? "updDate=" + updDate + ", " : "") +
                (updUserId != null ? "updUserId=" + updUserId + ", " : "") +
            "}";
    }

}
