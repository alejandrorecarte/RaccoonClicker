package controller.xml;

import model.Generador;
import model.Generadores.*;
import model.Mejora;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class EscribirXML {
    public static void escribirXML(long dineroTotal, ArrayList<Generador> generadores, ArrayList<Mejora> mejorasComprados) {
        try{
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

            DocumentBuilder builder=factory.newDocumentBuilder();

            Document doc=builder.newDocument();

            Element root = doc.createElement("Data");
            doc.appendChild(root);

            Element dineroTotalElement =doc.createElement("DineroTotal");
            root.appendChild(dineroTotalElement);
            Text dineroTotalText=doc.createTextNode(String.valueOf(dineroTotal));
            dineroTotalElement.appendChild(dineroTotalText);

            Element generadoresElement =doc.createElement("Generadores");
            root.appendChild(generadoresElement);

            for(int i = 0; i < generadores.size(); i++){

                Element generadorElement = null;
                if(generadores.get(i) instanceof Altar){
                    generadorElement=doc.createElement("Altar");
                } else if(generadores.get(i) instanceof Aprendiz){
                    generadorElement=doc.createElement("Aprendiz");
                } else if(generadores.get(i) instanceof Palantir){
                    generadorElement=doc.createElement("Palantir");
                } else if(generadores.get(i) instanceof Portal){
                    generadorElement=doc.createElement("Portal");
                } else if (generadores.get(i) instanceof Puntero){
                    generadorElement=doc.createElement("Puntero");
                } else if (generadores.get(i) instanceof Ritual){
                    generadorElement=doc.createElement("Ritual");
                } else if (generadores.get(i) instanceof Runa){
                    generadorElement=doc.createElement("Runa");
                } else if (generadores.get(i) instanceof TorreMago){
                    generadorElement=doc.createElement("TorreMago");
                } else if (generadores.get(i) instanceof Varita) {
                    generadorElement = doc.createElement("Varita");
                }

                generadoresElement.appendChild(generadorElement);
                Text generadorText=doc.createTextNode(String.valueOf(generadores.get(i).getCantidad()));
                generadorElement.appendChild(generadorText);
            }

            Element mejorasElement =doc.createElement("Mejoras");
            root.appendChild(mejorasElement);

            for(int i = 0; i < mejorasComprados.size(); i++){
                Element mejoraElement =doc.createElement("Mejora");
                mejorasElement.appendChild(mejoraElement);
                Text mejoraElementText =doc.createTextNode(String.valueOf(mejorasComprados.get(i).getNombre()));
                mejoraElement.appendChild(mejoraElementText);
            }

            TransformerFactory.newInstance().newTransformer()
                    .transform(new DOMSource(doc),new StreamResult(new File("src/controller/xml/data.xml")));

        }
        catch (ParserConfigurationException| TransformerException e){
            e.printStackTrace();
        }
    }
}
