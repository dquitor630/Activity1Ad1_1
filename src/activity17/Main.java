package activity17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().pruebas();
    }

    void pruebas() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        ConsoleInput in = new ConsoleInput(keyboard);
        BufferedReader buffRead = new BufferedReader(new FileReader("src\\activity16\\file.json"));
        StringBuilder json = new StringBuilder();
        String line, name = ".*", address = ".*", phone = ".*", postalCode = ".*", birth = ".*", lease = ".*", leaseQuantity = ".*";
        Pattern pattern;
        Matcher matcher;
        System.out.println("¿sort by name? (s/n)");
        if(in.readBooleanUsingChar('s', 'n')){
            System.out.println("Please insert a name to search");
            name = keyboard.nextLine();
            name = "\"" + name + "\"";
        }
        System.out.println("¿sort by address? (s/n)");
        if(in.readBooleanUsingChar('s', 'n')){
            System.out.println("Please insert a address to search");
            address = keyboard.nextLine();
            address = "\"" + address + "\"";
        }
        System.out.println("¿sort by phone? (s/n)");
        if(in.readBooleanUsingChar('s', 'n')){
            System.out.println("Please insert a phone to search");
            phone = String.valueOf(keyboard.nextInt());
        }
        System.out.println("¿sort by postal code? (s/n)");
        if(in.readBooleanUsingChar('s', 'n')){
            System.out.println("Please insert a postal code to search");
            postalCode = String.valueOf(keyboard.nextInt());
        }
        System.out.println("¿sort by birth? (s/n)");
        if(in.readBooleanUsingChar('s', 'n')){
            System.out.println("Please insert a birth to search (dd-mm-yyyy)");
            birth = keyboard.nextLine();
            birth = "\"" + birth + "\"";
        }
        System.out.println("¿sort by lease? (s/n)");
        if(in.readBooleanUsingChar('s', 'n')){
            System.out.println("¿have lease? s/n");
            lease = String.valueOf(in.readBooleanUsingChar('s', 'n'));
        }
        System.out.println("¿sort by lease quantity? (s/n)");
        if(in.readBooleanUsingChar('s', 'n')){
            System.out.println("Please insert a lease to search");
            leaseQuantity = String.valueOf(keyboard.nextDouble());
        }

        pattern =  Pattern.compile("\\s{2}\"contactName\":\\s" + name + ",\\n"+ "\\s{2}\"address\":\\s" + address + ",\\n"+ "\\s{2}\"phone\":\\s" + phone + ",\\n" + "\\s{2}\"postalCode\":\\s" +  postalCode + ",\\n"+  "\\s{2}\"birthDate\":\\s" + birth + ",\\n"+  "\\s{2}\"lease\":\\s" + lease +",\\n" +  "\\s{2}\"leaseQuantity\":\\s" + leaseQuantity + "\\n");
        while ((line = buffRead.readLine()) != null){
            json.append(line).append("\n");
        }
        matcher = pattern.matcher(json);
        while (matcher.find()){
            System.out.printf(json.substring(matcher.start(), matcher.end()));
            System.out.println();
        }
    }
}
