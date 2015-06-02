package com.pearson.psc.framework;
import com.experitest.client.Client;

public class AutomationAgent {
	
	private Client client = null;
	private XElement xElement = null;
	private Control control = null;
	private String xmlFile = null;
	public int DefaultWaitTime = 4000;
	
	public AutomationAgent(String testDetails)
    {
		xmlFile = "D:/Project/PSoC/code/SeeTestAutomation/Pearson.PSCAutomation.212App/Xml/Controls.xml";
		client = new Client("localhost", 8889, true);
		client.setProjectBaseDirectory("212SeeTestProject");
        client.setReporter("xml", "D:\\SeeTestReports", testDetails);
        client.setShowPassImageInReport(false);
        client.setDevice("ios_app:KiransAir2");
        client.launch("com.pearson.commoncore.develop", true, false);
    }
	
	public boolean closeApplication() {
		return client.applicationClose("com.pearson.commoncore.develop");
	}
	
	public void setDefaultclickDownTime(int clickDownTime) {
		client.setDefaultClickDownTime(clickDownTime);
	}
	
	public void closeKeyBoard() {
		client.closeKeyboard();
	}
	
	public void setDragStartDelay(int startDelay) {
		client.setDragStartDelay(startDelay);
	}
	
	public int getElementCount(String zone, String viewName, String controlName)
    {
        this.populateControl(viewName, controlName);
        return client.getElementCount(zone, this.control.getElement());
    }
	
	private void populateControl(String viewName, String controlName) {
		xElement = XElement.getControl(xmlFile, viewName, controlName);
		control = new Control(xElement);
	}
	
	private void populateDynamicControl(String viewName, String controlName, String dynamicVariable)
    {
		xElement = XElement.getControl(xmlFile, viewName, controlName);
        this.control = new Control(xElement);
        String updatedElement = this.control.getElement().replace("()", dynamicVariable);
        String updatedControlText = this.control.getControlText().replace("()", dynamicVariable);
        this.control.setElement(updatedElement);
        this.control.setControlText(updatedControlText);
    }
	
	public void addSteptoSeeTestReport(String message, boolean passOrFail)
    {
        client.report(message, passOrFail);
    }
	
	public void click(String viewName, String controlName)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.click(this.control.getZone(), this.control.getElement(), this.control.getIndex(), 1);
    }

    public boolean waitForElement(String viewName, String controlName, String dynamicVariable)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        return client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime);
    }

    public boolean waitForElement(String Zone, String viewName, String controlName, String dynamicVariable)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        return client.waitForElement(Zone, this.control.getElement(), this.control.getIndex(), DefaultWaitTime);
    }

    public void click(String viewName, String controlName, String dynamicVariable)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.click(this.control.getZone(), this.control.getElement(), this.control.getIndex(), 1);
    }

    public void click(String viewName, String controlName, String dynamicVariable, int Index)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.click(this.control.getZone(), this.control.getElement(), Index, 1);
    }

    public void setText(String viewName, String controlName, String textToSet)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            ;
        }
        client.elementSendText(this.control.getZone(), this.control.getElement(), this.control.getIndex(), textToSet);
    }

    public void sendText(String text)
    {
        client.sendText(text);
        this.sleep(500);
    }

    public void clickOnScreen(int x, int y)
    {
        client.clickCoordinate(x, y, 1);
    }

    public boolean waitForElement(String viewName, String controlName)
    {
        this.populateControl(viewName, controlName);
        return client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime);
    }

    public void verifyElementNotFound(String viewName, String controlName)
    {
    	this.sleep(DefaultWaitTime);
        this.populateControl(viewName, controlName);
        client.verifyElementNotFound(this.control.getZone(), this.control.getElement(), this.control.getIndex());
    }

    public void verifyElementFound(String viewName, String controlName)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.verifyElementFound(this.control.getZone(), this.control.getElement(), this.control.getIndex());
    }
           
    public void verifyElementFound(String viewName, String controlName, String dynamicVariable)
    {
        this.sleep(DefaultWaitTime);
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.verifyElementFound(this.control.getZone(), this.control.getElement(), this.control.getIndex());
    }

    public void verifyElementFound(String viewName, String controlName, String dynamicVariable, String Zone)
    {
    	this.sleep(DefaultWaitTime);
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.verifyElementFound(Zone, this.control.getElement(), this.control.getIndex());
    }


    public void verifyElementFoundInZone(String zone, String element, int index)
    {
    	this.sleep(DefaultWaitTime);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.verifyElementFound(zone, element, index);
    }

    public boolean waitForElementToVanish(String viewName, String controlName)
    {
        this.populateControl(viewName, controlName);
        return client.waitForElementToVanish(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime);
    }

    public boolean waitForElementToVanish(String viewName, String controlName, String dynamicVariable)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        return client.waitForElementToVanish(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime);
    }

    public String GetElementProperty(String viewName, String controlName, String property)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.elementGetProperty(this.control.getZone(), this.control.getElement(), this.control.getIndex(), property);
    }

    public String GetElementProperty(String viewName, String controlName, String property, int index)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), index, DefaultWaitTime))
        {
            // If statement
        }
        return client.elementGetProperty(this.control.getZone(), this.control.getElement(), index, property);
    }
    
    public String GetElementProperty(String viewName, String controlName, String property, String dynamicvalue)
    {
        this.populateDynamicControl(viewName, controlName, dynamicvalue);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.elementGetProperty(this.control.getZone(), this.control.getElement(), this.control.getIndex(), property);
    }

    public boolean IsElementEnabled(String viewName, String controlName)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return Boolean.getBoolean(client.elementGetProperty(this.control.getZone(), this.control.getElement(), this.control.getIndex(), "enable"));
    }

    public boolean IsElementEnabled(String viewName, String controlName, String dynamicVariable)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return Boolean.getBoolean(client.elementGetProperty(this.control.getZone(), this.control.getElement(), this.control.getIndex(), "enable"));
    }

    public void setElementProperty(String viewName, String controlName, String property, String value)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.elementSetProperty(this.control.getZone(), this.control.getElement(), this.control.getIndex(), property, value);
    }

    public void longclick(String viewName, String controlName, int X, int Y)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.longClick(this.control.getZone(), this.control.getElement(), this.control.getIndex(), 1, X, Y);
    }

    public void longclick(String viewName, String controlName, String dynamicVariable, int X, int Y)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.longClick(this.control.getZone(), this.control.getElement(), this.control.getIndex(), 1, X, Y);
    }

    public void swipeElement(String viewName, String controlName, Direction direction, int offSet, int swipeTime)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.elementSwipe(this.control.getZone(), this.control.getElement(), this.control.getIndex(), direction.toString(), offSet, swipeTime);
    }


    public void swipeElement(String viewName, String controlName, String dynamicVaiable, Direction direction, int offSet, int swipeTime)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVaiable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.elementSwipe(this.control.getZone(), this.control.getElement(), this.control.getIndex(), direction.toString(), offSet, swipeTime);
    }


    public void swipe(Direction direction)
    {
        client.swipe(direction.toString(), 500);
    }

    public String[] getAllValues(String viewName, String controlName, String property)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.getAllValues(this.control.getZone(), this.control.getElement(), property);
    }

    public String[] getAllValues(String viewName, String controlName, String dynamicVariable, String property)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.getAllValues(this.control.getZone(), this.control.getElement(), property);
    }

    public String[] getAllValues(String viewName, String controlName, String zone, String dynamicVariable, String property)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(zone, this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.getAllValues(zone, this.control.getElement(), property);
    }


    public void runNativeApICall(String viewName, String controlName, String script)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.runNativeAPICall(this.control.getZone(), this.control.getElement(), this.control.getIndex(), script);
    }

    public boolean isElementFound(String viewName, String controlName)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.isElementFound(this.control.getZone(), this.control.getElement(), this.control.getIndex());

    }

    public boolean isElementFound(String viewName, String controlName, String dynamicVariable)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.isElementFound(this.control.getZone(), this.control.getElement());
    }

    public boolean isElementFound(String viewName, String controlName, String dynamicVariable, String zone)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.isElementFound(zone, this.control.getElement(), this.control.getIndex());
    }

    public void dragElement(String viewName, String controlName, int xOffset, int yOffset)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        client.drag(this.control.getZone(), this.control.getElement(), this.control.getIndex(), xOffset, yOffset);
    }

    public String getPosition(String viewName, String controlName)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return this.client.getPosition(this.control.getZone(), this.control.getElement());

    }

    public String getPosition(String viewName, String controlName, String dynamicVar)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVar);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return this.client.getPosition(this.control.getZone(), this.control.getElement());
    }


    public String getElementText(String viewName, String controlName)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.elementGetText(this.control.getZone(), this.control.getElement(), this.control.getIndex());
    }

    public String getElementText(String viewName, String controlName, int index)
    {
        this.populateControl(viewName, controlName);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.elementGetText(this.control.getZone(), this.control.getElement(), index);
    }
    
    public String getElementText(String viewName, String controlName, String dynamicvar)
    {
        this.populateDynamicControl(viewName, controlName, dynamicvar);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.elementGetText(this.control.getZone(), this.control.getElement(), this.control.getIndex());
    }

    public String getElementText(String Zone, String viewName, String controlName, String dynamicvar)
    {
        this.populateDynamicControl(viewName, controlName, dynamicvar);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.elementGetText(Zone, this.control.getElement(), this.control.getIndex());
    }
    
    public String getText(String zone)
    {
        return client.getText(zone);
    }

    public boolean pinchIn(int xCoordinate, int yCoordinate, int pinchRadius)
    {
        return client.pinch(true, xCoordinate, yCoordinate, pinchRadius);
    }

    public boolean pinchOut(int xCoordinate, int yCoordinate, int pinchRadius)
    {
        return client.pinch(false, xCoordinate, yCoordinate, pinchRadius);
    }

    public void drag(int fromX1, int fromY1, int toX2, int toY2)
    {
        client.dragCoordinates(fromX1, fromY1, toX2, toY2, 1000);
    }

    public void drawDiamondImage(int x1, int y1, int length)
    {
        int x2 = x1 + length;
        int y2 = y1 + length;
        int x3 = x1 + length / 2;
        int y3 = y1 - length;
        drag(x1, y1, x2, y1);
        drag(x3, y3, x3, y2);
        drag(x2, y1, x3, y3);
        drag(x3, y3, x1, y1);
        drag(x1, y1, x3, y2);
        drag(x3, y2, x2, y1);
    }
    public void installApp(String path)
    {
        client.install(path, true, true);
    }

    public void uninstallApp(String appName)
    {
        client.uninstall(appName);
    }

    public void addDevice(String serialNumber, String deviceName)
    {
        client.addDevice(serialNumber, deviceName);
    }

    public void captureScreenshot(String screenshotMessage)
    {
        client.capture(screenshotMessage);
    }

    public void clickCoordinate(int x, int y)
    {
        client.clickCoordinate(x, y, 1);
    }

    public void sleep(int milliSeconds)
    {
        try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void generateReportAndReleaseClient()
    {
        this.client.generateReport(true);
    }

    public void dispose()
    {
        this.generateReportAndReleaseClient();
    }

    public void swipe(Direction direction, int offset, int time)
    {
        client.swipe(direction.toString(), offset, time);
    }

    public String getTextIn(String viewName, String controlName, String direction, String dynamicVariable, int width, int height)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.getTextIn(this.control.getZone(), this.control.getElement(), this.control.getIndex(), direction, width, height);
    }

    public String getTextIn(String viewName, String controlName, String direction, String dynamicVariable, int index, int width, int height)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.getTextIn(this.control.getZone(), this.control.getElement(), index, direction, width, height);
    }

    public String getTextIn(String viewName, String controlName, String direction, String dynamicVariable, String textZone, int index, int width, int height)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.getTextIn(this.control.getZone(), this.control.getElement(), index, textZone, direction, width, height);
    }

    public String getTextIn(String viewName, String controlName, String TextZone, String direction, String dynamicVariable, int width, int height)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        if (client.waitForElement(this.control.getZone(), this.control.getElement(), this.control.getIndex(), DefaultWaitTime))
        {
            // If statement
        }
        return client.getTextIn(this.control.getZone(), this.control.getElement(), this.control.getIndex(), TextZone, direction, width, height);
    }

    public boolean isFoundIn(String viewName, String controlName, String direction, String zone, int width, int height)
    {
        this.populateControl(viewName, controlName);
        return client.isFoundIn(this.control.getZone(), this.control.getElement(), this.control.getIndex(), direction, zone, this.control.getElement(), width, height);
    }


    public boolean swipeWhileNotFound(String searchElementviewName, String searchElementcontrolName, String dynamicVariable, String direction, int offset, int swipetime, int delay, int rounds)
    {
        this.populateDynamicControl(searchElementviewName, searchElementcontrolName, dynamicVariable);
        return client.swipeWhileNotFound(direction, offset, swipetime, this.control.getZone(), this.control.getElement(), 0, delay, rounds, true);
    }

    public void install(String ipaFilePath, boolean upgrade)
    {
        client.install(ipaFilePath, upgrade);
    }

    public int getElementCount(String Zone, String viewName, String controlName, String dynamicVariable)
    {
        this.populateDynamicControl(viewName, controlName, dynamicVariable);
        return client.getElementCount(Zone, this.control.getElement());
    }

}
