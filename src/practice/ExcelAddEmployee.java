package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;
import com.utils.Constants;
import com.utils.ExcelUtility;

public class ExcelAddEmployee extends CommonMethods{
	
	@Test(dataProvider = "getData")
	public void addEmployee(String firstname, String lastname, String username, String password) {
		login.login(ConfigsReader.getProperty("userName"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		
		sendText(addEmp.empName, firstname);
		sendText(addEmp.lastName, lastname);
		String expected = addEmp.empId.getAttribute("value");
		addEmp.createLoginBtn.click();
		sendText(addEmp.username, username);
		sendText(addEmp.userPwd, password);
		sendText(addEmp.rePwd, password);
		click(addEmp.saveBtn);
		
		String actual = pdetails.empId.getAttribute("value");
		Assert.assertEquals(actual, expected, "employee Id is not matched");
		wait(2);
		TakesScreenshot(firstname+" "+lastname);
	}
	
	@DataProvider
	public Object [][] getData(){
		return ExcelUtility.excelToArray(Constants.EXCEL_FILE_PATH, "Sheet1");
		
		
	}

}
