package com.test;

import org.testng.annotations.Test;

import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {

	@Test
	public void addEmployeePage() {
	
		login.login(ConfigsReader.getProperty("userName"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		
//		sendText(addEmp.empName, text);
//		sendText(addEmp.lastName, text);
//		sendText(addEmp.photo, photoPath);
//		waitForClickability(addEmp.saveBtn);
		
		
		
	}
	
}
