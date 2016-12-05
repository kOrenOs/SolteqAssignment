package servletControllers;
 
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import constants.GuiConstantsAndTexts;
import databaseControllers.SalaryDBOperations;
import databaseControllers.StaffPersonDBOperations;
import databaseEntity.Salary;
import databaseEntity.SalaryId;
import databaseEntity.Staffperson;
import guiComponents.StaticGuiComponents;
import guiComponents.TableComposer;

 
@Controller
public class ControllerService {
 	
	@RequestMapping("/addEntityPage")
	public ModelAndView addEntityRedirection() {
		return new ModelAndView("addEntityPage");
	}
	
	@RequestMapping("/searchPage")
	public ModelAndView searchPageRedirection() {
		return new ModelAndView("searchPage");
	}
	
	@RequestMapping(value="/addStaffMember", method=RequestMethod.POST)
	public  @ResponseBody void  addStaffMember(HttpServletRequest request) {
		
		String firstName = request.getParameter(StaticGuiComponents.insertFormStaffMember.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_FIRST_NAME));
		String Surname = request.getParameter(StaticGuiComponents.insertFormStaffMember.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_SURNAME));
		String City = request.getParameter(StaticGuiComponents.insertFormStaffMember.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_CITY));
		String PostalCode = request.getParameter(StaticGuiComponents.insertFormStaffMember.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_POSTAL_CODE));
		String Street = request.getParameter(StaticGuiComponents.insertFormStaffMember.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_STREET));
		String HouseNumber = request.getParameter(StaticGuiComponents.insertFormStaffMember.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_HOUSE_NUMBER));
		String Phone = request.getParameter(StaticGuiComponents.insertFormStaffMember.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_PHONE));
		String Email = request.getParameter(StaticGuiComponents.insertFormStaffMember.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_STAFF_EMAIL));
	}
	
	@RequestMapping(value="/addSalary", method=RequestMethod.POST)
	public  @ResponseBody void  addSalary(HttpServletRequest request) {
		
		String StaffMemberID = request.getParameter(StaticGuiComponents.insertFormSalary.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_SALARY_STAFF_MEMBER));
		String SalaryMonth = request.getParameter(StaticGuiComponents.insertFormSalary.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_SALARY_MONTH));
		String SalaryYear = request.getParameter(StaticGuiComponents.insertFormSalary.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_SALARY_YEAR));
		String SalarySum = request.getParameter(StaticGuiComponents.insertFormSalary.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_SALARY_SUM));
		String ExtraSalary = request.getParameter(StaticGuiComponents.insertFormSalary.findTaskName(
				GuiConstantsAndTexts.TEXTBOX_REPRESENTATIVE_NAME_ADD_SALARY_EXTRA_SALARY));
	}
	
	@RequestMapping(value="/getDataTable", method=RequestMethod.POST)
	public  @ResponseBody String  getTableParameterRequest(HttpServletRequest request) {
		int iterator = 1;
		ArrayList<String> columnNames = new ArrayList<String>();
		String inputColumnName;
		
		do{
			inputColumnName = request.getParameter("identifier"+iterator);
			if(inputColumnName != null){
				columnNames.add(inputColumnName);
			}
			
			iterator++;
		}while(inputColumnName != null);
		
		ArrayList<String[]> data = new ArrayList<String[]>();
		for(int i = 0; i< 50; i++){
			String[] nieco = new String[4];
			for(int j = 0; j< nieco.length; j++){
				nieco[j] = "random data"+i+j;
			}
			data.add(nieco);
		}
		
		TableComposer tc = new TableComposer(columnNames, data);
		
		return tc.composeDatabaseOutputTable();
	   }
}