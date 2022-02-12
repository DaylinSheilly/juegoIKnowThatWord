package myProject;

import javax.swing.*;
import java.util.ArrayList;

public class Usuario {
    private ArrayList<String> usuarios = new ArrayList<String>();
    private int unUsuario, nivelUsuario;
    private String usuarioIngresado, nombreUsuario;

    private FileManager fileManager;

    /**
     * Constructor
     */
    public Usuario() {
        fileManager = new FileManager();
        usuarios = fileManager.lecturaUsuario();

        unUsuario = 0;
        nivelUsuario = 1;
        usuarioIngresado = "";
        nombreUsuario = "";
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function ask an username at the user.
     */
    public void pedirDatos(){
        nombreUsuario = JOptionPane.showInputDialog(null, "Ingresa tu nombre",
                "Solicitud de datos", JOptionPane.QUESTION_MESSAGE);
        if(nombreUsuario == null || nombreUsuario.equals("")){
            pedirDatos();
        }
    }

    /**
     * This function saves the information of an user.
     */
    public void registrarUsuario(String nombreUsuario, int nivelUsuario){
        fileManager.escribirUsuario(nombreUsuario);
        fileManager.escribirNivelUsuario(nivelUsuario);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function gets the user level.
     * @return user level
     */
    public int getNivelUsuario() {
        for (unUsuario = 0; unUsuario < usuarios.size(); unUsuario++) {
            if (usuarios.get(unUsuario) == usuarioIngresado) {
                nivelUsuario = Integer.parseInt(usuarios.get(unUsuario+1));

            } else {
                nivelUsuario = 1;
            }
        }
        return nivelUsuario;
    }

    /**
     * This function gets the user name.
     * @return user level
     */
    public String getUsuarioIngresado() {
        return usuarioIngresado;
    }
}