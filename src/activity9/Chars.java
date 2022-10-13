package activity9;

import activity8.Contacto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Chars {
    public static void main(String[] args) throws IOException {
        new Chars().pruebas();
    }

    private final static int BYTES = 89;

    void pruebas() throws IOException {
        ArrayList<Contacto> contactos = new ArrayList<>();
        Contacto contactoUno = new activity8.Contacto("Diego Quiros", 678239920, "Calle colon n62 p6", 11300, true, 10.0, LocalDate.of(2003, 5, 14));
        Contacto contactoDos = new Contacto("Pepe Torres", 612565487, "Calle pedrosa n62 p6", 12333, false, 0.0, LocalDate.of(1999, 11, 13));
        RandomAccessFile fileRandom;
        byte i = 1;
        File file;
        StringBuilder buffer1, buffer2;
        Scanner keyboard = new Scanner(System.in);
        contactos.add(contactoUno);
        contactos.add(contactoDos);
        do{
            System.out.println("please insert the target path");
            file = new File(keyboard.nextLine());
        }while (!file.isFile());
        fileRandom = new RandomAccessFile(file, "rw");
        for(Contacto c : contactos){
            buffer1 = new StringBuilder(c.getContactName());
            buffer1.setLength(15);
            buffer2 = new StringBuilder(c.getAddress());
            buffer2.setLength(20);
            fileRandom.writeByte(i);
            fileRandom.writeBoolean(true);
            fileRandom.writeChars(buffer1.toString());
            fileRandom.writeChars(buffer2.toString());
            fileRandom.writeInt(c.getPhone());
            fileRandom.writeInt(c.getPostalCode());
            fileRandom.writeBoolean(c.isLease());
            fileRandom.writeDouble(c.getLeaseQuantity());
            i++;
        }
        fileRandom.close();
        fileRandom = new RandomAccessFile(file, "r");
        queryAll(fileRandom);
        System.out.println();
        queryId(fileRandom, (byte) 2);
    }

    public void queryAll(RandomAccessFile file) throws IOException {
        char[] name = new char[15];
        char[] address = new char[20];
        byte id;
        int phone, postalCode;
        boolean lease;
        double quantity;
        while (file.getFilePointer() < file.length()){
            id = file.readByte();
            file.readBoolean();
            for(int i = 0; i < name.length; i++){
                name[i] = file.readChar();
            }
            for(int i = 0; i < address.length; i++){
                address[i] = file.readChar();
            }
            phone = file.readInt();
            postalCode = file.readInt();
            lease = file.readBoolean();
            quantity = file.readDouble();
            System.out.printf("Id: %d Name: %s Address: %s Phone: %d Postal Code: %s lease: %s quantity: %f", id, new String(name).trim(), new String(address).trim(), phone, postalCode, lease ? "yes" : "no", quantity);
        }
    }
    public void queryId(RandomAccessFile file, byte id) throws IOException {
        char[] name = new char[15];
        char[] address = new char[20];
        int phone, postalCode;
        boolean lease;
        double quantity;
        file.seek((id - 1) * BYTES);
        id = file.readByte();
        file.readBoolean();
        for(int i = 0; i < name.length; i++){
            name[i] = file.readChar();
        }
        for(int i = 0; i < address.length; i++){
            address[i] = file.readChar();
        }
        phone = file.readInt();
        postalCode = file.readInt();
        lease = file.readBoolean();
        quantity = file.readDouble();
        System.out.printf("Id: %d Name: %s Address: %s Phone: %d Postal Code: %s lease: %s quantity: %f", id, new String(name).trim(), new String(address).trim(), phone, postalCode, lease ? "yes" : "no", quantity);
    }

    public void addLast(RandomAccessFile file) throws IOException {
        file.seek(file.length());
    }
}
