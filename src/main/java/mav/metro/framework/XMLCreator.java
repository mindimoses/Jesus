package mav.metro.framework;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class XMLCreator {

	private static XmlSuite suiteD, suiteM;

	private static XmlTest test;

	private static Map<String, Map<String, Map<String, ArrayList<Map<String, String>>>>> testsComb = new HashMap<String, Map<String, Map<String, ArrayList<Map<String, String>>>>>();
	private static List<XmlInclude> includemethod = new ArrayList<XmlInclude>();
	private static List<XmlClass> xmlclasslist = new ArrayList<XmlClass>();

	private static String basepkg = "mav.metro.alltestpack";
	private static XmlClass classxml;

	//initiating the scripts
	public static void main(String[] args) {
		initXML();
		ExcelReader xlReader = new ExcelReader(new XMLCreator());
		xlReader.readData();
		writeTestComb();
		generateXMLSuite();
		String xmlD = getXMLD();
		writeToXMLD(xmlD);
		String xmlM = getXMLM();
		writeToXMLM(xmlM);
	}

	private static void writeTestComb() {
		String serPath = System.getProperty("ResSuite") + "TestComb.json";		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(serPath);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(testsComb);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void generateXMLSuite() {
		//System.out.println("XML GENERATION");
		for (Entry<String, Map<String, Map<String, ArrayList<Map<String, String>>>>> tests : testsComb.entrySet()) {
			String testName = tests.getKey();
			System.out.println("TESTNAME : " + testName);
			if (testName.equals("Browser")) {
				test = new XmlTest(suiteD);
				test.setName(testName);
				test.setParallel(XmlSuite.DEFAULT_PARALLEL);
			} else if (testName.equals("mBrowser")) {
				test = new XmlTest(suiteM);
				test.setName(testName);
				test.setThreadCount(12);
				test.setParallel(XmlSuite.DEFAULT_PARALLEL);
			}
		}
		// test.setXmlClasses(xmlClassesList);
	}

	private static void initXML() {

		int threadcount = Integer.parseInt(ProjectConfig.getPropertyValue("threadCount"));
		int dpthreadcount = Integer.parseInt(ProjectConfig.getPropertyValue("dataproviderThreadCount"));
		suiteD = new XmlSuite();
		suiteD.setName("Browser");
		suiteD.setThreadCount(threadcount);
		// suiteD.setParallel(ParallelMode.METHODS);
		suiteD.setParallel(XmlSuite.PARALLEL_TESTS);
		// suiteD.setVerbose(10);
		suiteD.setDataProviderThreadCount(dpthreadcount);

		suiteM = new XmlSuite();
		suiteM.setName("mBrowser");
		suiteM.setParallel(XmlSuite.PARALLEL_TESTS);
		suiteM.setThreadCount(12);
		suiteM.setDataProviderThreadCount(1);
	}

	private static String getXMLD() {
		return suiteD.toXml();
	}

	private static String getXMLM() {
		return suiteM.toXml();
	}

	private static void writeToXMLD(String xml) {
		try {
			@SuppressWarnings("resource")
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("TestNgD.xml"), "utf-8"));
			writer.write(xml);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeToXMLM(String xml) {
		try {
			@SuppressWarnings("resource")
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("TestNgM.xml"), "utf-8"));
			writer.write(xml);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setCombination(Map<String, Map<String, Map<String, ArrayList<Map<String, String>>>>> testsComb) {
		XMLCreator.testsComb = testsComb;

	}

	public void writeTestNG(Map<String, String> combmap) {
		test = new XmlTest(suiteD);
		test.setThreadCount(12);
		test.setName(combmap.get("Testname") + "-" + combmap.get("Data"));
		System.out.println(combmap.get("Testname") + "-" + combmap.get("Data"));
		writeXML(test, combmap);
	}

	public void writeTestNGMob(Map<String, String> combmap) {
		test = new XmlTest(suiteM);
		test.setThreadCount(1);
		test.setName(combmap.get("Testname") + "-" + combmap.get("Device"));
		writeXML(test, combmap);
	}

	private void writeXML(XmlTest test, Map<String, String> combmap) {
		//System.out.println("�nside the xml");
		test.setParallel(XmlSuite.DEFAULT_PARALLEL);
		xmlclasslist = new ArrayList<XmlClass>();
		classxml = new XmlClass(basepkg + "." + combmap.get("Classname"));
		includemethod = classxml.getIncludedMethods();
		includemethod.add(new XmlInclude(combmap.get("Testname")));
		xmlclasslist.add(classxml);
		test.setXmlClasses(xmlclasslist);
	}

	public static void writeTestTag(String dkey, String classNM, List<String> mNames) {
		test = new XmlTest(suiteM);
		test.setThreadCount(1);
		test.setName(dkey);
		test.setThreadCount(1);
		xmlclasslist = new ArrayList<XmlClass>();

		classxml = new XmlClass(basepkg + "." + classNM);

		includemethod = classxml.getIncludedMethods();
		for (String mName : mNames) {

			XmlInclude x = new XmlInclude(mName);
			x.setXmlClass(classxml);
			includemethod.add(x);
		}
		classxml.setIncludedMethods(includemethod);
		xmlclasslist.add(classxml);

		test.setXmlClasses(xmlclasslist);
	}

}
