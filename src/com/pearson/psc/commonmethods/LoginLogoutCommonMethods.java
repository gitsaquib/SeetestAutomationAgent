package com.pearson.psc.commonmethods;

import com.pearson.psc.framework.AutomationAgent;

public class LoginLogoutCommonMethods {

	public static void setTextInUsername(AutomationAgent loginLogoutAutomationAgent, String username)
    {
		loginLogoutAutomationAgent.setText("LoginView", "UserName", "u");
		loginLogoutAutomationAgent.sendText("{BKSP}");
		loginLogoutAutomationAgent.sendText(username);
    }
	
	public static void setTextInPassword(AutomationAgent loginLogoutAutomationAgent, String password)
    {
        loginLogoutAutomationAgent.setText("LoginView", "Password", "p");
        loginLogoutAutomationAgent.sendText("{BKSP}");
        loginLogoutAutomationAgent.sendText(password);
    }
	
	public static void clickLoginButton(AutomationAgent loginLogoutAutomationAgent)
    {
        loginLogoutAutomationAgent.click("LoginView", "Login");
    }
	
	public static void verifyUsernameRequiredPopUp(AutomationAgent loginLogoutAutomationAgent)
    {
        loginLogoutAutomationAgent.verifyElementFound("LoginView", "LoginFailedPopup");
        loginLogoutAutomationAgent.verifyElementFound("LoginView", "UserNameRequiredPopUp");
        loginLogoutAutomationAgent.verifyElementFound("LoginView", "OkButton");
    }
	
	public static void clickUsernamePasswordOkButton(AutomationAgent loginLogoutAutomationAgent)
    {
        loginLogoutAutomationAgent.click("LoginView", "OkButton");
    }
}
