package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.domain.CMFCodesValues;
import io.github.jhipster.application.service.CMFCodesValuesService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.service.dto.CMFCodesValuesCriteria;
import io.github.jhipster.application.service.CMFCodesValuesQueryService;

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
 * REST controller for managing {@link io.github.jhipster.application.domain.CMFCodesValues}.
 */
@RestController
@RequestMapping("/api")
public class CMFCodesValuesResource {

    private final Logger log = LoggerFactory.getLogger(CMFCodesValuesResource.class);

    private static final String ENTITY_NAME = "cMFCodesValues";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CMFCodesValuesService cMFCodesValuesService;

    private final CMFCodesValuesQueryService cMFCodesValuesQueryService;

    public CMFCodesValuesResource(CMFCodesValuesService cMFCodesValuesService, CMFCodesValuesQueryService cMFCodesValuesQueryService) {
        this.cMFCodesValuesService = cMFCodesValuesService;
        this.cMFCodesValuesQueryService = cMFCodesValuesQueryService;
    }

    /**
     * {@code POST  /cmf-codes-values} : Create a new cMFCodesValues.
     *
     * @param cMFCodesValues the cMFCodesValues to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cMFCodesValues, or with status {@code 400 (Bad Request)} if the cMFCodesValues has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cmf-codes-values")
    public ResponseEntity<CMFCodesValues> createCMFCodesValues(@Valid @RequestBody CMFCodesValues cMFCodesValues) throws URISyntaxException {
        log.debug("REST request to save CMFCodesValues : {}", cMFCodesValues);
        if (cMFCodesValues.getId() != null) {
            throw new BadRequestAlertException("A new cMFCodesValues cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CMFCodesValues result = cMFCodesValuesService.save(cMFCodesValues);
        return ResponseEntity.created(new URI("/api/cmf-codes-values/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cmf-codes-values} : Updates an existing cMFCodesValues.
     *
     * @param cMFCodesValues the cMFCodesValues to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cMFCodesValues,
     * or with status {@code 400 (Bad Request)} if the cMFCodesValues is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cMFCodesValues couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cmf-codes-values")
    public ResponseEntity<CMFCodesValues> updateCMFCodesValues(@Valid @RequestBody CMFCodesValues cMFCodesValues) throws URISyntaxException {
        log.debug("REST request to update CMFCodesValues : {}", cMFCodesValues);
        if (cMFCodesValues.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CMFCodesValues result = cMFCodesValuesService.save(cMFCodesValues);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cMFCodesValues.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cmf-codes-values} : get all the cMFCodesValues.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cMFCodesValues in body.
     */
    @GetMapping("/cmf-codes-values")
    public ResponseEntity<List<CMFCodesValues>> getAllCMFCodesValues(CMFCodesValuesCriteria criteria, Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get CMFCodesValues by criteria: {}", criteria);
        Page<CMFCodesValues> page = cMFCodesValuesQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /cmf-codes-values/count} : count all the cMFCodesValues.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/cmf-codes-values/count")
    public ResponseEntity<Long> countCMFCodesValues(CMFCodesValuesCriteria criteria) {
        log.debug("REST request to count CMFCodesValues by criteria: {}", criteria);
        return ResponseEntity.ok().body(cMFCodesValuesQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cmf-codes-values/:id} : get the "id" cMFCodesValues.
     *
     * @param id the id of the cMFCodesValues to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cMFCodesValues, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cmf-codes-values/{id}")
    public ResponseEntity<CMFCodesValues> getCMFCodesValues(@PathVariable Long id) {
        log.debug("REST request to get CMFCodesValues : {}", id);
        Optional<CMFCodesValues> cMFCodesValues = cMFCodesValuesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cMFCodesValues);
    }

    /**
     * {@code DELETE  /cmf-codes-values/:id} : delete the "id" cMFCodesValues.
     *
     * @param id the id of the cMFCodesValues to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cmf-codes-values/{id}")
    public ResponseEntity<Void> deleteCMFCodesValues(@PathVariable Long id) {
        log.debug("REST request to delete CMFCodesValues : {}", id);
        cMFCodesValuesService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
