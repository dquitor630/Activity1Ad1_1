package activity5;


import java.io.*;
import java.util.Scanner;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class Activity5 {
    private final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        new Activity5().main();
    }
    void main() throws IOException {
        boolean exit = false;
        File source, destination, destinationFile;
        BufferedReader buffRead;
        BufferedWriter buffWrite;
        FileReader reader;
        FileWriter writer;
        String line, stringOption;
        int i;
        char[] buff = new char[20];
        boolean option = true;
        do{
            System.out.println("please insert the path of the source file you want to access: ");
            source = new File(keyboard.nextLine());
            if(source.isFile()){
                exit = true;
            }else{
                System.out.println("the source is not a file, please try again.");
            }
        }while (!exit);
        exit = false;
        System.out.println("please insert the path of the destination file or directory you want to access: ");
        destination = new File(keyboard.nextLine());
        do{
            System.out.println("y/n");
            stringOption = keyboard.nextLine();
            if (stringOption.equalsIgnoreCase("y")){
                exit = true;
            }else if (stringOption.equalsIgnoreCase("n")){
                option = false;
                exit = true;
            }else{
                System.out.println("invalid input, try again");
            }
        }while(!exit);
        if (destination.isDirectory()){
            destinationFile = new File(destination.getAbsolutePath(), source.getName());
            destinationFile.createNewFile();
            buffRead = new BufferedReader(new FileReader(source.getAbsolutePath()));
            buffWrite = new BufferedWriter(new FileWriter(destinationFile.getAbsolutePath()));
            while ((line = buffRead.readLine()) != null){
                buffWrite.write(line + "\n");
            }
            buffWrite.close();
        }else{
            reader = new FileReader(source);
            if(option){
                if (destination.exists()){
                    writer = new FileWriter(destination);
                    while(reader.read(buff) != -1) {
                        writer.write(buff, 0, buff.length);
                    }
                    writer.close();
                }else{
                    throw new IllegalArgumentException("file don´t exist");
                }
            }else{
                if(destination.exists()){
                    writer = new FileWriter(destination);
                    while((i = reader.read()) != -1) {
                        writer.write(i);
                    }
                    writer.close();
                }else{
                    System.out.println("the copy wasn't able to finish");
                }
            }
        }
    }
}
