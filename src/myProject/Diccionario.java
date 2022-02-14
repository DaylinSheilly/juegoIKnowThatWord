package myProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Diccionario {
    private ArrayList<String> diccionario = new ArrayList <String> ();
    private ArrayList<String> palabrasDelNivel;

    private String nuevaPalabra;

    /**
     * Constructor
     */

    public Diccionario(){
        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaDiccionario();
        palabrasDelNivel = new ArrayList<String>();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<String> getDiccionario() {
        return diccionario;
    }

}
