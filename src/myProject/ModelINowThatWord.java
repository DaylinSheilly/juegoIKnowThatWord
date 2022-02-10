package myProject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class ModelINowThatWord {

    private PalabrasDelNivel palabras;
    private Usuario usuario;
    private int conteoErrores, conteoAciertos, unaPalabra, suNivel;
    private boolean fallo, ganar;
    private String palabra, nuevaPalabra, elUsuario, nombreUsuario;
    private ArrayList<String> palabrasDelNivel, palabrasAMemorizar;

    /**
     * Constructor
     */
    public ModelINowThatWord(){
        palabras = new PalabrasDelNivel();
        usuario = new Usuario();
        conteoErrores = 0;
        conteoAciertos = 0;
        unaPalabra = 0;
        suNivel = usuario.getNivelUsuario();
        palabrasDelNivel = new ArrayList<String>();
        palabrasAMemorizar = new ArrayList<String>();
        nombreUsuario = "";
    }

    public void palabrasPorNivel(int nivel){
        switch (nivel){
            case 1: palabras.getPalabrasDelNivel(140); //del 0 al 19
                break;
            case 2: palabras.getPalabrasDelNivel(140); //del 0 al 39
                break;
            case 3: palabras.getPalabrasDelNivel(140); //del 0 al 49
                break;
            case 4: palabras.getPalabrasDelNivel(140); //del 0 al 59
                break;
            case 5: palabras.getPalabrasDelNivel(140); //del 0 al 69
                break;
            case 6: palabras.getPalabrasDelNivel(140); //del 0 al 79
                break;
            case 7: palabras.getPalabrasDelNivel(140); //del 0 al 99
                break;
            case 8: palabras.getPalabrasDelNivel(140); //del 0 al 119
                break;
            case 9: palabras.getPalabrasDelNivel(140); //del 0 al 139
                break;
            case 10: palabras.getPalabrasDelNivel(200); //del 0 al 199
                break;
        }
        palabras.palabrasAMemorizar();
    }

    /**
     * This function checks whether or not it came out in the list of words to be memorized.
     * @param palabra
     */

    public void validarPalabra(String palabra, boolean respuestaAfirmativa) {
        boolean correcta = false;
        int flag = 0;
        if (respuestaAfirmativa == true) {
            for (flag = 0; flag < palabrasAMemorizar.size(); flag++) ;
            {
                if (palabra == palabrasAMemorizar.get(flag)) {
                    correcta = true;
                } else {
                    correcta = false;
                }
            }
        } else {
            if (respuestaAfirmativa == false) {
                for (flag = 0; flag < palabrasAMemorizar.size(); flag++) ;
                {
                    if (palabra == palabrasAMemorizar.get(flag)) {
                        correcta = false;
                    } else {
                        correcta = true;
                    }
                }
            }
        }
        if (correcta) {
            conteoAciertos++;
        } else {
            conteoErrores++;
        }

    }

    public void pedirDatos(){
        usuario.pedirDatos();
        detectNewOrOldUser();
    }

    /**
     * This function saves the information of a new user.
     */

    public void registrarUsuario(){
        usuario.registrarUsuario(elUsuario,suNivel);
    }

    public void detectNewOrOldUser()
    {
        elUsuario = usuario.getUsuarioIngresado();
        suNivel = usuario.getNivelUsuario();
    }

    /**
     * This function level ups user.
     */
    public void subirNivelUsuario(int totalPalabras, int palabrasAcertadas){
        if(palabrasAcertadas >= totalPalabras/2) {
            suNivel++;
        }
        else
        {
            suNivel = suNivel;
        }
    }

    /**
     * This function gets the user level.
     * @return new level
     */
    public int getSuNivel() {
        return suNivel;
    }

    public int getCantidadPalabrasDelNivel() {
        return palabras.getCantidadPalabrasDelNivel();
    }

    public int getErrores() {
        return conteoErrores;
    }

    public int getAciertos() {
        return conteoAciertos;
    }
}
