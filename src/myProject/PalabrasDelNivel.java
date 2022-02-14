package myProject;

import java.util.ArrayList;
import java.util.Random;

public class PalabrasDelNivel {
    private Diccionario diccionario;
    private ArrayList<String> todasLasPalabras, palabrasDelNivel, palabrasAMemorizar;

    public PalabrasDelNivel(){
        diccionario = new Diccionario();
        todasLasPalabras = diccionario.getDiccionario();
        palabrasDelNivel = new ArrayList<String>();
        palabrasAMemorizar = new ArrayList<String>();
    }

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
        return palabrasAMemorizar;
    }

    public ArrayList<String> palabrasAMemorizar()
    {
        for (int flag=0; flag < palabrasDelNivel.size()/2; flag++)
        {
            palabrasAMemorizar.add(palabrasDelNivel.get(flag));
        }
        return palabrasAMemorizar;
    }

    public int getCantidadPalabrasDelNivel() {
        return palabrasDelNivel.size();
    }

    public String getUnaPalabra(int cualPalabra)
    {
        String unaPalabra = "";

        unaPalabra = palabrasDelNivel.get(cualPalabra);

        return unaPalabra;
    }
}


