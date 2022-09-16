package activity1;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        new Main().pruebas();
    }

    void pruebas(){
        File fichero = requestFile();
        if(fichero.exists()){
            System.out.println("Archivo: " + fichero.getName() + "\n¿ejecutable?: " + fichero.canExecute() + "\n¿esta oculto?: " + fichero.isHidden() + "\nruta relativa: " + fichero.getPath() + "\nruta absoluta: " + fichero.getAbsolutePath() + "\ntamaño: " + fichero.length() + "b");
        }else{
            System.out.println("El fichero no existe o el directorio es erroneo");
        }
    }
    public File requestFile(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("por favor, inserta la ruta del fichero al que desea acceder: ");
        return new File(keyboard.nextLine());
    }
}