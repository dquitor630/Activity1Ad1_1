package activity3;
import java.io.File;
import java.util.Scanner;

public class Activity3 {
    public static void main(String[] args) {
        new Activity3().pruebas();
    }
    void pruebas(){
        File dir = requestDirectory();
        System.out.println(dir.getName());
        listFiles(dir, 0);
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
    public void listFiles(File file, int i){
        File[] dir = file.listFiles();
        String space = "";
        for(int j = 0; j<=i;j++){
            space = space + " ";
        }
        for (File f : dir) {
            if (f.isDirectory()){
                System.out.printf(space + f.getName() + Colors.GREEN + " Directory\n" + Colors.WHITE);
                listFiles(f, i + 2);
            }else{
                System.out.printf(space + f.getName() + Colors.BLUE + " File\n" + Colors.WHITE);
            }
        }
    }
}
