package myProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Diccionario {
    private ArrayList<String> diccionario = new ArrayList <String> ();
    private ArrayList<String> palabrasDelNivel;

    private String palabra, nuevaPalabra;

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

    public ArrayList<String> getPalabra(int cantidadPalabras){
        Random aleatorio = new Random();
        boolean añadir = true;
        //diccionario.size() obtiene el tamaño del arraylist, comienza en 0
        for(int flag=0;flag<cantidadPalabras;flag++)
        {
            nuevaPalabra = palabrasDelNivel.get(aleatorio.nextInt(palabrasDelNivel.size()));
            if(palabrasDelNivel.size()!=0)
            {
                for (int flag1 = 0; flag1 < palabrasDelNivel.size(); flag1++)
                {
                    if (palabrasDelNivel.get(flag1) == nuevaPalabra)
                    {
                        añadir = false;
                    }
                    else
                    {
                        añadir = true;
                    }
                }
                if (añadir)
                {
                    palabrasDelNivel.add(nuevaPalabra);
                }
                else
                {
                    flag--;
                }
            }
            else
            {
                palabrasDelNivel.add(nuevaPalabra);
            }
        }
        return palabrasDelNivel;
    }
}
