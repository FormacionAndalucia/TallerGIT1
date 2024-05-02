package ExDomPractica;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class GeneraMenu {
	
	public void Menus(Document doc, menu menu) {
	    Element root = doc.getDocumentElement();
	    NodeList foodList = root.getElementsByTagName("food");
	    for (int i = 0; i < foodList.getLength(); i++) {
	        Element foodElement = (Element) foodList.item(i);
	        comida aux = new comida();
	        aux.setName(getTextContent(foodElement, "name").replaceAll("\n",""));
	        aux.setPrice(Double.parseDouble(getTextContent(foodElement, "price")));
	        aux.setDescription(getTextContent(foodElement, "description").replaceAll("\n",""));
	        aux.setCalories(Integer.parseInt(getTextContent(foodElement, "calories")));
	        aux.setHealthy(getTextContent(foodElement, "healthy"));
	        menu.add(aux);
	    }

	    System.out.println(menu.getMenu());
	}

	private String getTextContent(Element element, String tagName) {
	    NodeList nodeList = element.getElementsByTagName(tagName).item(0).getChildNodes();
	    Node node = nodeList.item(0);
	    return node.getNodeValue();
}
}