package myProject;

import java.util.ArrayList;
import java.util.Random;

public class PalabrasDelNivel {
    private Diccionario diccionario;
    private ArrayList<String> todasLasPalabras, palabrasDelNivel, palabrasAMemorizar;

    /**
     * Constructor
     */

    public PalabrasDelNivel(){
        diccionario = new Diccionario();
        todasLasPalabras = diccionario.getDiccionario();
        palabrasDelNivel = new ArrayList<String>();
        palabrasAMemorizar = new ArrayList<String>();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function gets a random word from dictionary.
     * @return a word
     */

    public ArrayList<String> getPalabrasDelNivel(int cantidadPalabras){
        Random aleatorio = new Random();
        boolean añadir = true;
        //diccionario.size() obtiene el tamaño del arraylist, comienza en 0
        for(int flag=0;flag<cantidadPalabras;flag++)
        {
            String unaPalabra = todasLasPalabras.get(aleatorio.nextInt(199));
            if(palabrasDelNivel.size() != 0)
            {
                añadir=true;
                for(int flag1=0;flag1<palabrasDelNivel.size();flag1++)
                {
                    if(palabrasDelNivel.get(flag1)==unaPalabra)
                    {
                        unaPalabra = todasLasPalabras.get(aleatorio.nextInt(199));
                        añadir = false;
                        break;
                    }
                }
                if(añadir)
                {
                    palabrasDelNivel.add(unaPalabra);
                }
                else
                {
                    flag--;
                }
            }
            else
            {
                palabrasDelNivel.add(unaPalabra);
            }
        }
        return palabrasDelNivel;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function returns half of the words in the level for the player to memorize
     * @return the words to memorize
     */

    public ArrayList<String> palabrasAMemorizar(int cantidadPalabras)
    {
        Random aleatorio = new Random();
        boolean añadir = true;
        //diccionario.size() obtiene el tamaño del arraylist, comienza en 0
        for(int flag=0;flag<cantidadPalabras;flag++)
        {
            String unaPalabra = palabrasDelNivel.get(aleatorio.nextInt((cantidadPalabras*2)-1));
            if(palabrasAMemorizar.size() != 0)
            {
                añadir=true;
                for(int flag1=0;flag1<palabrasAMemorizar.size();flag1++)
                {
                    if(palabrasAMemorizar.get(flag1)==unaPalabra)
                    {
                        unaPalabra = palabrasDelNivel.get(aleatorio.nextInt((cantidadPalabras*2)-1));
                        añadir = false;
                        break;
                    }
                }
                if(añadir)
                {
                    palabrasAMemorizar.add(unaPalabra);
                }
                else
                {
                    flag--;
                }
            }
            else
            {
                palabrasAMemorizar.add(unaPalabra);
            }
        }
        return palabrasAMemorizar;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This method gets the number of words that the level
     * @return the number of words that the level
     */

    public int getCantidadPalabrasDelNivel() {
        return palabrasDelNivel.size();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This method gets a word
     * @param cualPalabra
     * @return the word
     */

    public String getUnaPalabra(int cualPalabra)
    {
        String unaPalabra = "";

        unaPalabra = palabrasDelNivel.get(cualPalabra);

        return unaPalabra;
    }
}


