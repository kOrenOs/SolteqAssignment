package constants;

import java.util.ArrayList;
import java.util.List;

import databaseEntity.EntityDefinition;
import databaseEntity.Salary;
import databaseEntity.Staffperson;

/*
 * Database constants- representative names of database columns, error results texts and list of database entities
 * 
 * Representative names can be used for mapping with form component names
 * 
 * Error results are describe Error on the database side, it is possible to decode this errors with this codes
 * 
 * Database entities list can be use for access to all database entities instances, after creating new database entity
 * is necessary just add new entity to this list
 */
public class DatabaseConstants {
	public static final String DB_REPRESENTATIVE_NAME_STAFF_PERSON_PERSONAL_ID = "Personal ID";
	public static final String DB_REPRESENTATIVE_NAME_STAFF_PERSON_FIRST_NAME = "First name";
	public static final String DB_REPRESENTATIVE_NAME_STAFF_PERSON_SURNAME = "Surname";
	public static final String DB_REPRESENTATIVE_NAME_STAFF_PERSON_CITY = "City";
	public static final String DB_REPRESENTATIVE_NAME_STAFF_PERSON_POSTAL_CODE = "Postal code";
	public static final String DB_REPRESENTATIVE_NAME_STAFF_PERSON_STREET = "Street";
	public static final String DB_REPRESENTATIVE_NAME_STAFF_PERSON_HOUSE_NUMBER = "House number";
	public static final String DB_REPRESENTATIVE_NAME_STAFF_PERSON_PHONE = "Phone";
	public static final String DB_REPRESENTATIVE_NAME_STAFF_PERSON_EMAIL = "E-mail";

	public static final String DB_REPRESENTATIVE_NAME_SALARY_PERSONAL_ID = "Salary owner ID";
	public static final String DB_REPRESENTATIVE_NAME_SALARY_MONTH = "Salary month";
	public static final String DB_REPRESENTATIVE_NAME_SALARY_YEAR = "Salary year";
	public static final String DB_REPRESENTATIVE_NAME_SALARY_SALARY_SUM = "Salary sum";
	public static final String DB_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY = "Extra salary";

	public static final String DB_OPERATION_RESULT_SUCCESS = "operationSuccess"; // ok
	public static final String DB_OPERATION_RESULT_ERROR_NULL_PROPERTY = "nullPropertyOnNotNull"; // PropertyValueException
	public static final String DB_OPERATION_RESULT_ERROR_ENTITY_NOT_EXIST = "referenceEntityNotExist"; // illegalArgumentException
	public static final String DB_OPERATION_RESULT_ERROR_DUPLICITE = "duplicitePrimaryKey"; // ConstraintViolationException
	public static final String DB_OPERATION_RESULT_ERROR_UNKNOWN = "unknownException"; // Exception

	public static final List<EntityDefinition> DATABASE_ENTITIES = new ArrayList<EntityDefinition>() {
		{
			add(new Staffperson());
			add(new Salary());
		}
	};
}
