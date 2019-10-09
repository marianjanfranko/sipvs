import java.io.File;
import java.io.IOException;

import javax.xml.transform.stream.StreamSource;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import xmlutils.XMLValidator;


public class TestApp {

	public TestApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Object obj = new SimplePojo();
		formular.xmlutils.XMLSerializer.serializeXML("src/test/resources/generated_xml.xml", obj);
		
		
		XMLValidator xv = new XMLValidator();
		System.out.println("Validation result: " + xv.validate("data.xml","scheme.xsd"));
		
		xmlutils.XMLtoHTML.convertXMLToHTML(new StreamSource(new File("src/test/resources/test_xml2.xml")),new StreamSource(new File("src/test/resources/test_xsl.xsl")), "src/test/resources/final.html");
	}

}
