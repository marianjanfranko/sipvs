import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import xmlutils.XMLSerializer;
import xmlutils.XMLValidator;

import java.io.IOException;


public class TestApp {

	public TestApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Object obj = new SimplePojo();
		XMLSerializer xs = new XMLSerializer();
		xs.serializeXML("src/test/resources/generated_xml.xml", obj);
		
		
		XMLValidator xv = new XMLValidator();
		System.out.println("Validation result: " + xv.validate("data.xml","scheme.xsd"));
		
//		xmlutils.XMLtoHTML.convertXMLToHTML(new StreamSource(new File("src/test/resources/test_xml2.xml")),new StreamSource(new File("src/test/resources/test_xsl.xsl")), "src/test/resources/final.html");
	}

}
