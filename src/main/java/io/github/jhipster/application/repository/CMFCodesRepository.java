package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.CMFCodes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CMFCodes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CMFCodesRepository extends JpaRepository<CMFCodes, Long>, JpaSpecificationExecutor<CMFCodes> {

}
