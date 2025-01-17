package activity9;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;

public class Utf {
    private final static int BYTES = 58;
    private ConsoleInput console = new ConsoleInput(new Scanner(System.in));


    void pruebas() throws IOException {
        File file;
        int option;
        boolean exit = false;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("please insert the target path");
            file = new File(keyboard.nextLine());
        } while (!file.isFile());
        do {
            System.out.println("""
                    Select an option:\s
                    1.Query all contacts.\s
                    2.Query contact by id.\s
                    3.Add a contact.
                    4.Delete a contact.
                    5.Edit lease.
                    6.Compact File.
                    7.Exit.""");
            option = console.readIntInRange(1, 7);
            switch (option) {
                case 1 -> queryAll(file);
                case 2 -> queryId(file);
                case 3 -> {
                    System.out.println("At the end of the file or in the first empty slot? (1/2)");
                    if (console.readIntInRange(1, 2) == 1) {
                        addLast(file);
                    } else {
                        addFirstEmpty(file);
                    }
                }
                case 4 -> removeElement(file);
                case 5 -> editLease(file);
                case 6 -> compactFile(file);
                case 7 -> exit = true;
            }
        } while (!exit);
    }

    public void queryAll(File file) throws IOException {
        RandomAccessFile random = new RandomAccessFile(file, "rw");
        String name, address;
        byte id;
        int phone, postalCode;
        boolean lease, exist;
        double quantity;
        while (random.getFilePointer() < random.length()) {
            id = random.readByte();
            exist = random.readBoolean();
            name = random.readUTF();
            address = random.readUTF();
            phone = random.readInt();
            postalCode = random.readInt();
            lease = random.readBoolean();
            quantity = random.readDouble();
            if (exist) {
                System.out.printf("Id: %d Name: %s Address: %s Phone: %d Postal Code: %s lease: %s quantity: %f\n", id, name.trim(), address.trim(), phone, postalCode, lease ? "yes" : "no", quantity);
            }
        }
        random.close();
    }

    public void queryId(File file) throws IOException {
        byte id;
        RandomAccessFile random = new RandomAccessFile(file, "rw");
        System.out.println("insert the id");
        id = console.readByte();
        String name, address;
        int phone, postalCode;
        boolean lease, exist;
        double quantity;
        if (random.length() > (id-1) * BYTES) {
            random.seek((id - 1) * BYTES);
            id = random.readByte();
            exist = random.readBoolean();
            name = random.readUTF();
            address = random.readUTF();
            phone = random.readInt();
            postalCode = random.readInt();
            lease = random.readBoolean();
            quantity = random.readDouble();
            System.out.println(random.getFilePointer());
            if (exist) {
                System.out.printf(" Id: %d Name: %s Address: %s Phone: %d Postal Code: %s lease: %s quantity: %f\n", id, name.trim(), address.trim(), phone, postalCode, lease ? "yes" : "no", quantity);
            } else {
                System.out.println("removed slot");
            }
        } else {
            System.out.println("not exist");
        }
        random.close();
    }

    public void addLast(File file) throws IOException {
        Contacto contacto = createContact();
        RandomAccessFile random = new RandomAccessFile(file, "rw");
        StringBuilder buffer1, buffer2;
        Formatter formatter, formatter2;
        buffer1 = new StringBuilder();
        buffer2 = new StringBuilder(contacto.getAddress().trim());
        formatter = new Formatter(buffer1);
        formatter2 = new Formatter(buffer2);
        formatter.format("%-15s", contacto.getContactName().trim());
        formatter2.format("%-20s", contacto.getContactName().trim());
        buffer1.setLength(15);
        buffer2.setLength(20);
        random.seek(file.length());
        random.writeByte((int) (file.length() / BYTES + 1));
        random.writeBoolean(true);
        System.out.println(random.getFilePointer());
        random.writeUTF(buffer1.toString());
        System.out.println(random.getFilePointer());
        random.writeUTF(buffer2.toString());
        random.writeInt(contacto.getPhone());
        random.writeInt(contacto.getPostalCode());
        random.writeBoolean(contacto.isLease());
        random.writeDouble(contacto.getLeaseQuantity());
        random.close();
    }

    public void addFirstEmpty(File file) throws IOException {
        Contacto contacto;
        RandomAccessFile random = new RandomAccessFile(file, "rw");
        StringBuilder buffer1, buffer2;
                random.writeBoolean(true);
                Formatter formatter, formatter2;
                boolean writed = false;
                while (!writed && random.getFilePointer() < random.length()) {
                    random.readByte();
                    if (!random.readBoolean()) {
                        contacto = createContact();
                        buffer1 = new StringBuilder();
                        buffer2 = new StringBuilder();
                        formatter = new Formatter(buffer1);
                        formatter2 = new Formatter(buffer2);
                        formatter.format("%-15s", contacto.getContactName().trim());
                        formatter2.format("%-20s", contacto.getContactName().trim());
                        buffer1.setLength(15);
                        buffer2.setLength(20);
                        random.seek(random.getFilePointer() - 1);
                        random.writeUTF(buffer1.toString());
                        random.writeUTF(buffer2.toString());
                        random.writeInt(contacto.getPhone());
                        random.writeInt(contacto.getPostalCode());
                        random.writeBoolean(contacto.isLease());
                        random.writeDouble(contacto.getLeaseQuantity());
                        writed = true;
            } else {
                random.seek(random.getFilePointer() + BYTES - 2);
            }
        }
        random.close();
        if (!writed) {
            addLast(file);
        }
    }

    void removeElement(File file) throws IOException {
        byte id;
        RandomAccessFile random = new RandomAccessFile(file, "rw");
        System.out.println("insert the id");
        id = console.readByte();
        if (random.length() > id * BYTES - 1) {
            random.seek((id - 1) * BYTES);
            random.readByte();
            random.writeBoolean(false);
            random.close();
        } else {
            System.out.println("id not exist");
        }
    }

    void editLease(File file) throws IOException {
        byte id;
        boolean lease;
        double quantity;
        RandomAccessFile random = new RandomAccessFile(file, "rw");
        System.out.println("insert the id");
        id = console.readByte();
        System.out.println("¿has lease? (s/n)");
        lease = console.readBooleanUsingChar('s', 'n');
        if (lease) {
            System.out.println("insert lease quantity");
            quantity = console.readDouble();
        } else {
            quantity = 0.0;
        }
        if (random.length() > id * BYTES - 1) {
            random.seek((id - 1) * BYTES + (BYTES - 9));
            random.writeBoolean(lease);
            random.writeDouble(quantity);
        } else {
            System.out.println("id not exist");
        }
        random.close();
    }

    void compactFile(File file) throws IOException {
        RandomAccessFile random = new RandomAccessFile(file, "rw");
        File fileCopy = new File(file.getParent() + "/b.dat");
        RandomAccessFile randomCopy = new RandomAccessFile(fileCopy, "rw");
        StringBuilder buffer1, buffer2;
        String name, address;
        Formatter formatter, formatter2;
        byte id = 1;
        while (random.getFilePointer() < random.length()) {
            random.readByte();
            if (random.readBoolean()) {
                random.seek(random.getFilePointer() - 1);
                randomCopy.writeByte(id);
                randomCopy.writeBoolean(random.readBoolean());
                name = random.readUTF();
                address = random.readUTF();
                buffer1 = new StringBuilder();
                buffer2 = new StringBuilder();
                formatter = new Formatter(buffer1);
                formatter2 = new Formatter(buffer2);
                formatter.format("%-15s", name.trim());
                formatter2.format("%-20s", address.trim());
                randomCopy.writeUTF(buffer1.toString());
                randomCopy.writeUTF(buffer2.toString());
                randomCopy.writeInt(random.readInt());
                randomCopy.writeInt(random.readInt());
                randomCopy.writeBoolean(random.readBoolean());
                randomCopy.writeDouble(random.readDouble());
                id++;
            } else {
                random.seek(random.getFilePointer() + BYTES - 2);
            }
        }
        random.close();
        randomCopy.close();
        if (file.delete() && fileCopy.renameTo(new File(file.getAbsolutePath()))) {
            System.out.println("Compactación realizada con éxito");
        } else {
            System.out.println("Error en la compactación");
        }
    }

    private Contacto createContact() {
        String name, address;
        int phone, postalCode;
        boolean lease;
        double quantity;
        System.out.println("insert the name:");
        name = console.readString();
        System.out.println("insert the address");
        address = console.readString();
        System.out.println("insert the phone");
        phone = console.readInt();
        System.out.println("insert the postalCode");
        postalCode = console.readInt();
        System.out.println("¿has lease? (s/n)");
        lease = console.readBooleanUsingChar('s', 'n');
        if (lease) {
            System.out.println("insert lease quantity");
            quantity = console.readDouble();
        } else {
            quantity = 0.0;
        }
        return new Contacto(name, phone, address, postalCode, lease, quantity, LocalDate.of(2003, 5, 14));
    }
}
