package databaseControllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import constants.DatabaseConstants;
import databaseEntity.EntityDefinition;
import databaseEntity.Salary;
import databaseEntity.SalaryId;
import databaseEntity.Staffperson;

/*
 * Class gathering all functions on the database. It use DBOperations classes and provides this functions for controllers.
 */
public class FunctionProvider implements StatusUpdateInterface {

	// status of last operation- one of database operation results
	private String operationStatus = null;

	/**
	 * Function for add salaries to database.
	 * 
	 * @return list of strings with primary key of inserted entity
	 */
	public List<String> addSalary(int personalId, short month, short year, BigDecimal salarySum, BigDecimal extraSalary) {
		Salary newSalary = new Salary(personalId, month, year, salarySum, extraSalary);

		SalaryDBOperations salaryOperations = new SalaryDBOperations(this);
		SalaryId id = (SalaryId)salaryOperations.add(newSalary);
		
		if(id != null){
			return Arrays.asList(id.getPersonalId()+"",id.getMonth()+"",id.getYear()+"");
		}else{
			return null;
		}
	}

	/**
	 * Function for add Staffperson to database.
	 * 
	 * @return person id of inserted entity
	 */
	public Integer addStaffPerson(String fisrtName, String surname, String city, String postalCode, String street,
			int houseNumber, String phone, String email) {
		Staffperson newStaffPerson = new Staffperson(fisrtName, surname, city, postalCode, street, houseNumber, phone,
				email);

		StaffPersonDBOperations staffPersonOperations = new StaffPersonDBOperations(this);
		return (Integer)staffPersonOperations.add(newStaffPerson);
	}

	/**
	 * Function try to edit existing Salary entity in database.
	 * 
	 * @return true, if update was successful, otherwise false.
	 */
	public boolean editSalary(int personalId, short month, short year, BigDecimal salarySum, BigDecimal extraSalary) {
		Salary editSalary = new Salary(personalId, month, year, salarySum, extraSalary);

		SalaryDBOperations salaryOperations = new SalaryDBOperations(this);
		return salaryOperations.update(editSalary);
	}

	/**
	 * Function try to edit existing Staffperson entity in database.
	 * 
	 * @return true, if update was successful, otherwise false.
	 */
	public boolean editStaffPerson(int personalId, String fisrtName, String surname, String city, String postalCode,
			String street, int houseNumber, String phone, String email) {
		Staffperson editStaffPerson = new Staffperson(fisrtName, surname, city, postalCode, street, houseNumber, phone,
				email);
		editStaffPerson.setPersonalId(personalId);

		StaffPersonDBOperations staffPersonOperations = new StaffPersonDBOperations(this);
		return staffPersonOperations.update(editStaffPerson);
	}

	/**
	 * Function delete Salary entity from database.
	 * 
	 * @return true, if update was successful, otherwise false.
	 */
	public boolean deleteSalary(int personalId, short month, short year) {
		Salary mockedSalary = new Salary(personalId, month, year, new BigDecimal(0), new BigDecimal(0));

		SalaryDBOperations salaryOperations = new SalaryDBOperations(this);
		return salaryOperations.delete(mockedSalary);
	}

	/**
	 * Function delete Staffperson entity from database.
	 * 
	 * @return true, if update was successful, otherwise false.
	 */
	public boolean deleteStaffPerson(int personalId) {
		String persinalIdName = new Salary().tableColumnNames().get(0);

		// delete all salaries for first
		SalaryDBOperations salaryOperations = new SalaryDBOperations(this);
		salaryOperations.groupDelete(Arrays.asList(persinalIdName), Arrays.asList("=" + personalId));

		Staffperson mockedStaffPerson = new Staffperson();
		mockedStaffPerson.setPersonalId(personalId);
		StaffPersonDBOperations staffPersonOperations = new StaffPersonDBOperations(this);
		return staffPersonOperations.delete(mockedStaffPerson);
	}

	/**
	 * Function select Salary entity from database.
	 * 
	 * @return Salary entity, if the primary key is in the database, else return
	 *         null
	 */
	public Salary selectSalary(int personalId, short month, short year) {
		SalaryDBOperations salaryOperations = new SalaryDBOperations(this);

		// used mocked Salary with primary key to find Salary entity
		return (Salary) salaryOperations.select(new Salary(personalId, month, year, null, null));
	}

	/**
	 * Function select Staffperson entity from database.
	 * 
	 * @return Staffperson entity, if the primary key is in the database, else
	 *         return null
	 */
	public Staffperson selectStaffPerson(int personalId) {
		StaffPersonDBOperations salaryOperations = new StaffPersonDBOperations(this);

		// used mocked Staffperson with primary key to find Salary entity
		Staffperson mockedPerson = new Staffperson("", "", "", "", "", 0);
		mockedPerson.setPersonalId(personalId);
		return (Staffperson) salaryOperations.select(mockedPerson);
	}

	/**
	 * Select all salaries, which fit the parameters
	 * @param columnNames column names of salary
	 * @param boundingParameters parameters for selection
	 * @param orderBy column name to order by function
	 * @return return list of entities- salaries
	 */
	public List<EntityDefinition> selectSalary(List<String> columnNames, List<String> boundingParameters,
			String orderBy) {
		SalaryDBOperations salaryOperations = new SalaryDBOperations(this);

		List<EntityDefinition> selectedEntities = salaryOperations.select(columnNames, boundingParameters, orderBy);
		return selectedEntities;
	}

	/**
	 * Select all Staffpersons, which fit the parameters
	 * @param columnNames column names of salary
	 * @param boundingParameters parameters for selection
	 * @param orderBy column name to order by function
	 * @return return list of entities- Staffpersons
	 */
	public List<EntityDefinition> selectStaffPerson(List<String> columnNames, List<String> boundingParameters,
			String orderBy) {
		StaffPersonDBOperations staffPersonOperations = new StaffPersonDBOperations(this);

		List<EntityDefinition> selectedEntities = staffPersonOperations.select(columnNames, boundingParameters,
				orderBy);
		return selectedEntities;
	}

	/**
	 * Create JSONobject of database for export database data.
	 * 
	 * @return JSONObject with database data
	 */
	public JSONObject exportData() {
		StaffPersonDBOperations staffpersonOperations = new StaffPersonDBOperations(this);

		// select all Staffperson in database
		List<EntityDefinition> allStaffPersons = staffpersonOperations.select(null, null, null);

		JSONArray databaseDataArray = new JSONArray();

		// gather JSONobject data from person
		for (EntityDefinition person : allStaffPersons) {
			JSONObject a = getJsonOfStaffPerson(person);
			databaseDataArray.put(getJsonOfStaffPerson(person));
		}

		// create complete database object
		JSONObject composedDatabaseData = new JSONObject();
		composedDatabaseData.put("salarySystemData", databaseDataArray);

		return composedDatabaseData;
	}

	/**
	 * Create JSONObject of one person also with his salaries.
	 * 
	 * @return JSONObject with data of person in attribute with his salaries.
	 */
	private JSONObject getJsonOfStaffPerson(EntityDefinition person) {
		// find database column name with representative name of column
		String personalIDColumnName = new Salary()
				.getColumnName(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_PERSONAL_ID);

		SalaryDBOperations salaryOperations = new SalaryDBOperations(this);

		// select of all salaries of person
		List<EntityDefinition> personsSalaries = salaryOperations.select(Arrays.asList(personalIDColumnName),
				Arrays.asList("="
						+ person.getToStringValue(DatabaseConstants.DB_REPRESENTATIVE_NAME_STAFF_PERSON_PERSONAL_ID)),
				null);

		JSONObject personData = person.exportData();

		JSONArray composedData = new JSONArray();
		composedData.put(personData);
		composedData.put(composeSalaryData(personsSalaries));

		// compose person data to JSONObject
		JSONObject finalObject = new JSONObject();
		finalObject.put("staffPerson", composedData);

		return finalObject;
	}

	/**
	 * Create JSONObject of all salaries of person
	 * 
	 * @param personsSalaries
	 *            list of person's salaries
	 * @return return JSONObject with all salarie's of person
	 */
	private JSONObject composeSalaryData(List<EntityDefinition> personsSalaries) {
		JSONArray salaryData = new JSONArray();

		for (EntityDefinition salary : personsSalaries) {
			salaryData.put(salary.exportData());
		}

		JSONObject salariesObject = new JSONObject();
		salariesObject.put("salaries", salaryData);

		return salariesObject;
	}

	/**
	 * Make  of Staffperson with attributed data and create data table
	 * @return return list of String arrays- table
	 */
	public List<String[]> getStaffPersonTable(List<String> columnNames, List<String> boundingParameters,
			String orderBy) {
		List<String[]> table = null;

		List<EntityDefinition> SelectedStaffPerson = selectStaffPerson(columnNames, boundingParameters, orderBy);
		if(SelectedStaffPerson != null){
			if (SelectedStaffPerson.size() != 0) {
				table = getQueryResult(SelectedStaffPerson, columnNames);
			}
		}
		return table;
	}

	/**
	 * Make  of Salary with attributed data and create data table
	 * @return return list of String arrays- table
	 */
	public List<String[]> getSalaryTable(List<String> columnNames, List<String> boundingParameters, String orderBy) {
		List<String[]> table = null;

		List<EntityDefinition> selectedSalary = selectSalary(columnNames, boundingParameters, orderBy);
		if(selectedSalary != null){
			if (selectedSalary.size() != 0) {
				table = getQueryResult(selectedSalary, columnNames);
			}
		}
		return table;
	}

	/**
	 * Transform data to table
	 * 
	 * @param data selected data of table
	 * @param columnNames selected table columns
	 * @return return two dimensional data- table
	 */
	private List<String[]> getQueryResult(List<EntityDefinition> data, List<String> columnNames) {
		List<String[]> output = new ArrayList<>();
		String[] filledArray = new String[columnNames.size()];

		for (EntityDefinition entity : data) {
			filledArray = new String[columnNames.size()];
			for (int j = 0; j < columnNames.size(); j++) {
				filledArray[j] = entity.getToStringValue(columnNames.get(j));
			}
			output.add(filledArray);
		}

		return output;
	}

	/**
	 * Compute average salary in the selected month
	 * @param month month, where we want to compute average salary
	 * @param year year definition of selected month
	 * @return double value- average salary per selected month
	 */
	public double getAverageSalary(int month, int year) {
		// choose interested columns
		
		List<String> columnNames = new ArrayList<>();
		columnNames.add(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_MONTH);
		columnNames.add(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_YEAR);

		// choose terms of the selection
		List<String> boundingParameters = new ArrayList<>();
		boundingParameters.add("=" + month);
		boundingParameters.add("=" + year);

		SalaryDBOperations salaryOperations = new SalaryDBOperations(this);

		// list of all selected salaries
		List<EntityDefinition> selectedSalaries = salaryOperations.select(columnNames, boundingParameters, null);
		
		// average compution
		double salarySum = 0;
		for (EntityDefinition salary : selectedSalaries) {
			salarySum += Double
					.parseDouble(salary.getToStringValue(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_SALARY_SUM));
		}

		return salarySum / selectedSalaries.size();
	}

	/**
	 * Realisation of interface. This way is changing operation status after use
	 * some of database operation
	 */
	@Override
	public void setActualStatus(String status) {
		operationStatus = status;
	}

	/**
	 * Method for return all actual (last) status from using database operations
	 * 
	 * @return String status. It can get one of database operation results
	 */
	public String getStatus() {
		return operationStatus;
	}
}
