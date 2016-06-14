/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author m7942
 */
public class ParseXML {
    
    private static ParseXML instance = null;
    
    private ParseXML(){
        //TYHJÄÄ!!
    }
    
    public static ParseXML getInstance(){
        if (instance == null) {
            instance = new ParseXML();
        }
        return instance;
}
    
    private Document document;
    
    public String getCode(String urlS){
        URL url;
        String content = "";
        String line;
        
        try {
        url = new URL(urlS);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        while((line = br.readLine()) != null){
            content += line +"\n";
        }
        
        }catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return content;
    }
    
    private void DocumentBuilder(String content){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            document = dBuilder.parse(new InputSource(new StringReader(content)));
            //document = dBuilder.parse(content);
            document.getDocumentElement().normalize();
        
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ParseXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getTheatresCombo(String code,String area, String id, String name){
        ArrayList<TheatreData> al = new ArrayList();
        this.DocumentBuilder(code);
        NodeList areaNodes =  document.getElementsByTagName(area);      
        
        for(int i = 0;areaNodes.getLength()>i;i++){
            TheatreData td = new TheatreData();
            Node node = areaNodes.item(i);
            Element element = (Element) node;
            NodeList nodelist_id = element.getElementsByTagName(id);
            NodeList nodelist_name = element.getElementsByTagName(name);
            
            td.name = nodelist_name.item(0).getTextContent();
            td.id = Integer.parseInt(nodelist_id.item(0).getTextContent());
            al.add(td);
        }
        al.remove(0);
        return al;
    }
    
    public void getMoviesByDate(){
        //
    }
    
    public void getMoviesByName(String name){
        //
    }
    
   /* private String getValue(String name, Element e, String attribute){
        return ((Element)e.getElementsByTagName(name).item(0)).getAttribute(attribute);
    }
    private TheatreData getTheatreData(Element ele,String nameIN,String idIN){
        String name = getTextValue(ele, nameIN);
        int id = getIntValue(ele, idIN);
        TheatreData td = new TheatreData();
        td.id = id;
        td.name = name;
        return td;
    }
*/
    
/*
    private String getTextValue(Element ele, String tag) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tag);
        if(nl != null && nl.getLength()>0){
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }
        return textVal;
    }
    
    private int getIntValue(Element ele, String tag){
        return Integer.parseInt(getTextValue(ele,tag));
    }
    */
}
