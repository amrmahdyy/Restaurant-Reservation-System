package backend;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
public class AddMeal {
    public static void createNewOrder(String names,String orders,String prices,String tables,String types) {

        try {
            String filepath = "clientData.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            // Get the root element
            Node reserveation = doc.getFirstChild();



            // Get the client element by tag name directly
            //     Node client = doc.getElementsByTagName("client").item(index);
            //create new client

            Element client = doc.createElement("client");
            reserveation.appendChild(client);


            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(names));
            client.appendChild(name);
            Element order = doc.createElement("order");
            order.appendChild(doc.createTextNode(orders));
            client.appendChild(order);
            Element price = doc.createElement("price");
            price.appendChild(doc.createTextNode(prices));
            client.appendChild(price);
            Element table = doc.createElement("table");
            table.appendChild(doc.createTextNode(tables));
            client.appendChild(table);
            Element type = doc.createElement("type");
            type.appendChild(doc.createTextNode(types));
            client.appendChild(type);



            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            System.out.println("Done");


        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }




    public static void createSecondOrder(int index,String orders,String prices,String types) {

        try {
            String filepath = "C:\\Users\\ECC\\Desktop\\parsingg\\clientData.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            // Get the root element
            Node reserveation = doc.getFirstChild();



            // Get the client element by tag name directly
            Node client = doc.getElementsByTagName("client").item(index);
            //create new client
//
//            Element client = doc.createElement("client");
//            reserveation.appendChild(client);


//            Element name = doc.createElement("name");
//            name.appendChild(doc.createTextNode(names));
//            client.appendChild(name);
            Element order = doc.createElement("order");
            order.appendChild(doc.createTextNode(orders));
            client.appendChild(order);
            Element price = doc.createElement("price");
            price.appendChild(doc.createTextNode(prices));
            client.appendChild(price);
            Element type = doc.createElement("type");
            type.appendChild(doc.createTextNode(types));
            client.appendChild(type);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            System.out.println("Done");


        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }
}
