package myProject;

import java.util.ArrayList;

public class ModelINowThatWord {

    private Diccionario palabras;
    private Usuario usuario;
    private int conteoErrores, conteoAciertos, nivel, unaPalabra;
    private boolean fallo, ganar;

    /**
     * Constructor
     */
    public ModelINowThatWord(){
        palabras = new Diccionario();
        usuario = new Usuario();
        conteoErrores = 0;
        conteoAciertos = 0;
        nivel = 1;
        unaPalabra = 0;
    }

    public void listaDePalabras(int cantidadDePalabras){
        for(unaPalabra = 0; unaPalabra < cantidadDePalabras; unaPalabra++){
            palabras.getPalabra();
        }

    }

    public void palabrasPorNivel(int nivel){
        switch (nivel){
            case 1: palabras.getPalabra(); //del 0 al 19
                break;
            case 2: palabras.getPalabra(); //del 0 al 39
                break;
            case 3: palabras.getPalabra(); //del 0 al 49
                break;
            case 4: palabras.getPalabra(); //del 0 al 59
                break;
            case 5: palabras.getPalabra(); //del 0 al 69
                break;
            case 6: palabras.getPalabra(); //del 0 al 79
                break;
            case 7: palabras.getPalabra(); //del 0 al 99
                break;
            case 8: palabras.getPalabra(); //del 0 al 119
                break;
            case 9: palabras.getPalabra(); //del 0 al 139
                break;
            case 10: palabras.getPalabra(); //del 0 al 199
                break;


        }

    }

    /**
     * This function checks whether or not it came out in the list of words to be memorized.
     * @param palabra
     */

    public void validarPalabra(String palabra){
        fallo = false;
        if(palabras.getPalabra() == palabra){
            conteoAciertos++;
        }else{
            fallo = true;
            conteoErrores++;
        }
    }

    /**
     * This function level ups user.
     * @return new level
     */
    public int subirNivelUsuario(String usuarioIngresado){
        return usuario.getNivelUsuario(usuarioIngresado)+1;
    }
}
