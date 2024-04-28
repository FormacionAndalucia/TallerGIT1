package ejercicio;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProcesaXML_completar {

    public static void main(String[] args) {

        try {

            //Cargo el Fichero XML en Memoria
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("C:\\Users\\jogag\\OneDrive\\Escritorio\\ProgramacionUD8\\u8\\ejercicio\\mascotas.xml"));

            //Cojo el elemento (etiqueta) raíz
            Element root = doc.getDocumentElement();

            //Obtengo todos los nodos hijos del elemento raíz
            NodeList nl = root.getChildNodes();
            ArrayList<Mascota> listaMascotas=new ArrayList<>();
            ArrayList<Propietario> listaPropietarios=new ArrayList<>();
            
            for (int i = 0; i < nl.getLength(); i++) {
            	//compruebo que sea un elemento
            	if(nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
            		//creo el elemento de la raiz MASCOTAS
            		Element e = (Element) nl.item(i);
            		//necesitamos meterlo como nodo para luego comprobar si tiene hijos ese nodo o si el mismo no ya es el hijo
            		Node no = nl.item(i);
            		//compruebo que sea una mascota o propietario
            		if(e.getTagName().equalsIgnoreCase("mascota")) {
            			//creo el objeto dentro para usarlo de auxiliar y modificarlo
            			Mascota a = new Mascota();
            			//verifico que tenga atributos
            			if(e.hasAttributes()) {
            				//paso a un map de atributo = resultado, aunque xml los reconoce como nodo = atributo
            				NamedNodeMap nodeMapa = e.getAttributes();
            				for(int j = 0; j < nodeMapa.getLength(); j++) {
            					//meto cada atributo en un node llamado nodo
            					Node nodo = nodeMapa.item(j);
            					//vuelca cada nodo en un tipo atributo
            					Attr at = e.getAttributeNode(nodo.getNodeName());
            					if(at.getNodeName().equalsIgnoreCase("tipo")) {
            						a.setTipo(at.getValue());
            					} else {
            						a.setChip(at.getValue());
            					}
            				}
            			}
            			//verificamos si el no es un nodo padre un nodo hijo
            			if(no.hasChildNodes()) {
            				NodeList hijos = no.getChildNodes();
            				for(int y = 0; y < hijos.getLength(); y++) {
            					//IMPORTANTE VERIFICAR QUE SON ELEMENTOS, YA QUE hijos LEE DE NUEVO EL FICHERO ENTERO Y PILLA LOS SALTOS DE LINEAS DE NUEVO
            					if(hijos.item(y).getNodeType() == Node.ELEMENT_NODE) {
            						Element ehijo = (Element) hijos.item(y);
            						if(ehijo.getTagName().equals("nombre")) {
            							a.setNombre(ehijo.getTextContent());
            						}else {
            							a.setPropietario(ehijo.getTextContent());
            						}
            					}
            				}
            			}
            			listaMascotas.add(a);
            		//si es propietario ->
            		}else {
                    	Propietario p = new Propietario();
            			if(no.hasChildNodes()) {
            				NodeList hijos = no.getChildNodes();
            				for(int y = 0; y < hijos.getLength(); y++) {
            					//IMPORTANTE VERIFICAR QUE SON ELEMENTOS, YA QUE hijos LEE DE NUEVO EL FICHERO ENTERO Y PILLA LOS SALTOS DE LINEAS DE NUEVO
            					if(hijos.item(y).getNodeType() == Node.ELEMENT_NODE) {
            						Element ehijo = (Element) hijos.item(y);
            						if(ehijo.getTagName().equals("dni")) {
            							p.setDni(ehijo.getTextContent());
            						}else {
            							p.setNombre(ehijo.getTextContent());
            						}
            					}
            				}
            			}
            			listaPropietarios.add(p);
            		}
            	}
            }
            System.out.println("\n"+listaMascotas);
            System.out.println("\n"+listaPropietarios);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}