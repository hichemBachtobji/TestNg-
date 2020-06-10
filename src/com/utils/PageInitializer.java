package com.utils;

import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.pages.PersonalDetailsPageElements;
import com.pages.addEmployee;

public class PageInitializer extends BaseClass {
	
	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static addEmployee addEmp;
	public static PersonalDetailsPageElements pdetails;
	
	public static void initialize() {
		
		login= new LoginPageElements();
		dashboard= new DashboardPageElements();
		addEmp= new addEmployee();
		pdetails = new PersonalDetailsPageElements();
		
	}

}
