package constants;

import java.util.ArrayList;
import java.util.List;

import databaseEntity.EntityDefinition;
import databaseEntity.Salary;
import databaseEntity.Staffperson;
import guiComponents.FormularData;
import guiComponents.MenuComposer;
import guiComponents.MenuOptionData;
import guiComponents.FormularData.FormularTypes;

/*
 * In this class are static components of GUI in JSP. There is mainMenu template code. It is created just once 
 * at the start of run. It is not necessary to build menu again, when another JSP page is opened
 */
public class StaticGuiComponents {

	/**
	 * Menu options. Menu is composed in the static block
	 */
	public static final String mainMenuCode;
	static {
		ArrayList<MenuOptionData> menuData = new ArrayList<MenuOptionData>();

		menuData.add(new MenuOptionData("addEntityPage.jsp", GuiConstantsAndTexts.BUTON_LABEL_ADD_DATA));
		menuData.add(new MenuOptionData("searchPage.jsp", GuiConstantsAndTexts.BUTON_LABEL_SEARCH_DATA));
		menuData.add(new MenuOptionData("exportData.jsp", GuiConstantsAndTexts.BUTON_LABEL_EXPORT_DATA));
		menuData.add(new MenuOptionData("editDelete.jsp", GuiConstantsAndTexts.BUTON_LABEL_DELETE_EDIT_DATA));
		menuData.add(new MenuOptionData("calculationFunctions.jsp", GuiConstantsAndTexts.BUTON_LABEL_CALCULATION_FUNCTIONS));

		MenuComposer menuBuilder = new MenuComposer(menuData);
		mainMenuCode = menuBuilder.composeMenu();
	}

	/**
	 * Form definition/date template of Add Staff person
	 */
	public static final FormularData insertFormStaffMember;
	static {
		insertFormStaffMember = new FormularData("addStaffMemberForm", "POST", "addStaffMember.html", "submit",
				"Add Staff Member");
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_FIRST_NAME,
				FormularTypes.text, "fisrtName", "First name:", null);
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_SURNAME,
				FormularTypes.text, "surname", "Surname:", null);
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_CITY,
				FormularTypes.text, "city", "City:", null);
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_POSTAL_CODE,
				FormularTypes.text, "postalCode", "Postal code:", null);
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_STREET,
				FormularTypes.text, "street", "Street:", null);
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_HOUSE_NUMBER,
				FormularTypes.text, "houseNumber", "House number:", null);
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_PHONE,
				FormularTypes.text, "phone", "Phone:", null);
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_EMAIL,
				FormularTypes.text, "email", "E-mail:", null);
	}

	/**
	 * Form definition/date template of Add Salary
	 */
	public static final FormularData insertFormSalary;
	static {
		insertFormSalary = new FormularData("addSalaryForm", "POST", "addSalary.html", "submit", "Add Salary");
		insertFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_STAFF_MEMBER,
				FormularTypes.text, "personalId", "Staff member ID:", null);
		insertFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_MONTH,
				FormularTypes.text, "month", "Salary month:", null);
		insertFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_YEAR,
				FormularTypes.text, "year", "Salary year:", null);
		insertFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_SUM,
				FormularTypes.text, "salarySum", "Salary sum:", null);
		insertFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY,
				FormularTypes.text, "extraSalary", "Extra salary:", null);
	}

	/**
	 * Form definition/date template of Edit Staff person
	 */
	public static final FormularData editFormStaffMember;
	static {
		editFormStaffMember = new FormularData("editStaffMemberForm", "POST", "editStaffMember.html", "submit",
				"Edit Staff Member");
		editFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_PERSONAL_ID,
				FormularTypes.text, "personalId", "Personal ID:", null);
		editFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_FIRST_NAME,
				FormularTypes.text, "fisrtName", "First name:", null);
		editFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_SURNAME,
				FormularTypes.text, "surname", "Surname:", null);
		editFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_CITY,
				FormularTypes.text, "city", "City:, null", null);
		editFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_POSTAL_CODE,
				FormularTypes.text, "postalCode", "Postal code:", null);
		editFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_STREET,
				FormularTypes.text, "street", "Street:", null);
		editFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_HOUSE_NUMBER,
				FormularTypes.text, "houseNumber", "House number:", null);
		editFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_PHONE,
				FormularTypes.text, "phone", "Phone:", null);
		editFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_EMAIL,
				FormularTypes.text, "email", "E-mail:", null);
	}

	/**
	 * Form definition/date template of Edit Salary
	 */
	public static final FormularData editFormSalary;
	static {
		editFormSalary = new FormularData("editSalaryForm", "POST", "editSalary.html", "submit", "Edit Salary");
		editFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_STAFF_MEMBER,
				FormularTypes.text, "personalId", "Staff member ID:", null);
		editFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_MONTH,
				FormularTypes.text, "month", "Salary month:", null);
		editFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_YEAR,
				FormularTypes.text, "year", "Salary year:", null);
		editFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_SUM,
				FormularTypes.text, "salarySum", "Salary sum:", null);
		editFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY,
				FormularTypes.text, "extraSalary", "Extra salary:", null);
	}

	/**
	 * Form definition/date template of Delete Staff person
	 */
	public static final FormularData deleteFormStaffMember;
	static {
		deleteFormStaffMember = new FormularData("deleteStaffMemberForm", "POST", "deleteStaffMember.html", "submit",
				"Delete Staff Member");
		deleteFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_PERSONAL_ID,
				FormularTypes.text, "personalId", "Personal ID:", null);
	}

	/**
	 * Form definition/date template of Delete Salary
	 */
	public static final FormularData deleteFormSalary;
	static {
		deleteFormSalary = new FormularData("deleteSalaryForm", "POST", "deleteSalary.html", "submit", "Delete Salary");
		deleteFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_STAFF_MEMBER,
				FormularTypes.text, "personalId", "Staff member ID:", null);
		deleteFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_MONTH,
				FormularTypes.text, "month", "Salary month:", null);
		deleteFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_YEAR,
				FormularTypes.text, "year", "Salary year:", null);
	}

	/**
	 * Form definition/date template of Search(Select) Staff person
	 */
	public static final FormularData searchFormStaffPerson;
	static {
		searchFormStaffPerson = new FormularData("staffPersonForm", "POST", "getStaffPersonTable.html", "submit",
				"Search");
		searchFormStaffPerson.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_PERSONAL_ID,
				FormularTypes.text, "personalId", "Personal ID:", null);
		searchFormStaffPerson.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_FIRST_NAME,
				FormularTypes.text, "fisrtName", "First name:", null);
		searchFormStaffPerson.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_SURNAME,
				FormularTypes.text, "surname", "Surname:", null);
		searchFormStaffPerson.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_CITY,
				FormularTypes.text, "city", "City:", null);
		searchFormStaffPerson.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_POSTAL_CODE,
				FormularTypes.text, "postalCode", "Postal code:", null);
		searchFormStaffPerson.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_STREET,
				FormularTypes.text, "street", "Street:", null);
		searchFormStaffPerson.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_HOUSE_NUMBER,
				FormularTypes.text, "houseNumber", "House number:", null);
		searchFormStaffPerson.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_PHONE,
				FormularTypes.text, "phone", "Phone:", null);
		searchFormStaffPerson.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_STAFF_EMAIL,
				FormularTypes.text, "email", "E-mail:", null);
		searchFormStaffPerson.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ORDER_BY,
				FormularTypes.select, "orderBy", "Order by:", new Staffperson().tableColumnNames());
	}
	
	/**
	 * Form definition/date template of Search(Select) Salary
	 */
	public static final FormularData searchFormSalary;
	static {
		searchFormSalary = new FormularData("salaryForm", "POST", "getSalaryTable.html", "submit", "Search");
		searchFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_STAFF_MEMBER,
				FormularTypes.text, "personalId", "Staff member ID:", null);
		searchFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_MONTH,
				FormularTypes.text, "month", "Salary month:", null);
		searchFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_YEAR,
				FormularTypes.text, "year", "Salary year:", null);
		searchFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_SUM,
				FormularTypes.text, "salarySum", "Salary sum:", null);
		searchFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_SALARY_EXTRA_SALARY,
				FormularTypes.text, "extraSalary", "Extra salary:", null);
		searchFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ORDER_BY,
				FormularTypes.select, "orderBy", "Order by:", new Salary().tableColumnNames());
	}
	
	/**
	 * Form definition/date template of Average Salary function 
	 */
	public static final FormularData averageSalaryFunction;
	static {
		averageSalaryFunction = new FormularData("averageSalaryFunctionForm", "POST", "averageSalaryFunction.html", "submit", "Calculate");
		averageSalaryFunction.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_AVERAGE_MONTH,
				FormularTypes.text, "month", "Month:", null);
		averageSalaryFunction.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_AVERAGE_YEAR,
				FormularTypes.text, "year", "Year:", null);
	}
}
