package activity12;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Gestion extends DefaultHandler {
    File file;
    FileWriter writer;
    public Gestion() throws IOException {
        super();
        file = new File("C:\\Users\\diego\\IdeaProjects\\ActivityAd1_1\\src\\activity12\\contactos.txt");
        writer = new FileWriter(file);
        file.createNewFile();
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts){
        for(int i = 0; i < atts.getLength(); i++){
            System.out.print(atts.getValue(i));
            try {
                writer.write(atts.getValue(i));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        System.out.print(str);
        try {
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void endDocument(){
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
