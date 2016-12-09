package databaseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import constants.DatabaseConstants;
import databaseControllers.OperationClass;
import databaseControllers.SalaryDBOperations;

/**
 * Entity class generated by hibernate reverse engineering.
 */
public class Salary implements java.io.Serializable, EntityDefinition {

	private SalaryId id;
	private Staffperson staffperson;
	private BigDecimal salarySum;
	private BigDecimal extraSalary;

	public Salary() {
	}

	public Salary(SalaryId id, Staffperson staffperson, BigDecimal salarySum) {
		this.id = id;
		this.staffperson = staffperson;
		this.salarySum = salarySum;
	}

	public Salary(int personalId, short month, short year, BigDecimal salarySum, BigDecimal extraSalary) {
		this.id = new SalaryId(personalId, month, year);
		this.salarySum = salarySum;
		this.extraSalary = extraSalary;
	}

	public Salary(SalaryId id, Staffperson staffperson, BigDecimal salarySum, BigDecimal extraSalary) {
		this.id = id;
		this.staffperson = staffperson;
		this.salarySum = salarySum;
		this.extraSalary = extraSalary;
	}

	public SalaryId getId() {
		return this.id;
	}

	public void setId(SalaryId id) {
		this.id = id;
	}

	public Staffperson getStaffperson() {
		return this.staffperson;
	}

	public void setStaffperson(Staffperson staffperson) {
		this.staffperson = staffperson;
	}

	public BigDecimal getSalarySum() {
		return this.salarySum;
	}

	public void setSalarySum(BigDecimal salarySum) {
		this.salarySum = salarySum;
	}

	public BigDecimal getExtraSalary() {
		return this.extraSalary;
	}

	public void setExtraSalary(BigDecimal extraSalary) {
		this.extraSalary = extraSalary;
	}

	@Override
	public String toString() {
		return "Salary [" + id.toString() + ", staffperson=" + staffperson + ", salarySum=" + salarySum
				+ ", extraSalary=" + extraSalary + "]";
	}

	public void copyParameters(Salary copySalary) {
		this.salarySum = copySalary.getSalarySum();
		this.extraSalary = copySalary.getExtraSalary();
	}

	@Override
	public boolean equals(Object obj) {
		Salary target = (Salary) obj;
		if(id.getPersonalId()==target.getId().getPersonalId() && id.getMonth()==target.getId().getMonth() &&
				id.getYear()==target.getId().getYear() && salarySum.compareTo(target.getSalarySum())==0){
			if(extraSalary==null && target.getExtraSalary() == null){
				return true;
			}
			if(extraSalary==null || target.getExtraSalary() == null){
				return false;
			}
			if(extraSalary.compareTo(target.getExtraSalary())==0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * return entity representative column names.
	 */
	@Override
	public List<String> tableColumnNames() {
		List<String> outputList = new ArrayList<>();

		outputList.add(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_PERSONAL_ID);
		outputList.add(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_MONTH);
		outputList.add(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_YEAR);
		outputList.add(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_SALARY_SUM);
		outputList.add(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY);

		return outputList;
	}

	/**
	 * Exporting data of entity instance to JSONObject
	 */
	@Override
	public JSONObject exportData() {
		JSONObject exportData = new JSONObject();

		exportData.accumulate(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_PERSONAL_ID, staffperson);
		exportData.accumulate(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_MONTH, staffperson);
		exportData.accumulate(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_YEAR, staffperson);
		exportData.accumulate(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_SALARY_SUM, staffperson);
		exportData.accumulate(DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY, staffperson);

		JSONArray dataContainer = new JSONArray();
		dataContainer.put(exportData);

		JSONObject finalObject = new JSONObject();
		finalObject.put("salary", dataContainer);

		return finalObject;
	}

	/**
	 * Mapping of database column names to representative names.
	 */
	@Override
	public String getColumnName(String representativeName) {
		switch (representativeName) {
		case DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_PERSONAL_ID:
			return "personalId";
		case DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_MONTH:
			return "month";
		case DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_YEAR:
			return "year";
		case DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_SALARY_SUM:
			return "salarySum";
		case DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY:
			return "extraSalary";
		default:
			return null;
		}
	}

	/**
	 * Returning instance values on appropriate representative column name
	 */
	@Override
	public String getToStringValue(String reprezentativeName) {
		switch (reprezentativeName) {
		case DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_PERSONAL_ID:
			return id.getPersonalId() + "";
		case DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_MONTH:
			return id.getMonth() + "";
		case DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_YEAR:
			return id.getYear() + "";
		case DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_SALARY_SUM:
			return salarySum + "";
		case DatabaseConstants.DB_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY:
			return extraSalary + "";
		default:
			return null;
		}
	}

	/**
	 * Return empty instance of entity for gathering common data (column names,...)
	 */
	@Override
	public OperationClass getOperationInterface() {
		return new SalaryDBOperations();
	}
}
