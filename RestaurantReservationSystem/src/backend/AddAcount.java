package backend;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
public class AddAcount {
    public static void createAccount(String names,String passwords) {

        try {
            String filepath = "pom.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            // Get the root element
            Node reserveation = doc.getFirstChild();



            // Get the client element by tag name directly
            //     Node client = doc.getElementsByTagName("client").item(index);
            //create new client

            Element user = doc.createElement("user");
            reserveation.appendChild(user);


            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(names));
            user.appendChild(name);
            Element role = doc.createElement("role");
            role.appendChild(doc.createTextNode("Client"));
            user.appendChild(role);
            Element username = doc.createElement("username");
            username.appendChild(doc.createTextNode(names));
            user.appendChild(username);
            Element password = doc.createElement("password");
            password.appendChild(doc.createTextNode(passwords));
            user.appendChild(password);




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

