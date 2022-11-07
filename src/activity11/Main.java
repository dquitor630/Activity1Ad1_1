package activity11;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.*;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().pruebas();
    }
    void pruebas() throws IOException {
        XStream xStream = new XStream();
        xStream.addPermission(AnyTypePermission.ANY);
        ListaContactos contacts;
        ArrayList<Contacto> contactList;
            xStream.alias("ListaContactos", ListaContactos.class);
            xStream.alias("DatosContacto", Contacto.class);
            xStream.addImplicitCollection(ListaContactos.class, "contacts");
            contacts = (ListaContactos) xStream.fromXML(new FileInputStream("src\\activity11\\contactos.xml"));
            contactList = contacts.getListaContactos();
            generateFile(contactList);
            System.out.println(compareFiles(new File("src\\activity8\\contacts.dat"), new File("src\\activity11\\contactsXml.dat")));

    }




    boolean compareFiles(File file1, File file2) throws IOException {
        FileInputStream fileIn = new FileInputStream(file1);
        FileInputStream fileIn2 = new FileInputStream(file2);
        int i, j;
        boolean same = true;
        do{
            i = fileIn.read();
            j = fileIn2.read();
            if(!(j == i)){
                same = false;
            }
        }while(same && (i  != -1));
        return same;
    }
    void generateFile(ArrayList<Contacto> contactos) throws IOException {
        File file = new File("src\\activity11\\contactsXml.dat");
        DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(file));
        DataInputStream dataIS = new DataInputStream(new FileInputStream(file));
        for(Contacto c : contactos){
            dataOS.writeUTF(c.getContactName());
            dataOS.writeInt(c.getPhone());
            dataOS.writeUTF(c.getAddress());
            dataOS.writeInt(c.getPostalCode());
            dataOS.writeUTF(c.getBirthDate().toString());
            dataOS.writeBoolean(c.isLease());
            dataOS.writeDouble(c.getLeaseQuantity());
        }
        dataOS.close();
        try{
            while(true){
                System.out.println("Nombre: " + dataIS.readUTF() + "\nTeléfono: " + dataIS.readInt() + "\nDirección: " + dataIS.readUTF() + "\nCódigo Postal: " + dataIS.readInt() + "\nF.Nacimiento: " + dataIS.readUTF() + "\n¿Debe?: " + dataIS.readBoolean() + "\nCantidad: " + dataIS.readDouble());
            }
        }catch (EOFException ignored){}
        dataIS.close();
    }
}
