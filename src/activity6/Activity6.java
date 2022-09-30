package activity6;
import java.io.*;
import java.util.Scanner;
public class Activity6 {
    Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args){
        try {
            new Activity6().main();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("resource")
    void main() throws IOException {
        File source = requestFile(), sourceCopy = new File("C:\\Users\\diego\\Desktop\\Prueba\\sourceCopy.txt");
        File[] files = new File[3];
        FileWriter[] writers = new FileWriter[3];
        FileReader[] readers = new FileReader[3];
        BufferedReader buffRead1, buffRead2;
        char[] buff = new char[15];
        int i, j, k;
        readers[0] = new FileReader(source);
        for(i = 0; i < files.length;i++){
            files[i] = new File("C:\\Users\\diego\\Desktop\\Prueba\\" + (i + 1) + ".txt");
        }
        for( i =  0;i < writers.length; i++){
            writers[i] = new FileWriter(files[i]);
        }
        while(( i = readers[0].read(buff)) != -1){
            if(i > 10 && i <= 15){
                writers[0].write(buff, 0, 5);
                writers[1].write(buff, 5, 5);
                writers[2].write(buff, 10, i - 10);
            }else if(i > 5 && i <= 10){
                writers[0].write(buff, 0, 5);
                writers[1].write(buff, 5, i - 5);
            }else{
                writers[0].write(buff, 0, i);
            }
        }
        closeWriter(writers);
        closeReaders(readers);
        writers[0] = new FileWriter(sourceCopy);
        for(i = 0; i < readers.length; i++){
            readers[i] = new FileReader(files[i]);
        }
        while(( i = readers[0].read(buff,0,5)) != -1 && (j = readers[1].read(buff,5,5)) != 1 && (k = readers[2].read(buff,10,5)) != 1){
            writers[0].write(buff, 0, i + j + k);
        }
        closeWriter(writers);
        closeReaders(readers);
        buffRead1 = new BufferedReader(new FileReader(source));
        buffRead2 = new BufferedReader(new FileReader(sourceCopy));
        System.out.println(compareFiles(buffRead1, buffRead2));
    }
    public File requestFile() {
        File file;
        System.out.println("por favor, inserta la ruta del archivo al que desea acceder: ");
        do {
            file = new File(keyboard.nextLine());
            if (file.isDirectory()){
                System.out.println("Esta ruta no es un archivo");
            }
        } while (file.isDirectory());
        return file;
    }
    public void closeWriter(Writer[] writers) throws IOException {
        for(Writer w:writers){
            if(w != null){
                w.close();
            }
        }
    }
    public void closeReaders(Reader[] readers) throws IOException {
        for(Reader r:readers){
            if(r != null){
                r.close();
            }
        }
    }
    public boolean compareFiles(BufferedReader buffRead1, BufferedReader buffRead2) throws IOException {
        String line1, line2;
        boolean same = true;
        while (same && (line1 = buffRead1.readLine()) != null && (line2 = buffRead2.readLine()) != null){
            if(line1.compareTo(line2) != 0){
                same = false;
            }
        }
        return same;
    }
}