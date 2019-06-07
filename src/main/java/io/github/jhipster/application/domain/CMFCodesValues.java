package io.github.jhipster.application.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A CMFCodesValues.
 */
@Entity
@Table(name = "cmf_codes_values")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CMFCodesValues implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "code_val_key", precision = 21, scale = 2, nullable = false)
    private BigDecimal codeValKey;

    @NotNull
    @Column(name = "code_table_key", precision = 21, scale = 2, nullable = false)
    private BigDecimal codeTableKey;

    @NotNull
    @Size(max = 20)
    @Column(name = "code_classfctn_type_code", length = 20, nullable = false)
    private String codeClassfctnTypeCode;

    @NotNull
    @Size(max = 20)
    @Column(name = "src_sys_code", length = 20, nullable = false)
    private String srcSysCode;

    @NotNull
    @Size(max = 20)
    @Column(name = "lifecycle_status_code", length = 20, nullable = false)
    private String lifecycleStatusCode;

    @Size(max = 256)
    @Column(name = "code_col_val_code", length = 256)
    private String codeColValCode;

    @Size(max = 800)
    @Column(name = "desc_col_val_text", length = 800)
    private String descColValText;

    @Column(name = "eff_date")
    private Instant effDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Size(max = 800)
    @Column(name = "comment_text", length = 800)
    private String commentText;

    @Size(max = 512)
    @Column(name = "name_col_val_name", length = 512)
    private String nameColValName;

    @Column(name = "create_date")
    private Instant createDate;

    @NotNull
    @Size(max = 20)
    @Column(name = "create_user_id", length = 20, nullable = false)
    private String createUserId;

    @Column(name = "upd_date")
    private Instant updDate;

    @NotNull
    @Size(max = 20)
    @Column(name = "upd_user_id", length = 20, nullable = false)
    private String updUserId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCodeValKey() {
        return codeValKey;
    }

    public CMFCodesValues codeValKey(BigDecimal codeValKey) {
        this.codeValKey = codeValKey;
        return this;
    }

    public void setCodeValKey(BigDecimal codeValKey) {
        this.codeValKey = codeValKey;
    }

    public BigDecimal getCodeTableKey() {
        return codeTableKey;
    }

    public CMFCodesValues codeTableKey(BigDecimal codeTableKey) {
        this.codeTableKey = codeTableKey;
        return this;
    }

    public void setCodeTableKey(BigDecimal codeTableKey) {
        this.codeTableKey = codeTableKey;
    }

    public String getCodeClassfctnTypeCode() {
        return codeClassfctnTypeCode;
    }

    public CMFCodesValues codeClassfctnTypeCode(String codeClassfctnTypeCode) {
        this.codeClassfctnTypeCode = codeClassfctnTypeCode;
        return this;
    }

    public void setCodeClassfctnTypeCode(String codeClassfctnTypeCode) {
        this.codeClassfctnTypeCode = codeClassfctnTypeCode;
    }

    public String getSrcSysCode() {
        return srcSysCode;
    }

    public CMFCodesValues srcSysCode(String srcSysCode) {
        this.srcSysCode = srcSysCode;
        return this;
    }

    public void setSrcSysCode(String srcSysCode) {
        this.srcSysCode = srcSysCode;
    }

    public String getLifecycleStatusCode() {
        return lifecycleStatusCode;
    }

    public CMFCodesValues lifecycleStatusCode(String lifecycleStatusCode) {
        this.lifecycleStatusCode = lifecycleStatusCode;
        return this;
    }

    public void setLifecycleStatusCode(String lifecycleStatusCode) {
        this.lifecycleStatusCode = lifecycleStatusCode;
    }

    public String getCodeColValCode() {
        return codeColValCode;
    }

    public CMFCodesValues codeColValCode(String codeColValCode) {
        this.codeColValCode = codeColValCode;
        return this;
    }

    public void setCodeColValCode(String codeColValCode) {
        this.codeColValCode = codeColValCode;
    }

    public String getDescColValText() {
        return descColValText;
    }

    public CMFCodesValues descColValText(String descColValText) {
        this.descColValText = descColValText;
        return this;
    }

    public void setDescColValText(String descColValText) {
        this.descColValText = descColValText;
    }

    public Instant getEffDate() {
        return effDate;
    }

    public CMFCodesValues effDate(Instant effDate) {
        this.effDate = effDate;
        return this;
    }

    public void setEffDate(Instant effDate) {
        this.effDate = effDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public CMFCodesValues endDate(Instant endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public CMFCodesValues commentText(String commentText) {
        this.commentText = commentText;
        return this;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getNameColValName() {
        return nameColValName;
    }

    public CMFCodesValues nameColValName(String nameColValName) {
        this.nameColValName = nameColValName;
        return this;
    }

    public void setNameColValName(String nameColValName) {
        this.nameColValName = nameColValName;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public CMFCodesValues createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public CMFCodesValues createUserId(String createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Instant getUpdDate() {
        return updDate;
    }

    public CMFCodesValues updDate(Instant updDate) {
        this.updDate = updDate;
        return this;
    }

    public void setUpdDate(Instant updDate) {
        this.updDate = updDate;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public CMFCodesValues updUserId(String updUserId) {
        this.updUserId = updUserId;
        return this;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CMFCodesValues)) {
            return false;
        }
        return id != null && id.equals(((CMFCodesValues) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CMFCodesValues{" +
            "id=" + getId() +
            ", codeValKey=" + getCodeValKey() +
            ", codeTableKey=" + getCodeTableKey() +
            ", codeClassfctnTypeCode='" + getCodeClassfctnTypeCode() + "'" +
            ", srcSysCode='" + getSrcSysCode() + "'" +
            ", lifecycleStatusCode='" + getLifecycleStatusCode() + "'" +
            ", codeColValCode='" + getCodeColValCode() + "'" +
            ", descColValText='" + getDescColValText() + "'" +
            ", effDate='" + getEffDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", commentText='" + getCommentText() + "'" +
            ", nameColValName='" + getNameColValName() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUserId='" + getCreateUserId() + "'" +
            ", updDate='" + getUpdDate() + "'" +
            ", updUserId='" + getUpdUserId() + "'" +
            "}";
    }
}
