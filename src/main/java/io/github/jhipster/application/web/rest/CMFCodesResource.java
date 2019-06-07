package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.domain.CMFCodes;
import io.github.jhipster.application.service.CMFCodesService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.service.dto.CMFCodesCriteria;
import io.github.jhipster.application.service.CMFCodesQueryService;

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
 * REST controller for managing {@link io.github.jhipster.application.domain.CMFCodes}.
 */
@RestController
@RequestMapping("/api")
public class CMFCodesResource {

    private final Logger log = LoggerFactory.getLogger(CMFCodesResource.class);

    private static final String ENTITY_NAME = "cMFCodes";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CMFCodesService cMFCodesService;

    private final CMFCodesQueryService cMFCodesQueryService;

    public CMFCodesResource(CMFCodesService cMFCodesService, CMFCodesQueryService cMFCodesQueryService) {
        this.cMFCodesService = cMFCodesService;
        this.cMFCodesQueryService = cMFCodesQueryService;
    }

    /**
     * {@code POST  /cmf-codes} : Create a new cMFCodes.
     *
     * @param cMFCodes the cMFCodes to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cMFCodes, or with status {@code 400 (Bad Request)} if the cMFCodes has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cmf-codes")
    public ResponseEntity<CMFCodes> createCMFCodes(@Valid @RequestBody CMFCodes cMFCodes) throws URISyntaxException {
        log.debug("REST request to save CMFCodes : {}", cMFCodes);
        if (cMFCodes.getId() != null) {
            throw new BadRequestAlertException("A new cMFCodes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CMFCodes result = cMFCodesService.save(cMFCodes);
        return ResponseEntity.created(new URI("/api/cmf-codes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cmf-codes} : Updates an existing cMFCodes.
     *
     * @param cMFCodes the cMFCodes to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cMFCodes,
     * or with status {@code 400 (Bad Request)} if the cMFCodes is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cMFCodes couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cmf-codes")
    public ResponseEntity<CMFCodes> updateCMFCodes(@Valid @RequestBody CMFCodes cMFCodes) throws URISyntaxException {
        log.debug("REST request to update CMFCodes : {}", cMFCodes);
        if (cMFCodes.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CMFCodes result = cMFCodesService.save(cMFCodes);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cMFCodes.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cmf-codes} : get all the cMFCodes.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cMFCodes in body.
     */
    @GetMapping("/cmf-codes")
    public ResponseEntity<List<CMFCodes>> getAllCMFCodes(CMFCodesCriteria criteria, Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get CMFCodes by criteria: {}", criteria);
        Page<CMFCodes> page = cMFCodesQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /cmf-codes/count} : count all the cMFCodes.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/cmf-codes/count")
    public ResponseEntity<Long> countCMFCodes(CMFCodesCriteria criteria) {
        log.debug("REST request to count CMFCodes by criteria: {}", criteria);
        return ResponseEntity.ok().body(cMFCodesQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cmf-codes/:id} : get the "id" cMFCodes.
     *
     * @param id the id of the cMFCodes to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cMFCodes, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cmf-codes/{id}")
    public ResponseEntity<CMFCodes> getCMFCodes(@PathVariable Long id) {
        log.debug("REST request to get CMFCodes : {}", id);
        Optional<CMFCodes> cMFCodes = cMFCodesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cMFCodes);
    }

    /**
     * {@code DELETE  /cmf-codes/:id} : delete the "id" cMFCodes.
     *
     * @param id the id of the cMFCodes to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cmf-codes/{id}")
    public ResponseEntity<Void> deleteCMFCodes(@PathVariable Long id) {
        log.debug("REST request to delete CMFCodes : {}", id);
        cMFCodesService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
