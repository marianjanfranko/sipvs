import java.io.File;

import javax.xml.transform.stream.StreamSource;

import formular.xmlutils.XMLValidator;
import formular.xmlutils.XMLtoHTML;

public class TestApp {

	public TestApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLValidator xv = new XMLValidator();
		System.out.println(xv.validate("test_xml.xml","test_xsd.xsd"));
		
		XMLtoHTML.convertXMLToHTML(new StreamSource(new File("src/test/resources/test_xml2.xml")),new StreamSource(new File("src/test/resources/test_xsl.xsl")), "src/test/resources/final.html");
	}

}
