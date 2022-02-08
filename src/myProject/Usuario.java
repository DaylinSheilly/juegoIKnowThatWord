package myProject;

import javax.swing.*;
import java.util.ArrayList;

public class Usuario {
    private ArrayList<String> usuario = new ArrayList<String>();
    private ArrayList<String> usuarioRegistrado = new ArrayList<String>();
    private int unUsuario, nivelUsuario;
    private String usuarioIngresado, nombreUsuario;

    private FileManager fileManager;

    /**
     * Constructor
     */
    public Usuario() {

        fileManager = new FileManager();
        usuario = fileManager.lecturaUsuario();

        unUsuario = 0;
        nivelUsuario = 1;
        usuarioIngresado = "";
        nombreUsuario = "";
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    public void pedirDatos(){
        nombreUsuario = JOptionPane.showInputDialog(null, "Ingresa tu nombre",
                "Solicitud de datos", JOptionPane.QUESTION_MESSAGE);
        System.out.println("-"+nombreUsuario+"-");
        if(nombreUsuario == null || nombreUsuario.equals("")){
            pedirDatos();
        }
        else{
            nombreUsuario = nombreUsuario;
        }
    }

    /**
     * This function saves the information of a new user.
     */

    public void registrarUsuario(){
        usuarioRegistrado.add(nombreUsuario);
        usuarioRegistrado.add(String.valueOf(nivelUsuario));
        fileManager.escribirUsuario(nombreUsuario);
        fileManager.escribirNivelUsuario(nivelUsuario);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function gets the user level.
     * @return user level
     */

    public int getNivelUsuario() {
        for (unUsuario = 0; unUsuario < usuario.size(); unUsuario++) {
            if (usuario.get(unUsuario) == usuarioIngresado) {
                nivelUsuario = Integer.parseInt(usuario.get(unUsuario+1));
            } else {
                nivelUsuario = 1;
            }
        }
        return nivelUsuario;
    }

    public String getUsuarioIngresado() {
        return usuarioIngresado;
    }
}