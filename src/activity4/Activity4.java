package activity4;


import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args){
        new Activity4().pruebas();
    }

    void pruebas(){
        File dir = requestDirectory();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Por favor, inserte la extensión sin punto que desea buscar");
        String a = keyboard.nextLine();
        File[] validFiles = dir.listFiles(new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(a);
            }
        });
        for(File f : validFiles){
            System.out.println(f.getName());
        }
    }

    public File requestDirectory() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("por favor, inserta la ruta del directorio al que desea acceder: ");
        File file;
        boolean exit = false;
        do {
            file = new File(keyboard.nextLine());
            if (!file.isDirectory()){
                System.out.println("Esta ruta no es un directorio");
            }else{
                exit = true;
            }
        } while (!exit);
        return file;
    }
}
