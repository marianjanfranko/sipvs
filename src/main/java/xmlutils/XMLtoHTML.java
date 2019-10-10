package xmlutils;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class XMLtoHTML {


	public void convertXMLToHTML(Source source, Source source2, String finalFilePath) {
		StringWriter sw = new StringWriter();

		try {

			FileWriter fw = new FileWriter(finalFilePath);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer trasform = tFactory.newTransformer(source2);
			trasform.transform(source, new StreamResult(sw));
			fw.write(sw.toString());
			fw.close();

			System.out.println("file generated at " + finalFilePath);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}
}