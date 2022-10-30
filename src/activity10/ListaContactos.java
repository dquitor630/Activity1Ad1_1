package activity10;

import java.util.ArrayList;
import java.util.List;

class ListaContactos {
    private List<Contacto> contacts = new ArrayList<>();
    public ListaContactos(){

    }
    public void add(Contacto cont){
        contacts.add(cont);
    }
    public List<Contacto> getListaContactos(){
        return contacts;
    }
}
