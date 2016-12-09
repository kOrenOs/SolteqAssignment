package guiComponents;

import java.util.List;

import constants.StaticGuiComponents;
import guiComponents.FormularData;

/*
 * This class provides services necessary in JSP files. Provides table templates, menu created html code,...
 */
public class GuiServices {

	/*
	 * Method send created menu template to JSP file
	 */
	public String getMainMenu() {
		return StaticGuiComponents.mainMenuCode;
	}

	/*
	 * Method, which sent form template for create Add Staff person form
	 */
	public FormularData getInsertFormStaffMemberForm() {
		return StaticGuiComponents.insertFormStaffMember;
	}

	/*
	 * Method, which sent form template for create Add Salary form
	 */
	public FormularData getInsertFormSalaryForm() {
		return StaticGuiComponents.insertFormSalary;
	}

	/*
	 * Method, which sent form template for create Edit Staff person form
	 */
	public FormularData getEditFormStaffMemberForm() {
		return StaticGuiComponents.editFormStaffMember;
	}

	/*
	 * Method, which sent form template for create Edit Salary form
	 */
	public FormularData getEditFormSalaryForm() {
		return StaticGuiComponents.editFormSalary;
	}

	/*
	 * Method, which sent form template for create Delete Staff person form
	 */
	public FormularData getDeleteFormStaffMemberForm() {
		return StaticGuiComponents.deleteFormStaffMember;
	}

	/*
	 * Method, which sent form template for create Delete Salary form
	 */
	public FormularData getDeleteFormSalaryForm() {
		return StaticGuiComponents.deleteFormSalary;
	}

	/*
	 * Method, which sent form template for create Search (Select) Staff person form
	 */
	public FormularData getSearchFormStaffMemberForm() {
		return StaticGuiComponents.searchFormStaffPerson;
	}

	/*
	 * Method, which sent form template for create Search (Select) Salary form
	 */
	public FormularData getSearchFormSalaryForm() {
		return StaticGuiComponents.searchFormSalary;
	}
	
	/*
	 * Method, which sent form template for create Average Salary function form
	 */
	public FormularData getAverageSalaryForm() {
		return StaticGuiComponents.averageSalaryFunction;
	}
}
