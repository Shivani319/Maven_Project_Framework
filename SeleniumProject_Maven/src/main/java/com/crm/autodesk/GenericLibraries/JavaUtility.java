package com.crm.autodesk.GenericLibraries;

import java.util.Random;

/**
 * 
 * @author saday kumar
 *
 */
public class JavaUtility {
	/**
	 * This method generates random number
	 */
public int getRandomNum()
{
	Random ran = new Random();
	int randomNum = ran.nextInt(1000);
	return randomNum;
	
}
}
