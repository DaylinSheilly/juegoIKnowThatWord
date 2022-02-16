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

    public void pedirDatos(){
        usuario.pedirDatos();
        detectNewOrOldUser();
    }

    /**
     * This function saves the information of a new user.
     */

    public void registrarUsuario(){
        usuario.registrarUsuario(suNivel);
    }

    public void detectNewOrOldUser()
    {
        elUsuario = usuario.getUsuarioIngresado();
        suNivel = usuario.getNivelUsuario();
    }

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

    public ArrayList<String> getPalabrasDelNivel() {
        return palabrasDelNivel;
    }

    public ArrayList<String> getPalabrasAMemorizar() {
        return palabrasAMemorizar;
    }
}
