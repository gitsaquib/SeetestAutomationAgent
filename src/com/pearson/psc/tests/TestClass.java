package com.pearson.psc.tests;
import org.junit.Test;

import com.pearson.psc.commonmethods.LoginLogoutCommonMethods;
import com.pearson.psc.framework.AutomationAgent;
import com.pearson.psc.framework.XElement;


public class TestClass {
	
	AutomationAgent loginLogoutAutomationAgent;
	
	@Test
	public void ErrorMessageOnUnsuccessfulLogin() {
		loginLogoutAutomationAgent = new AutomationAgent("TC17664: error message on unsuccessful login is a native iOS pop-up");
		LoginLogoutCommonMethods.setTextInUsername(loginLogoutAutomationAgent, "");
        LoginLogoutCommonMethods.setTextInPassword(loginLogoutAutomationAgent, "sch00lnet");
        LoginLogoutCommonMethods.clickLoginButton(loginLogoutAutomationAgent);
        LoginLogoutCommonMethods.verifyUsernameRequiredPopUp(loginLogoutAutomationAgent);
        LoginLogoutCommonMethods.clickUsernamePasswordOkButton(loginLogoutAutomationAgent);
	}

}
