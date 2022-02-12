package myProject;

import java.util.ArrayList;
import java.util.Random;

public class PalabrasDelNivel {
    private boolean memory;
    private String palabra;
    private Diccionario diccionario;
    private ArrayList<String> todasLasPalabras, palabrasDelNivel;
    private ArrayList<> memorizar;

    public PalabrasDelNivel(){
        memory = false;
        palabra = "";

        diccionario = new Diccionario();
        palabrasDelNivel = new ArrayList<String>();
        memorizar = new ArrayList<boolean>();
        todasLasPalabras = diccionario.getDiccionario();
    }

    /**
     * This function gets a random word from dictionary.
     * @return a word
     */

    public void getPalabrasDelNivel(int cantidadPalabras){
        Random aleatorio = new Random();
        String nuevaPalabra = new String();
        boolean añadir = true;
        //diccionario.size() obtiene el tamaño del arraylist, comienza en 0
        for(int flag=0;flag<cantidadPalabras;flag++)
        {
            añadir = true;
            nuevaPalabra = todasLasPalabras.get(aleatorio.nextInt(cantidadPalabras));
            if(palabrasDelNivel.size() != 0)
            {
                System.out.println(flag+" "+cantidadPalabras);
                for (int flag1=0; flag1 < palabrasDelNivel.size(); flag1++)
                {
                    if ((palabrasDelNivel.get(flag1)).equals(nuevaPalabra))
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
            System.out.println(nuevaPalabra);
        }
        for(int kk=0;kk<palabrasDelNivel.size();kk++)
        {
            System.out.println(palabrasDelNivel.get(kk));
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
        for(int kk=0;kk<palabrasDelNivel.size();kk++)
        {
            System.out.println(palabrasDelNivel.get(kk).getPalabra()+" | "+palabrasDelNivel.get(kk).getIsMemory());
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

    public boolean getIsMemory() {
        return memory;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}


