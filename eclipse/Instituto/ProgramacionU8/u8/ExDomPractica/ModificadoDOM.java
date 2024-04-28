package ExDomPractica;

import java.io.File;
import java.util.Scanner;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class ModificadoDOM {
	ModificadoDOM(){}
	public void añadeComida(Document doc) {
		Element root = doc.getDocumentElement();
		//comida
		Element food = doc.createElement("food");
		String valores = "";
		Scanner tc = new Scanner(System.in);
		//nombre
		System.out.println("¿Cual será el nombre de la comida?");
		valores = tc.nextLine();
		Element nombre = doc.createElement("name");
		nombre.setTextContent(valores);
		food.appendChild(nombre);
		valores = "";
		//precio
		System.out.println("¿Cual será el precio de "+ nombre.getTextContent()+"?");
		valores = tc.nextLine();
		Element precio = doc.createElement("price");
		precio.setTextContent(valores);
		food.appendChild(precio);
		valores = "";
		//descripción
		System.out.println("¿Qué descripción tendra " + nombre.getTextContent()+"?");
		valores = tc.nextLine();
		Element descripcion = doc.createElement("description");
		descripcion.setTextContent(valores);
		food.appendChild(descripcion);
		valores = "";
		//calorias
		System.out.println("¿Cuantas calorias tendrá " + nombre.getTextContent()+"?");
		valores = tc.nextLine();
		Element calor = doc.createElement("calories");
		calor.setTextContent(valores);
		food.appendChild(calor);
		//último append
		root.appendChild(food);
		tc.close();
		escribeXML(root);
	}
	
	public void añadeHealthyACadaPlato(Document doc) {
		Element root = doc.getDocumentElement();
	    NodeList foodList = root.getElementsByTagName("food");
	    for (int i = 0; i < foodList.getLength(); i++) {
	        Element food = (Element) foodList.item(i);
	        Element caloriesElement = (Element) food.getElementsByTagName("calories").item(0);
	        int calorieValue = Integer.parseInt(caloriesElement.getTextContent());
	        Element healthy = doc.createElement("healthy");
	        if (calorieValue < 450) {
	            healthy.setTextContent("Yes");
	        } else {
	            healthy.setTextContent("No");
	        }
	        NodeList existingHealthy = food.getElementsByTagName("healthy");
	        if (existingHealthy.getLength() == 0) {
	            food.appendChild(healthy);
	        } 
	    }
	    escribeXML(root);
	}
	
	private void escribeXML(Element root) {
		 try {
		        TransformerFactory tf = TransformerFactory.newInstance();
		        Transformer transformer = tf.newTransformer();

		        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		        transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

		        DOMSource origenDOM = new DOMSource(root);
		        File archivo = new File("C:\\Users\\Usuario\\Desktop\\DEV\\NTTData\\SVC\\eclipse\\Instituto\\ProgramacionU8\\u8\\ExDomPractica\\ejercicio2.xml");
		        StreamResult destino = new StreamResult(archivo);
		        transformer.transform(origenDOM, destino);
		        System.out.println("Archivo cargado correctamente");
		    } catch (TransformerException e) {
		        System.out.println("No se pudo cargar el archivo, debido al error:"+'\n');
		        e.printStackTrace();
		    }
	}
}
