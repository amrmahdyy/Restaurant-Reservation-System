package backend;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
public class Verification {
    public static int length;


    public  String[] dataArray=new String[100];
    int count=0;


    private static String names;
    private int i;

    public static String getNames() {
        return names;
    }

    public  String[] verification(String tagname,String item) {

        try {
            File xmlDoc = new File(("pom.xml"));
            DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild = dbFact.newDocumentBuilder();
            Document doc = dBuild.parse(xmlDoc);
            NodeList nlist = doc.getElementsByTagName(tagname);
            length= nlist.getLength();

            for (int i = 0; i < nlist.getLength(); i++) {
                Node nNode = nlist.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    dataArray[i] = eElement.getElementsByTagName(item).item(0).getTextContent();
                }
            }



        } catch (Exception e) {

        }
        return dataArray;
    }
    public int finalLength(String tagname,String item){
        verification(tagname,item);
        for(int i=0; i<dataArray.length;i++){
            if(dataArray[i].isEmpty()){   // it counts only the items that it is not empty and it return the length of filled items
                count++;
            }
        }
        return length-count;
    }

    public int getLength(String tagname,String item) {
        verification(tagname,item);
        return length;
    }



}
