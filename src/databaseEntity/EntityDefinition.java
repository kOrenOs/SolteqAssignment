package databaseEntity;

import java.util.List;

import org.json.JSONObject;

import databaseControllers.OperationClass;

/**
 * This interface contains basic methods for database entities.
 */
public interface EntityDefinition {
	
	/**
	 * Get all entity columns
	 * @return return list of string with names of entity columns
	 */
	List<String> tableColumnNames();

	/**
	 * Exporting data of entity
	 * @return return JSONObject with serialised entity data
	 */
	JSONObject exportData();

	/**
	 * Get back appropriate column name mapped to representative name
	 * @param reprezentativeName representative names from GUI constants
	 * @return return string with column name
	 */
	String getColumnName(String representativeName);

	/**
	 * Get back value of column mapped to representative name
	 * @param reprezentativeName representative names from GUI constants
	 * @return return string value of tasked column
	 */
	String getToStringValue(String representativeName);

	/**
	 * Return empty instance of entity for gathering common data (column names,...)
	 * @return return entity instance
	 */
	OperationClass getOperationInterface();
}
