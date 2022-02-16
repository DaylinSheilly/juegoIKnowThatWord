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

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function show the words of the level that is indicated
     * @param nivel
     */

    public void palabrasPorNivel(int nivel){
        if(nivel >= 1 && nivel <= 10) {
            switch (nivel) {
                case 1:
                    palabrasDelNivel=palabras.getPalabrasDelNivel(20); //del 0 al 19
                    palabrasAMemorizar=palabras.palabrasAMemorizar(20/2);
                    break;
                case 2:
                    palabrasDelNivel=palabras.getPalabrasDelNivel(40); //del 0 al 39
                    palabrasAMemorizar=palabras.palabrasAMemorizar(40/2);
                    break;
                case 3:
                    palabrasDelNivel=palabras.getPalabrasDelNivel(50); //del 0 al 49
                    palabrasAMemorizar=palabras.palabrasAMemorizar(50/2);
                    break;
                case 4:
                    palabrasDelNivel=palabras.getPalabrasDelNivel(60); //del 0 al 59
                    palabrasAMemorizar=palabras.palabrasAMemorizar(60/2);
                    break;
                case 5:
                    palabrasDelNivel=palabras.getPalabrasDelNivel(70); //del 0 al 69
                    palabrasAMemorizar=palabras.palabrasAMemorizar(70/2);
                    break;
                case 6:
                    palabrasDelNivel=palabras.getPalabrasDelNivel(80); //del 0 al 79
                    palabrasAMemorizar=palabras.palabrasAMemorizar(80/2);
                    break;
                case 7:
                    palabrasDelNivel=palabras.getPalabrasDelNivel(100); //del 0 al 99
                    palabrasAMemorizar=palabras.palabrasAMemorizar(100/2);
                    break;
                case 8:
                    palabrasDelNivel=palabras.getPalabrasDelNivel(120); //del 0 al 119
                    palabrasAMemorizar=palabras.palabrasAMemorizar(120/2);
                    break;
                case 9:
                    palabrasDelNivel=palabras.getPalabrasDelNivel(140); //del 0 al 139
                    palabrasAMemorizar=palabras.palabrasAMemorizar(140/2);
                    break;
                case 10:
                    palabrasDelNivel=palabras.getPalabrasDelNivel(200); //del 0 al 199
                    palabrasAMemorizar=palabras.palabrasAMemorizar(200/2);
                    break;
            }
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function checks whether or not it came out in the list of words to be memorized.
     * @param palabra
     */

    public void validarPalabra(String palabra, boolean respuestaAfirmativa) {
        boolean correcta = false;
        int flag = 0;
        if (respuestaAfirmativa == true) {
            for (flag = 0; flag < palabrasAMemorizar.size(); flag++)
            {
                if (palabra == palabrasAMemorizar.get(flag)) {
                    correcta = true;
                    break;
                } else {
                    correcta = false;
                }
            }
        } else {
            if (respuestaAfirmativa == false) {
                for (flag = 0; flag < palabrasAMemorizar.size(); flag++)
                {
                    if (palabra == palabrasAMemorizar.get(flag)) {
                        correcta = false;
                        break;
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

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function calls the pedirDatos functions of the Model class to request the name of the player in the GUI
     */
    public void pedirDatos(){
        usuario.pedirDatos();
        detectNewOrOldUser();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function saves the information of a new user.
     */

    public void registrarUsuario(){
        usuario.registrarUsuario(suNivel);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function detects if the player has already played or not
     */

    public void detectNewOrOldUser()
    {
        elUsuario = usuario.getUsuarioIngresado();
        suNivel = usuario.getNivelUsuario();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function level ups user.
     */

    public int subirNivelUsuario(int totalPalabras, int palabrasAcertadas){
        if(suNivel==10) {
            suNivel=suNivel;
        }
        else {
            if (palabrasAcertadas >= totalPalabras / 2) {
                suNivel++;
            } else {
                suNivel = suNivel;
            }
        }
        return suNivel;
    }

    public void noAnswer()
    {
        conteoErrores++;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This method gets the user level.
     * @return new level
     */

    public int getSuNivel() {
        return suNivel;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This method returns the number of words that the level
     * @return the number of words that the level
     */

    public int getCantidadPalabrasDelNivel() {
        return palabras.getCantidadPalabrasDelNivel();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This method returns the number of the errors that were made
     * @return the number of the errors
     */

    public int getErrores() {
        return conteoErrores;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This method returns the number of the hits that were made
     * @return the number of the hits
     */

    public int getAciertos() {
        return conteoAciertos;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function returns all words in the level
     * @return an array with the words
     */

    public ArrayList<String> getPalabrasDelNivel() {
        return palabrasDelNivel;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function returns only the words to be menorized from the level
     * @return an array with the words
     */

    public ArrayList<String> getPalabrasAMemorizar() {
        return palabrasAMemorizar;
    }
}
