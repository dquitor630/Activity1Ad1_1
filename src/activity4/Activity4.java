package activity4;


import java.io.File;
import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args){
        new Activity4().pruebas();
    }
    void pruebas(){
        File dir = requestDirectory();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Por favor, inserte la extensión sin punto que desea buscar");
        String extension = keyboard.nextLine();
        File[] validFiles = dir.listFiles((dir1, name) -> name.endsWith(extension));
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
