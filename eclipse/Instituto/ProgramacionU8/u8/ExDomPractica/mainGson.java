package ExDomPractica;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class mainGson {
	public static void main(String [] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			Document doc;
			doc = db.parse("C:\\Users\\Usuario\\Desktop\\DEV\\NTTData\\SVC\\eclipse\\Instituto\\ProgramacionU8\\u8\\ExDomPractica\\ejercicio2.xml");
			menu menu = new menu();
			GeneraMenu genmenu = new GeneraMenu();
			genmenu.Menus(doc, menu);
			menu.generaJson();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
