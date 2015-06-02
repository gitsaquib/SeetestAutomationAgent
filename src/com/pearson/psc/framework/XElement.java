package com.pearson.psc.framework;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XElement {
	
	private String zone;
	private String element;
	private String controlName;
	private String controlType;
	private String controlText;
	private String index;
	private String xCoordinate;
	private String yCoordinate;
	
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public String getControlName() {
		return controlName;
	}
	public void setControlName(String controlName) {
		this.controlName = controlName;
	}
	public String getControlType() {
		return controlType;
	}
	public void setControlType(String controlType) {
		this.controlType = controlType;
	}
	public String getControlText() {
		return controlText;
	}
	public void setControlText(String controlText) {
		this.controlText = controlText;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(String xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public String getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(String yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	public static XElement getControl(String controlXml, String viewName, String controlName) {
		File fXmlFile = new File(controlXml);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			Element docEle = doc.getDocumentElement();
			NodeList osList = docEle.getElementsByTagName("OS");
		 	for(int os=0; os<osList.getLength(); os++) {
		 		Element osElement = (Element) osList.item(os);
		 		if(osElement.getAttribute("OSName").equalsIgnoreCase("IOS")) {
		 			NodeList viewList = osElement.getElementsByTagName("View");
		 			for(int v=0; v<viewList.getLength(); v++) {
		 				Element vElement = (Element) viewList.item(v);
		 				if(vElement.getAttribute("ViewName").equalsIgnoreCase(viewName)) {
		 					NodeList controlList = vElement.getElementsByTagName("Control");
		 					for(int c=0; c<controlList.getLength(); c++) {
				 				Element cElement = (Element) controlList.item(c);
				 				if(cElement.getAttribute("ControlName").equalsIgnoreCase(controlName)) {
				 					XElement xElement = new XElement();
				 					xElement.setControlName(controlName);
				 					xElement.setControlText(getTextValue(cElement, "ControlText"));
				 					xElement.setControlType(getTextValue(cElement, "ControlType"));
				 					xElement.setElement(getTextValue(cElement, "Element"));
				 					xElement.setIndex(getTextValue(cElement, "Index"));
				 					xElement.setZone(getTextValue(cElement, "Zone"));
				 					return xElement;
				 				}
		 					}
		 				}
		 			}
		 		}
		 	}
		 	
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	private static String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}
}
