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
            añadir = true;
            //System.out.println(palabrasDelNivel.size());
            nuevaPalabra = diccionario.get(aleatorio.nextInt(cantidadPalabras));
            if(palabrasDelNivel.size() != 0)
            {
                for (int flag1 = 0; flag1 < palabrasDelNivel.size(); flag1++)
                {
                    if (palabrasDelNivel.get(flag1) == nuevaPalabra)
                    {
                        añadir = false;
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
            //System.out.println(palabrasDelNivel.get(flag));
        }
        return palabrasDelNivel;
    }
}
