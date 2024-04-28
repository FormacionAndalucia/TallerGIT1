package ExDomPractica;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Main {
	public static void main(String [] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			Document doc = db.parse("C:\\Users\\Usuario\\Desktop\\DEV\\NTTData\\SVC\\eclipse\\Instituto\\ProgramacionU8\\u8\\ExDomPractica\\ejercicio1.xml");
			RecorridoDOM lee = new RecorridoDOM();
			lee.mostrarXML(doc);
			System.out.println();
			System.out.println();
			System.out.println(lee.cantidadDePlatos());
			lee.platoCaro(doc);
			ModificadoDOM mod = new ModificadoDOM();
			mod.añadeComida(doc);
			mod.añadeHealthyACadaPlato(doc);
			System.out.println();
			lee.mostrarXML2(doc);
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
