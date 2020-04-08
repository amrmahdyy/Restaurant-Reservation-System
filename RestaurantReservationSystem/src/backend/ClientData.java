package backend;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class ClientData {

    public static void data(int index,String item,String data) {

        try {
            String filepath = "C:C:\\Users\\LENOVO\\IdeaProjects\\login1\\clientData.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            // Get the root element
            Node reserveation = doc.getFirstChild();



            // Get the client element by tag name directly
            Node client = doc.getElementsByTagName("client").item(index);

//            Element name = doc.createElement("name");
//            name.appendChild(doc.createTextNode("AMOORA"));
//            client.appendChild(name);


            NodeList list = client.getChildNodes();
            //  System.out.println(list.getLength());

            for (int i = 0; i < list.getLength(); i++) {

                Node node = list.item(i);

                // get the salary element, and update the value
                if (item.equals(node.getNodeName())) {
                    node.setTextContent(data);
                }
            }
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
