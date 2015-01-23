package com.erecyclingcorps.utils;

/**
 * @author parora
 **/

public class Constants {

	public static final String MODEL_DELTA="10000";
	public static final String MODEL = "api/model/";
	public static final String MODEL_IMAGE_SMALL_BASE_URL = "/small/image";
	public static final String MODEL_IMAGE_LARGE_BASE_URL = "/large/image";
	public static final String ATTRIBUTE_PAGE = "attribute";
	public static final String SUCCESS = "SUCCESS",FAILURE= "FAILURE",RETRY="RETRY";
	public static final String REDIRECT = "redirect:/";
	public static final String FILE_UPLOAD_FAIL = "fileUploadFail";
	public static final String FILE_UPLOAD_SUCCESS = "fileSuccess";
	public static final String PROGRAM_LIST = "programList";
	public static final String ATTRIBUTE_LIST = "attributeList";
	public static final String FILE_NOT_FOUND = "fileNotFound";
	public static final String FILE_ERROR = "fileErrors";
	public static final String PROGRAM_VALUE = "programValue";
	public static final String CUSTOM_ATTRIBUTE = "customattribute";
	public static final String CUSTOM_ATTRIBUTES = "customattributes";
	public static final String MODEL_MAPPING_CSV_BEAN = "modelMappingCsvBeans";
	public static final String INVALID_HEADER_NAMES = "invalidHeadersName";
	public static final String VALID_HEADER_NAMES = "validHeadersName";
	public static final String MODEL_MAPPING_ID = "modelmappingid";
	public static final String MODELCODE = "modelcode";
	public static final String MODELCATEGORY = "manufacturermodelcategory";
	public static final String HOME_PAGE = "home";
	public static final String CELLPHONE = "CELLPHONE";
	public static final String CSV_FILE_TYPE = "text/csv";
	public static final String FILE_EXTENSION = "csv";
	public static final Long CSV_FILE_SIZE = 1024L;
	public static final String SEARCH_ORDER = "searchOrder";
	public static final String SEARCH_ORDER_MODULUS ="(search_order % "+MODEL_DELTA+" ) AS " + SEARCH_ORDER;
	public static final String MODEL_BATCH_SIZE = "6";
	public static final String URL = "url";
	public static final String TOKEN = "token";
	public static final String CacheControl = "Cache-Control";
	public static final String NOCACHE = "no-cache";
	public static final String ALL= "ALL";
	public static final String PROGRAM_ATT= "ATT";
	public static final String PRIORITIZATION_STRING_REGEX = "([a-zA-Z][0-9])|([0-9][A-Za-z])";
	public static final String MANUFACTURERMODEL_MANUFACTURERMODELID = "manufacturerModel.manufacturerModelId", ID = "id",
			MANUFACTURERMODEL_MODELCODE = "manufacturerModel.modelCode", MANUFACTURERMODEL_MODELNUMBER = "manufacturerModel.modelNumber",
			LABEL = "label", PROGRAMCATEGORY = "programCategory", PROGRAMCATEGORY_PROGRAM = "programCategory.program",
			PROGRAMCATEGORY_CATEGORY = "programCategory.category", 
			PROGRAM_PROGRAMNAME = "program.programName", CATEGORY_CODE = "category.code", WHITESPACES = "\\W", WILD_CHAR = ":*", AND = " & ",
			MANUFACTURERMODELID = "manufacturerModelId", MANUFACTURERMODEL_PRODUCT = "manufacturerModel.product",
			MANUFACTURERMODEL_MANUFACTURER = "manufacturerModel.manufacturer", MANUFACTURER = "manufacturer", CARRIER = "carrier",
			MANUFACTURERMODEL_PRODUCTFAMILY = "manufacturerModel.productfamily", MANUFACTURERMODEL = "manufacturerModel",
			FIND_MODEL_TSQUERY_RESTRICTION_STARTS = "modeltextsearch @@ to_tsquery('", FIND_MODEL_TSQUERY_RESTRICTION_ENDS = "')",
			MANUFACTURER_CODE = "manufacturer.code",PRODUCT="product",PRODUCTFAMILY="productfamily",MANUFACTURERMODEL_ACTIVE="manufacturerModel.active";
	public static final String TYPE = "type";
	public final static String PROGRAM = "program", CATEGORY = "category", ATTRIBUTE = "attribute", PRIORITIZATION_TYPE = "prioritizationType",
			PRIORITIZATIONTYPE_PROGRAM_ID = "prioritizationType.program.id", PROGRAM_ID = "program.id",PRIORITIZATIONTYPE_PRIORITY="prioritizationType.priority",
			PRIORITIZATIONTYPE_HIDDEN="prioritizationType.isHidden";

	public static final String MANUFACTURER_DESCRIPTION="manufacturer.description";
	public static final String CONTACTUS_HEADER_PREFIX="HEADER", CONTACTUS_QUESTIONS_PREFIX="QUESTIONS",CONTACTUS_COMMENTS_PREFIX="COMMENTS";
	public static enum ApplicationName {
		TRADE("TRADE"), UPLOAD_PRIORITY("UPLOAD_PRIORITY");
		private String key;

		/**
		 * @param key
		 */
		private ApplicationName(String key) {
			this.key = key;
		}

		/**
		 * @return the key
		 */
		public String getKey() {
			return key;
		}
	}

	public static enum AttributeCode {
		CE_APP_USERNAME("CEAPPUSERNAME"), CE_APP_PASSWORD("CEAPPPASSWORD"), CE_APP_URL("CEAPPAPIURL"),BANNERURL("BANNERURL"),DEVICEWORTHIMAGEURL("DEVICEWORTHIMAGEURL"),BUYBACKIMAGEURL("BUYBACKIMAGEURL");
		private String code;

		/**
		 * @param key
		 */
		private AttributeCode(String key) {
			this.code = key;
		}

		/**
		 * @return the key
		 */
		public String getCode() {
			return code;
		}
	}
	public static final String STRING_BOOLEAN_TRUE="true",STRING_BOOLEAN_FALSE="false";
	
	private Constants(){
	      super();
	}
}
