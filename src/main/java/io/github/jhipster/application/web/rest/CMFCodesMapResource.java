package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.domain.CMFCodesMap;
import io.github.jhipster.application.service.CMFCodesMapService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.service.dto.CMFCodesMapCriteria;
import io.github.jhipster.application.service.CMFCodesMapQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link io.github.jhipster.application.domain.CMFCodesMap}.
 */
@RestController
@RequestMapping("/api")
public class CMFCodesMapResource {

    private final Logger log = LoggerFactory.getLogger(CMFCodesMapResource.class);

    private static final String ENTITY_NAME = "cMFCodesMap";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CMFCodesMapService cMFCodesMapService;

    private final CMFCodesMapQueryService cMFCodesMapQueryService;

    public CMFCodesMapResource(CMFCodesMapService cMFCodesMapService, CMFCodesMapQueryService cMFCodesMapQueryService) {
        this.cMFCodesMapService = cMFCodesMapService;
        this.cMFCodesMapQueryService = cMFCodesMapQueryService;
    }

    /**
     * {@code POST  /cmf-codes-maps} : Create a new cMFCodesMap.
     *
     * @param cMFCodesMap the cMFCodesMap to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cMFCodesMap, or with status {@code 400 (Bad Request)} if the cMFCodesMap has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cmf-codes-maps")
    public ResponseEntity<CMFCodesMap> createCMFCodesMap(@Valid @RequestBody CMFCodesMap cMFCodesMap) throws URISyntaxException {
        log.debug("REST request to save CMFCodesMap : {}", cMFCodesMap);
        if (cMFCodesMap.getId() != null) {
            throw new BadRequestAlertException("A new cMFCodesMap cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CMFCodesMap result = cMFCodesMapService.save(cMFCodesMap);
        return ResponseEntity.created(new URI("/api/cmf-codes-maps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cmf-codes-maps} : Updates an existing cMFCodesMap.
     *
     * @param cMFCodesMap the cMFCodesMap to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cMFCodesMap,
     * or with status {@code 400 (Bad Request)} if the cMFCodesMap is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cMFCodesMap couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cmf-codes-maps")
    public ResponseEntity<CMFCodesMap> updateCMFCodesMap(@Valid @RequestBody CMFCodesMap cMFCodesMap) throws URISyntaxException {
        log.debug("REST request to update CMFCodesMap : {}", cMFCodesMap);
        if (cMFCodesMap.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CMFCodesMap result = cMFCodesMapService.save(cMFCodesMap);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cMFCodesMap.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cmf-codes-maps} : get all the cMFCodesMaps.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cMFCodesMaps in body.
     */
    @GetMapping("/cmf-codes-maps")
    public ResponseEntity<List<CMFCodesMap>> getAllCMFCodesMaps(CMFCodesMapCriteria criteria, Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get CMFCodesMaps by criteria: {}", criteria);
        Page<CMFCodesMap> page = cMFCodesMapQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /cmf-codes-maps/count} : count all the cMFCodesMaps.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/cmf-codes-maps/count")
    public ResponseEntity<Long> countCMFCodesMaps(CMFCodesMapCriteria criteria) {
        log.debug("REST request to count CMFCodesMaps by criteria: {}", criteria);
        return ResponseEntity.ok().body(cMFCodesMapQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cmf-codes-maps/:id} : get the "id" cMFCodesMap.
     *
     * @param id the id of the cMFCodesMap to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cMFCodesMap, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cmf-codes-maps/{id}")
    public ResponseEntity<CMFCodesMap> getCMFCodesMap(@PathVariable Long id) {
        log.debug("REST request to get CMFCodesMap : {}", id);
        Optional<CMFCodesMap> cMFCodesMap = cMFCodesMapService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cMFCodesMap);
    }

    /**
     * {@code DELETE  /cmf-codes-maps/:id} : delete the "id" cMFCodesMap.
     *
     * @param id the id of the cMFCodesMap to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cmf-codes-maps/{id}")
    public ResponseEntity<Void> deleteCMFCodesMap(@PathVariable Long id) {
        log.debug("REST request to delete CMFCodesMap : {}", id);
        cMFCodesMapService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
