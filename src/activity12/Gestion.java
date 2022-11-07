package activity12;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Gestion extends DefaultHandler {
    File file;
    FileWriter writer;
    String att;
    String[] data;
    int count = 0;
    public Gestion() throws IOException {
        super();
        data = new String[7];
        file = new File("src\\activity12\\contactos.txt");
        writer = new FileWriter(file);
        file.createNewFile();
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts){
        att = "";
        for(int i = 0; i < atts.getLength(); i++){
            att = "%s%s".formatted(att, atts.getValue(i));
        }
    }

    public void characters(char[] ch, int start, int length) {
        StringBuilder str;
        if(count < 7){
            str = new StringBuilder(new String(ch, start, length));
            if(!str.toString().isBlank()){
                data[count] = att + " " + str.toString().replace("\n", "") + " ";
                count++;
            }
        }else{
            str = new StringBuilder();
            for (String datum : data) {
                str.append(datum);
            }
            str.append("\n");
            try {
                writer.write(String.valueOf(str));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            count = 0;
            Arrays.fill(data, "");
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
