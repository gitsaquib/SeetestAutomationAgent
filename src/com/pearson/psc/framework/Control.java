package com.pearson.psc.framework;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Control {
	
	private String zone;
    private String element;
    private String controlName;
    private int index;
    private String controlType;
    private String controlText;
    private int xcoordinate;
    private int ycoordinate;
    
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
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
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
	public int getXcoordinate() {
		return xcoordinate;
	}
	public void setXcoordinate(int xcoordinate) {
		this.xcoordinate = xcoordinate;
	}
	public int getYcoordinate() {
		return ycoordinate;
	}
	public void setYcoordinate(int ycoordinate) {
		this.ycoordinate = ycoordinate;
	}
	
	public Control(XElement xElement) {
		this.controlName = xElement.getControlName();
		this.controlText = xElement.getControlText();
		this.element = xElement.getElement();
		int indexOfElement = 0;
		if(null != xElement.getIndex()) {
			try {
				indexOfElement = Integer.parseInt(xElement.getIndex());
			} catch (Exception ex) {
				
			}
		}
		this.index = indexOfElement;
	 	this.zone = xElement.getZone();
	}
}
