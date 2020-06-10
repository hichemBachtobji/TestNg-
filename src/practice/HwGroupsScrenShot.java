package practice;

import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class HwGroupsScrenShot extends CommonMethods {

//	@Test
//	public void login(String username, String password ) {
//		sendText(login.username, ConfigsReader.getProperty("userName"));
//		sendText(login.password, ConfigsReader.getProperty("password"));
//		click(login.loginBtn);
//	}
	
	@Test(dataProvider="testData")
	public void diffEmpCred(String firstname, String lastname, String username, String password) {
		
		login.login(ConfigsReader.getProperty("userName"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		wait(1);
		sendText(addEmp.empName, firstname);
		sendText(addEmp.lastName, lastname);
		String expectedID = addEmp.empId.getAttribute("value");
		wait(1);
		addEmp.createLoginBtn.click();
		//addEmp.createLoginCr();
		sendText(addEmp.username, username);
		sendText(addEmp.userPwd, password);
		sendText(addEmp.rePwd, password);
		wait(1);
		addEmp.saveBtn.click();
		
		String actualID = pdetails.empId.getAttribute("value");
		Assert.assertEquals(actualID, expectedID, "Ids are not matched");
		
		TakesScreenshot(firstname+"_"+ lastname);
	
	}
	
	@DataProvider(name="testData")
		public Object [] [] getData() {
		Object [] [] data= {{"Hichem1","Bachtobji1","HichemBachtobji1","+HichemBach123@"},
		{"Hichem1","Bachtobji1","HichemBachtobji1","+HichemBach123@"},
		{"Hichem1","Bachtobji1","HichemBachtobji1","+HichemBach123@"}
		};
				
			return data;
		
	}
	
	
}
