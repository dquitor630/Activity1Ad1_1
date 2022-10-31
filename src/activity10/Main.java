package activity10;
import com.thoughtworks.xstream.XStream;
import java.io.*;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args){
        new Main().pruebas();
    }
    void pruebas() {
        XStream xStream = new XStream();
        ListaContactos contacts = new ListaContactos();
        contacts.add(new Contacto("Diego Quirós", 678239920, "Calle colon n62 p6", 11300, true, 10.0, LocalDate.of(2003, 5, 14)));
        contacts.add(new Contacto("Pepe Torres", 612565487, "Calle pedrosa n62 p6", 12333, false, 0.0, LocalDate.of(1999, 11, 13)));
        try {
            xStream.alias("ListaContactos", ListaContactos.class);
            xStream.alias("DatosContacto", Contacto.class);
            xStream.addImplicitCollection(ListaContactos.class, "contacts");
            xStream.toXML(contacts, new FileOutputStream("c:\\contactos.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
