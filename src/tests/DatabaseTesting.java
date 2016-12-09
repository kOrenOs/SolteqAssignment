package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import constants.DatabaseConstants;
import databaseControllers.FunctionProvider;
import databaseEntity.Salary;
import databaseEntity.SalaryId;
import databaseEntity.Staffperson;

public class DatabaseTesting {
	
	Staffperson testedStaffPerson = null;
	Salary testedSalary = null;
	
	@After
	public void cleanDatabase(){
		FunctionProvider functions = new FunctionProvider();
		
		if(testedSalary != null){
			SalaryId id = testedSalary.getId();
			functions.deleteSalary(id.getPersonalId(), id.getMonth(), id.getYear());
		}
		if(testedStaffPerson != null){
			functions.deleteStaffPerson(testedStaffPerson.getPersonalId());
		}
	}

	@Test
	public void addStaffPersonToDatabase() {
		FunctionProvider functions = new FunctionProvider();
		
		int id = functions.addStaffPerson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		
		testedStaffPerson = new Staffperson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson.setPersonalId(id);
		
		assertTrue(functions.selectStaffPerson(id).equals(testedStaffPerson));
	}
	
	@Test
	public void addSalaryToDatabase() {
		FunctionProvider functions = new FunctionProvider();
		
		int id = functions.addStaffPerson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson = new Staffperson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson.setPersonalId(id);
		
		List<String> salaryid = functions.addSalary(id, new Short(1+""), new Short(10+""), new BigDecimal(50.0), null);
		
		testedSalary = new Salary(id, new Short(1+""), new Short(10+""), new BigDecimal(50.0), null);
		
		assertTrue(functions.selectSalary(Integer.parseInt(salaryid.get(0)), new Short(salaryid.get(1)), new Short(salaryid.get(2))).equals(testedSalary));
	}
	
	@Test
	public void editStaffPersonInDatabase() {
		FunctionProvider functions = new FunctionProvider();
		
		int id = functions.addStaffPerson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		
		testedStaffPerson = new Staffperson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson.setPersonalId(id);
		
		String changedName = "no name";
		
		functions.editStaffPerson(testedStaffPerson.getPersonalId(), changedName, "surname", "city", "postalCode", "street", 10, "phone", "email");
		
		assertTrue(functions.selectStaffPerson(id).getFisrtName().compareTo(changedName)==0);
	}
	
	@Test
	public void editSalaryInDatabase() {
		FunctionProvider functions = new FunctionProvider();
		
		int id = functions.addStaffPerson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson = new Staffperson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson.setPersonalId(id);
		
		List<String> salaryid = functions.addSalary(id, new Short(1+""), new Short(10+""), new BigDecimal(50.0), null);
		
		testedSalary = new Salary(id, new Short(1+""), new Short(10+""), new BigDecimal(50.0), null);
		
		BigDecimal changedSalarySum = new BigDecimal("1000");
		
		functions.editSalary(id, new Short(1+""), new Short(10+""), changedSalarySum, null);
		
		assertTrue(functions.selectSalary(Integer.parseInt(salaryid.get(0)), new Short(salaryid.get(1)), new Short(salaryid.get(2)))
				.getSalarySum().compareTo(changedSalarySum)==0);
	}
	
	@Test
	public void deleteStaffPersonFromDatabase() {
		FunctionProvider functions = new FunctionProvider();
		
		int id = functions.addStaffPerson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		
		testedStaffPerson = new Staffperson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson.setPersonalId(id);
		
		functions.deleteStaffPerson(id);
		
		assertNull(functions.selectStaffPerson(id));
	}
	
	@Test
	public void deleteSalaryFromDatabase() {
		FunctionProvider functions = new FunctionProvider();
		
		int id = functions.addStaffPerson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson = new Staffperson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson.setPersonalId(id);
		
		List<String> salaryid = functions.addSalary(id, new Short(1+""), new Short(10+""), new BigDecimal(50.0), null);
		
		testedSalary = new Salary(id, new Short(1+""), new Short(10+""), new BigDecimal(50.0), null);
		
		functions.deleteSalary(id, new Short(1+""), new Short(10+""));
		
		assertNull(functions.selectSalary(Integer.parseInt(salaryid.get(0)), new Short(salaryid.get(1)), new Short(salaryid.get(2))));
	}
	
	@Test
	public void checkAddSalaryWithDuplicitePrimaryKey() {
		FunctionProvider functions = new FunctionProvider();
		
		int id = functions.addStaffPerson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson = new Staffperson("name", "surname", "city", "postalCode", "street", 10, "phone", "email");
		testedStaffPerson.setPersonalId(id);
		
		testedSalary = new Salary(id, new Short(1+""), new Short(10+""), new BigDecimal(50.0), null);
		
		assertNull(functions.addSalary(id, new Short(1+""), new Short(10+""), new BigDecimal(50.0), null));
		
		assertTrue(functions.getStatus()==DatabaseConstants.DB_OPERATION_RESULT_ERROR_DUPLICITE);
	}
}
