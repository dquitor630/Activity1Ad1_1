package activity14;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().pruebas();
    }


    void pruebas() throws IOException {
        XStream xStream = new XStream();
        FileWriter writer = new FileWriter("src\\activity14\\file.json");
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer()).setPrettyPrinting().create();
        StringBuilder representacionJson = new StringBuilder();
        ListaContactos contacts;
        ArrayList<Contacto> contactList;
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.alias("ListaContactos", ListaContactos.class);
        xStream.alias("DatosContacto", Contacto.class);
        xStream.addImplicitCollection(ListaContactos.class, "contacts");
        contacts = (ListaContactos) xStream.fromXML(new FileInputStream("src\\activity14\\contactos.xml"));
        contactList = contacts.getListaContactos();
        representacionJson.append("[\n");
        for(Contacto c : contactList){
            representacionJson.append(" ").append(gson.toJson(c)).append(",");
        }
        representacionJson.replace(representacionJson.length() - 1, representacionJson.length()," ");
        representacionJson.append("\n]");
        writer.write(String.valueOf(representacionJson));
        writer.close();
    }
}
