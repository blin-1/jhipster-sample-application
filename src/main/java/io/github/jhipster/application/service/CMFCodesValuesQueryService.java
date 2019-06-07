package io.github.jhipster.application.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import io.github.jhipster.application.domain.CMFCodesValues;
import io.github.jhipster.application.domain.*; // for static metamodels
import io.github.jhipster.application.repository.CMFCodesValuesRepository;
import io.github.jhipster.application.service.dto.CMFCodesValuesCriteria;

/**
 * Service for executing complex queries for {@link CMFCodesValues} entities in the database.
 * The main input is a {@link CMFCodesValuesCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CMFCodesValues} or a {@link Page} of {@link CMFCodesValues} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CMFCodesValuesQueryService extends QueryService<CMFCodesValues> {

    private final Logger log = LoggerFactory.getLogger(CMFCodesValuesQueryService.class);

    private final CMFCodesValuesRepository cMFCodesValuesRepository;

    public CMFCodesValuesQueryService(CMFCodesValuesRepository cMFCodesValuesRepository) {
        this.cMFCodesValuesRepository = cMFCodesValuesRepository;
    }

    /**
     * Return a {@link List} of {@link CMFCodesValues} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CMFCodesValues> findByCriteria(CMFCodesValuesCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CMFCodesValues> specification = createSpecification(criteria);
        return cMFCodesValuesRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link CMFCodesValues} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CMFCodesValues> findByCriteria(CMFCodesValuesCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CMFCodesValues> specification = createSpecification(criteria);
        return cMFCodesValuesRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CMFCodesValuesCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CMFCodesValues> specification = createSpecification(criteria);
        return cMFCodesValuesRepository.count(specification);
    }

    /**
     * Function to convert CMFCodesValuesCriteria to a {@link Specification}.
     */
    private Specification<CMFCodesValues> createSpecification(CMFCodesValuesCriteria criteria) {
        Specification<CMFCodesValues> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), CMFCodesValues_.id));
            }
            if (criteria.getCodeValKey() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCodeValKey(), CMFCodesValues_.codeValKey));
            }
            if (criteria.getCodeTableKey() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCodeTableKey(), CMFCodesValues_.codeTableKey));
            }
            if (criteria.getCodeClassfctnTypeCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCodeClassfctnTypeCode(), CMFCodesValues_.codeClassfctnTypeCode));
            }
            if (criteria.getSrcSysCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSrcSysCode(), CMFCodesValues_.srcSysCode));
            }
            if (criteria.getLifecycleStatusCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLifecycleStatusCode(), CMFCodesValues_.lifecycleStatusCode));
            }
            if (criteria.getCodeColValCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCodeColValCode(), CMFCodesValues_.codeColValCode));
            }
            if (criteria.getDescColValText() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescColValText(), CMFCodesValues_.descColValText));
            }
            if (criteria.getEffDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getEffDate(), CMFCodesValues_.effDate));
            }
            if (criteria.getEndDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getEndDate(), CMFCodesValues_.endDate));
            }
            if (criteria.getCommentText() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCommentText(), CMFCodesValues_.commentText));
            }
            if (criteria.getNameColValName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNameColValName(), CMFCodesValues_.nameColValName));
            }
            if (criteria.getCreateDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreateDate(), CMFCodesValues_.createDate));
            }
            if (criteria.getCreateUserId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCreateUserId(), CMFCodesValues_.createUserId));
            }
            if (criteria.getUpdDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getUpdDate(), CMFCodesValues_.updDate));
            }
            if (criteria.getUpdUserId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUpdUserId(), CMFCodesValues_.updUserId));
            }
        }
        return specification;
    }
}
