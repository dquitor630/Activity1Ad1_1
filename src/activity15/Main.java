package activity15;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().pruebas();
    }


    void pruebas() throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("src\\activity15\\file.json"));
        StringBuilder json = new StringBuilder();
        String line = "";
        File file = new File("src\\activity15\\contacts.txt");
        BufferedWriter buffWriter = new BufferedWriter(new FileWriter(file));
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer()).create();
        final Type typeListContact = new TypeToken<List<Contacto>>(){}.getType();
        final List<Contacto> contacts;
        file.createNewFile();
        while ((line = buffRead.readLine()) != null){
            json.append(line).append("\n");
        }
        contacts = gson.fromJson(json.toString(), typeListContact);
        buffWriter.write("""
                ********************************************************************************
                                              Agenda De Contactos                              \s
                ********************************************************************************
                """);
        for(Contacto c : contacts){
            buffWriter.write("Nombre:             " + c.getContactName() + "\n");
            buffWriter.write("Teléfono:           " + c.getPhone() + "\n") ;
            buffWriter.write("Dirección:          " + c.getAddress() + "\n");
            buffWriter.write("Código Postal:      " + c.getPostalCode() + "\n");
            buffWriter.write("Fecha de nacimiento:" + c.getBirthDate() + "\n");
            buffWriter.write("Me debe dinero:     " + c.isLease() + "\n");
            buffWriter.write("Cuánto:             " + c.getLeaseQuantity() + "\n");
            buffWriter.write("********************************************************************************\n");
        }
        buffWriter.write("                           Fin De La Agenda De Contactos                            \n" +
                "********************************************************************************");
        buffWriter.close();
        buffRead.close();
    }
}
