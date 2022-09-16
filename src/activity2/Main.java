package activity2;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().pruebas();
    }

    void pruebas(){
        File directorio = requestDirectory();
        if (directorio.isDirectory()){

        }else{
            System.out.println("el archivo no es un directorio");
        }
    }
    public File requestDirectory(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("por favor, inserta la ruta del directorio al que desea acceder: ");
        return new File(keyboard.nextLine());
    }
}
