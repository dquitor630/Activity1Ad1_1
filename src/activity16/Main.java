package activity16;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().pruebas();
    }

    void pruebas() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        BufferedReader buffRead = new BufferedReader(new FileReader("src\\activity16\\file.json"));
        StringBuilder json = new StringBuilder();
        String line, name;
        Pattern pattern;
        Matcher matcher;
        System.out.println("Please insert a name to search");
        name = keyboard.nextLine();
        pattern =  Pattern.compile("\\s{2}\"contactName\":\\s\"" + name + "(.*)\\n(.*)\\n(.*)\\n(.*)\\n(.*)\\n(.*)\\n(.*)\\n");
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
