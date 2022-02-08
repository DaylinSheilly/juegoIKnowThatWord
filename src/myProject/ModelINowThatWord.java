package myProject;

import java.util.ArrayList;
import java.util.Random;

public class ModelINowThatWord {

    private Diccionario palabras;
    private Usuario usuario;
    private int conteoErrores, conteoAciertos, nivel, unaPalabra;
    private boolean fallo, ganar;
    private String palabra, nuevaPalabra;
    private ArrayList<String> palabrasDelNivel, palabrasAMemorizar;

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
        palabrasDelNivel = new ArrayList<String>();
        palabrasAMemorizar = new ArrayList<String>();
    }

    public void palabrasPorNivel(int nivel){
        switch (nivel){
            case 1: palabrasDelNivel=palabras.getPalabra(20); //del 0 al 19
                break;
            case 2: palabrasDelNivel=palabras.getPalabra(40); //del 0 al 39
                break;
            case 3: palabrasDelNivel=palabras.getPalabra(50); //del 0 al 49
                break;
            case 4: palabrasDelNivel=palabras.getPalabra(60); //del 0 al 59
                break;
            case 5: palabrasDelNivel=palabras.getPalabra(70); //del 0 al 69
                break;
            case 6: palabrasDelNivel=palabras.getPalabra(80); //del 0 al 79
                break;
            case 7: palabrasDelNivel=palabras.getPalabra(100); //del 0 al 99
                break;
            case 8: palabrasDelNivel=palabras.getPalabra(120); //del 0 al 119
                break;
            case 9: palabrasDelNivel=palabras.getPalabra(140); //del 0 al 139
                break;
            case 10: palabrasDelNivel=palabras.getPalabra(200); //del 0 al 199
                break;
        }
        for(int i=0;i<palabrasDelNivel.size();i++)
        {
            System.out.println(palabrasDelNivel.get(i));
        }
        palabrasAMemorizar();
    }

    public void palabrasAMemorizar()
    {
        int cantidadPalabrasAMemorizar = (palabrasDelNivel.size())/2;
        for(int flag=0;flag<cantidadPalabrasAMemorizar;flag++)
        {
            palabrasAMemorizar.add(palabrasDelNivel.get(flag));
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

    /**
     * This function level ups user.
     * @return new level
     */
    public int subirNivelUsuario(String usuarioIngresado){
        return usuario.getNivelUsuario(usuarioIngresado)+1;
    }
}
