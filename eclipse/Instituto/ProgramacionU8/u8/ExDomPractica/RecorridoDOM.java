package ExDomPractica;

import java.util.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class RecorridoDOM {
	
	private List <Double> NumPlatos;
	
	public RecorridoDOM() {
		NumPlatos = new ArrayList();
	}
	
	public void mostrarXML(Document doc){
			Element root = doc.getDocumentElement();
			NodeList nl = root.getChildNodes();
			for(int i = 0; i < nl.getLength(); i++) {
				if(nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Node n = nl.item(i);
					if(n.hasChildNodes()) {
						NodeList hijos = n.getChildNodes();
						for(int j = 0; j < hijos.getLength(); j++) {
							if(hijos.item(j).getNodeType() == Node.ELEMENT_NODE) {
								Element ehijos = (Element) hijos.item(j);
								switch (ehijos.getTagName()){
									case "name":
										System.out.println(ehijos.getTagName()+": "+ehijos.getTextContent()+".");
									break;
									case "price":
										System.out.println(ehijos.getTagName()+": "+ehijos.getTextContent()+".");
										NumPlatos.add(Double.parseDouble(ehijos.getTextContent()));
									break;
									case "description":
										System.out.println(ehijos.getTagName()+": "+ehijos.getTextContent()+".");
									break;
									case "calories":
										System.out.println(ehijos.getTagName()+": "+ehijos.getTextContent()+"."+'\n');
									break;
								}
							}
						}
					}
				}
			}
	}
	
	public void mostrarXML2(Document doc){
		Element root = doc.getDocumentElement();
		NodeList nl = root.getChildNodes();
		for(int i = 0; i < nl.getLength(); i++) {
			if(nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Node n = nl.item(i);
				if(n.hasChildNodes()) {
					NodeList hijos = n.getChildNodes();
					for(int j = 0; j < hijos.getLength(); j++) {
						if(hijos.item(j).getNodeType() == Node.ELEMENT_NODE) {
							Element ehijos = (Element) hijos.item(j);
							switch (ehijos.getTagName()){
								case "name":
									System.out.println(ehijos.getTagName()+": "+ehijos.getTextContent()+".");
								break;
								case "price":
									System.out.println(ehijos.getTagName()+": "+ehijos.getTextContent()+".");
									NumPlatos.add(Double.parseDouble(ehijos.getTextContent()));
								break;
								case "description":
									System.out.println(ehijos.getTagName()+": "+ehijos.getTextContent()+".");
								break;
								case "calories":
									System.out.println(ehijos.getTagName()+": "+ehijos.getTextContent()+".");
								break;
								case "healthy":
									System.out.println(ehijos.getTagName()+": "+ehijos.getTextContent()+"."+'\n');
								break;
							}
						}
					}
				}
			}
		}
}
	
	public String cantidadDePlatos() {
		return "Hay: "+NumPlatos.size()+" en la carta.";
	}
	public void platoCaro(Document d) {
		Double precioCaro = 0.00;
		NodeList lista = d.getElementsByTagName("price");
			Element em = (Element) lista.item(0);
			for(int i = 0; i < lista.getLength(); i ++) {
				if(em.getNodeType()==Node.ELEMENT_NODE) {
					Element e = (Element) lista.item(i);
						if(Double.parseDouble(e.getTextContent())>precioCaro) {
							precioCaro = Double.parseDouble(e.getTextContent());
							em = e;
						}
				}
			}
			NodeList nl = em.getParentNode().getChildNodes();
			String plato = "";
			for(int i = 0; i < nl.getLength(); i++) {
				if(nl.item(i).getNodeType()==Node.ELEMENT_NODE) {
					Element plat = (Element) nl.item(i);
					if(plat.getTagName().equalsIgnoreCase("name")) {
						plato = plat.getTextContent();
					}
				}
			}
			System.out.println('\n'+"El plato más caro, es: "+plato+" y su precio es: "+precioCaro+"$.");
		}
	}
