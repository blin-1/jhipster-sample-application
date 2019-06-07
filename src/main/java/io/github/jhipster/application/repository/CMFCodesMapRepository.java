package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.CMFCodesMap;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CMFCodesMap entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CMFCodesMapRepository extends JpaRepository<CMFCodesMap, Long>, JpaSpecificationExecutor<CMFCodesMap> {

}
