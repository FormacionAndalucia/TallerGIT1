package practicaExtra;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModificaXML {
	public static void main(String [] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("C:\\Users\\Usuario\\Desktop\\DEV\\NTTData\\WORKSPACES\\Eclipse\\Instituto\\ProgramacionU8\\u8\\practicaExtra\\MascotitasGen.xml");
			Element root = doc.getDocumentElement();
			
			
			NodeList mascotas = doc.getElementsByTagName("Mascotas");
			for (int i = 0; i < mascotas.getLength(); i++) {
				Mascota perro = new Mascota();
				Element pe =(Element) mascotas.item(i);
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
