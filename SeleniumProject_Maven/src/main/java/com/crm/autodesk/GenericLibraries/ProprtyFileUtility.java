package com.crm.autodesk.GenericLibraries;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author saday kumar
 *
 */

public class ProprtyFileUtility {
	//this method contains method to read the data from property file
	public String getPropertyFileData(String key) throws Throwable {
	FileInputStream fis = new FileInputStream(IPathConstants.PropertyFilePath);
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	
	

}
}