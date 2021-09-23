package com.practice;

import com.crm.autodesk.GenericLibraries.JSONFileUtility;

public class DemoFileReader {
	public static void main(String[] args) throws Throwable {
		JSONFileUtility jasonLib = new JSONFileUtility();
		String val = jasonLib.readDataFromJSON("url");
		System.out.println(val);
		
	}

}
