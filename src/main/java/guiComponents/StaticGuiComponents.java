package guiComponents;

import java.util.ArrayList;

import constants.GuiConstantsAndTexts;
import guiComponents.FormularData.FormularTypes;

/*
 * In this class are static components of GUI in JSP. There is mainMenu template code. It is created just once 
 * at the start of run. The it is not necessary to build menu again, when another JSP page is opened
 */
public class StaticGuiComponents {
	
	public static String mainMenuCode;
	static{
		ArrayList<MenuOptionData> menuData = new ArrayList<MenuOptionData>();
		
		menuData.add(new MenuOptionData("AddEntityPage.jsp", GuiConstantsAndTexts.BUTON_LABEL_ADD_DATA));
		menuData.add(new MenuOptionData("SearchPage.jsp", GuiConstantsAndTexts.BUTON_LABEL_SEARCH_EDIT_DELETE));
		menuData.add(new MenuOptionData("something", GuiConstantsAndTexts.BUTON_LABEL_EXPORT_DATA));
		
		MenuComposer menuBuilder = new MenuComposer(menuData);
		mainMenuCode = menuBuilder.composeMenu();
	}
	
	public static FormularData insertFormStaffMember;
	static{
		insertFormStaffMember = new FormularData("addStaffMemberForm", "POST", "addStaffMember", "submit", "Add Staff Member");
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_FIRST_NAME, 
				FormularTypes.text, "firstName", "firstname", "First name:");
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_SURNAME,
				FormularTypes.text, "surname", "surname", "Surname:");
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_CITY,
				FormularTypes.text, "city", "city", "City:");
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_POSTAL_CODE,
				FormularTypes.text, "postalCode", "postalCode", "Postal code:");
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_STREET,
				FormularTypes.text, "street", "street", "Street:");
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_HOUSE_NUMBER,
				FormularTypes.text, "houseNumber", "houseNumber", "House number:");
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_PHONE,
				FormularTypes.text, "phone", "phone", "Phone:");
		insertFormStaffMember.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_EMAIL,
				FormularTypes.text, "email", "email", "E-mail:");
	}
	
	public static FormularData insertFormSalary;
	static{
		insertFormSalary = new FormularData("addSalaryForm","POST", "addSalary", "submit", "Add Salary");
		insertFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_SALARY_STAFF_MEMBER,
				FormularTypes.text, "staffMember", "staffMember", "Staff member ID:");
		insertFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_SALARY_MONTH,
				FormularTypes.text, "salaryMonth", "salaryMonth", "Salary month:");
		insertFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_SALARY_YEAR,
				FormularTypes.text, "salaryYear", "salaryYear", "Salary year:");
		insertFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_SALARY_SUM,
				FormularTypes.text, "salarySum", "salarySum", "Salary sum:");
		insertFormSalary.addFormularTaskData(GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_SALARY_EXTRA_SALARY,
				FormularTypes.text, "extraSalary", "extraSalary", "Extra salary:");
	}
	
	
	//this data and method are fictive and just for GUI functionality illustration 
	public static String[] fictiveDatabaseColumnNames = new String[]{"firstName", "surname", "city","street"};
}

