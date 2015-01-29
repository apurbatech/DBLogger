/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xbrl.server.dal;

/**
 *
 * @author Yousuf Zaman
 */

public interface DefaultProperties
{
    /**
     * Project Table Names
     */
    String USER_INFO_TBL                = "user_info";
    String PROJECT_INFO_TBL             = "project_info";
    String PROFILE_INFO_TBL             = "profile_info";
    String FILE_INFO_TBL                = "file_info";
    String ELEMENT_INFO_TBL             = "element_info";
    String BASE_ELEMENT_INFO_TBL        = "base_element_info";
    String BASE_ELEMENT_DETAIL_INFO_TBL = "base_element_detail_info";
    String PROJECT_TAXONOMY_MAP_TBL     = "project_taxonomy_map";
    String TAXONOMY_ELEMENT_INFO_TBL    = "taxonomy_element_info";
    String ACCESS_LOG_TBL               = "access_log";
    String TAXONOMY_FILE_INFO_TBL       = "taxonomy_file_info";
    String MISCELLANEOUS_TYPES_TBL      = "misc_types";
    String TAXONOMY_TABLE_MAP_TBL       = "taxonomy_table_map";
    String TAXONOMY_DETAIL_INFO_TBL     = "taxonomy_detail_info";
    String TAXONOMY_ROLE_INFO_TBL       = "taxonomy_role_info";
    String TEMPLATE_INFO_TBL            = "template_info";
    String PROJECT_UNIT_INFO_TBL        = "project_unit_info";

   //Project module
    String USER_TYPE_INFO_TBL           = "user_type_info";
    String SUBSCRIBER_INFO_TBL          = "subscriber_info";
    String SUBSCRIBER_USER_INFO_TBL     = "subscriber_user_info";
    String PREFERENCE_TBL               = "preference";
    String COMPANY_INFO_TBL             = "company_info";
    //String NEW_PROJECT_INFO_TBL       = "new_project_info";

    //Update of Project Module with super admin and dynamic preference 4 November, 2010
    String INITIAL_PREFERENCE_TBL       = "initial_preference";
    //String DYNAMIC_DIRECTORY_INFO_TBL   = "dynamic_directory_info";
    String FILE_TYPE_TBL                = "file_type";
    String QUARTER_TYPE_TBL             = "quarter_type";
    String YEAR_INFO_TBL                = "year_info";

    String EXCEL_INFO_TBL               = "excel_info";
    String PROOF_INFO_TBL               = "proof_info";
    String PROOF_RECIPIENT_INFO_TBL     = "proof_recipient_info";
    String PROOF_FILE_INFO_TBL          = "proof_file_info";
    String PREVIEW_INFO_TBL             = "preview_info";

    String BILL_INFO_TBL                = "bill_info";
    String PRICE_TYPE_INFO_TBL          = "price_type_info";
    String ACCESS_MODULE_TBL            = "access_module";

    String IP_INFO_TBL                  = "ip_info";
    String SIC_CODES_TBL                = "sic_codes";
    String LANGUAGE_CODES_TBL           = "language_codes";
    String COMPANY_BILL_INFO_TBL        = "company_bill_info";
    String EDGAR_FILING_HISTORY_INFO_TBL        = "edgar_filing_history_info";
    String TAXONOMY_ID_INFO_TBL         = "taxonomy_id_info";
    String PROJECT_CATEGORY_INFO_TBL    = "project_category_info";
    String UNIT_DATA_TYPE_INFO_TBL      = "unit_data_type_info";
    String SERIES_INFO_TBL              = "series_info";
    String CLASS_INFO_TBL               = "class_info";
    String USER_PRICE_INFO_TBL          = "user_price_info";
    String COMPANY_PRICE_INFO_TBL       = "company_price_info";

    /**
     * Project Sequence Names
     */
    String SEQ_USER_INFO_TBL            = "user_info_user_id_seq";
    String SEQ_PROJECT_INFO_TBL         = "project_info_project_id_seq";
    String SEQ_PROFILE_INFO_TBL         = "profile_info_profile_id_seq";
    String SEQ_FILE_INFO_TBL            = "file_info_file_id_seq";
    String SEQ_ELEMENT_INFO_TBL         = "element_info_element_id_seq";
    String SEQ_ELEMENT_ROOT_INFO_TBL    = "element_root_info_item_id_seq";
    String SEQ_PROJECT_TAXONOMY_MAP_TBL = "project_taxonomy_map_map_id_seq";
    String SEQ_TAXONOMY_ELEMENT_INFO_TBL= "taxonomy_element_info_element_id_seq";
    String SEQ_ACCESS_LOG_TBL           = "access_log_access_id_seq";
    String SEQ_TAXONOMY_FILE_INFO_TBL   = "taxonomy_file_info_file_id_seq";
    String SEQ_MISCELLANEOUS_TYPES_TBL  = "misc_types_type_id_seq";
    String SEQ_TAXONOMY_TABLE_MAP_TBL   = "taxonomy_table_map_map_id_seq";
    String SEQ_TAXONOMY_DETAIL_INFO_TBL = "taxonomy_detail_info_detail_id_seq";
    String SEQ_TAXONOMY_ROLE_INFO_TBL   = "taxonomy_role_info_role_id_seq";
    String SEQ_TEMPLATE_INFO_TBL        = "template_info_template_id_seq";
    String SEQ_PROJECT_UNIT_INFO_TBL    = "project_unit_info_unit_id_seq";

    //Project Module
    String SEQ_PREFERENCE_TBL           = "preference_pref_id_seq";
    String SEQ_COMPANY_INFO_TBL         = "company_id_seq";
    //String SEQ_NEW_PROJECT_INFO_TBL     = "new_project_id_seq";

    //Update of Project Module with super admin and dynamic preference 4 November, 2010
    String SEQ_INITIAL_PREFERENCE_TBL     = "initial_preference_id_seq";
    //String SEQ_DYNAMIC_DIRECTORY_INFO_TBL = "dynamic_derectory_id_seq";
    String SEQ_FILE_TYPE_TBL            = "file_type_id_seq";
    String SEQ_QUARTER_TYPE_TBL         = "quarter_type_id_seq";
    String SEQ_YEAR_INFO_TBL            = "year_id_seq";

    String SEQ_EXCEL_INFO_TBL           = "excel_info_id_seq";
    String SEQ_PROOF_INFO_TBL           = "proof_id_seq";
    String SEQ_PROOF_RECIPIENT_INFO_TBL = "proof_recipient_id_seq";
    String SEQ_PROOF_FILE_INFO_TBL      = "proof_file_id_seq";
    String SEQ_PREVIEW_INFO_TBL         = "preview_info_id_seq";

    String SEQ_BILL_INFO_TBL            = "bill_id_seq";
    String SEQ_PRICE_INFO_TBL           = "price_type_id_seq";
    String SEQ_ACCESS_MODULE_TBL        = "access_module_id_seq";

    String SEQ_IP_INFO_TBL              = "ip_id_seq";
    String SEQ_SIC_CODES_TBL            = "sic_codes_id_seq";
    String SEQ_LANGUAGE_CODE_TBL        = "language_codes_id_seq";
    String SEQ_COMPANY_BILL_INFO_TBL    = "company_bill_id_seq";
    String SEQ_EDGAR_FILING_HISTORY_INFO_TBL    = "edgar_filing_history_info_history_id_seq";

    String SEQ_SERIES_INFO_TBL = "series_info_id_seq";
    String SEQ_CLASS_INFO_TBL = "class_info_id_seq";
    String SEQ_USER_PRICE_INFO_TBL = "user_price_info_user_price_id_seq";
    String SEQ_COMPANY_PRICE_INFO_TBL = "company_price_info_company_price_id_seq";
    /*
     * Project Error Types
     */
    String SAVE_SUCCESS_MSG             = "SAVE_SUCCESS";
    String SAVE_FAILED_MSG              = "SAVE_FAILED";
    String UPDATE_SUCCESS_MSG           = "UPDATE_SUCCESS";
    String UPDATE_FAILED_MSG            = "UPDATE_FAILED";
    String SQL_EXCEPTION_MSG            = "SQL_EXCEPTION";
    String PROCESSING_ERROR_MSG         = "PROCESSING_ERROR";
    String DELETE_SUCCESS_MSG           = "DELETE_SUCCESS";
    String DELETE_FAILED_MSG            = "DELETE_FAILED";

    String DB_DUMP_DELIMITER            = "|";
    String MISC_UNIT_DATA_TYPE          = "unit_data_type";
}
