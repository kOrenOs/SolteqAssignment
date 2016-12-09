package servletControllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import constants.DatabaseConstants;
import constants.GuiConstantsAndTexts;
import constants.StaticGuiComponents;
import databaseControllers.FunctionProvider;
import databaseEntity.EntityDefinition;
import databaseEntity.Salary;
import databaseEntity.Staffperson;
import guiComponents.TableComposer;

/**
 * Spring controller class. It provides all services for jsp pages.
 */
@Controller
public class ControllerService {

	/**
	 * Redirection to  addEntityPage
	 */
	@RequestMapping("/addEntityPage")
	public ModelAndView addEntityRedirection() {
		return new ModelAndView("addEntityPage");
	}

	/**
	 * Redirection to  searchEntityPage
	 */
	@RequestMapping("/searchPage")
	public ModelAndView searchPageRedirection() {
		return new ModelAndView("searchPage");
	}

	/**
	 * Redirection to  addeditEntityPage
	 */
	@RequestMapping("/editDelete")
	public ModelAndView editDeletePageRedirection() {
		return new ModelAndView("editDelete");
	}
	
	/**
	 * Redirection to  calculationFunctionsEntityPage
	 */
	@RequestMapping("/calculationFunctions")
	public ModelAndView calculationFunctionsPageRedirection() {
		return new ModelAndView("calculationFunctions");
	}

	/**
	 * Provide export data
	 * @return JSONObject of database
	 */
	@RequestMapping(value = "/exportData", method = RequestMethod.GET, produces = "application/json")
	public String exportData() {
		FunctionProvider functions = new FunctionProvider();
		JSONObject success = null;
		success = functions.exportData();
		
		return success.toString();
	}
	
	@RequestMapping(value = "/edit/{personid}/{month}/{year}", method = RequestMethod.GET)
	public ModelAndView editStaffMember(@PathVariable(value="personid") String personalID,
			@PathVariable(value="month") String month, @PathVariable(value="year") String year) {
		
		System.out.println(personalID+", "+month+", "+year);
		
		return new ModelAndView("redirect:editDelete");
	}

	/**
	 * Receive data for edit of Staff person and try to edit this entity in database
	 * @param request request from jsp page
	 * @return return result to demanding page- one of error texts or success result
	 */
	@RequestMapping(value = "/editStaffMember", method = RequestMethod.POST)
	public @ResponseBody String editStaffMember(WebRequest request) {

		//reading of data from input form
		String personId = stringController(request.getParameter(StaticGuiComponents.editFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_PERSONAL_ID)));
		String firstName = stringController(request.getParameter(StaticGuiComponents.editFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_FIRST_NAME)));
		String surname = stringController(request.getParameter(StaticGuiComponents.editFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_SURNAME)));
		String city = stringController(request.getParameter(StaticGuiComponents.editFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_CITY)));
		String postalCode = stringController(request.getParameter(StaticGuiComponents.editFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_POSTAL_CODE)));
		String street = stringController(request.getParameter(StaticGuiComponents.editFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_STREET)));
		String houseNumber = stringController(request.getParameter(StaticGuiComponents.editFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_HOUSE_NUMBER)));
		String phone = stringController(request.getParameter(StaticGuiComponents.editFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_PHONE)));
		String email = stringController(request.getParameter(StaticGuiComponents.editFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_EMAIL)));

		//try to edit entity instance in database
		FunctionProvider functions = new FunctionProvider();
		try {
			functions.editStaffPerson(parseInteger(personId), firstName, surname, city, postalCode, street,
					parseInteger(houseNumber), phone, email);
		} catch (NullPointerException e) {
			// e.printStackTrace();
		}

		//evaluating of result operation
		String result = getResultText(functions.getStatus());
		if (result == null) {
			return GuiConstantsAndTexts.ACTION_EDIT_STAFF_PERSON_DATA_RESULT;
		}
		return result;
	}

	/**
	 * Receive data for edit of Salary and try to edit this entity in database
	 * @param request request from jsp page
	 * @return return result to demanding page- one of error texts or success result
	 */
	@RequestMapping(value = "/editSalary", method = RequestMethod.POST)
	public @ResponseBody String editSalary(WebRequest request) {

		//reading of data from input form
		String staffMemberID = stringController(request.getParameter(StaticGuiComponents.editFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_STAFF_MEMBER)));
		String salaryMonth = stringController(request.getParameter(StaticGuiComponents.editFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_MONTH)));
		String salaryYear = stringController(request.getParameter(StaticGuiComponents.editFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_YEAR)));
		String salarySum = stringController(request.getParameter(StaticGuiComponents.editFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_SUM)));
		String extraSalary = stringController(request.getParameter(StaticGuiComponents.editFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY)));

		//try to edit entity instance in database
		FunctionProvider functions = new FunctionProvider();
		try {
			functions.editSalary(parseInteger(staffMemberID), parseShort(salaryMonth), parseShort(salaryYear),
					createBigDecimal(salarySum), createBigDecimal(extraSalary));
		} catch (NullPointerException e) {
			// e.printStackTrace();
		}

		//evaluating of result operation
		String result = getResultText(functions.getStatus());
		if (result == null) {
			return GuiConstantsAndTexts.ACTION_EDIT_SALARY_DATA_RESULT;
		}
		return result;
	}

	/**
	 * Receive person ID from form and try to delete Staff person from database
	 * @param request request from jsp page
	 * @return return result to demanding page- one of error texts or success result
	 */
	@RequestMapping(value = "/deleteStaffMember", method = RequestMethod.POST)
	public @ResponseBody String deleteStaffMember(WebRequest request) {

		//reading of data from input form
		String personId = stringController(request.getParameter(StaticGuiComponents.deleteFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_PERSONAL_ID)));

		//try to delete entity instance in database
		FunctionProvider functions = new FunctionProvider();
		try {
			functions.deleteStaffPerson(parseInteger(personId));
		} catch (NullPointerException e) {
			// e.printStackTrace();
		}

		//evaluating of result operation
		String result = getResultText(functions.getStatus());
		if (result == null) {
			return GuiConstantsAndTexts.ACTION_DELETE_STAFF_PERSON_DATA_RESULT;
		}
		return result;
	}

	/**
	 * Receive primary key of Salary from form and try to delete Salary from database
	 * @param request request from jsp page
	 * @return return result to demanding page- one of error texts or success result
	 */
	@RequestMapping(value = "/deleteSalary", method = RequestMethod.POST)
	public @ResponseBody String deleteSalary(WebRequest request) {

		//reading of data from input form
		String staffMemberID = stringController(request.getParameter(StaticGuiComponents.deleteFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_STAFF_MEMBER)));
		String salaryMonth = stringController(request.getParameter(StaticGuiComponents.deleteFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_MONTH)));
		String salaryYear = stringController(request.getParameter(StaticGuiComponents.deleteFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_YEAR)));

		//try to delete entity instance in database
		FunctionProvider functions = new FunctionProvider();
		try {
			functions.deleteSalary(parseInteger(staffMemberID), parseShort(salaryMonth), parseShort(salaryYear));
		} catch (NullPointerException e) {
			// e.printStackTrace();
		}

		//evaluating of result operation
		String result = getResultText(functions.getStatus());
		if (result == null) {
			return GuiConstantsAndTexts.ACTION_DELETE_SALARY_DATA_RESULT;
		}
		return result;
	}

	/**
	 * Gather data from jsp form and try to add Staff person to database
	 * @param request request from jsp page
	 * @return return result to demanding page- one of error texts or success result
	 */
	@RequestMapping(value = "/addStaffMember", method = RequestMethod.POST)
	public @ResponseBody String addStaffMember(WebRequest request) {

		//reading of data from input form
		String firstName = stringController(request.getParameter(StaticGuiComponents.insertFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_FIRST_NAME)));
		String surname = stringController(request.getParameter(StaticGuiComponents.insertFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_SURNAME)));
		String city = stringController(request.getParameter(StaticGuiComponents.insertFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_CITY)));
		String postalCode = stringController(request.getParameter(StaticGuiComponents.insertFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_POSTAL_CODE)));
		String street = stringController(request.getParameter(StaticGuiComponents.insertFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_STREET)));
		String houseNumber = stringController(request.getParameter(StaticGuiComponents.insertFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_HOUSE_NUMBER)));
		String phone = stringController(request.getParameter(StaticGuiComponents.insertFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_PHONE)));
		String email = stringController(request.getParameter(StaticGuiComponents.insertFormStaffMember
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_EMAIL)));

		//try to add entity instance to database
		FunctionProvider functions = new FunctionProvider();
		Integer newPersonalID = null;
		try {
			newPersonalID = functions.addStaffPerson(firstName, surname, city, postalCode, street, parseInteger(houseNumber), phone,
					email);
		} catch (NullPointerException e) {
			// e.printStackTrace();
		}

		//evaluating of result operation
		String result = getResultText(functions.getStatus());
		if (result == null) {
			return String.format(GuiConstantsAndTexts.ACTION_ADD_STAFF_PERSON_DATA_RESULT, newPersonalID+"");
		}
		return result;
	}

	/**
	 * Gather data from jsp form and try to add Salary to database
	 * @param request request from jsp page
	 * @return return result to demanding page- one of error texts or success result
	 */
	@RequestMapping(value = "/addSalary", method = RequestMethod.POST)
	public @ResponseBody String addSalary(WebRequest request) {

		//reading of data from input form
		String staffMemberID = stringController(request.getParameter(StaticGuiComponents.insertFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_STAFF_MEMBER)));
		String salaryMonth = stringController(request.getParameter(StaticGuiComponents.insertFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_MONTH)));
		String salaryYear = stringController(request.getParameter(StaticGuiComponents.insertFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_YEAR)));
		String salarySum = stringController(request.getParameter(StaticGuiComponents.insertFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_SUM)));
		String extraSalary = stringController(request.getParameter(StaticGuiComponents.insertFormSalary
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY)));

		//try to add entity instance to database
		FunctionProvider functions = new FunctionProvider();
		List<String> insertedKey = null;
		try {
			insertedKey = functions.addSalary(parseInteger(staffMemberID), parseShort(salaryMonth), parseShort(salaryYear),
					createBigDecimal(salarySum), createBigDecimal(extraSalary));
		} catch (NullPointerException e) {
			// e.printStackTrace();
		}

		//evaluating of result operation
		String result = getResultText(functions.getStatus());
		if (result == null) {
			return String.format(GuiConstantsAndTexts.ACTION_ADD_SALARY_DATA_RESULT, insertedKey.get(0), insertedKey.get(1), insertedKey.get(2));
		}
		return result;
	}


	/**
	 * Find all Staff person instances in database which fit to parameters and return output table in html string form
	 * @param request request from jsp page
	 * @return return output table in html string form with selected Staf person data
	 */
	@RequestMapping(value = "/getStaffPersonTable", method = RequestMethod.POST)
	public @ResponseBody String getStaffPersonTable(WebRequest request) {
		Staffperson mockedStaffPerson = new Staffperson();
		
		//get table names
		List<String> columnNames = mockedStaffPerson.tableColumnNames();

		//get order by parameter and another bounding parameters from jsp form
		String orderBy = request.getParameter("orderBy");
		List<String> parameters = readParameters(columnNames, request, mockedStaffPerson);

		//take data from database
		FunctionProvider functions = new FunctionProvider();
		List<String[]> tableData = functions.getStaffPersonTable(columnNames, parameters, orderBy);

		//create table
		TableComposer tc = new TableComposer(tableData, columnNames);
		return tc.composeDatabaseOutputTable();
	}

	/**
	 * Find all Salaries instances in database which fit to parameters and return output table in html string form
	 * @param request request from jsp page
	 * @return return output table in html string form with selected Staf person data
	 */
	@RequestMapping(value = "/getSalaryTable", method = RequestMethod.POST)
	public @ResponseBody String getSalaryTable(WebRequest request) {
		Salary mockedSalary = new Salary();
		
		//get table names
		List<String> columnNames = mockedSalary.tableColumnNames();

		//get order by parameter and another bounding parameters from jsp form
		String orderBy = request.getParameter("orderBy");
		List<String> parameters = readParameters(columnNames, request, mockedSalary);

		//take data from database
		FunctionProvider functions = new FunctionProvider();
		List<String[]> tableData = functions.getSalaryTable(columnNames, parameters, orderBy);

		//create table
		TableComposer tc = new TableComposer(tableData, columnNames);
		return tc.composeDatabaseOutputTable();
	}

	/**
	 * Read parameter data from request with representative names of database entity
	 * @return return parameters from request
	 */
	private List<String> readParameters(List<String> columnNames, WebRequest request, EntityDefinition entity) {
		ArrayList<String> parameters = new ArrayList<String>();

		for (int i = 0; i < columnNames.size(); i++) {
			parameters.add(request.getParameter(entity.getColumnName(columnNames.get(i))));
		}

		return parameters;
	}
	
	/**
	 * Read parameters from request, select all Salaries in asked term and compute average salary
	 * @param request request from jsp page
	 * @return return double value of average salary
	 */
	@RequestMapping(value = "/averageSalaryFunction", method = RequestMethod.POST)
	public @ResponseBody String getAverageSalary(WebRequest request) {
		
		//read data from form
		String month = stringController(request.getParameter(StaticGuiComponents.averageSalaryFunction
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_AVERAGE_MONTH)));
		String year = stringController(request.getParameter(StaticGuiComponents.averageSalaryFunction
				.findTaskName(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_AVERAGE_YEAR)));
		
		//try to get result of average function
		FunctionProvider functions = new FunctionProvider();
		double functionResult = 0;
		try {
			functionResult = functions.getAverageSalary(parseShort(month), parseShort(year));
		} catch (NullPointerException e) {
			// e.printStackTrace();
		}

		//evaluating of result operation
		if(functionResult < 0){
			return GuiConstantsAndTexts.FUNCTION_ERROR_AVERAGE_SALARY;
		}
		return String.format(GuiConstantsAndTexts.FUNCTION_RESULT_AVERAGE_SALARY,functionResult);
	}

	/**
	 * Try to parse String to integer and handle exception. It will return null if it is not possible to parse String. 
	 * Another check of this value is on the database side.
	 */
	private Integer parseInteger(String toParse) {
		try {
			return Integer.parseInt(toParse);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Try to parse String to short and handle exception. It will return null if it is not possible to parse String.
	 * Another check of this value is on the database side.
	 */
	private Short parseShort(String toParse) {
		try {
			return Short.parseShort(toParse);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Control String value. If it is empty String it will return null. Another check of this value is on the database side.
	 */
	private String stringController(String toControll) {
		if (toControll.compareTo("") == 0) {
			return null;
		}
		return toControll;
	}

	/**
	 * Try to parse String to big decimal and handle exception. It will return null if it is not possible to parse String.
	 * Another check of this value is on the database side.
	 */
	private BigDecimal createBigDecimal(String number) {
		if (number == null) {
			return null;
		}
		try {
			return new BigDecimal(number);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Mapping of result messages to output for user interface (jsp pages)
	 */
	private String getResultText(String result) {
		if (result == null) {
			return GuiConstantsAndTexts.CONTROLLER_OPERATION_ERROR;
		}
		switch (result) {
		case DatabaseConstants.DB_OPERATION_RESULT_ERROR_DUPLICITE:
			return GuiConstantsAndTexts.DB_OPERATION_ERROR_DUPLICITE_TEXT;
		case DatabaseConstants.DB_OPERATION_RESULT_ERROR_ENTITY_NOT_EXIST:
			return GuiConstantsAndTexts.DB_OPERATION_ERROR_ENTITY_NOT_EXIST_TEXT;
		case DatabaseConstants.DB_OPERATION_RESULT_ERROR_NULL_PROPERTY:
			return GuiConstantsAndTexts.DB_OPERATION_ERROR_NULL_PROPERTY_TEXT;
		case DatabaseConstants.DB_OPERATION_RESULT_ERROR_UNKNOWN:
			return GuiConstantsAndTexts.DB_OPERATION_ERROR_UNKNOWN_TEXT;
		default:
			return null;
		}
	}
}