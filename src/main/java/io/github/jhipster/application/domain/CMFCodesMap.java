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
 * A CMFCodesMap.
 */
@Entity
@Table(name = "cmf_codes_map")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CMFCodesMap implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "code_val_key", precision = 21, scale = 2, nullable = false)
    private BigDecimal codeValKey;

    @NotNull
    @Column(name = "code_val_rltd_key", precision = 21, scale = 2, nullable = false)
    private BigDecimal codeValRltdKey;

    @NotNull
    @Size(max = 20)
    @Column(name = "map_type_code", length = 20, nullable = false)
    private String mapTypeCode;

    @Column(name = "eff_date")
    private Instant effDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Size(max = 800)
    @Column(name = "comment_text", length = 800)
    private String commentText;

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

    @OneToOne
    @JoinColumn(unique = true)
    private CMFCodesValues cMFCodeValues;

    @OneToOne
    @JoinColumn(unique = true)
    private CMFCodesValues cMFCodeValuesRltd;

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

    public CMFCodesMap codeValKey(BigDecimal codeValKey) {
        this.codeValKey = codeValKey;
        return this;
    }

    public void setCodeValKey(BigDecimal codeValKey) {
        this.codeValKey = codeValKey;
    }

    public BigDecimal getCodeValRltdKey() {
        return codeValRltdKey;
    }

    public CMFCodesMap codeValRltdKey(BigDecimal codeValRltdKey) {
        this.codeValRltdKey = codeValRltdKey;
        return this;
    }

    public void setCodeValRltdKey(BigDecimal codeValRltdKey) {
        this.codeValRltdKey = codeValRltdKey;
    }

    public String getMapTypeCode() {
        return mapTypeCode;
    }

    public CMFCodesMap mapTypeCode(String mapTypeCode) {
        this.mapTypeCode = mapTypeCode;
        return this;
    }

    public void setMapTypeCode(String mapTypeCode) {
        this.mapTypeCode = mapTypeCode;
    }

    public Instant getEffDate() {
        return effDate;
    }

    public CMFCodesMap effDate(Instant effDate) {
        this.effDate = effDate;
        return this;
    }

    public void setEffDate(Instant effDate) {
        this.effDate = effDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public CMFCodesMap endDate(Instant endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public CMFCodesMap commentText(String commentText) {
        this.commentText = commentText;
        return this;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public CMFCodesMap createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public CMFCodesMap createUserId(String createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Instant getUpdDate() {
        return updDate;
    }

    public CMFCodesMap updDate(Instant updDate) {
        this.updDate = updDate;
        return this;
    }

    public void setUpdDate(Instant updDate) {
        this.updDate = updDate;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public CMFCodesMap updUserId(String updUserId) {
        this.updUserId = updUserId;
        return this;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }

    public CMFCodesValues getCMFCodeValues() {
        return cMFCodeValues;
    }

    public CMFCodesMap cMFCodeValues(CMFCodesValues cMFCodesValues) {
        this.cMFCodeValues = cMFCodesValues;
        return this;
    }

    public void setCMFCodeValues(CMFCodesValues cMFCodesValues) {
        this.cMFCodeValues = cMFCodesValues;
    }

    public CMFCodesValues getCMFCodeValuesRltd() {
        return cMFCodeValuesRltd;
    }

    public CMFCodesMap cMFCodeValuesRltd(CMFCodesValues cMFCodesValues) {
        this.cMFCodeValuesRltd = cMFCodesValues;
        return this;
    }

    public void setCMFCodeValuesRltd(CMFCodesValues cMFCodesValues) {
        this.cMFCodeValuesRltd = cMFCodesValues;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CMFCodesMap)) {
            return false;
        }
        return id != null && id.equals(((CMFCodesMap) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CMFCodesMap{" +
            "id=" + getId() +
            ", codeValKey=" + getCodeValKey() +
            ", codeValRltdKey=" + getCodeValRltdKey() +
            ", mapTypeCode='" + getMapTypeCode() + "'" +
            ", effDate='" + getEffDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", commentText='" + getCommentText() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUserId='" + getCreateUserId() + "'" +
            ", updDate='" + getUpdDate() + "'" +
            ", updUserId='" + getUpdUserId() + "'" +
            "}";
    }
}
