package activity12;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        Gestion gestor = new Gestion();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("C:\\Users\\diego\\IdeaProjects\\ActivityAd1_1\\src\\activity12\\contactos.xml");
        procesadorXML.parse(fileXML);
    }
}
