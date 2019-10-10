package xmlutils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLSerializer {

	public XMLSerializer() {
	}
	
	public void serializeXML(String xmlPath, Object obj) throws JsonGenerationException, JsonMappingException, IOException{
	    XmlMapper xmlMapper = new XmlMapper();
	    xmlMapper.writeValue(new File(xmlPath), obj);
	    System.out.println("XML generated at " + xmlPath);
	}
}
