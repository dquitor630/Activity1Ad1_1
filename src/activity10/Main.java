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
        contacts.add(new Contacto("Diego", 424242, "calle colon", 11300, true, 19.9, LocalDate.of(2003, 5, 14)));
        contacts.add(new Contacto("Pepe", 342432, "calle pepon", 11200, false, 0.0, LocalDate.of(2001, 2, 14)));
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
