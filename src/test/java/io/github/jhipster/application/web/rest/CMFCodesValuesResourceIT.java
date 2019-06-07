package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;
import io.github.jhipster.application.domain.CMFCodesValues;
import io.github.jhipster.application.repository.CMFCodesValuesRepository;
import io.github.jhipster.application.service.CMFCodesValuesService;
import io.github.jhipster.application.web.rest.errors.ExceptionTranslator;
import io.github.jhipster.application.service.dto.CMFCodesValuesCriteria;
import io.github.jhipster.application.service.CMFCodesValuesQueryService;

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
 * Integration tests for the {@Link CMFCodesValuesResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class CMFCodesValuesResourceIT {

    private static final BigDecimal DEFAULT_CODE_VAL_KEY = new BigDecimal(1);
    private static final BigDecimal UPDATED_CODE_VAL_KEY = new BigDecimal(2);

    private static final BigDecimal DEFAULT_CODE_TABLE_KEY = new BigDecimal(1);
    private static final BigDecimal UPDATED_CODE_TABLE_KEY = new BigDecimal(2);

    private static final String DEFAULT_CODE_CLASSFCTN_TYPE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_CLASSFCTN_TYPE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SRC_SYS_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SRC_SYS_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_LIFECYCLE_STATUS_CODE = "AAAAAAAAAA";
    private static final String UPDATED_LIFECYCLE_STATUS_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_COL_VAL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE_COL_VAL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DESC_COL_VAL_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_DESC_COL_VAL_TEXT = "BBBBBBBBBB";

    private static final Instant DEFAULT_EFF_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_EFF_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_END_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_END_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_COMMENT_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT_TEXT = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_COL_VAL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME_COL_VAL_NAME = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_CREATE_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_USER_ID = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPD_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPD_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPD_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_UPD_USER_ID = "BBBBBBBBBB";

    @Autowired
    private CMFCodesValuesRepository cMFCodesValuesRepository;

    @Autowired
    private CMFCodesValuesService cMFCodesValuesService;

    @Autowired
    private CMFCodesValuesQueryService cMFCodesValuesQueryService;

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

    private MockMvc restCMFCodesValuesMockMvc;

    private CMFCodesValues cMFCodesValues;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CMFCodesValuesResource cMFCodesValuesResource = new CMFCodesValuesResource(cMFCodesValuesService, cMFCodesValuesQueryService);
        this.restCMFCodesValuesMockMvc = MockMvcBuilders.standaloneSetup(cMFCodesValuesResource)
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
    public static CMFCodesValues createEntity(EntityManager em) {
        CMFCodesValues cMFCodesValues = new CMFCodesValues()
            .codeValKey(DEFAULT_CODE_VAL_KEY)
            .codeTableKey(DEFAULT_CODE_TABLE_KEY)
            .codeClassfctnTypeCode(DEFAULT_CODE_CLASSFCTN_TYPE_CODE)
            .srcSysCode(DEFAULT_SRC_SYS_CODE)
            .lifecycleStatusCode(DEFAULT_LIFECYCLE_STATUS_CODE)
            .codeColValCode(DEFAULT_CODE_COL_VAL_CODE)
            .descColValText(DEFAULT_DESC_COL_VAL_TEXT)
            .effDate(DEFAULT_EFF_DATE)
            .endDate(DEFAULT_END_DATE)
            .commentText(DEFAULT_COMMENT_TEXT)
            .nameColValName(DEFAULT_NAME_COL_VAL_NAME)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .updDate(DEFAULT_UPD_DATE)
            .updUserId(DEFAULT_UPD_USER_ID);
        return cMFCodesValues;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CMFCodesValues createUpdatedEntity(EntityManager em) {
        CMFCodesValues cMFCodesValues = new CMFCodesValues()
            .codeValKey(UPDATED_CODE_VAL_KEY)
            .codeTableKey(UPDATED_CODE_TABLE_KEY)
            .codeClassfctnTypeCode(UPDATED_CODE_CLASSFCTN_TYPE_CODE)
            .srcSysCode(UPDATED_SRC_SYS_CODE)
            .lifecycleStatusCode(UPDATED_LIFECYCLE_STATUS_CODE)
            .codeColValCode(UPDATED_CODE_COL_VAL_CODE)
            .descColValText(UPDATED_DESC_COL_VAL_TEXT)
            .effDate(UPDATED_EFF_DATE)
            .endDate(UPDATED_END_DATE)
            .commentText(UPDATED_COMMENT_TEXT)
            .nameColValName(UPDATED_NAME_COL_VAL_NAME)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .updDate(UPDATED_UPD_DATE)
            .updUserId(UPDATED_UPD_USER_ID);
        return cMFCodesValues;
    }

    @BeforeEach
    public void initTest() {
        cMFCodesValues = createEntity(em);
    }

    @Test
    @Transactional
    public void createCMFCodesValues() throws Exception {
        int databaseSizeBeforeCreate = cMFCodesValuesRepository.findAll().size();

        // Create the CMFCodesValues
        restCMFCodesValuesMockMvc.perform(post("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesValues)))
            .andExpect(status().isCreated());

        // Validate the CMFCodesValues in the database
        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeCreate + 1);
        CMFCodesValues testCMFCodesValues = cMFCodesValuesList.get(cMFCodesValuesList.size() - 1);
        assertThat(testCMFCodesValues.getCodeValKey()).isEqualTo(DEFAULT_CODE_VAL_KEY);
        assertThat(testCMFCodesValues.getCodeTableKey()).isEqualTo(DEFAULT_CODE_TABLE_KEY);
        assertThat(testCMFCodesValues.getCodeClassfctnTypeCode()).isEqualTo(DEFAULT_CODE_CLASSFCTN_TYPE_CODE);
        assertThat(testCMFCodesValues.getSrcSysCode()).isEqualTo(DEFAULT_SRC_SYS_CODE);
        assertThat(testCMFCodesValues.getLifecycleStatusCode()).isEqualTo(DEFAULT_LIFECYCLE_STATUS_CODE);
        assertThat(testCMFCodesValues.getCodeColValCode()).isEqualTo(DEFAULT_CODE_COL_VAL_CODE);
        assertThat(testCMFCodesValues.getDescColValText()).isEqualTo(DEFAULT_DESC_COL_VAL_TEXT);
        assertThat(testCMFCodesValues.getEffDate()).isEqualTo(DEFAULT_EFF_DATE);
        assertThat(testCMFCodesValues.getEndDate()).isEqualTo(DEFAULT_END_DATE);
        assertThat(testCMFCodesValues.getCommentText()).isEqualTo(DEFAULT_COMMENT_TEXT);
        assertThat(testCMFCodesValues.getNameColValName()).isEqualTo(DEFAULT_NAME_COL_VAL_NAME);
        assertThat(testCMFCodesValues.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testCMFCodesValues.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testCMFCodesValues.getUpdDate()).isEqualTo(DEFAULT_UPD_DATE);
        assertThat(testCMFCodesValues.getUpdUserId()).isEqualTo(DEFAULT_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void createCMFCodesValuesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = cMFCodesValuesRepository.findAll().size();

        // Create the CMFCodesValues with an existing ID
        cMFCodesValues.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCMFCodesValuesMockMvc.perform(post("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesValues)))
            .andExpect(status().isBadRequest());

        // Validate the CMFCodesValues in the database
        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkCodeValKeyIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesValuesRepository.findAll().size();
        // set the field null
        cMFCodesValues.setCodeValKey(null);

        // Create the CMFCodesValues, which fails.

        restCMFCodesValuesMockMvc.perform(post("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesValues)))
            .andExpect(status().isBadRequest());

        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCodeTableKeyIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesValuesRepository.findAll().size();
        // set the field null
        cMFCodesValues.setCodeTableKey(null);

        // Create the CMFCodesValues, which fails.

        restCMFCodesValuesMockMvc.perform(post("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesValues)))
            .andExpect(status().isBadRequest());

        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCodeClassfctnTypeCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesValuesRepository.findAll().size();
        // set the field null
        cMFCodesValues.setCodeClassfctnTypeCode(null);

        // Create the CMFCodesValues, which fails.

        restCMFCodesValuesMockMvc.perform(post("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesValues)))
            .andExpect(status().isBadRequest());

        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSrcSysCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesValuesRepository.findAll().size();
        // set the field null
        cMFCodesValues.setSrcSysCode(null);

        // Create the CMFCodesValues, which fails.

        restCMFCodesValuesMockMvc.perform(post("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesValues)))
            .andExpect(status().isBadRequest());

        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLifecycleStatusCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesValuesRepository.findAll().size();
        // set the field null
        cMFCodesValues.setLifecycleStatusCode(null);

        // Create the CMFCodesValues, which fails.

        restCMFCodesValuesMockMvc.perform(post("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesValues)))
            .andExpect(status().isBadRequest());

        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateUserIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesValuesRepository.findAll().size();
        // set the field null
        cMFCodesValues.setCreateUserId(null);

        // Create the CMFCodesValues, which fails.

        restCMFCodesValuesMockMvc.perform(post("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesValues)))
            .andExpect(status().isBadRequest());

        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUpdUserIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesValuesRepository.findAll().size();
        // set the field null
        cMFCodesValues.setUpdUserId(null);

        // Create the CMFCodesValues, which fails.

        restCMFCodesValuesMockMvc.perform(post("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesValues)))
            .andExpect(status().isBadRequest());

        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValues() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList
        restCMFCodesValuesMockMvc.perform(get("/api/cmf-codes-values?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cMFCodesValues.getId().intValue())))
            .andExpect(jsonPath("$.[*].codeValKey").value(hasItem(DEFAULT_CODE_VAL_KEY.intValue())))
            .andExpect(jsonPath("$.[*].codeTableKey").value(hasItem(DEFAULT_CODE_TABLE_KEY.intValue())))
            .andExpect(jsonPath("$.[*].codeClassfctnTypeCode").value(hasItem(DEFAULT_CODE_CLASSFCTN_TYPE_CODE.toString())))
            .andExpect(jsonPath("$.[*].srcSysCode").value(hasItem(DEFAULT_SRC_SYS_CODE.toString())))
            .andExpect(jsonPath("$.[*].lifecycleStatusCode").value(hasItem(DEFAULT_LIFECYCLE_STATUS_CODE.toString())))
            .andExpect(jsonPath("$.[*].codeColValCode").value(hasItem(DEFAULT_CODE_COL_VAL_CODE.toString())))
            .andExpect(jsonPath("$.[*].descColValText").value(hasItem(DEFAULT_DESC_COL_VAL_TEXT.toString())))
            .andExpect(jsonPath("$.[*].effDate").value(hasItem(DEFAULT_EFF_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].commentText").value(hasItem(DEFAULT_COMMENT_TEXT.toString())))
            .andExpect(jsonPath("$.[*].nameColValName").value(hasItem(DEFAULT_NAME_COL_VAL_NAME.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].updDate").value(hasItem(DEFAULT_UPD_DATE.toString())))
            .andExpect(jsonPath("$.[*].updUserId").value(hasItem(DEFAULT_UPD_USER_ID.toString())));
    }
    
    @Test
    @Transactional
    public void getCMFCodesValues() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get the cMFCodesValues
        restCMFCodesValuesMockMvc.perform(get("/api/cmf-codes-values/{id}", cMFCodesValues.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(cMFCodesValues.getId().intValue()))
            .andExpect(jsonPath("$.codeValKey").value(DEFAULT_CODE_VAL_KEY.intValue()))
            .andExpect(jsonPath("$.codeTableKey").value(DEFAULT_CODE_TABLE_KEY.intValue()))
            .andExpect(jsonPath("$.codeClassfctnTypeCode").value(DEFAULT_CODE_CLASSFCTN_TYPE_CODE.toString()))
            .andExpect(jsonPath("$.srcSysCode").value(DEFAULT_SRC_SYS_CODE.toString()))
            .andExpect(jsonPath("$.lifecycleStatusCode").value(DEFAULT_LIFECYCLE_STATUS_CODE.toString()))
            .andExpect(jsonPath("$.codeColValCode").value(DEFAULT_CODE_COL_VAL_CODE.toString()))
            .andExpect(jsonPath("$.descColValText").value(DEFAULT_DESC_COL_VAL_TEXT.toString()))
            .andExpect(jsonPath("$.effDate").value(DEFAULT_EFF_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.commentText").value(DEFAULT_COMMENT_TEXT.toString()))
            .andExpect(jsonPath("$.nameColValName").value(DEFAULT_NAME_COL_VAL_NAME.toString()))
            .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.toString()))
            .andExpect(jsonPath("$.updDate").value(DEFAULT_UPD_DATE.toString()))
            .andExpect(jsonPath("$.updUserId").value(DEFAULT_UPD_USER_ID.toString()));
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeValKeyIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeValKey equals to DEFAULT_CODE_VAL_KEY
        defaultCMFCodesValuesShouldBeFound("codeValKey.equals=" + DEFAULT_CODE_VAL_KEY);

        // Get all the cMFCodesValuesList where codeValKey equals to UPDATED_CODE_VAL_KEY
        defaultCMFCodesValuesShouldNotBeFound("codeValKey.equals=" + UPDATED_CODE_VAL_KEY);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeValKeyIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeValKey in DEFAULT_CODE_VAL_KEY or UPDATED_CODE_VAL_KEY
        defaultCMFCodesValuesShouldBeFound("codeValKey.in=" + DEFAULT_CODE_VAL_KEY + "," + UPDATED_CODE_VAL_KEY);

        // Get all the cMFCodesValuesList where codeValKey equals to UPDATED_CODE_VAL_KEY
        defaultCMFCodesValuesShouldNotBeFound("codeValKey.in=" + UPDATED_CODE_VAL_KEY);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeValKeyIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeValKey is not null
        defaultCMFCodesValuesShouldBeFound("codeValKey.specified=true");

        // Get all the cMFCodesValuesList where codeValKey is null
        defaultCMFCodesValuesShouldNotBeFound("codeValKey.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeTableKeyIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeTableKey equals to DEFAULT_CODE_TABLE_KEY
        defaultCMFCodesValuesShouldBeFound("codeTableKey.equals=" + DEFAULT_CODE_TABLE_KEY);

        // Get all the cMFCodesValuesList where codeTableKey equals to UPDATED_CODE_TABLE_KEY
        defaultCMFCodesValuesShouldNotBeFound("codeTableKey.equals=" + UPDATED_CODE_TABLE_KEY);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeTableKeyIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeTableKey in DEFAULT_CODE_TABLE_KEY or UPDATED_CODE_TABLE_KEY
        defaultCMFCodesValuesShouldBeFound("codeTableKey.in=" + DEFAULT_CODE_TABLE_KEY + "," + UPDATED_CODE_TABLE_KEY);

        // Get all the cMFCodesValuesList where codeTableKey equals to UPDATED_CODE_TABLE_KEY
        defaultCMFCodesValuesShouldNotBeFound("codeTableKey.in=" + UPDATED_CODE_TABLE_KEY);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeTableKeyIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeTableKey is not null
        defaultCMFCodesValuesShouldBeFound("codeTableKey.specified=true");

        // Get all the cMFCodesValuesList where codeTableKey is null
        defaultCMFCodesValuesShouldNotBeFound("codeTableKey.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeClassfctnTypeCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeClassfctnTypeCode equals to DEFAULT_CODE_CLASSFCTN_TYPE_CODE
        defaultCMFCodesValuesShouldBeFound("codeClassfctnTypeCode.equals=" + DEFAULT_CODE_CLASSFCTN_TYPE_CODE);

        // Get all the cMFCodesValuesList where codeClassfctnTypeCode equals to UPDATED_CODE_CLASSFCTN_TYPE_CODE
        defaultCMFCodesValuesShouldNotBeFound("codeClassfctnTypeCode.equals=" + UPDATED_CODE_CLASSFCTN_TYPE_CODE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeClassfctnTypeCodeIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeClassfctnTypeCode in DEFAULT_CODE_CLASSFCTN_TYPE_CODE or UPDATED_CODE_CLASSFCTN_TYPE_CODE
        defaultCMFCodesValuesShouldBeFound("codeClassfctnTypeCode.in=" + DEFAULT_CODE_CLASSFCTN_TYPE_CODE + "," + UPDATED_CODE_CLASSFCTN_TYPE_CODE);

        // Get all the cMFCodesValuesList where codeClassfctnTypeCode equals to UPDATED_CODE_CLASSFCTN_TYPE_CODE
        defaultCMFCodesValuesShouldNotBeFound("codeClassfctnTypeCode.in=" + UPDATED_CODE_CLASSFCTN_TYPE_CODE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeClassfctnTypeCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeClassfctnTypeCode is not null
        defaultCMFCodesValuesShouldBeFound("codeClassfctnTypeCode.specified=true");

        // Get all the cMFCodesValuesList where codeClassfctnTypeCode is null
        defaultCMFCodesValuesShouldNotBeFound("codeClassfctnTypeCode.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesBySrcSysCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where srcSysCode equals to DEFAULT_SRC_SYS_CODE
        defaultCMFCodesValuesShouldBeFound("srcSysCode.equals=" + DEFAULT_SRC_SYS_CODE);

        // Get all the cMFCodesValuesList where srcSysCode equals to UPDATED_SRC_SYS_CODE
        defaultCMFCodesValuesShouldNotBeFound("srcSysCode.equals=" + UPDATED_SRC_SYS_CODE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesBySrcSysCodeIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where srcSysCode in DEFAULT_SRC_SYS_CODE or UPDATED_SRC_SYS_CODE
        defaultCMFCodesValuesShouldBeFound("srcSysCode.in=" + DEFAULT_SRC_SYS_CODE + "," + UPDATED_SRC_SYS_CODE);

        // Get all the cMFCodesValuesList where srcSysCode equals to UPDATED_SRC_SYS_CODE
        defaultCMFCodesValuesShouldNotBeFound("srcSysCode.in=" + UPDATED_SRC_SYS_CODE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesBySrcSysCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where srcSysCode is not null
        defaultCMFCodesValuesShouldBeFound("srcSysCode.specified=true");

        // Get all the cMFCodesValuesList where srcSysCode is null
        defaultCMFCodesValuesShouldNotBeFound("srcSysCode.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByLifecycleStatusCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where lifecycleStatusCode equals to DEFAULT_LIFECYCLE_STATUS_CODE
        defaultCMFCodesValuesShouldBeFound("lifecycleStatusCode.equals=" + DEFAULT_LIFECYCLE_STATUS_CODE);

        // Get all the cMFCodesValuesList where lifecycleStatusCode equals to UPDATED_LIFECYCLE_STATUS_CODE
        defaultCMFCodesValuesShouldNotBeFound("lifecycleStatusCode.equals=" + UPDATED_LIFECYCLE_STATUS_CODE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByLifecycleStatusCodeIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where lifecycleStatusCode in DEFAULT_LIFECYCLE_STATUS_CODE or UPDATED_LIFECYCLE_STATUS_CODE
        defaultCMFCodesValuesShouldBeFound("lifecycleStatusCode.in=" + DEFAULT_LIFECYCLE_STATUS_CODE + "," + UPDATED_LIFECYCLE_STATUS_CODE);

        // Get all the cMFCodesValuesList where lifecycleStatusCode equals to UPDATED_LIFECYCLE_STATUS_CODE
        defaultCMFCodesValuesShouldNotBeFound("lifecycleStatusCode.in=" + UPDATED_LIFECYCLE_STATUS_CODE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByLifecycleStatusCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where lifecycleStatusCode is not null
        defaultCMFCodesValuesShouldBeFound("lifecycleStatusCode.specified=true");

        // Get all the cMFCodesValuesList where lifecycleStatusCode is null
        defaultCMFCodesValuesShouldNotBeFound("lifecycleStatusCode.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeColValCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeColValCode equals to DEFAULT_CODE_COL_VAL_CODE
        defaultCMFCodesValuesShouldBeFound("codeColValCode.equals=" + DEFAULT_CODE_COL_VAL_CODE);

        // Get all the cMFCodesValuesList where codeColValCode equals to UPDATED_CODE_COL_VAL_CODE
        defaultCMFCodesValuesShouldNotBeFound("codeColValCode.equals=" + UPDATED_CODE_COL_VAL_CODE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeColValCodeIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeColValCode in DEFAULT_CODE_COL_VAL_CODE or UPDATED_CODE_COL_VAL_CODE
        defaultCMFCodesValuesShouldBeFound("codeColValCode.in=" + DEFAULT_CODE_COL_VAL_CODE + "," + UPDATED_CODE_COL_VAL_CODE);

        // Get all the cMFCodesValuesList where codeColValCode equals to UPDATED_CODE_COL_VAL_CODE
        defaultCMFCodesValuesShouldNotBeFound("codeColValCode.in=" + UPDATED_CODE_COL_VAL_CODE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCodeColValCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where codeColValCode is not null
        defaultCMFCodesValuesShouldBeFound("codeColValCode.specified=true");

        // Get all the cMFCodesValuesList where codeColValCode is null
        defaultCMFCodesValuesShouldNotBeFound("codeColValCode.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByDescColValTextIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where descColValText equals to DEFAULT_DESC_COL_VAL_TEXT
        defaultCMFCodesValuesShouldBeFound("descColValText.equals=" + DEFAULT_DESC_COL_VAL_TEXT);

        // Get all the cMFCodesValuesList where descColValText equals to UPDATED_DESC_COL_VAL_TEXT
        defaultCMFCodesValuesShouldNotBeFound("descColValText.equals=" + UPDATED_DESC_COL_VAL_TEXT);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByDescColValTextIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where descColValText in DEFAULT_DESC_COL_VAL_TEXT or UPDATED_DESC_COL_VAL_TEXT
        defaultCMFCodesValuesShouldBeFound("descColValText.in=" + DEFAULT_DESC_COL_VAL_TEXT + "," + UPDATED_DESC_COL_VAL_TEXT);

        // Get all the cMFCodesValuesList where descColValText equals to UPDATED_DESC_COL_VAL_TEXT
        defaultCMFCodesValuesShouldNotBeFound("descColValText.in=" + UPDATED_DESC_COL_VAL_TEXT);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByDescColValTextIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where descColValText is not null
        defaultCMFCodesValuesShouldBeFound("descColValText.specified=true");

        // Get all the cMFCodesValuesList where descColValText is null
        defaultCMFCodesValuesShouldNotBeFound("descColValText.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByEffDateIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where effDate equals to DEFAULT_EFF_DATE
        defaultCMFCodesValuesShouldBeFound("effDate.equals=" + DEFAULT_EFF_DATE);

        // Get all the cMFCodesValuesList where effDate equals to UPDATED_EFF_DATE
        defaultCMFCodesValuesShouldNotBeFound("effDate.equals=" + UPDATED_EFF_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByEffDateIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where effDate in DEFAULT_EFF_DATE or UPDATED_EFF_DATE
        defaultCMFCodesValuesShouldBeFound("effDate.in=" + DEFAULT_EFF_DATE + "," + UPDATED_EFF_DATE);

        // Get all the cMFCodesValuesList where effDate equals to UPDATED_EFF_DATE
        defaultCMFCodesValuesShouldNotBeFound("effDate.in=" + UPDATED_EFF_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByEffDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where effDate is not null
        defaultCMFCodesValuesShouldBeFound("effDate.specified=true");

        // Get all the cMFCodesValuesList where effDate is null
        defaultCMFCodesValuesShouldNotBeFound("effDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByEndDateIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where endDate equals to DEFAULT_END_DATE
        defaultCMFCodesValuesShouldBeFound("endDate.equals=" + DEFAULT_END_DATE);

        // Get all the cMFCodesValuesList where endDate equals to UPDATED_END_DATE
        defaultCMFCodesValuesShouldNotBeFound("endDate.equals=" + UPDATED_END_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByEndDateIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where endDate in DEFAULT_END_DATE or UPDATED_END_DATE
        defaultCMFCodesValuesShouldBeFound("endDate.in=" + DEFAULT_END_DATE + "," + UPDATED_END_DATE);

        // Get all the cMFCodesValuesList where endDate equals to UPDATED_END_DATE
        defaultCMFCodesValuesShouldNotBeFound("endDate.in=" + UPDATED_END_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByEndDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where endDate is not null
        defaultCMFCodesValuesShouldBeFound("endDate.specified=true");

        // Get all the cMFCodesValuesList where endDate is null
        defaultCMFCodesValuesShouldNotBeFound("endDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCommentTextIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where commentText equals to DEFAULT_COMMENT_TEXT
        defaultCMFCodesValuesShouldBeFound("commentText.equals=" + DEFAULT_COMMENT_TEXT);

        // Get all the cMFCodesValuesList where commentText equals to UPDATED_COMMENT_TEXT
        defaultCMFCodesValuesShouldNotBeFound("commentText.equals=" + UPDATED_COMMENT_TEXT);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCommentTextIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where commentText in DEFAULT_COMMENT_TEXT or UPDATED_COMMENT_TEXT
        defaultCMFCodesValuesShouldBeFound("commentText.in=" + DEFAULT_COMMENT_TEXT + "," + UPDATED_COMMENT_TEXT);

        // Get all the cMFCodesValuesList where commentText equals to UPDATED_COMMENT_TEXT
        defaultCMFCodesValuesShouldNotBeFound("commentText.in=" + UPDATED_COMMENT_TEXT);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCommentTextIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where commentText is not null
        defaultCMFCodesValuesShouldBeFound("commentText.specified=true");

        // Get all the cMFCodesValuesList where commentText is null
        defaultCMFCodesValuesShouldNotBeFound("commentText.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByNameColValNameIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where nameColValName equals to DEFAULT_NAME_COL_VAL_NAME
        defaultCMFCodesValuesShouldBeFound("nameColValName.equals=" + DEFAULT_NAME_COL_VAL_NAME);

        // Get all the cMFCodesValuesList where nameColValName equals to UPDATED_NAME_COL_VAL_NAME
        defaultCMFCodesValuesShouldNotBeFound("nameColValName.equals=" + UPDATED_NAME_COL_VAL_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByNameColValNameIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where nameColValName in DEFAULT_NAME_COL_VAL_NAME or UPDATED_NAME_COL_VAL_NAME
        defaultCMFCodesValuesShouldBeFound("nameColValName.in=" + DEFAULT_NAME_COL_VAL_NAME + "," + UPDATED_NAME_COL_VAL_NAME);

        // Get all the cMFCodesValuesList where nameColValName equals to UPDATED_NAME_COL_VAL_NAME
        defaultCMFCodesValuesShouldNotBeFound("nameColValName.in=" + UPDATED_NAME_COL_VAL_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByNameColValNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where nameColValName is not null
        defaultCMFCodesValuesShouldBeFound("nameColValName.specified=true");

        // Get all the cMFCodesValuesList where nameColValName is null
        defaultCMFCodesValuesShouldNotBeFound("nameColValName.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCreateDateIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where createDate equals to DEFAULT_CREATE_DATE
        defaultCMFCodesValuesShouldBeFound("createDate.equals=" + DEFAULT_CREATE_DATE);

        // Get all the cMFCodesValuesList where createDate equals to UPDATED_CREATE_DATE
        defaultCMFCodesValuesShouldNotBeFound("createDate.equals=" + UPDATED_CREATE_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCreateDateIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where createDate in DEFAULT_CREATE_DATE or UPDATED_CREATE_DATE
        defaultCMFCodesValuesShouldBeFound("createDate.in=" + DEFAULT_CREATE_DATE + "," + UPDATED_CREATE_DATE);

        // Get all the cMFCodesValuesList where createDate equals to UPDATED_CREATE_DATE
        defaultCMFCodesValuesShouldNotBeFound("createDate.in=" + UPDATED_CREATE_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCreateDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where createDate is not null
        defaultCMFCodesValuesShouldBeFound("createDate.specified=true");

        // Get all the cMFCodesValuesList where createDate is null
        defaultCMFCodesValuesShouldNotBeFound("createDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCreateUserIdIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where createUserId equals to DEFAULT_CREATE_USER_ID
        defaultCMFCodesValuesShouldBeFound("createUserId.equals=" + DEFAULT_CREATE_USER_ID);

        // Get all the cMFCodesValuesList where createUserId equals to UPDATED_CREATE_USER_ID
        defaultCMFCodesValuesShouldNotBeFound("createUserId.equals=" + UPDATED_CREATE_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCreateUserIdIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where createUserId in DEFAULT_CREATE_USER_ID or UPDATED_CREATE_USER_ID
        defaultCMFCodesValuesShouldBeFound("createUserId.in=" + DEFAULT_CREATE_USER_ID + "," + UPDATED_CREATE_USER_ID);

        // Get all the cMFCodesValuesList where createUserId equals to UPDATED_CREATE_USER_ID
        defaultCMFCodesValuesShouldNotBeFound("createUserId.in=" + UPDATED_CREATE_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByCreateUserIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where createUserId is not null
        defaultCMFCodesValuesShouldBeFound("createUserId.specified=true");

        // Get all the cMFCodesValuesList where createUserId is null
        defaultCMFCodesValuesShouldNotBeFound("createUserId.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByUpdDateIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where updDate equals to DEFAULT_UPD_DATE
        defaultCMFCodesValuesShouldBeFound("updDate.equals=" + DEFAULT_UPD_DATE);

        // Get all the cMFCodesValuesList where updDate equals to UPDATED_UPD_DATE
        defaultCMFCodesValuesShouldNotBeFound("updDate.equals=" + UPDATED_UPD_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByUpdDateIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where updDate in DEFAULT_UPD_DATE or UPDATED_UPD_DATE
        defaultCMFCodesValuesShouldBeFound("updDate.in=" + DEFAULT_UPD_DATE + "," + UPDATED_UPD_DATE);

        // Get all the cMFCodesValuesList where updDate equals to UPDATED_UPD_DATE
        defaultCMFCodesValuesShouldNotBeFound("updDate.in=" + UPDATED_UPD_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByUpdDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where updDate is not null
        defaultCMFCodesValuesShouldBeFound("updDate.specified=true");

        // Get all the cMFCodesValuesList where updDate is null
        defaultCMFCodesValuesShouldNotBeFound("updDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByUpdUserIdIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where updUserId equals to DEFAULT_UPD_USER_ID
        defaultCMFCodesValuesShouldBeFound("updUserId.equals=" + DEFAULT_UPD_USER_ID);

        // Get all the cMFCodesValuesList where updUserId equals to UPDATED_UPD_USER_ID
        defaultCMFCodesValuesShouldNotBeFound("updUserId.equals=" + UPDATED_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByUpdUserIdIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where updUserId in DEFAULT_UPD_USER_ID or UPDATED_UPD_USER_ID
        defaultCMFCodesValuesShouldBeFound("updUserId.in=" + DEFAULT_UPD_USER_ID + "," + UPDATED_UPD_USER_ID);

        // Get all the cMFCodesValuesList where updUserId equals to UPDATED_UPD_USER_ID
        defaultCMFCodesValuesShouldNotBeFound("updUserId.in=" + UPDATED_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesValuesByUpdUserIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesValuesRepository.saveAndFlush(cMFCodesValues);

        // Get all the cMFCodesValuesList where updUserId is not null
        defaultCMFCodesValuesShouldBeFound("updUserId.specified=true");

        // Get all the cMFCodesValuesList where updUserId is null
        defaultCMFCodesValuesShouldNotBeFound("updUserId.specified=false");
    }
    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultCMFCodesValuesShouldBeFound(String filter) throws Exception {
        restCMFCodesValuesMockMvc.perform(get("/api/cmf-codes-values?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cMFCodesValues.getId().intValue())))
            .andExpect(jsonPath("$.[*].codeValKey").value(hasItem(DEFAULT_CODE_VAL_KEY.intValue())))
            .andExpect(jsonPath("$.[*].codeTableKey").value(hasItem(DEFAULT_CODE_TABLE_KEY.intValue())))
            .andExpect(jsonPath("$.[*].codeClassfctnTypeCode").value(hasItem(DEFAULT_CODE_CLASSFCTN_TYPE_CODE)))
            .andExpect(jsonPath("$.[*].srcSysCode").value(hasItem(DEFAULT_SRC_SYS_CODE)))
            .andExpect(jsonPath("$.[*].lifecycleStatusCode").value(hasItem(DEFAULT_LIFECYCLE_STATUS_CODE)))
            .andExpect(jsonPath("$.[*].codeColValCode").value(hasItem(DEFAULT_CODE_COL_VAL_CODE)))
            .andExpect(jsonPath("$.[*].descColValText").value(hasItem(DEFAULT_DESC_COL_VAL_TEXT)))
            .andExpect(jsonPath("$.[*].effDate").value(hasItem(DEFAULT_EFF_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].commentText").value(hasItem(DEFAULT_COMMENT_TEXT)))
            .andExpect(jsonPath("$.[*].nameColValName").value(hasItem(DEFAULT_NAME_COL_VAL_NAME)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID)))
            .andExpect(jsonPath("$.[*].updDate").value(hasItem(DEFAULT_UPD_DATE.toString())))
            .andExpect(jsonPath("$.[*].updUserId").value(hasItem(DEFAULT_UPD_USER_ID)));

        // Check, that the count call also returns 1
        restCMFCodesValuesMockMvc.perform(get("/api/cmf-codes-values/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultCMFCodesValuesShouldNotBeFound(String filter) throws Exception {
        restCMFCodesValuesMockMvc.perform(get("/api/cmf-codes-values?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restCMFCodesValuesMockMvc.perform(get("/api/cmf-codes-values/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().string("0"));
    }


    @Test
    @Transactional
    public void getNonExistingCMFCodesValues() throws Exception {
        // Get the cMFCodesValues
        restCMFCodesValuesMockMvc.perform(get("/api/cmf-codes-values/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCMFCodesValues() throws Exception {
        // Initialize the database
        cMFCodesValuesService.save(cMFCodesValues);

        int databaseSizeBeforeUpdate = cMFCodesValuesRepository.findAll().size();

        // Update the cMFCodesValues
        CMFCodesValues updatedCMFCodesValues = cMFCodesValuesRepository.findById(cMFCodesValues.getId()).get();
        // Disconnect from session so that the updates on updatedCMFCodesValues are not directly saved in db
        em.detach(updatedCMFCodesValues);
        updatedCMFCodesValues
            .codeValKey(UPDATED_CODE_VAL_KEY)
            .codeTableKey(UPDATED_CODE_TABLE_KEY)
            .codeClassfctnTypeCode(UPDATED_CODE_CLASSFCTN_TYPE_CODE)
            .srcSysCode(UPDATED_SRC_SYS_CODE)
            .lifecycleStatusCode(UPDATED_LIFECYCLE_STATUS_CODE)
            .codeColValCode(UPDATED_CODE_COL_VAL_CODE)
            .descColValText(UPDATED_DESC_COL_VAL_TEXT)
            .effDate(UPDATED_EFF_DATE)
            .endDate(UPDATED_END_DATE)
            .commentText(UPDATED_COMMENT_TEXT)
            .nameColValName(UPDATED_NAME_COL_VAL_NAME)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .updDate(UPDATED_UPD_DATE)
            .updUserId(UPDATED_UPD_USER_ID);

        restCMFCodesValuesMockMvc.perform(put("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCMFCodesValues)))
            .andExpect(status().isOk());

        // Validate the CMFCodesValues in the database
        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeUpdate);
        CMFCodesValues testCMFCodesValues = cMFCodesValuesList.get(cMFCodesValuesList.size() - 1);
        assertThat(testCMFCodesValues.getCodeValKey()).isEqualTo(UPDATED_CODE_VAL_KEY);
        assertThat(testCMFCodesValues.getCodeTableKey()).isEqualTo(UPDATED_CODE_TABLE_KEY);
        assertThat(testCMFCodesValues.getCodeClassfctnTypeCode()).isEqualTo(UPDATED_CODE_CLASSFCTN_TYPE_CODE);
        assertThat(testCMFCodesValues.getSrcSysCode()).isEqualTo(UPDATED_SRC_SYS_CODE);
        assertThat(testCMFCodesValues.getLifecycleStatusCode()).isEqualTo(UPDATED_LIFECYCLE_STATUS_CODE);
        assertThat(testCMFCodesValues.getCodeColValCode()).isEqualTo(UPDATED_CODE_COL_VAL_CODE);
        assertThat(testCMFCodesValues.getDescColValText()).isEqualTo(UPDATED_DESC_COL_VAL_TEXT);
        assertThat(testCMFCodesValues.getEffDate()).isEqualTo(UPDATED_EFF_DATE);
        assertThat(testCMFCodesValues.getEndDate()).isEqualTo(UPDATED_END_DATE);
        assertThat(testCMFCodesValues.getCommentText()).isEqualTo(UPDATED_COMMENT_TEXT);
        assertThat(testCMFCodesValues.getNameColValName()).isEqualTo(UPDATED_NAME_COL_VAL_NAME);
        assertThat(testCMFCodesValues.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testCMFCodesValues.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testCMFCodesValues.getUpdDate()).isEqualTo(UPDATED_UPD_DATE);
        assertThat(testCMFCodesValues.getUpdUserId()).isEqualTo(UPDATED_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingCMFCodesValues() throws Exception {
        int databaseSizeBeforeUpdate = cMFCodesValuesRepository.findAll().size();

        // Create the CMFCodesValues

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCMFCodesValuesMockMvc.perform(put("/api/cmf-codes-values")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodesValues)))
            .andExpect(status().isBadRequest());

        // Validate the CMFCodesValues in the database
        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCMFCodesValues() throws Exception {
        // Initialize the database
        cMFCodesValuesService.save(cMFCodesValues);

        int databaseSizeBeforeDelete = cMFCodesValuesRepository.findAll().size();

        // Delete the cMFCodesValues
        restCMFCodesValuesMockMvc.perform(delete("/api/cmf-codes-values/{id}", cMFCodesValues.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database is empty
        List<CMFCodesValues> cMFCodesValuesList = cMFCodesValuesRepository.findAll();
        assertThat(cMFCodesValuesList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CMFCodesValues.class);
        CMFCodesValues cMFCodesValues1 = new CMFCodesValues();
        cMFCodesValues1.setId(1L);
        CMFCodesValues cMFCodesValues2 = new CMFCodesValues();
        cMFCodesValues2.setId(cMFCodesValues1.getId());
        assertThat(cMFCodesValues1).isEqualTo(cMFCodesValues2);
        cMFCodesValues2.setId(2L);
        assertThat(cMFCodesValues1).isNotEqualTo(cMFCodesValues2);
        cMFCodesValues1.setId(null);
        assertThat(cMFCodesValues1).isNotEqualTo(cMFCodesValues2);
    }
}
