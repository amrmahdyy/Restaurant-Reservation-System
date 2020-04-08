package backend;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
public class ReadClientData {

    int length;
    int count=0;
    public  String[] clientDataArray=new String[getLength("client","name")];
    public  String[] readClientData(String tagname,String item) {

        try {
            File xmlDoc = new File(("clientData.xml"));
            DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild = dbFact.newDocumentBuilder();
            Document doc = dBuild.parse(xmlDoc);
            NodeList nlist = doc.getElementsByTagName(tagname);
            length=nlist.getLength();


            for (int i = 0; i < nlist.getLength(); i++) {
                Node nNode = nlist.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    clientDataArray[i] = eElement.getElementsByTagName(item).item(0).getTextContent();
                }


            }


        } catch (Exception e) {

        }
        return clientDataArray;
    }
    public int finalLength(String tagname,String item){
        readClientData(tagname,item);
        for(int i=0; i<clientDataArray.length;i++){
            if(clientDataArray[i].isEmpty()){   // it counts only the items that it is not empty and it return the length of filled items
                count++;
            }
        }
        return length-count;
    }

    public int getLength(String tagname,String item) {
        readClientData(tagname,item);
        return length;
    }
}
