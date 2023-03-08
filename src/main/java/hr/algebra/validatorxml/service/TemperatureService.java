package hr.algebra.validatorxml.service;

import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URL;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

@Component
public class TemperatureService {
    public String getTemperature(String city) {
        try {
            String url = "https://vrijeme.hr/hrvatska_n.xml";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(url).openStream());

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Grad");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element elem = (Element) nodeList.item(i);
                String cityName = elem.getElementsByTagName("GradIme").item(0).getTextContent();
                if (cityName.equalsIgnoreCase(city)) {
                    return elem.getElementsByTagName("Temp").item(0).getTextContent();
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return "City not found";
    }
}
