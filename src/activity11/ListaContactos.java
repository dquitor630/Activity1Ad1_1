package activity11;

import java.util.ArrayList;

class ListaContactos {
    private ArrayList<Contacto> contacts = new ArrayList<>();
    public ListaContactos(){

    }
    public void add(Contacto cont){
        contacts.add(cont);
    }
    public ArrayList<Contacto> getListaContactos(){
        return contacts;
    }
}
