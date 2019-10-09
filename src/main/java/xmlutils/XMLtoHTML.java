package formular.xmlutils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;

public class XMLtoHTML {


	public static void convertXMLToHTML(Source source, Source source2, String finalFilePath) {
		StringWriter sw = new StringWriter();

		try {

			FileWriter fw = new FileWriter(finalFilePath);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer trasform = tFactory.newTransformer(source2);
			trasform.transform(source, new StreamResult(sw));
			fw.write(sw.toString());
			fw.close();

			System.out
					.println("file generated at " + finalFilePath);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}
}