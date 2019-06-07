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

import io.github.jhipster.application.domain.CMFCodesMap;
import io.github.jhipster.application.domain.*; // for static metamodels
import io.github.jhipster.application.repository.CMFCodesMapRepository;
import io.github.jhipster.application.service.dto.CMFCodesMapCriteria;

/**
 * Service for executing complex queries for {@link CMFCodesMap} entities in the database.
 * The main input is a {@link CMFCodesMapCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CMFCodesMap} or a {@link Page} of {@link CMFCodesMap} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CMFCodesMapQueryService extends QueryService<CMFCodesMap> {

    private final Logger log = LoggerFactory.getLogger(CMFCodesMapQueryService.class);

    private final CMFCodesMapRepository cMFCodesMapRepository;

    public CMFCodesMapQueryService(CMFCodesMapRepository cMFCodesMapRepository) {
        this.cMFCodesMapRepository = cMFCodesMapRepository;
    }

    /**
     * Return a {@link List} of {@link CMFCodesMap} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CMFCodesMap> findByCriteria(CMFCodesMapCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CMFCodesMap> specification = createSpecification(criteria);
        return cMFCodesMapRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link CMFCodesMap} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CMFCodesMap> findByCriteria(CMFCodesMapCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CMFCodesMap> specification = createSpecification(criteria);
        return cMFCodesMapRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CMFCodesMapCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CMFCodesMap> specification = createSpecification(criteria);
        return cMFCodesMapRepository.count(specification);
    }

    /**
     * Function to convert CMFCodesMapCriteria to a {@link Specification}.
     */
    private Specification<CMFCodesMap> createSpecification(CMFCodesMapCriteria criteria) {
        Specification<CMFCodesMap> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), CMFCodesMap_.id));
            }
            if (criteria.getCodeValKey() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCodeValKey(), CMFCodesMap_.codeValKey));
            }
            if (criteria.getCodeValRltdKey() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCodeValRltdKey(), CMFCodesMap_.codeValRltdKey));
            }
            if (criteria.getMapTypeCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMapTypeCode(), CMFCodesMap_.mapTypeCode));
            }
            if (criteria.getEffDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getEffDate(), CMFCodesMap_.effDate));
            }
            if (criteria.getEndDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getEndDate(), CMFCodesMap_.endDate));
            }
            if (criteria.getCommentText() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCommentText(), CMFCodesMap_.commentText));
            }
            if (criteria.getCreateDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreateDate(), CMFCodesMap_.createDate));
            }
            if (criteria.getCreateUserId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCreateUserId(), CMFCodesMap_.createUserId));
            }
            if (criteria.getUpdDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getUpdDate(), CMFCodesMap_.updDate));
            }
            if (criteria.getUpdUserId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUpdUserId(), CMFCodesMap_.updUserId));
            }
            if (criteria.getCMFCodeValuesId() != null) {
                specification = specification.and(buildSpecification(criteria.getCMFCodeValuesId(),
                    root -> root.join(CMFCodesMap_.cMFCodeValues, JoinType.LEFT).get(CMFCodesValues_.id)));
            }
            if (criteria.getCMFCodeValuesRltdId() != null) {
                specification = specification.and(buildSpecification(criteria.getCMFCodeValuesRltdId(),
                    root -> root.join(CMFCodesMap_.cMFCodeValuesRltd, JoinType.LEFT).get(CMFCodesValues_.id)));
            }
        }
        return specification;
    }
}
