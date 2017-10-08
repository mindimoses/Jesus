package mav.metro.framework;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ProjectConfig {

	public static Properties prop = new Properties();
	public static String filepath;
	static {
		try {
			filepath = System.getProperty("ResSuite");				
			if (filepath == null) {
				filepath = "projectconfig.properties";
				System.out.println(filepath);
				try{
					InputStream resourceStream = Thread.currentThread().getContextClassLoader()
							.getResourceAsStream(filepath);
					prop.load(resourceStream);
				} catch (Exception E) {
					Assert.fail(E.getMessage());
				}
			} else {				
				filepath = filepath + "/" + "projectconfig.properties";				
				prop.load(new FileInputStream(filepath));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPropertyValue(String key) {		
		return prop.getProperty(key);
	}

}
