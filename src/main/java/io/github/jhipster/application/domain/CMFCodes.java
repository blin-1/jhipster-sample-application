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
 * A CMFCodes.
 */
@Entity
@Table(name = "cmf_codes")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CMFCodes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "code_table_key", precision = 21, scale = 2, nullable = false)
    private BigDecimal codeTableKey;

    @NotNull
    @Size(max = 128)
    @Column(name = "code_enty_name", length = 128, nullable = false)
    private String codeEntyName;

    @NotNull
    @Size(max = 800)
    @Column(name = "code_enty_definition_text", length = 800, nullable = false)
    private String codeEntyDefinitionText;

    @NotNull
    @Size(max = 64)
    @Column(name = "code_table_name", length = 64, nullable = false)
    private String codeTableName;

    @NotNull
    @Size(max = 128)
    @Column(name = "code_attrb_name", length = 128, nullable = false)
    private String codeAttrbName;

    @NotNull
    @Size(max = 128)
    @Column(name = "desc_attrb_name", length = 128, nullable = false)
    private String descAttrbName;

    @NotNull
    @Size(max = 64)
    @Column(name = "code_col_name", length = 64, nullable = false)
    private String codeColName;

    @NotNull
    @Size(max = 64)
    @Column(name = "desc_col_name", length = 64, nullable = false)
    private String descColName;

    @NotNull
    @Size(max = 800)
    @Column(name = "comment_text", length = 800, nullable = false)
    private String commentText;

    @NotNull
    @Size(max = 128)
    @Column(name = "name_attrb_name", length = 128, nullable = false)
    private String nameAttrbName;

    @NotNull
    @Size(max = 30)
    @Column(name = "name_col_name", length = 30, nullable = false)
    private String nameColName;

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

    public BigDecimal getCodeTableKey() {
        return codeTableKey;
    }

    public CMFCodes codeTableKey(BigDecimal codeTableKey) {
        this.codeTableKey = codeTableKey;
        return this;
    }

    public void setCodeTableKey(BigDecimal codeTableKey) {
        this.codeTableKey = codeTableKey;
    }

    public String getCodeEntyName() {
        return codeEntyName;
    }

    public CMFCodes codeEntyName(String codeEntyName) {
        this.codeEntyName = codeEntyName;
        return this;
    }

    public void setCodeEntyName(String codeEntyName) {
        this.codeEntyName = codeEntyName;
    }

    public String getCodeEntyDefinitionText() {
        return codeEntyDefinitionText;
    }

    public CMFCodes codeEntyDefinitionText(String codeEntyDefinitionText) {
        this.codeEntyDefinitionText = codeEntyDefinitionText;
        return this;
    }

    public void setCodeEntyDefinitionText(String codeEntyDefinitionText) {
        this.codeEntyDefinitionText = codeEntyDefinitionText;
    }

    public String getCodeTableName() {
        return codeTableName;
    }

    public CMFCodes codeTableName(String codeTableName) {
        this.codeTableName = codeTableName;
        return this;
    }

    public void setCodeTableName(String codeTableName) {
        this.codeTableName = codeTableName;
    }

    public String getCodeAttrbName() {
        return codeAttrbName;
    }

    public CMFCodes codeAttrbName(String codeAttrbName) {
        this.codeAttrbName = codeAttrbName;
        return this;
    }

    public void setCodeAttrbName(String codeAttrbName) {
        this.codeAttrbName = codeAttrbName;
    }

    public String getDescAttrbName() {
        return descAttrbName;
    }

    public CMFCodes descAttrbName(String descAttrbName) {
        this.descAttrbName = descAttrbName;
        return this;
    }

    public void setDescAttrbName(String descAttrbName) {
        this.descAttrbName = descAttrbName;
    }

    public String getCodeColName() {
        return codeColName;
    }

    public CMFCodes codeColName(String codeColName) {
        this.codeColName = codeColName;
        return this;
    }

    public void setCodeColName(String codeColName) {
        this.codeColName = codeColName;
    }

    public String getDescColName() {
        return descColName;
    }

    public CMFCodes descColName(String descColName) {
        this.descColName = descColName;
        return this;
    }

    public void setDescColName(String descColName) {
        this.descColName = descColName;
    }

    public String getCommentText() {
        return commentText;
    }

    public CMFCodes commentText(String commentText) {
        this.commentText = commentText;
        return this;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getNameAttrbName() {
        return nameAttrbName;
    }

    public CMFCodes nameAttrbName(String nameAttrbName) {
        this.nameAttrbName = nameAttrbName;
        return this;
    }

    public void setNameAttrbName(String nameAttrbName) {
        this.nameAttrbName = nameAttrbName;
    }

    public String getNameColName() {
        return nameColName;
    }

    public CMFCodes nameColName(String nameColName) {
        this.nameColName = nameColName;
        return this;
    }

    public void setNameColName(String nameColName) {
        this.nameColName = nameColName;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public CMFCodes createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public CMFCodes createUserId(String createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Instant getUpdDate() {
        return updDate;
    }

    public CMFCodes updDate(Instant updDate) {
        this.updDate = updDate;
        return this;
    }

    public void setUpdDate(Instant updDate) {
        this.updDate = updDate;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public CMFCodes updUserId(String updUserId) {
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
        if (!(o instanceof CMFCodes)) {
            return false;
        }
        return id != null && id.equals(((CMFCodes) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CMFCodes{" +
            "id=" + getId() +
            ", codeTableKey=" + getCodeTableKey() +
            ", codeEntyName='" + getCodeEntyName() + "'" +
            ", codeEntyDefinitionText='" + getCodeEntyDefinitionText() + "'" +
            ", codeTableName='" + getCodeTableName() + "'" +
            ", codeAttrbName='" + getCodeAttrbName() + "'" +
            ", descAttrbName='" + getDescAttrbName() + "'" +
            ", codeColName='" + getCodeColName() + "'" +
            ", descColName='" + getDescColName() + "'" +
            ", commentText='" + getCommentText() + "'" +
            ", nameAttrbName='" + getNameAttrbName() + "'" +
            ", nameColName='" + getNameColName() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUserId='" + getCreateUserId() + "'" +
            ", updDate='" + getUpdDate() + "'" +
            ", updUserId='" + getUpdUserId() + "'" +
            "}";
    }
}
