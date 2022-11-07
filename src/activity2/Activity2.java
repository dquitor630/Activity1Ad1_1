package activity2;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class Activity2 {

    public static void main(String[] args) throws IOException {
        new Activity2().pruebas();
    }
    void pruebas() throws IOException{
        File dir = new File("src\\activity2\\directorio");
        dir.mkdir();
        File first = new File(dir, "1.txt");
        File second = new File(dir, "2.txt");
        File third = new File(dir, "3.txt");
        File subDir = new File(dir, "2dir");
        subDir.mkdir();
        File subDirFile = new File(subDir,"hola.txt");
        first.createNewFile();
        second.createNewFile();
        third.createNewFile();
        subDirFile.createNewFile();
        second.delete();
        third.renameTo(new File(dir,"tercero.txt"));
        System.out.println("Ruta absoluta del primer directorio: " + dir.getAbsolutePath() + "\nContenido:\n");
        listarDirectorio(dir);
        System.out.println("\nRuta absoluta del subdirectorio: " + subDir.getAbsolutePath() + "\nContenido:\n");
        listarDirectorio(subDir);
    }
    void listarDirectorio(File directorio){
        File[] dir = directorio.listFiles();
        for (File file : dir) {
            System.out.println(file.getName());
        }
    }
}
