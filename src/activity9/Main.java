package activity9;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleInput console = new ConsoleInput(new Scanner(System.in));
        System.out.println("¿Chars or Utf? (c/u)");
        if(console.readBooleanUsingChar('c', 'u')){
            new Chars().pruebas();
        }else{
            new Utf().pruebas();
        }
    }
}
