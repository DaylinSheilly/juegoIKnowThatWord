package myProject;

import java.util.ArrayList;
import java.util.Random;

public class Diccionario {
    private ArrayList<String> diccionario = new ArrayList <String> ();

    /**
     * Constructor
     */

    public Diccionario(){

        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaDiccionario();

    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function gets a random word from dictionary.
     * @return a word
     */

    public String getPalabra(){
        Random aleatorio = new Random();
        //diccionario.size() obtiene el tamaño del arraylist, comienza en 0
        return diccionario.get(aleatorio.nextInt(diccionario.size())); //retorna un entero entre 0 y 199

    }
}
