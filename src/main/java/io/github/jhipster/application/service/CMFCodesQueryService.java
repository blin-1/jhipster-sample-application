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

import io.github.jhipster.application.domain.CMFCodes;
import io.github.jhipster.application.domain.*; // for static metamodels
import io.github.jhipster.application.repository.CMFCodesRepository;
import io.github.jhipster.application.service.dto.CMFCodesCriteria;

/**
 * Service for executing complex queries for {@link CMFCodes} entities in the database.
 * The main input is a {@link CMFCodesCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CMFCodes} or a {@link Page} of {@link CMFCodes} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CMFCodesQueryService extends QueryService<CMFCodes> {

    private final Logger log = LoggerFactory.getLogger(CMFCodesQueryService.class);

    private final CMFCodesRepository cMFCodesRepository;

    public CMFCodesQueryService(CMFCodesRepository cMFCodesRepository) {
        this.cMFCodesRepository = cMFCodesRepository;
    }

    /**
     * Return a {@link List} of {@link CMFCodes} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CMFCodes> findByCriteria(CMFCodesCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CMFCodes> specification = createSpecification(criteria);
        return cMFCodesRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link CMFCodes} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CMFCodes> findByCriteria(CMFCodesCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CMFCodes> specification = createSpecification(criteria);
        return cMFCodesRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CMFCodesCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CMFCodes> specification = createSpecification(criteria);
        return cMFCodesRepository.count(specification);
    }

    /**
     * Function to convert CMFCodesCriteria to a {@link Specification}.
     */
    private Specification<CMFCodes> createSpecification(CMFCodesCriteria criteria) {
        Specification<CMFCodes> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), CMFCodes_.id));
            }
            if (criteria.getCodeTableKey() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCodeTableKey(), CMFCodes_.codeTableKey));
            }
            if (criteria.getCodeEntyName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCodeEntyName(), CMFCodes_.codeEntyName));
            }
            if (criteria.getCodeEntyDefinitionText() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCodeEntyDefinitionText(), CMFCodes_.codeEntyDefinitionText));
            }
            if (criteria.getCodeTableName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCodeTableName(), CMFCodes_.codeTableName));
            }
            if (criteria.getCodeAttrbName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCodeAttrbName(), CMFCodes_.codeAttrbName));
            }
            if (criteria.getDescAttrbName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescAttrbName(), CMFCodes_.descAttrbName));
            }
            if (criteria.getCodeColName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCodeColName(), CMFCodes_.codeColName));
            }
            if (criteria.getDescColName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescColName(), CMFCodes_.descColName));
            }
            if (criteria.getCommentText() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCommentText(), CMFCodes_.commentText));
            }
            if (criteria.getNameAttrbName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNameAttrbName(), CMFCodes_.nameAttrbName));
            }
            if (criteria.getNameColName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNameColName(), CMFCodes_.nameColName));
            }
            if (criteria.getCreateDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreateDate(), CMFCodes_.createDate));
            }
            if (criteria.getCreateUserId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCreateUserId(), CMFCodes_.createUserId));
            }
            if (criteria.getUpdDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getUpdDate(), CMFCodes_.updDate));
            }
            if (criteria.getUpdUserId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUpdUserId(), CMFCodes_.updUserId));
            }
        }
        return specification;
    }
}
