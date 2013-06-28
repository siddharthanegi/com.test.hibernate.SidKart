package com.test.hibernate.xmlService;

import java.io.IOException;
import java.io.StringWriter;


import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.stereotype.Service;



@Service
public class MarshallerService {
	
	@Autowired private Marshaller marshaller;
	
	public String doMarshalling(Object obj) throws IOException{
		
	
			StringWriter outWriter=new StringWriter();
			marshaller.marshal(obj, new StreamResult(outWriter));
			return outWriter.toString();
	
	
	}
}
