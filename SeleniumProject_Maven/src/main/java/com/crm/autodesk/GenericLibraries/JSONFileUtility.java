package com.crm.autodesk.GenericLibraries;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileUtility {
	public String readDataFromJSON(String key) throws Throwable {
		FileReader file = new FileReader("./commondata.json");
		JSONParser jsonobj = new JSONParser();
		Object jobj = jsonobj.parse(file);
		HashMap map = (HashMap) jobj;
		String value = map.get(key).toString();
		return value;
	

}
}