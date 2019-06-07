package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.CMFCodes;
import io.github.jhipster.application.repository.CMFCodesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CMFCodes}.
 */
@Service
@Transactional
public class CMFCodesService {

    private final Logger log = LoggerFactory.getLogger(CMFCodesService.class);

    private final CMFCodesRepository cMFCodesRepository;

    public CMFCodesService(CMFCodesRepository cMFCodesRepository) {
        this.cMFCodesRepository = cMFCodesRepository;
    }

    /**
     * Save a cMFCodes.
     *
     * @param cMFCodes the entity to save.
     * @return the persisted entity.
     */
    public CMFCodes save(CMFCodes cMFCodes) {
        log.debug("Request to save CMFCodes : {}", cMFCodes);
        return cMFCodesRepository.save(cMFCodes);
    }

    /**
     * Get all the cMFCodes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CMFCodes> findAll(Pageable pageable) {
        log.debug("Request to get all CMFCodes");
        return cMFCodesRepository.findAll(pageable);
    }


    /**
     * Get one cMFCodes by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CMFCodes> findOne(Long id) {
        log.debug("Request to get CMFCodes : {}", id);
        return cMFCodesRepository.findById(id);
    }

    /**
     * Delete the cMFCodes by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CMFCodes : {}", id);
        cMFCodesRepository.deleteById(id);
    }
}
