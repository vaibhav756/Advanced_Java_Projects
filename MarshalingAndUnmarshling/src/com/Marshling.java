package com;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshling {

	public static void main(String[] args) {
		Employee e=new Employee();
        e.setEmpId(101);
        e.setEmpName("Vaibhav Yadav");
        e.setEmpSal(1000.00);
        
        try {
			JAXBContext instance=JAXBContext.newInstance(Employee.class);
			Marshaller marshal=instance.createMarshaller();
			marshal.marshal(e,new File("Employee.xml"));
			marshal.setProperty(marshal.JAXB_FORMATTED_OUTPUT,true);
			marshal.marshal(e,System.out);
			
			
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
