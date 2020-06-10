package practice;

import org.testng.annotations.Test;

import com.pages.DashboardPageElements;
import com.pages.addEmployee;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest extends CommonMethods {
	
	
  @Test
  public void verifyNameEmpIdPhoto() {
	  DashboardPageElements dashboard=new DashboardPageElements();
	 // click(dashborad.PIM);
	 
	  //click(dashboard.PIM);
	  dashboard.PIM.click();
	  wait(2);
	  //click(dashboard.addEmp);
	  dashboard.addEmp.click();
	  wait(2);
	  addEmployee add= new addEmployee();
	  boolean verifyName= add.empName.isDisplayed();
	  Assert.assertTrue(verifyName, "first name is displayed");
	  
	 boolean verifyLastName= add.lastName.isDisplayed();
	 Assert.assertTrue(verifyLastName, "last name is displayed");
	 
	 boolean verifyId=add.empId.isDisplayed();
	 Assert.assertTrue(verifyId,"employee ID is displayed");
	 
	 boolean verifyPhoto=add.photo.isDisplayed();
	 Assert.assertTrue(verifyPhoto,"photo is displayed");
	  
  }
  
  @Test
  public void addPicture() {
	  DashboardPageElements dashboard= new DashboardPageElements();
	  click(dashboard.PIM);
	  click(dashboard.addEmp);
	  addEmployee add= new addEmployee();
	  
	  
	  sendText(add.empName, "Bob");
	  
	  sendText(add.lastName, "Marley");
	  wait(2);
	  //click(add.photo);
	  String photoPath="C:\\Users\\bacht\\OneDrive\\Pictures";
	 add.photo.sendKeys(photoPath);
	  wait(2);
	  click(add.saveBtn);
	  
	  
  }
  
  
  @BeforeMethod
  public void urlAndSignIn() {
	  setUp();
	  
	   WebElement userName = driver.findElement(By.id("txtUsername"));
	  sendText(userName, ConfigsReader.getProperty("userName"));
	  
	  WebElement password = driver.findElement(By.id("txtPassword"));
	  sendText(password, ConfigsReader.getProperty("password"));
	  
	  WebElement loginBtn = driver.findElement(By.id("btnLogin"));
	  click(loginBtn);
	  
	  
  }

 @AfterMethod
  public void quitBrowser() {
	  wait(5);
	 tearDown();
  }

}
