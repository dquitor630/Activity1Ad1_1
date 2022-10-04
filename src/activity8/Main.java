package activity8;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        new Main().pruebas();
    }
    void pruebas() throws IOException {
        ArrayList<Contacto> contactos = new ArrayList<>();
        Contacto contactoUno = new Contacto("Diego Quirós", 678239920, "Calle colon n62 p6", 11300, true, 10.0, LocalDate.of(2003, 5, 14));
        Contacto contactoDos = new Contacto("Pepe Quirós", 612565487, "Calle pedrosa n62 p6", 12333, false, 0.0, LocalDate.of(1999, 11, 13));
        contactos.add(contactoUno);
        contactos.add(contactoDos);
        generateFile(contactos);
    }
    void generateFile(ArrayList<Contacto> contactos) throws IOException {
        File file = new File("C:\\Users\\diego\\Desktop\\binario\\File.dat");
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