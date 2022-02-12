package myProject;

import java.util.ArrayList;
import java.util.Random;

public class PalabrasDelNivel {
    private boolean memory;
    private String palabra;
    private Diccionario diccionario;
    private ArrayList<String> todasLasPalabras;
    private ArrayList<PalabrasDelNivel> palabrasDelNivel;

    public PalabrasDelNivel(){
        diccionario = new Diccionario();
        palabrasDelNivel = new ArrayList<PalabrasDelNivel>();
        todasLasPalabras = diccionario.getDiccionario();
    }

    /**
     * This function gets a random word from dictionary.
     * @return a word
     */

    public void getPalabrasDelNivel(int cantidadPalabras){
        Random aleatorio = new Random();
        PalabrasDelNivel nuevaPalabra = new PalabrasDelNivel();
        boolean añadir = true;
        //diccionario.size() obtiene el tamaño del arraylist, comienza en 0
        for(int flag=0;flag<cantidadPalabras;flag++)
        {
            añadir = true;
            nuevaPalabra.setPalabra(todasLasPalabras.get(aleatorio.nextInt(cantidadPalabras)));
            if(palabrasDelNivel.size() != 0)
            {
                for (int flag1 = 0; flag1 < palabrasDelNivel.size(); flag1++)
                {
                    if (palabrasDelNivel.get(flag1).getPalabra() == nuevaPalabra.getPalabra())
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
    }

    public void palabrasAMemorizar()
    {
        for (int flag1 = 0; flag1 < palabrasDelNivel.size(); flag1++)
        {
            if(flag1 <= palabrasDelNivel.size()/2)
            {
                palabrasDelNivel.get(flag1).setMemory(true);
            }
            else
            {
                palabrasDelNivel.get(flag1).setMemory(false);
            }
        }
    }

    public int getCantidadPalabrasDelNivel() {
        return palabrasDelNivel.size();
    }

    public String getUnaPalabra(int cualPalabra)
    {
        String unaPalabra = "";

        unaPalabra = palabrasDelNivel.get(cualPalabra).getPalabra();

        return unaPalabra;
    }

    public void setMemory(boolean memory) {
        this.memory = memory;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}


