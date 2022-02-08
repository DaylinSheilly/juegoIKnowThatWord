package myProject;

import javax.swing.*;
import java.util.ArrayList;

public class Usuario {
    private ArrayList<String> usuario = new ArrayList<String>();
    private ArrayList<String> usuarioRegistrado = new ArrayList<String>();
    private int unUsuario, nivelUsuario;
    private String usuarioIngresado;

    /**
     * Constructor
     */
    public Usuario() {

        FileManager fileManager = new FileManager();
        usuario = fileManager.lecturaUsuario();
        //fileManager.escribirUsuario(usuarioIngresado);

        unUsuario = 0;
        nivelUsuario = 1;
        usuarioIngresado = " ";

    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function saves the information of a new user.
     */

    public void registrarUsuario(){
        usuarioIngresado = JOptionPane.showInputDialog(null, "Ingresa tu nombre",
                "Solicitud de datos", JOptionPane.QUESTION_MESSAGE);
        usuarioRegistrado.add(usuarioIngresado);
        usuarioRegistrado.add(String.valueOf(nivelUsuario));
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function gets the user level.
     * @param usuarioIngresado
     * @return user level
     */

    public int getNivelUsuario(String usuarioIngresado) {
        for (unUsuario = 0; unUsuario < usuario.size(); unUsuario++) {
            if (usuario.get(unUsuario) == usuarioIngresado) {
                nivelUsuario = Integer.parseInt(usuario.get(unUsuario+1));
            } else {
                nivelUsuario = 1;
            }
        }
        return nivelUsuario;
    }

}