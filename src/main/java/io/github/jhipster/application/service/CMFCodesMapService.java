package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.CMFCodesMap;
import io.github.jhipster.application.repository.CMFCodesMapRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CMFCodesMap}.
 */
@Service
@Transactional
public class CMFCodesMapService {

    private final Logger log = LoggerFactory.getLogger(CMFCodesMapService.class);

    private final CMFCodesMapRepository cMFCodesMapRepository;

    public CMFCodesMapService(CMFCodesMapRepository cMFCodesMapRepository) {
        this.cMFCodesMapRepository = cMFCodesMapRepository;
    }

    /**
     * Save a cMFCodesMap.
     *
     * @param cMFCodesMap the entity to save.
     * @return the persisted entity.
     */
    public CMFCodesMap save(CMFCodesMap cMFCodesMap) {
        log.debug("Request to save CMFCodesMap : {}", cMFCodesMap);
        return cMFCodesMapRepository.save(cMFCodesMap);
    }

    /**
     * Get all the cMFCodesMaps.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CMFCodesMap> findAll(Pageable pageable) {
        log.debug("Request to get all CMFCodesMaps");
        return cMFCodesMapRepository.findAll(pageable);
    }


    /**
     * Get one cMFCodesMap by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CMFCodesMap> findOne(Long id) {
        log.debug("Request to get CMFCodesMap : {}", id);
        return cMFCodesMapRepository.findById(id);
    }

    /**
     * Delete the cMFCodesMap by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CMFCodesMap : {}", id);
        cMFCodesMapRepository.deleteById(id);
    }
}
