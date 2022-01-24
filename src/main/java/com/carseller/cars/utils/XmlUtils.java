package com.carseller.cars.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlUtils {
	
	public static <T> T unmarshal(Class<T> classe, String filename) throws JAXBException, IOException {
		
		File file = new ClassPathResource(filename).getFile();
	  
	  	JAXBContext jaxbContext = JAXBContext.newInstance(classe);              
   
      	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
   
      	@SuppressWarnings("unchecked")
		T obj = (T) jaxbUnmarshaller.unmarshal(file);

      	Writer w = new StringWriter();
      	jaxbContext.createMarshaller().marshal(obj, w);
      	log.info("File read : {}", w.toString());
		  
		return obj;
	}

}
