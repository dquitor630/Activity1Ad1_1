package activity13;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().convertir();
    }
    void convertir() throws IOException {
        String style = "src\\activity13\\contactTemplate.xsl";
        String contactData = "src\\activity11\\contactos.xml";
        File html = new File("src\\activity13\\index.html");
        FileOutputStream fileOutputStream = new FileOutputStream(html);
        Source styles = new StreamSource(style);
        Source data = new StreamSource(contactData);
        Result result = new StreamResult(fileOutputStream);
        Transformer transformer;
        try{
            transformer = TransformerFactory.newInstance().newTransformer(styles);
            transformer.transform(data, result);
        } catch (TransformerException e ) {
            throw new RuntimeException(e);
        }
        fileOutputStream.close();
    }
}
