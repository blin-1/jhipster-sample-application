package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;
import io.github.jhipster.application.domain.CMFCodesMap;
import io.github.jhipster.application.domain.CMFCodesValues;
import io.github.jhipster.application.repository.CMFCodesMapRepository;
import io.github.jhipster.application.service.CMFCodesMapService;
import io.github.jhipster.application.web.rest.errors.ExceptionTranslator;
import io.github.jhipster.application.service.dto.CMFCodesMapCriteria;
import io.github.jhipster.application.service.CMFCodesMapQueryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static io.github.jhipster.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@Link CMFCodesMapResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class CMFCodesMapResourceIT {

    private static final BigDecimal DEFAULT_CODE_VAL_KEY = new BigDecimal(1);
    private static final BigDecimal UPDATED_CODE_VAL_KEY = new BigDecimal(2);

    private static final BigDecimal DEFAULT_CODE_VAL_RLTD_KEY = new BigDecimal(1);
    private static final BigDecimal UPDATED_CODE_VAL_RLTD_KEY = new BigDecimal(2);

    private static final String DEFAULT_MAP_TYPE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MAP_TYPE_CODE = "BBBBBBBBBB";

    private static final Instant DEFAULT_EFF_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_EFF_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_END_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_END_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_COMMENT_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT_TEXT = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_CREATE_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_USER_ID = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPD_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPD_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPD_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_UPD_USER_ID = "BBBBBBBBBB";

    @Autowired
    private CMFCodesMapRepository cMFCodesMapRepository;

    @Autowired
    private CMFCodesMapService cMFCodesMapService;

    @Autowired
    private CMFCodesMapQueryService cMFCodesMapQueryService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restCMFCodesMapMockMvc;

    private CMFCodesMap cMFCodesMap;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CMFCodesMapResource cMFCodesMapResource = new CMFCodesMapResource(cMFCodesMapService, cMFCodesMapQueryService);
        this.restCMFCodesMapMockMvc = MockMvcBuilders.standaloneSetup(cMFCodesMapResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CMFCodesMap createEntity(EntityManager em) {
        CMFCodesMap cMFCodesMap = new CMFCodesMap()
            .codeValKey(DEFAULT_CODE_VAL_KEY)
            .codeValRltdKey(DEFAULT_CODE_VAL_RLTD_KEY)
            .mapTypeCode(DEFAULT_MAP_TYPE_CODE)
            .effDate(DEFAULT_EFF_DATE)
            .endDate(DEFAULT_END_DATE)
            .commentText(DEFAULT_COMMENT_TEXT)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .updDate(DEFAULT_UPD_DATE)
            .updUserId(DEFAULT_UPD_USER_ID);
        return cMFCodesMap;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CMFCodesMap createUpdatedEntity(EntityManager em) {
        CMFCodesMap cMFCodesMap = new CMFCodesMap()
            .codeValKey(UPDATED_CODE_VAL_KEY)
            .codeValRltdKey(UPDATED_CODE_VAL_RLTD_KEY)
            .mapTypeCode(UPDATED_MAP_TYPE_CODE)
            .effDate(UPDATED_EFF_DATE)
            .endDate(UPDATED_END_DATE)
            .commentText(UPDATED_COMMENT_TEXT)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .updDate(UPDATED_UPD_DATE)
            .updUserId(UPDATED_UPD_USER_ID);
        return cMFCodesMap;
    }

    @BeforeEach
    public void initTest() {
        cMFCodesMap = createEntity(em);
    }

    @Test
    @Transactional
    public void createCMFCodesMap() throws Exception {
        int databaseSizeBeforeCreate = cMFCodesMapRepository.findAll().size();

        // Create the CMFCodesMap
        restCMFCodesMapMockMvc.perform(post("/api/cmf-codes-maps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesMap)))
            .andExpect(status().isCreated());

        // Validate the CMFCodesMap in the database
        List<CMFCodesMap> cMFCodesMapList = cMFCodesMapRepository.findAll();
        assertThat(cMFCodesMapList).hasSize(databaseSizeBeforeCreate + 1);
        CMFCodesMap testCMFCodesMap = cMFCodesMapList.get(cMFCodesMapList.size() - 1);
        assertThat(testCMFCodesMap.getCodeValKey()).isEqualTo(DEFAULT_CODE_VAL_KEY);
        assertThat(testCMFCodesMap.getCodeValRltdKey()).isEqualTo(DEFAULT_CODE_VAL_RLTD_KEY);
        assertThat(testCMFCodesMap.getMapTypeCode()).isEqualTo(DEFAULT_MAP_TYPE_CODE);
        assertThat(testCMFCodesMap.getEffDate()).isEqualTo(DEFAULT_EFF_DATE);
        assertThat(testCMFCodesMap.getEndDate()).isEqualTo(DEFAULT_END_DATE);
        assertThat(testCMFCodesMap.getCommentText()).isEqualTo(DEFAULT_COMMENT_TEXT);
        assertThat(testCMFCodesMap.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testCMFCodesMap.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testCMFCodesMap.getUpdDate()).isEqualTo(DEFAULT_UPD_DATE);
        assertThat(testCMFCodesMap.getUpdUserId()).isEqualTo(DEFAULT_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void createCMFCodesMapWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = cMFCodesMapRepository.findAll().size();

        // Create the CMFCodesMap with an existing ID
        cMFCodesMap.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCMFCodesMapMockMvc.perform(post("/api/cmf-codes-maps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesMap)))
            .andExpect(status().isBadRequest());

        // Validate the CMFCodesMap in the database
        List<CMFCodesMap> cMFCodesMapList = cMFCodesMapRepository.findAll();
        assertThat(cMFCodesMapList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkCodeValKeyIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesMapRepository.findAll().size();
        // set the field null
        cMFCodesMap.setCodeValKey(null);

        // Create the CMFCodesMap, which fails.

        restCMFCodesMapMockMvc.perform(post("/api/cmf-codes-maps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesMap)))
            .andExpect(status().isBadRequest());

        List<CMFCodesMap> cMFCodesMapList = cMFCodesMapRepository.findAll();
        assertThat(cMFCodesMapList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCodeValRltdKeyIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesMapRepository.findAll().size();
        // set the field null
        cMFCodesMap.setCodeValRltdKey(null);

        // Create the CMFCodesMap, which fails.

        restCMFCodesMapMockMvc.perform(post("/api/cmf-codes-maps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesMap)))
            .andExpect(status().isBadRequest());

        List<CMFCodesMap> cMFCodesMapList = cMFCodesMapRepository.findAll();
        assertThat(cMFCodesMapList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkMapTypeCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesMapRepository.findAll().size();
        // set the field null
        cMFCodesMap.setMapTypeCode(null);

        // Create the CMFCodesMap, which fails.

        restCMFCodesMapMockMvc.perform(post("/api/cmf-codes-maps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesMap)))
            .andExpect(status().isBadRequest());

        List<CMFCodesMap> cMFCodesMapList = cMFCodesMapRepository.findAll();
        assertThat(cMFCodesMapList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateUserIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesMapRepository.findAll().size();
        // set the field null
        cMFCodesMap.setCreateUserId(null);

        // Create the CMFCodesMap, which fails.

        restCMFCodesMapMockMvc.perform(post("/api/cmf-codes-maps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesMap)))
            .andExpect(status().isBadRequest());

        List<CMFCodesMap> cMFCodesMapList = cMFCodesMapRepository.findAll();
        assertThat(cMFCodesMapList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUpdUserIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesMapRepository.findAll().size();
        // set the field null
        cMFCodesMap.setUpdUserId(null);

        // Create the CMFCodesMap, which fails.

        restCMFCodesMapMockMvc.perform(post("/api/cmf-codes-maps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesMap)))
            .andExpect(status().isBadRequest());

        List<CMFCodesMap> cMFCodesMapList = cMFCodesMapRepository.findAll();
        assertThat(cMFCodesMapList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMaps() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList
        restCMFCodesMapMockMvc.perform(get("/api/cmf-codes-maps?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cMFCodesMap.getId().intValue())))
            .andExpect(jsonPath("$.[*].codeValKey").value(hasItem(DEFAULT_CODE_VAL_KEY.intValue())))
            .andExpect(jsonPath("$.[*].codeValRltdKey").value(hasItem(DEFAULT_CODE_VAL_RLTD_KEY.intValue())))
            .andExpect(jsonPath("$.[*].mapTypeCode").value(hasItem(DEFAULT_MAP_TYPE_CODE.toString())))
            .andExpect(jsonPath("$.[*].effDate").value(hasItem(DEFAULT_EFF_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].commentText").value(hasItem(DEFAULT_COMMENT_TEXT.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].updDate").value(hasItem(DEFAULT_UPD_DATE.toString())))
            .andExpect(jsonPath("$.[*].updUserId").value(hasItem(DEFAULT_UPD_USER_ID.toString())));
    }
    
    @Test
    @Transactional
    public void getCMFCodesMap() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get the cMFCodesMap
        restCMFCodesMapMockMvc.perform(get("/api/cmf-codes-maps/{id}", cMFCodesMap.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(cMFCodesMap.getId().intValue()))
            .andExpect(jsonPath("$.codeValKey").value(DEFAULT_CODE_VAL_KEY.intValue()))
            .andExpect(jsonPath("$.codeValRltdKey").value(DEFAULT_CODE_VAL_RLTD_KEY.intValue()))
            .andExpect(jsonPath("$.mapTypeCode").value(DEFAULT_MAP_TYPE_CODE.toString()))
            .andExpect(jsonPath("$.effDate").value(DEFAULT_EFF_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.commentText").value(DEFAULT_COMMENT_TEXT.toString()))
            .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.toString()))
            .andExpect(jsonPath("$.updDate").value(DEFAULT_UPD_DATE.toString()))
            .andExpect(jsonPath("$.updUserId").value(DEFAULT_UPD_USER_ID.toString()));
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCodeValKeyIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where codeValKey equals to DEFAULT_CODE_VAL_KEY
        defaultCMFCodesMapShouldBeFound("codeValKey.equals=" + DEFAULT_CODE_VAL_KEY);

        // Get all the cMFCodesMapList where codeValKey equals to UPDATED_CODE_VAL_KEY
        defaultCMFCodesMapShouldNotBeFound("codeValKey.equals=" + UPDATED_CODE_VAL_KEY);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCodeValKeyIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where codeValKey in DEFAULT_CODE_VAL_KEY or UPDATED_CODE_VAL_KEY
        defaultCMFCodesMapShouldBeFound("codeValKey.in=" + DEFAULT_CODE_VAL_KEY + "," + UPDATED_CODE_VAL_KEY);

        // Get all the cMFCodesMapList where codeValKey equals to UPDATED_CODE_VAL_KEY
        defaultCMFCodesMapShouldNotBeFound("codeValKey.in=" + UPDATED_CODE_VAL_KEY);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCodeValKeyIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where codeValKey is not null
        defaultCMFCodesMapShouldBeFound("codeValKey.specified=true");

        // Get all the cMFCodesMapList where codeValKey is null
        defaultCMFCodesMapShouldNotBeFound("codeValKey.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCodeValRltdKeyIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where codeValRltdKey equals to DEFAULT_CODE_VAL_RLTD_KEY
        defaultCMFCodesMapShouldBeFound("codeValRltdKey.equals=" + DEFAULT_CODE_VAL_RLTD_KEY);

        // Get all the cMFCodesMapList where codeValRltdKey equals to UPDATED_CODE_VAL_RLTD_KEY
        defaultCMFCodesMapShouldNotBeFound("codeValRltdKey.equals=" + UPDATED_CODE_VAL_RLTD_KEY);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCodeValRltdKeyIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where codeValRltdKey in DEFAULT_CODE_VAL_RLTD_KEY or UPDATED_CODE_VAL_RLTD_KEY
        defaultCMFCodesMapShouldBeFound("codeValRltdKey.in=" + DEFAULT_CODE_VAL_RLTD_KEY + "," + UPDATED_CODE_VAL_RLTD_KEY);

        // Get all the cMFCodesMapList where codeValRltdKey equals to UPDATED_CODE_VAL_RLTD_KEY
        defaultCMFCodesMapShouldNotBeFound("codeValRltdKey.in=" + UPDATED_CODE_VAL_RLTD_KEY);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCodeValRltdKeyIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where codeValRltdKey is not null
        defaultCMFCodesMapShouldBeFound("codeValRltdKey.specified=true");

        // Get all the cMFCodesMapList where codeValRltdKey is null
        defaultCMFCodesMapShouldNotBeFound("codeValRltdKey.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByMapTypeCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where mapTypeCode equals to DEFAULT_MAP_TYPE_CODE
        defaultCMFCodesMapShouldBeFound("mapTypeCode.equals=" + DEFAULT_MAP_TYPE_CODE);

        // Get all the cMFCodesMapList where mapTypeCode equals to UPDATED_MAP_TYPE_CODE
        defaultCMFCodesMapShouldNotBeFound("mapTypeCode.equals=" + UPDATED_MAP_TYPE_CODE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByMapTypeCodeIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where mapTypeCode in DEFAULT_MAP_TYPE_CODE or UPDATED_MAP_TYPE_CODE
        defaultCMFCodesMapShouldBeFound("mapTypeCode.in=" + DEFAULT_MAP_TYPE_CODE + "," + UPDATED_MAP_TYPE_CODE);

        // Get all the cMFCodesMapList where mapTypeCode equals to UPDATED_MAP_TYPE_CODE
        defaultCMFCodesMapShouldNotBeFound("mapTypeCode.in=" + UPDATED_MAP_TYPE_CODE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByMapTypeCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where mapTypeCode is not null
        defaultCMFCodesMapShouldBeFound("mapTypeCode.specified=true");

        // Get all the cMFCodesMapList where mapTypeCode is null
        defaultCMFCodesMapShouldNotBeFound("mapTypeCode.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByEffDateIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where effDate equals to DEFAULT_EFF_DATE
        defaultCMFCodesMapShouldBeFound("effDate.equals=" + DEFAULT_EFF_DATE);

        // Get all the cMFCodesMapList where effDate equals to UPDATED_EFF_DATE
        defaultCMFCodesMapShouldNotBeFound("effDate.equals=" + UPDATED_EFF_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByEffDateIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where effDate in DEFAULT_EFF_DATE or UPDATED_EFF_DATE
        defaultCMFCodesMapShouldBeFound("effDate.in=" + DEFAULT_EFF_DATE + "," + UPDATED_EFF_DATE);

        // Get all the cMFCodesMapList where effDate equals to UPDATED_EFF_DATE
        defaultCMFCodesMapShouldNotBeFound("effDate.in=" + UPDATED_EFF_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByEffDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where effDate is not null
        defaultCMFCodesMapShouldBeFound("effDate.specified=true");

        // Get all the cMFCodesMapList where effDate is null
        defaultCMFCodesMapShouldNotBeFound("effDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByEndDateIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where endDate equals to DEFAULT_END_DATE
        defaultCMFCodesMapShouldBeFound("endDate.equals=" + DEFAULT_END_DATE);

        // Get all the cMFCodesMapList where endDate equals to UPDATED_END_DATE
        defaultCMFCodesMapShouldNotBeFound("endDate.equals=" + UPDATED_END_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByEndDateIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where endDate in DEFAULT_END_DATE or UPDATED_END_DATE
        defaultCMFCodesMapShouldBeFound("endDate.in=" + DEFAULT_END_DATE + "," + UPDATED_END_DATE);

        // Get all the cMFCodesMapList where endDate equals to UPDATED_END_DATE
        defaultCMFCodesMapShouldNotBeFound("endDate.in=" + UPDATED_END_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByEndDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where endDate is not null
        defaultCMFCodesMapShouldBeFound("endDate.specified=true");

        // Get all the cMFCodesMapList where endDate is null
        defaultCMFCodesMapShouldNotBeFound("endDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCommentTextIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where commentText equals to DEFAULT_COMMENT_TEXT
        defaultCMFCodesMapShouldBeFound("commentText.equals=" + DEFAULT_COMMENT_TEXT);

        // Get all the cMFCodesMapList where commentText equals to UPDATED_COMMENT_TEXT
        defaultCMFCodesMapShouldNotBeFound("commentText.equals=" + UPDATED_COMMENT_TEXT);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCommentTextIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where commentText in DEFAULT_COMMENT_TEXT or UPDATED_COMMENT_TEXT
        defaultCMFCodesMapShouldBeFound("commentText.in=" + DEFAULT_COMMENT_TEXT + "," + UPDATED_COMMENT_TEXT);

        // Get all the cMFCodesMapList where commentText equals to UPDATED_COMMENT_TEXT
        defaultCMFCodesMapShouldNotBeFound("commentText.in=" + UPDATED_COMMENT_TEXT);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCommentTextIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where commentText is not null
        defaultCMFCodesMapShouldBeFound("commentText.specified=true");

        // Get all the cMFCodesMapList where commentText is null
        defaultCMFCodesMapShouldNotBeFound("commentText.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCreateDateIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where createDate equals to DEFAULT_CREATE_DATE
        defaultCMFCodesMapShouldBeFound("createDate.equals=" + DEFAULT_CREATE_DATE);

        // Get all the cMFCodesMapList where createDate equals to UPDATED_CREATE_DATE
        defaultCMFCodesMapShouldNotBeFound("createDate.equals=" + UPDATED_CREATE_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCreateDateIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where createDate in DEFAULT_CREATE_DATE or UPDATED_CREATE_DATE
        defaultCMFCodesMapShouldBeFound("createDate.in=" + DEFAULT_CREATE_DATE + "," + UPDATED_CREATE_DATE);

        // Get all the cMFCodesMapList where createDate equals to UPDATED_CREATE_DATE
        defaultCMFCodesMapShouldNotBeFound("createDate.in=" + UPDATED_CREATE_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCreateDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where createDate is not null
        defaultCMFCodesMapShouldBeFound("createDate.specified=true");

        // Get all the cMFCodesMapList where createDate is null
        defaultCMFCodesMapShouldNotBeFound("createDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCreateUserIdIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where createUserId equals to DEFAULT_CREATE_USER_ID
        defaultCMFCodesMapShouldBeFound("createUserId.equals=" + DEFAULT_CREATE_USER_ID);

        // Get all the cMFCodesMapList where createUserId equals to UPDATED_CREATE_USER_ID
        defaultCMFCodesMapShouldNotBeFound("createUserId.equals=" + UPDATED_CREATE_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCreateUserIdIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where createUserId in DEFAULT_CREATE_USER_ID or UPDATED_CREATE_USER_ID
        defaultCMFCodesMapShouldBeFound("createUserId.in=" + DEFAULT_CREATE_USER_ID + "," + UPDATED_CREATE_USER_ID);

        // Get all the cMFCodesMapList where createUserId equals to UPDATED_CREATE_USER_ID
        defaultCMFCodesMapShouldNotBeFound("createUserId.in=" + UPDATED_CREATE_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCreateUserIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where createUserId is not null
        defaultCMFCodesMapShouldBeFound("createUserId.specified=true");

        // Get all the cMFCodesMapList where createUserId is null
        defaultCMFCodesMapShouldNotBeFound("createUserId.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByUpdDateIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where updDate equals to DEFAULT_UPD_DATE
        defaultCMFCodesMapShouldBeFound("updDate.equals=" + DEFAULT_UPD_DATE);

        // Get all the cMFCodesMapList where updDate equals to UPDATED_UPD_DATE
        defaultCMFCodesMapShouldNotBeFound("updDate.equals=" + UPDATED_UPD_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByUpdDateIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where updDate in DEFAULT_UPD_DATE or UPDATED_UPD_DATE
        defaultCMFCodesMapShouldBeFound("updDate.in=" + DEFAULT_UPD_DATE + "," + UPDATED_UPD_DATE);

        // Get all the cMFCodesMapList where updDate equals to UPDATED_UPD_DATE
        defaultCMFCodesMapShouldNotBeFound("updDate.in=" + UPDATED_UPD_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByUpdDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where updDate is not null
        defaultCMFCodesMapShouldBeFound("updDate.specified=true");

        // Get all the cMFCodesMapList where updDate is null
        defaultCMFCodesMapShouldNotBeFound("updDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByUpdUserIdIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where updUserId equals to DEFAULT_UPD_USER_ID
        defaultCMFCodesMapShouldBeFound("updUserId.equals=" + DEFAULT_UPD_USER_ID);

        // Get all the cMFCodesMapList where updUserId equals to UPDATED_UPD_USER_ID
        defaultCMFCodesMapShouldNotBeFound("updUserId.equals=" + UPDATED_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByUpdUserIdIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where updUserId in DEFAULT_UPD_USER_ID or UPDATED_UPD_USER_ID
        defaultCMFCodesMapShouldBeFound("updUserId.in=" + DEFAULT_UPD_USER_ID + "," + UPDATED_UPD_USER_ID);

        // Get all the cMFCodesMapList where updUserId equals to UPDATED_UPD_USER_ID
        defaultCMFCodesMapShouldNotBeFound("updUserId.in=" + UPDATED_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByUpdUserIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);

        // Get all the cMFCodesMapList where updUserId is not null
        defaultCMFCodesMapShouldBeFound("updUserId.specified=true");

        // Get all the cMFCodesMapList where updUserId is null
        defaultCMFCodesMapShouldNotBeFound("updUserId.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesMapsByCMFCodeValuesIsEqualToSomething() throws Exception {
        // Initialize the database
        CMFCodesValues cMFCodeValues = CMFCodesValuesResourceIT.createEntity(em);
        em.persist(cMFCodeValues);
        em.flush();
        cMFCodesMap.setCMFCodeValues(cMFCodeValues);
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);
        Long cMFCodeValuesId = cMFCodeValues.getId();

        // Get all the cMFCodesMapList where cMFCodeValues equals to cMFCodeValuesId
        defaultCMFCodesMapShouldBeFound("cMFCodeValuesId.equals=" + cMFCodeValuesId);

        // Get all the cMFCodesMapList where cMFCodeValues equals to cMFCodeValuesId + 1
        defaultCMFCodesMapShouldNotBeFound("cMFCodeValuesId.equals=" + (cMFCodeValuesId + 1));
    }


    @Test
    @Transactional
    public void getAllCMFCodesMapsByCMFCodeValuesRltdIsEqualToSomething() throws Exception {
        // Initialize the database
        CMFCodesValues cMFCodeValuesRltd = CMFCodesValuesResourceIT.createEntity(em);
        em.persist(cMFCodeValuesRltd);
        em.flush();
        cMFCodesMap.setCMFCodeValuesRltd(cMFCodeValuesRltd);
        cMFCodesMapRepository.saveAndFlush(cMFCodesMap);
        Long cMFCodeValuesRltdId = cMFCodeValuesRltd.getId();

        // Get all the cMFCodesMapList where cMFCodeValuesRltd equals to cMFCodeValuesRltdId
        defaultCMFCodesMapShouldBeFound("cMFCodeValuesRltdId.equals=" + cMFCodeValuesRltdId);

        // Get all the cMFCodesMapList where cMFCodeValuesRltd equals to cMFCodeValuesRltdId + 1
        defaultCMFCodesMapShouldNotBeFound("cMFCodeValuesRltdId.equals=" + (cMFCodeValuesRltdId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultCMFCodesMapShouldBeFound(String filter) throws Exception {
        restCMFCodesMapMockMvc.perform(get("/api/cmf-codes-maps?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cMFCodesMap.getId().intValue())))
            .andExpect(jsonPath("$.[*].codeValKey").value(hasItem(DEFAULT_CODE_VAL_KEY.intValue())))
            .andExpect(jsonPath("$.[*].codeValRltdKey").value(hasItem(DEFAULT_CODE_VAL_RLTD_KEY.intValue())))
            .andExpect(jsonPath("$.[*].mapTypeCode").value(hasItem(DEFAULT_MAP_TYPE_CODE)))
            .andExpect(jsonPath("$.[*].effDate").value(hasItem(DEFAULT_EFF_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].commentText").value(hasItem(DEFAULT_COMMENT_TEXT)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID)))
            .andExpect(jsonPath("$.[*].updDate").value(hasItem(DEFAULT_UPD_DATE.toString())))
            .andExpect(jsonPath("$.[*].updUserId").value(hasItem(DEFAULT_UPD_USER_ID)));

        // Check, that the count call also returns 1
        restCMFCodesMapMockMvc.perform(get("/api/cmf-codes-maps/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultCMFCodesMapShouldNotBeFound(String filter) throws Exception {
        restCMFCodesMapMockMvc.perform(get("/api/cmf-codes-maps?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restCMFCodesMapMockMvc.perform(get("/api/cmf-codes-maps/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().string("0"));
    }


    @Test
    @Transactional
    public void getNonExistingCMFCodesMap() throws Exception {
        // Get the cMFCodesMap
        restCMFCodesMapMockMvc.perform(get("/api/cmf-codes-maps/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCMFCodesMap() throws Exception {
        // Initialize the database
        cMFCodesMapService.save(cMFCodesMap);

        int databaseSizeBeforeUpdate = cMFCodesMapRepository.findAll().size();

        // Update the cMFCodesMap
        CMFCodesMap updatedCMFCodesMap = cMFCodesMapRepository.findById(cMFCodesMap.getId()).get();
        // Disconnect from session so that the updates on updatedCMFCodesMap are not directly saved in db
        em.detach(updatedCMFCodesMap);
        updatedCMFCodesMap
            .codeValKey(UPDATED_CODE_VAL_KEY)
            .codeValRltdKey(UPDATED_CODE_VAL_RLTD_KEY)
            .mapTypeCode(UPDATED_MAP_TYPE_CODE)
            .effDate(UPDATED_EFF_DATE)
            .endDate(UPDATED_END_DATE)
            .commentText(UPDATED_COMMENT_TEXT)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .updDate(UPDATED_UPD_DATE)
            .updUserId(UPDATED_UPD_USER_ID);

        restCMFCodesMapMockMvc.perform(put("/api/cmf-codes-maps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCMFCodesMap)))
            .andExpect(status().isOk());

        // Validate the CMFCodesMap in the database
        List<CMFCodesMap> cMFCodesMapList = cMFCodesMapRepository.findAll();
        assertThat(cMFCodesMapList).hasSize(databaseSizeBeforeUpdate);
        CMFCodesMap testCMFCodesMap = cMFCodesMapList.get(cMFCodesMapList.size() - 1);
        assertThat(testCMFCodesMap.getCodeValKey()).isEqualTo(UPDATED_CODE_VAL_KEY);
        assertThat(testCMFCodesMap.getCodeValRltdKey()).isEqualTo(UPDATED_CODE_VAL_RLTD_KEY);
        assertThat(testCMFCodesMap.getMapTypeCode()).isEqualTo(UPDATED_MAP_TYPE_CODE);
        assertThat(testCMFCodesMap.getEffDate()).isEqualTo(UPDATED_EFF_DATE);
        assertThat(testCMFCodesMap.getEndDate()).isEqualTo(UPDATED_END_DATE);
        assertThat(testCMFCodesMap.getCommentText()).isEqualTo(UPDATED_COMMENT_TEXT);
        assertThat(testCMFCodesMap.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testCMFCodesMap.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testCMFCodesMap.getUpdDate()).isEqualTo(UPDATED_UPD_DATE);
        assertThat(testCMFCodesMap.getUpdUserId()).isEqualTo(UPDATED_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingCMFCodesMap() throws Exception {
        int databaseSizeBeforeUpdate = cMFCodesMapRepository.findAll().size();

        // Create the CMFCodesMap

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCMFCodesMapMockMvc.perform(put("/api/cmf-codes-maps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesMap)))
            .andExpect(status().isBadRequest());

        // Validate the CMFCodesMap in the database
        List<CMFCodesMap> cMFCodesMapList = cMFCodesMapRepository.findAll();
        assertThat(cMFCodesMapList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCMFCodesMap() throws Exception {
        // Initialize the database
        cMFCodesMapService.save(cMFCodesMap);

        int databaseSizeBeforeDelete = cMFCodesMapRepository.findAll().size();

        // Delete the cMFCodesMap
        restCMFCodesMapMockMvc.perform(delete("/api/cmf-codes-maps/{id}", cMFCodesMap.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database is empty
        List<CMFCodesMap> cMFCodesMapList = cMFCodesMapRepository.findAll();
        assertThat(cMFCodesMapList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CMFCodesMap.class);
        CMFCodesMap cMFCodesMap1 = new CMFCodesMap();
        cMFCodesMap1.setId(1L);
        CMFCodesMap cMFCodesMap2 = new CMFCodesMap();
        cMFCodesMap2.setId(cMFCodesMap1.getId());
        assertThat(cMFCodesMap1).isEqualTo(cMFCodesMap2);
        cMFCodesMap2.setId(2L);
        assertThat(cMFCodesMap1).isNotEqualTo(cMFCodesMap2);
        cMFCodesMap1.setId(null);
        assertThat(cMFCodesMap1).isNotEqualTo(cMFCodesMap2);
    }
}
