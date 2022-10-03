package activity7;

import java.io.*;
import java.util.Scanner;

public class Activity7 {
    Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        new Activity7().pruebas();
    }
    void pruebas() throws IOException {
        File source = requestFile();
        System.out.println("please insert the password for the file");
        String key = keyboard.nextLine();
        encryptDecrypt(encryptDecrypt(source, key, true), key, false);
    }
    File encryptDecrypt(File source, String key, boolean operation) throws IOException {
        File destination;
        FileReader reader = new FileReader(source);
        FileWriter writer;
        int j, indexKey = 0;
        System.out.println("insert the destination");
        destination = requestFile();
        writer = new FileWriter(destination);
        while((j = reader.read()) != -1){
            writer.write(operation ? (char) (j + (int)key.charAt(indexKey)): (char) (j - (int)key.charAt(indexKey)));
            indexKey = indexKey + 1 < key.length() ? indexKey + 1 : 0;
        }
        writer.close();
        reader.close();
        return destination;
    }
    File requestFile(){
        File file;
        System.out.println("please insert the path of the file: ");
        do {
            file = new File(keyboard.nextLine());
            if (file.isDirectory()){
                System.out.println("this path is not a file, please try again");
            }
        } while (file.isDirectory());
        return file;
    }
}