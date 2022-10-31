package activity8;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Main().pruebas();
    }
    void pruebas() throws IOException, ClassNotFoundException {
        ArrayList<Contacto> contactos = new ArrayList<>();
        Contacto contactoUno = new Contacto("Diego Quirós", 678239920, "Calle colon n62 p6", 11300, true, 10.0, LocalDate.of(2003, 5, 14));
        Contacto contactoDos = new Contacto("Pepe Torres", 612565487, "Calle pedrosa n62 p6", 12333, false, 0.0, LocalDate.of(1999, 11, 13));
        contactos.add(contactoUno);
        contactos.add(contactoDos);
        generateFile(contactos);
        generateFileSerialized(contactos);
    }
    void generateFile(ArrayList<Contacto> contactos) throws IOException {
        File file = new File("C:\\contacts.dat");
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

    void generateFileSerialized(ArrayList<Contacto> contactos) throws IOException, ClassNotFoundException {
        File file = new File("C:\\Users\\diego\\Desktop\\binario\\FileO.dat");
        Scanner keyboard = new Scanner(System.in);
        boolean overwrite = false, exit = false;
        String selection;
        ObjectOutputStream dataOS;
        ObjectInputStream dataIS;
        Contacto contacto;
        System.out.println("¿do you want overwrite? s/n");
        do{
            selection = keyboard.nextLine();
            if(selection.equalsIgnoreCase("s")){
                exit = true;
                overwrite = true;
            }else if(selection.equalsIgnoreCase("n")){
                exit = true;
            }else{
                System.out.println("input invalido");
            }
        }while (!exit);
        dataOS = overwrite ? new ObjectOutputStream(new FileOutputStream(file)) : new MiObjectOutputStream(new FileOutputStream(file, true));
        for(Contacto c : contactos){
            dataOS.writeObject(c);
        }
        dataOS.close();
        dataIS = new ObjectInputStream(new FileInputStream(file));
        try{
            while(true){
                contacto = (Contacto) dataIS.readObject();
                System.out.println(contacto.toString());
            }
        }catch (EOFException ignored){}
        dataIS.close();
    }
    public static class MiObjectOutputStream extends ObjectOutputStream {
        public MiObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        protected void writeStreamHeader() {
        }
    }

}