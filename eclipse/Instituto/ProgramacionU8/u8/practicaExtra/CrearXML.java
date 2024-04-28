package practicaExtra;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import practicaExtra.Mascota.colorMas;

import org.xml.sax.Attributes;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CrearXML {

    public static void main(String[] args) {

        try {

            //Cargo el Fichero XML en Memoria
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            //Text sl = doc.createTextNode("\n");
            //Text tab = doc.createTextNode("\t");
          //creacion del nodo padre mascotas
            Element root = doc.createElement("Personas_y_Animales");
            doc.appendChild(root);
            Mascota perro = new Mascota("Perro","El perro cobarde", "98D9", "2442274L");
            Mascota raton = new Mascota("Raton", "Mickey" , "73846248P");
            Propietario p1 = new Propietario("2442274L", "Ramon");
            Propietario p2 = new Propietario("73846248P", "Fernando alonso", "El nano");
            //Mascota
            Element mascotas = doc.createElement("Mascotas");
            //Creamos el nodo mascota
            Element mascota = doc.createElement("mascota");
            //asignamos los atributos y al nodo mascota
            mascota.setAttribute("chip", perro.getChip());
            mascota.setAttribute("tipo", perro.getTipo());
            //Le creamos informacion sobre la mascota
            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(perro.getNombre());
            Element dueño = doc.createElement("propietario");
            dueño.setTextContent(perro.getPropietario());
            //Unimos a el elemento mascota los valores dueño y nombre
            mascota.appendChild(nombre);
            mascota.appendChild(dueño);
            mascotas.appendChild(mascota);
            //unimos el elemento mascota a el nodo padre "mascotas"
            root.appendChild(mascotas);
            //Propietarios
            Element propi = doc.createElement("Propietarios");
            Element propietario = doc.createElement("Propietario");
            propietario.setAttribute("Apodo", p2.getApodo());
            Element nombreP = doc.createElement("nombre");
            nombreP.setTextContent(p2.getNombre());
            Element DNIP = doc.createElement("DNI");
            DNIP.setTextContent(p2.getDni());
            propietario.appendChild(DNIP);
            propietario.appendChild(nombreP);
            propi.appendChild(propietario);
            root.appendChild(propi);
            
            
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            
            transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "no" );
            transformer.setOutputProperty( OutputKeys.METHOD, "xml" );
            transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");
            
            DOMSource origenDOM = new DOMSource(root);
            File Arch = new File("C:\\Users\\Usuario\\Desktop\\DEV\\NTTData\\WORKSPACES\\Eclipse\\Instituto\\ProgramacionU8\\u8\\practicaExtra\\MascotitasGen.xml");
            StreamResult destino = new StreamResult(Arch);
            transformer.transform(origenDOM, destino);
            
        } catch (ParserConfigurationException e) {
            System.out.println(e.getStackTrace());
        } catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}