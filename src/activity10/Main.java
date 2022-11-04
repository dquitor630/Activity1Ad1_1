package activity10;
import activity8.Contacto;
import com.thoughtworks.xstream.XStream;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        new Main().pruebas();
    }
    void pruebas() throws IOException {
        XStream xStream = new XStream();
        ListaContactos contacts = leer();
        try {
            xStream.alias("ListaContactos", ListaContactos.class);
            xStream.alias("DatosContacto", Contacto.class);
            xStream.addImplicitCollection(ListaContactos.class, "contacts");
            xStream.toXML(contacts, new FileOutputStream("c:\\contactos.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    ListaContactos leer() throws IOException {
        Contacto contacto;
        ListaContactos contacts = new ListaContactos();
        ObjectInputStream dataIS;
        File file = new File("C:\\fileO.dat");
        dataIS = new ObjectInputStream(new FileInputStream(file));
        try{
            while(true){
                contacto = (Contacto) dataIS.readObject();
                contacts.add(contacto);
            }
        }catch (EOFException ignored){} catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        dataIS.close();
        return contacts;
    }
}
