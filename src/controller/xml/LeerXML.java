package controller.xml;

import model.Generador;
import model.Generadores.*;
import model.Mejora;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class LeerXML {

    public static long leerDineroTotalXML() {
        long dinero = 0;
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File file = new File("src/controller/xml/data.xml");
            Document doc = builder.parse(file);

            NodeList nodeList = doc.getElementsByTagName("Data");

            for(int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;

                   dinero = Long.parseLong(elemento.getElementsByTagName("DineroTotal").item(0).getTextContent());
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dinero;
    }

    public static ArrayList<Generador> leerGeneradoresXML(ArrayList<Generador> generadores) {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File file = new File("src/controller/xml/data.xml");
            Document doc = builder.parse(file);

            NodeList nodeList = doc.getElementsByTagName("Generadores");

            for(int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;

                    generadores.get(0).setCantidad(Integer.parseInt(elemento.getElementsByTagName("Puntero").item(0).getTextContent()));
                    generadores.get(1).setCantidad(Integer.parseInt(elemento.getElementsByTagName("Runa").item(0).getTextContent()));
                    generadores.get(2).setCantidad(Integer.parseInt(elemento.getElementsByTagName("Varita").item(0).getTextContent()));
                    generadores.get(3).setCantidad(Integer.parseInt(elemento.getElementsByTagName("Palantir").item(0).getTextContent()));
                    generadores.get(4).setCantidad(Integer.parseInt(elemento.getElementsByTagName("Aprendiz").item(0).getTextContent()));
                    generadores.get(5).setCantidad(Integer.parseInt(elemento.getElementsByTagName("Ritual").item(0).getTextContent()));
                    generadores.get(6).setCantidad(Integer.parseInt(elemento.getElementsByTagName("Altar").item(0).getTextContent()));
                    generadores.get(7).setCantidad(Integer.parseInt(elemento.getElementsByTagName("Portal").item(0).getTextContent()));
                    generadores.get(8).setCantidad(Integer.parseInt(elemento.getElementsByTagName("TorreMago").item(0).getTextContent()));
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return generadores;
    }

    public static ArrayList<Mejora> leerMejorasXML(ArrayList<Mejora> mejoras) {
        ArrayList<Mejora> mejorasComprados = new ArrayList<>();
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File file = new File("src/controller/xml/data.xml");
            Document doc = builder.parse(file);

            NodeList nodeList = doc.getElementsByTagName("Mejora");

            for(int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;

                    for(int j = 0; j < mejoras.size(); j++){
                        if(mejoras.get(j).getNombre().equals(elemento.getTextContent())){
                            mejorasComprados.add(mejoras.get(j));
                        }
                    }


                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return mejorasComprados;
    }
}
