package practice;

import org.testng.Assert;
import org.testng.annotations.*;

import com.pages.addEmployee;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

/*
 * Automate user stories below:
US 12678 As an Admin I should be able to create login credentials while adding employee

US 67789 As an admin while adding employee if I leave required fields empty I should see “Required” message
Note: first name and last name are required fields
 */

public class HwUserStory extends CommonMethods {
	
	@Test
	public void createLoginCr () {
		login.login(ConfigsReader.getProperty("userName"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		
		addEmp.addEmpInfo();
		addEmp.createLoginCr();
		String expected="Bob Marley";
		String actual=pdetails.textProfilePic.getText();
		//Assert.assertEquals(addEmp.profilePic.getText(), expected, "new employee is NOT added");
		Assert.assertEquals(actual, expected, "new employee is NOT added");
	}
	
	@Test
	public void verifyErrMsg() {
		login.login(ConfigsReader.getProperty("userName"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		
		addEmp.saveBtn.click();
		String expected="Required";
		String firstNameReq= addEmp.reqFname.getText();
		String lastNameReq= addEmp.reqLname.getText();
		
		Assert.assertEquals(firstNameReq, expected, "first name required");
		Assert.assertEquals(lastNameReq, expected, "last name required");
	}

}
