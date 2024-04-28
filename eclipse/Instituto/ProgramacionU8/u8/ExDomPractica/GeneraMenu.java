package ExDomPractica;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GeneraMenu {
	
	public void Menus(Document doc){
		Element root = doc.getDocumentElement();
		NodeList nl = root.getChildNodes();
		menu menu = new menu();
		for(int i = 0; i < nl.getLength(); i++) {
			comida aux = new comida();
			if(nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Node n = nl.item(i);
				if(n.hasChildNodes()) {
					NodeList hijos = n.getChildNodes();
					for(int j = 0; j < hijos.getLength(); j++) {
						if(hijos.item(j).getNodeType() == Node.ELEMENT_NODE) {
							Element ehijos = (Element) hijos.item(j);
							switch (ehijos.getTagName()){
								case "name":
									    aux.setName(ehijos.getTextContent());
								break;
								case "price":
									    aux.setPrice(Double.parseDouble(ehijos.getTextContent()));
								break;
								case "description":
									    aux.setDescription(ehijos.getTextContent());
								break;
								case "calories":
									    aux.setCalories(Integer.parseInt(ehijos.getTextContent()));
								case "healthy":
										aux.setHealthy(ehijos.getTextContent());
								break;
							}
						}
					}
				}
			}
		menu.add(aux);	
		}
		menu.getMenu();
	}
	
	public void generaJson() {
		
	}
}
