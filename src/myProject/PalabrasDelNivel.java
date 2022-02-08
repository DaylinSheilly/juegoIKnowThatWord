package myProject;

import java.util.ArrayList;
import java.util.Random;

public class PalabrasDelNivel {
    private boolean memory;
    private String palabra;
    private Diccionario diccionario;
    private ArrayList<String> palabrasDelNivel;
    private ArrayList<String> todasLasPalabras;

    public PalabrasDelNivel(){
        diccionario = new Diccionario();
        palabrasDelNivel = new ArrayList<String>();
        todasLasPalabras = diccionario.getDiccionario();
    }

    /**
     * This function gets a random word from dictionary.
     * @return a word
     */

    public ArrayList<String> getPalabra(int cantidadPalabras){
        Random aleatorio = new Random();
        String nuevaPalabra = "";
        boolean añadir = true;
        //diccionario.size() obtiene el tamaño del arraylist, comienza en 0
        for(int flag=0;flag<cantidadPalabras;flag++)
        {
            añadir = true;
            nuevaPalabra = todasLasPalabras.get(aleatorio.nextInt(cantidadPalabras));
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
        }
        return palabrasDelNivel;
    }

}


