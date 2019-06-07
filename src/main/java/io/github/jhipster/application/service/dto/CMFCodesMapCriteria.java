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
 * Criteria class for the {@link io.github.jhipster.application.domain.CMFCodesMap} entity. This class is used
 * in {@link io.github.jhipster.application.web.rest.CMFCodesMapResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cmf-codes-maps?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CMFCodesMapCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private BigDecimalFilter codeValKey;

    private BigDecimalFilter codeValRltdKey;

    private StringFilter mapTypeCode;

    private InstantFilter effDate;

    private InstantFilter endDate;

    private StringFilter commentText;

    private InstantFilter createDate;

    private StringFilter createUserId;

    private InstantFilter updDate;

    private StringFilter updUserId;

    private LongFilter cMFCodeValuesId;

    private LongFilter cMFCodeValuesRltdId;

    public CMFCodesMapCriteria(){
    }

    public CMFCodesMapCriteria(CMFCodesMapCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.codeValKey = other.codeValKey == null ? null : other.codeValKey.copy();
        this.codeValRltdKey = other.codeValRltdKey == null ? null : other.codeValRltdKey.copy();
        this.mapTypeCode = other.mapTypeCode == null ? null : other.mapTypeCode.copy();
        this.effDate = other.effDate == null ? null : other.effDate.copy();
        this.endDate = other.endDate == null ? null : other.endDate.copy();
        this.commentText = other.commentText == null ? null : other.commentText.copy();
        this.createDate = other.createDate == null ? null : other.createDate.copy();
        this.createUserId = other.createUserId == null ? null : other.createUserId.copy();
        this.updDate = other.updDate == null ? null : other.updDate.copy();
        this.updUserId = other.updUserId == null ? null : other.updUserId.copy();
        this.cMFCodeValuesId = other.cMFCodeValuesId == null ? null : other.cMFCodeValuesId.copy();
        this.cMFCodeValuesRltdId = other.cMFCodeValuesRltdId == null ? null : other.cMFCodeValuesRltdId.copy();
    }

    @Override
    public CMFCodesMapCriteria copy() {
        return new CMFCodesMapCriteria(this);
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

    public BigDecimalFilter getCodeValRltdKey() {
        return codeValRltdKey;
    }

    public void setCodeValRltdKey(BigDecimalFilter codeValRltdKey) {
        this.codeValRltdKey = codeValRltdKey;
    }

    public StringFilter getMapTypeCode() {
        return mapTypeCode;
    }

    public void setMapTypeCode(StringFilter mapTypeCode) {
        this.mapTypeCode = mapTypeCode;
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

    public LongFilter getCMFCodeValuesId() {
        return cMFCodeValuesId;
    }

    public void setCMFCodeValuesId(LongFilter cMFCodeValuesId) {
        this.cMFCodeValuesId = cMFCodeValuesId;
    }

    public LongFilter getCMFCodeValuesRltdId() {
        return cMFCodeValuesRltdId;
    }

    public void setCMFCodeValuesRltdId(LongFilter cMFCodeValuesRltdId) {
        this.cMFCodeValuesRltdId = cMFCodeValuesRltdId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CMFCodesMapCriteria that = (CMFCodesMapCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(codeValKey, that.codeValKey) &&
            Objects.equals(codeValRltdKey, that.codeValRltdKey) &&
            Objects.equals(mapTypeCode, that.mapTypeCode) &&
            Objects.equals(effDate, that.effDate) &&
            Objects.equals(endDate, that.endDate) &&
            Objects.equals(commentText, that.commentText) &&
            Objects.equals(createDate, that.createDate) &&
            Objects.equals(createUserId, that.createUserId) &&
            Objects.equals(updDate, that.updDate) &&
            Objects.equals(updUserId, that.updUserId) &&
            Objects.equals(cMFCodeValuesId, that.cMFCodeValuesId) &&
            Objects.equals(cMFCodeValuesRltdId, that.cMFCodeValuesRltdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        codeValKey,
        codeValRltdKey,
        mapTypeCode,
        effDate,
        endDate,
        commentText,
        createDate,
        createUserId,
        updDate,
        updUserId,
        cMFCodeValuesId,
        cMFCodeValuesRltdId
        );
    }

    @Override
    public String toString() {
        return "CMFCodesMapCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (codeValKey != null ? "codeValKey=" + codeValKey + ", " : "") +
                (codeValRltdKey != null ? "codeValRltdKey=" + codeValRltdKey + ", " : "") +
                (mapTypeCode != null ? "mapTypeCode=" + mapTypeCode + ", " : "") +
                (effDate != null ? "effDate=" + effDate + ", " : "") +
                (endDate != null ? "endDate=" + endDate + ", " : "") +
                (commentText != null ? "commentText=" + commentText + ", " : "") +
                (createDate != null ? "createDate=" + createDate + ", " : "") +
                (createUserId != null ? "createUserId=" + createUserId + ", " : "") +
                (updDate != null ? "updDate=" + updDate + ", " : "") +
                (updUserId != null ? "updUserId=" + updUserId + ", " : "") +
                (cMFCodeValuesId != null ? "cMFCodeValuesId=" + cMFCodeValuesId + ", " : "") +
                (cMFCodeValuesRltdId != null ? "cMFCodeValuesRltdId=" + cMFCodeValuesRltdId + ", " : "") +
            "}";
    }

}
