package bddSDET_GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
	public static String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties properties = new Properties();
		properties.load(file);
		String value = properties.getProperty(key);
		return value;
	}

}
