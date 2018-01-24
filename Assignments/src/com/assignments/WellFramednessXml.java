package com.assignments;

/**
 * #1. XML wellformedness
 */

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class WellFramednessXml {

	public static void main(String[] args) {

		String xmlFile = "Student-details.xml";
		File file = new File(xmlFile);
		if (file.exists()) {
			try {
				// new factory for parsers
				DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();

				// create a builder and parse the document
				DocumentBuilder builder = dBF.newDocumentBuilder();

				// input source xml file
				InputSource is = new InputSource(xmlFile);

				Document doc = builder.parse(is);
				System.out.println(xmlFile + " is a well formed XML.");
			} catch (Exception e) {
				System.out.println(xmlFile + " is not a well formed XML.");
			}
		} else {
			System.out.println("XML file not exists.");

		}

	}

}
