package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.CMFCodesValues;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CMFCodesValues entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CMFCodesValuesRepository extends JpaRepository<CMFCodesValues, Long>, JpaSpecificationExecutor<CMFCodesValues> {

}
