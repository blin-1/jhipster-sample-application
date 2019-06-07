package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;
import io.github.jhipster.application.domain.CMFCodes;
import io.github.jhipster.application.repository.CMFCodesRepository;
import io.github.jhipster.application.service.CMFCodesService;
import io.github.jhipster.application.web.rest.errors.ExceptionTranslator;
import io.github.jhipster.application.service.dto.CMFCodesCriteria;
import io.github.jhipster.application.service.CMFCodesQueryService;

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
 * Integration tests for the {@Link CMFCodesResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class CMFCodesResourceIT {

    private static final BigDecimal DEFAULT_CODE_TABLE_KEY = new BigDecimal(1);
    private static final BigDecimal UPDATED_CODE_TABLE_KEY = new BigDecimal(2);

    private static final String DEFAULT_CODE_ENTY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CODE_ENTY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_ENTY_DEFINITION_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_CODE_ENTY_DEFINITION_TEXT = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_TABLE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CODE_TABLE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_ATTRB_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CODE_ATTRB_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DESC_ATTRB_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DESC_ATTRB_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_COL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CODE_COL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DESC_COL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DESC_COL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENT_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT_TEXT = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_ATTRB_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME_ATTRB_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_COL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME_COL_NAME = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_CREATE_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_USER_ID = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPD_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPD_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPD_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_UPD_USER_ID = "BBBBBBBBBB";

    @Autowired
    private CMFCodesRepository cMFCodesRepository;

    @Autowired
    private CMFCodesService cMFCodesService;

    @Autowired
    private CMFCodesQueryService cMFCodesQueryService;

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

    private MockMvc restCMFCodesMockMvc;

    private CMFCodes cMFCodes;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CMFCodesResource cMFCodesResource = new CMFCodesResource(cMFCodesService, cMFCodesQueryService);
        this.restCMFCodesMockMvc = MockMvcBuilders.standaloneSetup(cMFCodesResource)
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
    public static CMFCodes createEntity(EntityManager em) {
        CMFCodes cMFCodes = new CMFCodes()
            .codeTableKey(DEFAULT_CODE_TABLE_KEY)
            .codeEntyName(DEFAULT_CODE_ENTY_NAME)
            .codeEntyDefinitionText(DEFAULT_CODE_ENTY_DEFINITION_TEXT)
            .codeTableName(DEFAULT_CODE_TABLE_NAME)
            .codeAttrbName(DEFAULT_CODE_ATTRB_NAME)
            .descAttrbName(DEFAULT_DESC_ATTRB_NAME)
            .codeColName(DEFAULT_CODE_COL_NAME)
            .descColName(DEFAULT_DESC_COL_NAME)
            .commentText(DEFAULT_COMMENT_TEXT)
            .nameAttrbName(DEFAULT_NAME_ATTRB_NAME)
            .nameColName(DEFAULT_NAME_COL_NAME)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .updDate(DEFAULT_UPD_DATE)
            .updUserId(DEFAULT_UPD_USER_ID);
        return cMFCodes;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CMFCodes createUpdatedEntity(EntityManager em) {
        CMFCodes cMFCodes = new CMFCodes()
            .codeTableKey(UPDATED_CODE_TABLE_KEY)
            .codeEntyName(UPDATED_CODE_ENTY_NAME)
            .codeEntyDefinitionText(UPDATED_CODE_ENTY_DEFINITION_TEXT)
            .codeTableName(UPDATED_CODE_TABLE_NAME)
            .codeAttrbName(UPDATED_CODE_ATTRB_NAME)
            .descAttrbName(UPDATED_DESC_ATTRB_NAME)
            .codeColName(UPDATED_CODE_COL_NAME)
            .descColName(UPDATED_DESC_COL_NAME)
            .commentText(UPDATED_COMMENT_TEXT)
            .nameAttrbName(UPDATED_NAME_ATTRB_NAME)
            .nameColName(UPDATED_NAME_COL_NAME)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .updDate(UPDATED_UPD_DATE)
            .updUserId(UPDATED_UPD_USER_ID);
        return cMFCodes;
    }

    @BeforeEach
    public void initTest() {
        cMFCodes = createEntity(em);
    }

    @Test
    @Transactional
    public void createCMFCodes() throws Exception {
        int databaseSizeBeforeCreate = cMFCodesRepository.findAll().size();

        // Create the CMFCodes
        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isCreated());

        // Validate the CMFCodes in the database
        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeCreate + 1);
        CMFCodes testCMFCodes = cMFCodesList.get(cMFCodesList.size() - 1);
        assertThat(testCMFCodes.getCodeTableKey()).isEqualTo(DEFAULT_CODE_TABLE_KEY);
        assertThat(testCMFCodes.getCodeEntyName()).isEqualTo(DEFAULT_CODE_ENTY_NAME);
        assertThat(testCMFCodes.getCodeEntyDefinitionText()).isEqualTo(DEFAULT_CODE_ENTY_DEFINITION_TEXT);
        assertThat(testCMFCodes.getCodeTableName()).isEqualTo(DEFAULT_CODE_TABLE_NAME);
        assertThat(testCMFCodes.getCodeAttrbName()).isEqualTo(DEFAULT_CODE_ATTRB_NAME);
        assertThat(testCMFCodes.getDescAttrbName()).isEqualTo(DEFAULT_DESC_ATTRB_NAME);
        assertThat(testCMFCodes.getCodeColName()).isEqualTo(DEFAULT_CODE_COL_NAME);
        assertThat(testCMFCodes.getDescColName()).isEqualTo(DEFAULT_DESC_COL_NAME);
        assertThat(testCMFCodes.getCommentText()).isEqualTo(DEFAULT_COMMENT_TEXT);
        assertThat(testCMFCodes.getNameAttrbName()).isEqualTo(DEFAULT_NAME_ATTRB_NAME);
        assertThat(testCMFCodes.getNameColName()).isEqualTo(DEFAULT_NAME_COL_NAME);
        assertThat(testCMFCodes.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testCMFCodes.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testCMFCodes.getUpdDate()).isEqualTo(DEFAULT_UPD_DATE);
        assertThat(testCMFCodes.getUpdUserId()).isEqualTo(DEFAULT_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void createCMFCodesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = cMFCodesRepository.findAll().size();

        // Create the CMFCodes with an existing ID
        cMFCodes.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        // Validate the CMFCodes in the database
        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkCodeTableKeyIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setCodeTableKey(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCodeEntyNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setCodeEntyName(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCodeEntyDefinitionTextIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setCodeEntyDefinitionText(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCodeTableNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setCodeTableName(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCodeAttrbNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setCodeAttrbName(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDescAttrbNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setDescAttrbName(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCodeColNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setCodeColName(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDescColNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setDescColName(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCommentTextIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setCommentText(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNameAttrbNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setNameAttrbName(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNameColNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setNameColName(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateUserIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setCreateUserId(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUpdUserIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = cMFCodesRepository.findAll().size();
        // set the field null
        cMFCodes.setUpdUserId(null);

        // Create the CMFCodes, which fails.

        restCMFCodesMockMvc.perform(post("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllCMFCodes() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList
        restCMFCodesMockMvc.perform(get("/api/cmf-codes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cMFCodes.getId().intValue())))
            .andExpect(jsonPath("$.[*].codeTableKey").value(hasItem(DEFAULT_CODE_TABLE_KEY.intValue())))
            .andExpect(jsonPath("$.[*].codeEntyName").value(hasItem(DEFAULT_CODE_ENTY_NAME.toString())))
            .andExpect(jsonPath("$.[*].codeEntyDefinitionText").value(hasItem(DEFAULT_CODE_ENTY_DEFINITION_TEXT.toString())))
            .andExpect(jsonPath("$.[*].codeTableName").value(hasItem(DEFAULT_CODE_TABLE_NAME.toString())))
            .andExpect(jsonPath("$.[*].codeAttrbName").value(hasItem(DEFAULT_CODE_ATTRB_NAME.toString())))
            .andExpect(jsonPath("$.[*].descAttrbName").value(hasItem(DEFAULT_DESC_ATTRB_NAME.toString())))
            .andExpect(jsonPath("$.[*].codeColName").value(hasItem(DEFAULT_CODE_COL_NAME.toString())))
            .andExpect(jsonPath("$.[*].descColName").value(hasItem(DEFAULT_DESC_COL_NAME.toString())))
            .andExpect(jsonPath("$.[*].commentText").value(hasItem(DEFAULT_COMMENT_TEXT.toString())))
            .andExpect(jsonPath("$.[*].nameAttrbName").value(hasItem(DEFAULT_NAME_ATTRB_NAME.toString())))
            .andExpect(jsonPath("$.[*].nameColName").value(hasItem(DEFAULT_NAME_COL_NAME.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].updDate").value(hasItem(DEFAULT_UPD_DATE.toString())))
            .andExpect(jsonPath("$.[*].updUserId").value(hasItem(DEFAULT_UPD_USER_ID.toString())));
    }
    
    @Test
    @Transactional
    public void getCMFCodes() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get the cMFCodes
        restCMFCodesMockMvc.perform(get("/api/cmf-codes/{id}", cMFCodes.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(cMFCodes.getId().intValue()))
            .andExpect(jsonPath("$.codeTableKey").value(DEFAULT_CODE_TABLE_KEY.intValue()))
            .andExpect(jsonPath("$.codeEntyName").value(DEFAULT_CODE_ENTY_NAME.toString()))
            .andExpect(jsonPath("$.codeEntyDefinitionText").value(DEFAULT_CODE_ENTY_DEFINITION_TEXT.toString()))
            .andExpect(jsonPath("$.codeTableName").value(DEFAULT_CODE_TABLE_NAME.toString()))
            .andExpect(jsonPath("$.codeAttrbName").value(DEFAULT_CODE_ATTRB_NAME.toString()))
            .andExpect(jsonPath("$.descAttrbName").value(DEFAULT_DESC_ATTRB_NAME.toString()))
            .andExpect(jsonPath("$.codeColName").value(DEFAULT_CODE_COL_NAME.toString()))
            .andExpect(jsonPath("$.descColName").value(DEFAULT_DESC_COL_NAME.toString()))
            .andExpect(jsonPath("$.commentText").value(DEFAULT_COMMENT_TEXT.toString()))
            .andExpect(jsonPath("$.nameAttrbName").value(DEFAULT_NAME_ATTRB_NAME.toString()))
            .andExpect(jsonPath("$.nameColName").value(DEFAULT_NAME_COL_NAME.toString()))
            .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.toString()))
            .andExpect(jsonPath("$.updDate").value(DEFAULT_UPD_DATE.toString()))
            .andExpect(jsonPath("$.updUserId").value(DEFAULT_UPD_USER_ID.toString()));
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeTableKeyIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeTableKey equals to DEFAULT_CODE_TABLE_KEY
        defaultCMFCodesShouldBeFound("codeTableKey.equals=" + DEFAULT_CODE_TABLE_KEY);

        // Get all the cMFCodesList where codeTableKey equals to UPDATED_CODE_TABLE_KEY
        defaultCMFCodesShouldNotBeFound("codeTableKey.equals=" + UPDATED_CODE_TABLE_KEY);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeTableKeyIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeTableKey in DEFAULT_CODE_TABLE_KEY or UPDATED_CODE_TABLE_KEY
        defaultCMFCodesShouldBeFound("codeTableKey.in=" + DEFAULT_CODE_TABLE_KEY + "," + UPDATED_CODE_TABLE_KEY);

        // Get all the cMFCodesList where codeTableKey equals to UPDATED_CODE_TABLE_KEY
        defaultCMFCodesShouldNotBeFound("codeTableKey.in=" + UPDATED_CODE_TABLE_KEY);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeTableKeyIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeTableKey is not null
        defaultCMFCodesShouldBeFound("codeTableKey.specified=true");

        // Get all the cMFCodesList where codeTableKey is null
        defaultCMFCodesShouldNotBeFound("codeTableKey.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeEntyNameIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeEntyName equals to DEFAULT_CODE_ENTY_NAME
        defaultCMFCodesShouldBeFound("codeEntyName.equals=" + DEFAULT_CODE_ENTY_NAME);

        // Get all the cMFCodesList where codeEntyName equals to UPDATED_CODE_ENTY_NAME
        defaultCMFCodesShouldNotBeFound("codeEntyName.equals=" + UPDATED_CODE_ENTY_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeEntyNameIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeEntyName in DEFAULT_CODE_ENTY_NAME or UPDATED_CODE_ENTY_NAME
        defaultCMFCodesShouldBeFound("codeEntyName.in=" + DEFAULT_CODE_ENTY_NAME + "," + UPDATED_CODE_ENTY_NAME);

        // Get all the cMFCodesList where codeEntyName equals to UPDATED_CODE_ENTY_NAME
        defaultCMFCodesShouldNotBeFound("codeEntyName.in=" + UPDATED_CODE_ENTY_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeEntyNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeEntyName is not null
        defaultCMFCodesShouldBeFound("codeEntyName.specified=true");

        // Get all the cMFCodesList where codeEntyName is null
        defaultCMFCodesShouldNotBeFound("codeEntyName.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeEntyDefinitionTextIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeEntyDefinitionText equals to DEFAULT_CODE_ENTY_DEFINITION_TEXT
        defaultCMFCodesShouldBeFound("codeEntyDefinitionText.equals=" + DEFAULT_CODE_ENTY_DEFINITION_TEXT);

        // Get all the cMFCodesList where codeEntyDefinitionText equals to UPDATED_CODE_ENTY_DEFINITION_TEXT
        defaultCMFCodesShouldNotBeFound("codeEntyDefinitionText.equals=" + UPDATED_CODE_ENTY_DEFINITION_TEXT);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeEntyDefinitionTextIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeEntyDefinitionText in DEFAULT_CODE_ENTY_DEFINITION_TEXT or UPDATED_CODE_ENTY_DEFINITION_TEXT
        defaultCMFCodesShouldBeFound("codeEntyDefinitionText.in=" + DEFAULT_CODE_ENTY_DEFINITION_TEXT + "," + UPDATED_CODE_ENTY_DEFINITION_TEXT);

        // Get all the cMFCodesList where codeEntyDefinitionText equals to UPDATED_CODE_ENTY_DEFINITION_TEXT
        defaultCMFCodesShouldNotBeFound("codeEntyDefinitionText.in=" + UPDATED_CODE_ENTY_DEFINITION_TEXT);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeEntyDefinitionTextIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeEntyDefinitionText is not null
        defaultCMFCodesShouldBeFound("codeEntyDefinitionText.specified=true");

        // Get all the cMFCodesList where codeEntyDefinitionText is null
        defaultCMFCodesShouldNotBeFound("codeEntyDefinitionText.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeTableNameIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeTableName equals to DEFAULT_CODE_TABLE_NAME
        defaultCMFCodesShouldBeFound("codeTableName.equals=" + DEFAULT_CODE_TABLE_NAME);

        // Get all the cMFCodesList where codeTableName equals to UPDATED_CODE_TABLE_NAME
        defaultCMFCodesShouldNotBeFound("codeTableName.equals=" + UPDATED_CODE_TABLE_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeTableNameIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeTableName in DEFAULT_CODE_TABLE_NAME or UPDATED_CODE_TABLE_NAME
        defaultCMFCodesShouldBeFound("codeTableName.in=" + DEFAULT_CODE_TABLE_NAME + "," + UPDATED_CODE_TABLE_NAME);

        // Get all the cMFCodesList where codeTableName equals to UPDATED_CODE_TABLE_NAME
        defaultCMFCodesShouldNotBeFound("codeTableName.in=" + UPDATED_CODE_TABLE_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeTableNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeTableName is not null
        defaultCMFCodesShouldBeFound("codeTableName.specified=true");

        // Get all the cMFCodesList where codeTableName is null
        defaultCMFCodesShouldNotBeFound("codeTableName.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeAttrbNameIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeAttrbName equals to DEFAULT_CODE_ATTRB_NAME
        defaultCMFCodesShouldBeFound("codeAttrbName.equals=" + DEFAULT_CODE_ATTRB_NAME);

        // Get all the cMFCodesList where codeAttrbName equals to UPDATED_CODE_ATTRB_NAME
        defaultCMFCodesShouldNotBeFound("codeAttrbName.equals=" + UPDATED_CODE_ATTRB_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeAttrbNameIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeAttrbName in DEFAULT_CODE_ATTRB_NAME or UPDATED_CODE_ATTRB_NAME
        defaultCMFCodesShouldBeFound("codeAttrbName.in=" + DEFAULT_CODE_ATTRB_NAME + "," + UPDATED_CODE_ATTRB_NAME);

        // Get all the cMFCodesList where codeAttrbName equals to UPDATED_CODE_ATTRB_NAME
        defaultCMFCodesShouldNotBeFound("codeAttrbName.in=" + UPDATED_CODE_ATTRB_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeAttrbNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeAttrbName is not null
        defaultCMFCodesShouldBeFound("codeAttrbName.specified=true");

        // Get all the cMFCodesList where codeAttrbName is null
        defaultCMFCodesShouldNotBeFound("codeAttrbName.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByDescAttrbNameIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where descAttrbName equals to DEFAULT_DESC_ATTRB_NAME
        defaultCMFCodesShouldBeFound("descAttrbName.equals=" + DEFAULT_DESC_ATTRB_NAME);

        // Get all the cMFCodesList where descAttrbName equals to UPDATED_DESC_ATTRB_NAME
        defaultCMFCodesShouldNotBeFound("descAttrbName.equals=" + UPDATED_DESC_ATTRB_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByDescAttrbNameIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where descAttrbName in DEFAULT_DESC_ATTRB_NAME or UPDATED_DESC_ATTRB_NAME
        defaultCMFCodesShouldBeFound("descAttrbName.in=" + DEFAULT_DESC_ATTRB_NAME + "," + UPDATED_DESC_ATTRB_NAME);

        // Get all the cMFCodesList where descAttrbName equals to UPDATED_DESC_ATTRB_NAME
        defaultCMFCodesShouldNotBeFound("descAttrbName.in=" + UPDATED_DESC_ATTRB_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByDescAttrbNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where descAttrbName is not null
        defaultCMFCodesShouldBeFound("descAttrbName.specified=true");

        // Get all the cMFCodesList where descAttrbName is null
        defaultCMFCodesShouldNotBeFound("descAttrbName.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeColNameIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeColName equals to DEFAULT_CODE_COL_NAME
        defaultCMFCodesShouldBeFound("codeColName.equals=" + DEFAULT_CODE_COL_NAME);

        // Get all the cMFCodesList where codeColName equals to UPDATED_CODE_COL_NAME
        defaultCMFCodesShouldNotBeFound("codeColName.equals=" + UPDATED_CODE_COL_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeColNameIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeColName in DEFAULT_CODE_COL_NAME or UPDATED_CODE_COL_NAME
        defaultCMFCodesShouldBeFound("codeColName.in=" + DEFAULT_CODE_COL_NAME + "," + UPDATED_CODE_COL_NAME);

        // Get all the cMFCodesList where codeColName equals to UPDATED_CODE_COL_NAME
        defaultCMFCodesShouldNotBeFound("codeColName.in=" + UPDATED_CODE_COL_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCodeColNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where codeColName is not null
        defaultCMFCodesShouldBeFound("codeColName.specified=true");

        // Get all the cMFCodesList where codeColName is null
        defaultCMFCodesShouldNotBeFound("codeColName.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByDescColNameIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where descColName equals to DEFAULT_DESC_COL_NAME
        defaultCMFCodesShouldBeFound("descColName.equals=" + DEFAULT_DESC_COL_NAME);

        // Get all the cMFCodesList where descColName equals to UPDATED_DESC_COL_NAME
        defaultCMFCodesShouldNotBeFound("descColName.equals=" + UPDATED_DESC_COL_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByDescColNameIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where descColName in DEFAULT_DESC_COL_NAME or UPDATED_DESC_COL_NAME
        defaultCMFCodesShouldBeFound("descColName.in=" + DEFAULT_DESC_COL_NAME + "," + UPDATED_DESC_COL_NAME);

        // Get all the cMFCodesList where descColName equals to UPDATED_DESC_COL_NAME
        defaultCMFCodesShouldNotBeFound("descColName.in=" + UPDATED_DESC_COL_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByDescColNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where descColName is not null
        defaultCMFCodesShouldBeFound("descColName.specified=true");

        // Get all the cMFCodesList where descColName is null
        defaultCMFCodesShouldNotBeFound("descColName.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCommentTextIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where commentText equals to DEFAULT_COMMENT_TEXT
        defaultCMFCodesShouldBeFound("commentText.equals=" + DEFAULT_COMMENT_TEXT);

        // Get all the cMFCodesList where commentText equals to UPDATED_COMMENT_TEXT
        defaultCMFCodesShouldNotBeFound("commentText.equals=" + UPDATED_COMMENT_TEXT);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCommentTextIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where commentText in DEFAULT_COMMENT_TEXT or UPDATED_COMMENT_TEXT
        defaultCMFCodesShouldBeFound("commentText.in=" + DEFAULT_COMMENT_TEXT + "," + UPDATED_COMMENT_TEXT);

        // Get all the cMFCodesList where commentText equals to UPDATED_COMMENT_TEXT
        defaultCMFCodesShouldNotBeFound("commentText.in=" + UPDATED_COMMENT_TEXT);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCommentTextIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where commentText is not null
        defaultCMFCodesShouldBeFound("commentText.specified=true");

        // Get all the cMFCodesList where commentText is null
        defaultCMFCodesShouldNotBeFound("commentText.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByNameAttrbNameIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where nameAttrbName equals to DEFAULT_NAME_ATTRB_NAME
        defaultCMFCodesShouldBeFound("nameAttrbName.equals=" + DEFAULT_NAME_ATTRB_NAME);

        // Get all the cMFCodesList where nameAttrbName equals to UPDATED_NAME_ATTRB_NAME
        defaultCMFCodesShouldNotBeFound("nameAttrbName.equals=" + UPDATED_NAME_ATTRB_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByNameAttrbNameIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where nameAttrbName in DEFAULT_NAME_ATTRB_NAME or UPDATED_NAME_ATTRB_NAME
        defaultCMFCodesShouldBeFound("nameAttrbName.in=" + DEFAULT_NAME_ATTRB_NAME + "," + UPDATED_NAME_ATTRB_NAME);

        // Get all the cMFCodesList where nameAttrbName equals to UPDATED_NAME_ATTRB_NAME
        defaultCMFCodesShouldNotBeFound("nameAttrbName.in=" + UPDATED_NAME_ATTRB_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByNameAttrbNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where nameAttrbName is not null
        defaultCMFCodesShouldBeFound("nameAttrbName.specified=true");

        // Get all the cMFCodesList where nameAttrbName is null
        defaultCMFCodesShouldNotBeFound("nameAttrbName.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByNameColNameIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where nameColName equals to DEFAULT_NAME_COL_NAME
        defaultCMFCodesShouldBeFound("nameColName.equals=" + DEFAULT_NAME_COL_NAME);

        // Get all the cMFCodesList where nameColName equals to UPDATED_NAME_COL_NAME
        defaultCMFCodesShouldNotBeFound("nameColName.equals=" + UPDATED_NAME_COL_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByNameColNameIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where nameColName in DEFAULT_NAME_COL_NAME or UPDATED_NAME_COL_NAME
        defaultCMFCodesShouldBeFound("nameColName.in=" + DEFAULT_NAME_COL_NAME + "," + UPDATED_NAME_COL_NAME);

        // Get all the cMFCodesList where nameColName equals to UPDATED_NAME_COL_NAME
        defaultCMFCodesShouldNotBeFound("nameColName.in=" + UPDATED_NAME_COL_NAME);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByNameColNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where nameColName is not null
        defaultCMFCodesShouldBeFound("nameColName.specified=true");

        // Get all the cMFCodesList where nameColName is null
        defaultCMFCodesShouldNotBeFound("nameColName.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCreateDateIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where createDate equals to DEFAULT_CREATE_DATE
        defaultCMFCodesShouldBeFound("createDate.equals=" + DEFAULT_CREATE_DATE);

        // Get all the cMFCodesList where createDate equals to UPDATED_CREATE_DATE
        defaultCMFCodesShouldNotBeFound("createDate.equals=" + UPDATED_CREATE_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCreateDateIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where createDate in DEFAULT_CREATE_DATE or UPDATED_CREATE_DATE
        defaultCMFCodesShouldBeFound("createDate.in=" + DEFAULT_CREATE_DATE + "," + UPDATED_CREATE_DATE);

        // Get all the cMFCodesList where createDate equals to UPDATED_CREATE_DATE
        defaultCMFCodesShouldNotBeFound("createDate.in=" + UPDATED_CREATE_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCreateDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where createDate is not null
        defaultCMFCodesShouldBeFound("createDate.specified=true");

        // Get all the cMFCodesList where createDate is null
        defaultCMFCodesShouldNotBeFound("createDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCreateUserIdIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where createUserId equals to DEFAULT_CREATE_USER_ID
        defaultCMFCodesShouldBeFound("createUserId.equals=" + DEFAULT_CREATE_USER_ID);

        // Get all the cMFCodesList where createUserId equals to UPDATED_CREATE_USER_ID
        defaultCMFCodesShouldNotBeFound("createUserId.equals=" + UPDATED_CREATE_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCreateUserIdIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where createUserId in DEFAULT_CREATE_USER_ID or UPDATED_CREATE_USER_ID
        defaultCMFCodesShouldBeFound("createUserId.in=" + DEFAULT_CREATE_USER_ID + "," + UPDATED_CREATE_USER_ID);

        // Get all the cMFCodesList where createUserId equals to UPDATED_CREATE_USER_ID
        defaultCMFCodesShouldNotBeFound("createUserId.in=" + UPDATED_CREATE_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByCreateUserIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where createUserId is not null
        defaultCMFCodesShouldBeFound("createUserId.specified=true");

        // Get all the cMFCodesList where createUserId is null
        defaultCMFCodesShouldNotBeFound("createUserId.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByUpdDateIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where updDate equals to DEFAULT_UPD_DATE
        defaultCMFCodesShouldBeFound("updDate.equals=" + DEFAULT_UPD_DATE);

        // Get all the cMFCodesList where updDate equals to UPDATED_UPD_DATE
        defaultCMFCodesShouldNotBeFound("updDate.equals=" + UPDATED_UPD_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByUpdDateIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where updDate in DEFAULT_UPD_DATE or UPDATED_UPD_DATE
        defaultCMFCodesShouldBeFound("updDate.in=" + DEFAULT_UPD_DATE + "," + UPDATED_UPD_DATE);

        // Get all the cMFCodesList where updDate equals to UPDATED_UPD_DATE
        defaultCMFCodesShouldNotBeFound("updDate.in=" + UPDATED_UPD_DATE);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByUpdDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where updDate is not null
        defaultCMFCodesShouldBeFound("updDate.specified=true");

        // Get all the cMFCodesList where updDate is null
        defaultCMFCodesShouldNotBeFound("updDate.specified=false");
    }

    @Test
    @Transactional
    public void getAllCMFCodesByUpdUserIdIsEqualToSomething() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where updUserId equals to DEFAULT_UPD_USER_ID
        defaultCMFCodesShouldBeFound("updUserId.equals=" + DEFAULT_UPD_USER_ID);

        // Get all the cMFCodesList where updUserId equals to UPDATED_UPD_USER_ID
        defaultCMFCodesShouldNotBeFound("updUserId.equals=" + UPDATED_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByUpdUserIdIsInShouldWork() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where updUserId in DEFAULT_UPD_USER_ID or UPDATED_UPD_USER_ID
        defaultCMFCodesShouldBeFound("updUserId.in=" + DEFAULT_UPD_USER_ID + "," + UPDATED_UPD_USER_ID);

        // Get all the cMFCodesList where updUserId equals to UPDATED_UPD_USER_ID
        defaultCMFCodesShouldNotBeFound("updUserId.in=" + UPDATED_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void getAllCMFCodesByUpdUserIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        cMFCodesRepository.saveAndFlush(cMFCodes);

        // Get all the cMFCodesList where updUserId is not null
        defaultCMFCodesShouldBeFound("updUserId.specified=true");

        // Get all the cMFCodesList where updUserId is null
        defaultCMFCodesShouldNotBeFound("updUserId.specified=false");
    }
    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultCMFCodesShouldBeFound(String filter) throws Exception {
        restCMFCodesMockMvc.perform(get("/api/cmf-codes?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cMFCodes.getId().intValue())))
            .andExpect(jsonPath("$.[*].codeTableKey").value(hasItem(DEFAULT_CODE_TABLE_KEY.intValue())))
            .andExpect(jsonPath("$.[*].codeEntyName").value(hasItem(DEFAULT_CODE_ENTY_NAME)))
            .andExpect(jsonPath("$.[*].codeEntyDefinitionText").value(hasItem(DEFAULT_CODE_ENTY_DEFINITION_TEXT)))
            .andExpect(jsonPath("$.[*].codeTableName").value(hasItem(DEFAULT_CODE_TABLE_NAME)))
            .andExpect(jsonPath("$.[*].codeAttrbName").value(hasItem(DEFAULT_CODE_ATTRB_NAME)))
            .andExpect(jsonPath("$.[*].descAttrbName").value(hasItem(DEFAULT_DESC_ATTRB_NAME)))
            .andExpect(jsonPath("$.[*].codeColName").value(hasItem(DEFAULT_CODE_COL_NAME)))
            .andExpect(jsonPath("$.[*].descColName").value(hasItem(DEFAULT_DESC_COL_NAME)))
            .andExpect(jsonPath("$.[*].commentText").value(hasItem(DEFAULT_COMMENT_TEXT)))
            .andExpect(jsonPath("$.[*].nameAttrbName").value(hasItem(DEFAULT_NAME_ATTRB_NAME)))
            .andExpect(jsonPath("$.[*].nameColName").value(hasItem(DEFAULT_NAME_COL_NAME)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID)))
            .andExpect(jsonPath("$.[*].updDate").value(hasItem(DEFAULT_UPD_DATE.toString())))
            .andExpect(jsonPath("$.[*].updUserId").value(hasItem(DEFAULT_UPD_USER_ID)));

        // Check, that the count call also returns 1
        restCMFCodesMockMvc.perform(get("/api/cmf-codes/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultCMFCodesShouldNotBeFound(String filter) throws Exception {
        restCMFCodesMockMvc.perform(get("/api/cmf-codes?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restCMFCodesMockMvc.perform(get("/api/cmf-codes/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().string("0"));
    }


    @Test
    @Transactional
    public void getNonExistingCMFCodes() throws Exception {
        // Get the cMFCodes
        restCMFCodesMockMvc.perform(get("/api/cmf-codes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCMFCodes() throws Exception {
        // Initialize the database
        cMFCodesService.save(cMFCodes);

        int databaseSizeBeforeUpdate = cMFCodesRepository.findAll().size();

        // Update the cMFCodes
        CMFCodes updatedCMFCodes = cMFCodesRepository.findById(cMFCodes.getId()).get();
        // Disconnect from session so that the updates on updatedCMFCodes are not directly saved in db
        em.detach(updatedCMFCodes);
        updatedCMFCodes
            .codeTableKey(UPDATED_CODE_TABLE_KEY)
            .codeEntyName(UPDATED_CODE_ENTY_NAME)
            .codeEntyDefinitionText(UPDATED_CODE_ENTY_DEFINITION_TEXT)
            .codeTableName(UPDATED_CODE_TABLE_NAME)
            .codeAttrbName(UPDATED_CODE_ATTRB_NAME)
            .descAttrbName(UPDATED_DESC_ATTRB_NAME)
            .codeColName(UPDATED_CODE_COL_NAME)
            .descColName(UPDATED_DESC_COL_NAME)
            .commentText(UPDATED_COMMENT_TEXT)
            .nameAttrbName(UPDATED_NAME_ATTRB_NAME)
            .nameColName(UPDATED_NAME_COL_NAME)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .updDate(UPDATED_UPD_DATE)
            .updUserId(UPDATED_UPD_USER_ID);

        restCMFCodesMockMvc.perform(put("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCMFCodes)))
            .andExpect(status().isOk());

        // Validate the CMFCodes in the database
        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeUpdate);
        CMFCodes testCMFCodes = cMFCodesList.get(cMFCodesList.size() - 1);
        assertThat(testCMFCodes.getCodeTableKey()).isEqualTo(UPDATED_CODE_TABLE_KEY);
        assertThat(testCMFCodes.getCodeEntyName()).isEqualTo(UPDATED_CODE_ENTY_NAME);
        assertThat(testCMFCodes.getCodeEntyDefinitionText()).isEqualTo(UPDATED_CODE_ENTY_DEFINITION_TEXT);
        assertThat(testCMFCodes.getCodeTableName()).isEqualTo(UPDATED_CODE_TABLE_NAME);
        assertThat(testCMFCodes.getCodeAttrbName()).isEqualTo(UPDATED_CODE_ATTRB_NAME);
        assertThat(testCMFCodes.getDescAttrbName()).isEqualTo(UPDATED_DESC_ATTRB_NAME);
        assertThat(testCMFCodes.getCodeColName()).isEqualTo(UPDATED_CODE_COL_NAME);
        assertThat(testCMFCodes.getDescColName()).isEqualTo(UPDATED_DESC_COL_NAME);
        assertThat(testCMFCodes.getCommentText()).isEqualTo(UPDATED_COMMENT_TEXT);
        assertThat(testCMFCodes.getNameAttrbName()).isEqualTo(UPDATED_NAME_ATTRB_NAME);
        assertThat(testCMFCodes.getNameColName()).isEqualTo(UPDATED_NAME_COL_NAME);
        assertThat(testCMFCodes.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testCMFCodes.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testCMFCodes.getUpdDate()).isEqualTo(UPDATED_UPD_DATE);
        assertThat(testCMFCodes.getUpdUserId()).isEqualTo(UPDATED_UPD_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingCMFCodes() throws Exception {
        int databaseSizeBeforeUpdate = cMFCodesRepository.findAll().size();

        // Create the CMFCodes

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCMFCodesMockMvc.perform(put("/api/cmf-codes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cMFCodes)))
            .andExpect(status().isBadRequest());

        // Validate the CMFCodes in the database
        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCMFCodes() throws Exception {
        // Initialize the database
        cMFCodesService.save(cMFCodes);

        int databaseSizeBeforeDelete = cMFCodesRepository.findAll().size();

        // Delete the cMFCodes
        restCMFCodesMockMvc.perform(delete("/api/cmf-codes/{id}", cMFCodes.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database is empty
        List<CMFCodes> cMFCodesList = cMFCodesRepository.findAll();
        assertThat(cMFCodesList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CMFCodes.class);
        CMFCodes cMFCodes1 = new CMFCodes();
        cMFCodes1.setId(1L);
        CMFCodes cMFCodes2 = new CMFCodes();
        cMFCodes2.setId(cMFCodes1.getId());
        assertThat(cMFCodes1).isEqualTo(cMFCodes2);
        cMFCodes2.setId(2L);
        assertThat(cMFCodes1).isNotEqualTo(cMFCodes2);
        cMFCodes1.setId(null);
        assertThat(cMFCodes1).isNotEqualTo(cMFCodes2);
    }
}
