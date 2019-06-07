package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.CMFCodesValues;
import io.github.jhipster.application.repository.CMFCodesValuesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CMFCodesValues}.
 */
@Service
@Transactional
public class CMFCodesValuesService {

    private final Logger log = LoggerFactory.getLogger(CMFCodesValuesService.class);

    private final CMFCodesValuesRepository cMFCodesValuesRepository;

    public CMFCodesValuesService(CMFCodesValuesRepository cMFCodesValuesRepository) {
        this.cMFCodesValuesRepository = cMFCodesValuesRepository;
    }

    /**
     * Save a cMFCodesValues.
     *
     * @param cMFCodesValues the entity to save.
     * @return the persisted entity.
     */
    public CMFCodesValues save(CMFCodesValues cMFCodesValues) {
        log.debug("Request to save CMFCodesValues : {}", cMFCodesValues);
        return cMFCodesValuesRepository.save(cMFCodesValues);
    }

    /**
     * Get all the cMFCodesValues.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CMFCodesValues> findAll(Pageable pageable) {
        log.debug("Request to get all CMFCodesValues");
        return cMFCodesValuesRepository.findAll(pageable);
    }


    /**
     * Get one cMFCodesValues by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CMFCodesValues> findOne(Long id) {
        log.debug("Request to get CMFCodesValues : {}", id);
        return cMFCodesValuesRepository.findById(id);
    }

    /**
     * Delete the cMFCodesValues by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CMFCodesValues : {}", id);
        cMFCodesValuesRepository.deleteById(id);
    }
}
