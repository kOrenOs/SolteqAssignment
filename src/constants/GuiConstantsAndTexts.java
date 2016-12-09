package constants;

/*
 * Class used for storing constants, component identificator and item texts. This static texts are used for form creating.
 * There are also output texts for every database error result
 */

public class GuiConstantsAndTexts {
	public static final String BUTON_LABEL_ADD_DATA = "Add data";
	public static final String BUTON_LABEL_SEARCH_DATA = "Search data";
	public static final String BUTON_LABEL_EXPORT_DATA = "Export data";
	public static final String BUTON_LABEL_DELETE_EDIT_DATA = "Delete/Edit data";
	public static final String BUTON_LABEL_CALCULATION_FUNCTIONS = "Calculation functions";

	public static final String TEXTBOX_REPRESENTATIVE_NAME_STAFF_PERSONAL_ID = "Personal ID";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_STAFF_FIRST_NAME = "FirstName";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_STAFF_SURNAME = "Surname";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_STAFF_CITY = "City";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_STAFF_POSTAL_CODE = "PostalCode";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_STAFF_STREET = "Street";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_STAFF_HOUSE_NUMBER = "HouseNumber";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_STAFF_PHONE = "Phone";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_STAFF_EMAIL = "Email";

	public static final String TEXTBOX_REPRESENTATIVE_NAME_SALARY_STAFF_MEMBER = "StaffMemberID";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_SALARY_MONTH = "SalaryMonth";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_SALARY_YEAR = "SalaryYear";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_SALARY_SUM = "SalarySum";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY = "ExtraSalary";

	public static final String TEXTBOX_REPRESENTATIVE_NAME_ORDER_BY = "OrderByField";
	
	public static final String TEXTBOX_REPRESENTATIVE_NAME_AVERAGE_YEAR = "year";
	public static final String TEXTBOX_REPRESENTATIVE_NAME_AVERAGE_MONTH = "month";

	public static final String DB_OPERATION_SUCCESS_TEXT = "Operation successful."; // ok
	public static final String DB_OPERATION_ERROR_NULL_PROPERTY_TEXT = "Null value on not null property."; // PropertyValueException
	public static final String DB_OPERATION_ERROR_ENTITY_NOT_EXIST_TEXT = "Reference entity not exist."; // illegalArgumentException
	public static final String DB_OPERATION_ERROR_DUPLICITE_TEXT = "Primary key duplicity"; // ConstraintViolationException
	public static final String DB_OPERATION_ERROR_UNKNOWN_TEXT = "Unknown error."; // Exception
	
	public static final String CONTROLLER_OPERATION_ERROR = "Format exception";
	
	public static final String ACTION_ADD_STAFF_PERSON_DATA_RESULT = "Staff person was inserted. His id is %s.";
	public static final String ACTION_ADD_SALARY_DATA_RESULT = "Salary was inserted. His id is %s, month %s, year %s.";
	public static final String ACTION_DELETE_STAFF_PERSON_DATA_RESULT = "Staff person was deleted.";
	public static final String ACTION_DELETE_SALARY_DATA_RESULT = "Salary was deleted.";
	public static final String ACTION_EDIT_STAFF_PERSON_DATA_RESULT = "Staff person was edited.";
	public static final String ACTION_EDIT_SALARY_DATA_RESULT = "Salary was edited.";
	
	public static final String FUNCTION_RESULT_AVERAGE_SALARY = "Average salary in choosen term is %s.";
	public static final String FUNCTION_ERROR_AVERAGE_SALARY = "Calculation was not successful.";
}
