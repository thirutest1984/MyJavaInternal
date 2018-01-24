package com.assignments;

/**
 * #2. JAXB marshalling. Marshall below object and print XML on console
 * SCartItem
 * Item name
 * Item code
 * special discount
 * Numbers
 */

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class SCartItem {
	// class variables
	private String itemName;
	private int itemCode;
	private float specialDiscount;

	// setter and getter methods
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public float getSpecialDiscount() {
		return specialDiscount;
	}

	public void setSpecialDiscount(float specialDiscount) {
		this.specialDiscount = specialDiscount;
	}
}

public class PrintXmlOnConsole {

	public static void main(String[] args) {
		SCartItem sci = new SCartItem(); // SCartItem class object
		// set values
		sci.setItemName("Mobile");
		sci.setItemCode(100);
		sci.setSpecialDiscount(10);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(SCartItem.class); // create the JAXBContext

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller(); // create marshaller object
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(sci, System.out); // printing to console
			
			System.out.println("XML is created successfully.");
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
