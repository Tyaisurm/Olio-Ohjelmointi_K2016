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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
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

    private ParseXML() {
        //TYHJÄÄ!!
    }

    public static ParseXML getInstance() {//varmistetaan että vain yksi "ParseXML" voi olla olemassa
        if (instance == null) {
            instance = new ParseXML();
        }
        return instance;
    }

    private Document document;
    private Document dataDoc;

    public String getCode(String urlS) {//haetaan annetusta URL lähdekoodi, joka palautetaan String muodossa
        URL url;
        String content = "";
        String line;

        try {
            url = new URL(urlS);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = br.readLine()) != null) {
                content += line + "\n";
            }

        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return content;
    }

    private void DocumentBuilder(String content) {//luodaan uusi DOM Document instance saadun String-muodossa olevan koodin pohjalta
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

    public ArrayList getTheatresCombo(String code, String area, String id, String name) {//haetaan saatavissa olevat teatterit
        ArrayList<TheatreData> al = new ArrayList();
        DocumentBuilder(code);//laitetaan DocumenBuilder rakentamaan uusi DOM String-muodossa olevan XML pohjalta
        NodeList areaNodes = document.getElementsByTagName(area);//etsitään "area" muutujan nimellä kaikki nodet ja tehdään niistä lista

        for (int i = 0; areaNodes.getLength() > i; i++) {//käydään läpi "area" nodet yksi kerrallaan
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

    public Map<String, ArrayList<ShowData>> getMovies(int id, String startT, String endT, String airD, String movieName, int mode) {
        String urlFinal;
        if (mode == 0) {
            String url1 = "http://www.finnkino.fi/xml/Schedule/?area=";
            String url2 = "&dt=";
            urlFinal = url1.concat(Integer.toString(id)).concat(url2).concat(airD);//muodostetaan URL
        } else {
            urlFinal = "http://www.finnkino.fi/xml/Schedule";
        }
        //System.out.println(urlFinal);
        Element root = parseToElement(urlFinal);
        NodeList nl = root.getElementsByTagName("Show");//muodostetaan NodeList, jossa on root:sta "Show" nodet
        SimpleDateFormat sdfXML = new SimpleDateFormat("yyyy'-'MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        //sdfXML.setTimeZone(TimeZone.getTimeZone("GMT+2:00"));
        //DateFormat dfXML = sdfXML;
        //DateFormat dfData = sdfData;

        ArrayList<ShowData> al = new ArrayList();
        Map<String, ArrayList<ShowData>> map = new TreeMap<>();

        for (int i = 0; nl.getLength() > i; i++) {

            try {
                //käydään läpi NodeListin nodet yksi kerrallaan
                ShowData showdata = new ShowData();//luodaan uusi ShowData-olio, joka pitää sisällään yhden esityksen kaikki tiedot
                Node node = nl.item(i);
                Element element = (Element) node;
                if (mode == 1) {
                    String testString = element.getElementsByTagName("Title").item(0).getTextContent().toLowerCase();
                    if (testString.contains((CharSequence) movieName)) {
                        //
                    } else {
                        continue;
                    }
                }
                String dataS = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                if (mode == 0) {
                    if (!startT.isEmpty() && !endT.isEmpty()) {
                        if (dateIsValid(startT, endT, dataS) == false) {
                            continue;
                        }
                    }
                }

                showdata.titleFin = element.getElementsByTagName("Title").item(0).getTextContent();
                showdata.titleORG = element.getElementsByTagName("OriginalTitle").item(0).getTextContent();
                showdata.prodYear = Integer.parseInt(element.getElementsByTagName("ProductionYear").item(0).getTextContent());
                showdata.genres = element.getElementsByTagName("Genres").item(0).getTextContent();
                showdata.theAndAud = element.getElementsByTagName("TheatreAndAuditorium").item(0).getTextContent();
                Date start = sdfXML.parse(element.getElementsByTagName("dttmShowStart").item(0).getTextContent());
                Date end = sdfXML.parse(element.getElementsByTagName("dttmShowEnd").item(0).getTextContent());
                //String startD, endD;//parsitaan aika uudella tavalla
                //startD = dfData.format(start);
                //endD = dfData.format(end);
                showdata.showStart = start;//dfData.parse(startD);
                showdata.showEnd = end;//dfData.parse(endD);
                showdata.id = Integer.parseInt(element.getElementsByTagName("ID").item(0).getTextContent());
                System.out.println(showdata.theAndAud + "#" + showdata.titleFin + "#" + showdata.showStart);
                if (!map.containsKey(showdata.titleFin)) {//onko Mapissa jo tämänniminen leffa? Jos ei, lisätään sellainen!
                    al.add(showdata);
                    map.put(showdata.titleFin, al);
                } else {//Mapissa oli jo tämänniminen leffa, lisätään uusi esitysaika/-paikka ArrayListiin
                    al = map.get(showdata.titleFin);
                    al.add(showdata);
                    map.put(showdata.titleFin, al);

                }
            } catch (ParseException ex) {
                System.out.println("ParseException showdataa parsiessa");
            }
        }
        return map;

    }

    public Map<String, ArrayList<ShowData>> getMoviesByName(int id, String startT, String endT, String airD, String movieName, int mode) {//haetaan elokuvaesityksiä nimen perusteella
        Map<String, ArrayList<ShowData>> map = new TreeMap<>();
        map = getMovies(id, startT, endT, airD, movieName, mode);
        return map;
    }

    public Map<String, ArrayList<ShowData>> getMoviesByDate(int id, String startT, String endT, String airD, String movieName, int mode) {
        Map<String, ArrayList<ShowData>> map = new TreeMap<>();
        map = getMovies(id, startT, endT, airD, null, mode);
        return map;
    }

    private Element parseToElement(String url) {//otetaan vastaan String-muodossa oleva koodi, josta tehdään DOM Document Instance.
        Element root = null;                    //Tästä palautetaan Element root, jossa on suora pääsy childnodeen
        try {
            //
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            dataDoc = dBuilder.parse(url);
            root = dataDoc.getDocumentElement();

            return root;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error in parseToElement");
        }
        return root;
    }

    private boolean dateIsValid(String startT, String endT, String timeXML) throws ParseException {
        boolean bool;
        SimpleDateFormat sdfTIME = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdfXML = new SimpleDateFormat("yyyy'-'MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        if (!startT.isEmpty()) {
            if (!endT.isEmpty()) {
                Date timeXML1 = sdfXML.parse(timeXML);
                String timeS = sdfTIME.format(timeXML1);
                timeS = timeS.replace(":", ".");
                float fXML = Float.parseFloat(timeS);
                float fS = Float.parseFloat(startT.replace(":", "."));
                float fE = Float.parseFloat(endT.replace(":", "."));
                //System.out.println("HUOMIO!!!!!!!!!!!! "+ startT+"  " + endT + " " +timeS);
                if (fS <= fXML) {
                    bool = fE >= fXML;
                } else {
                    bool = false;
                }

            } else {
                bool = false;
            }
        } else {
            bool = false;
        }
        return bool;
    }
}
