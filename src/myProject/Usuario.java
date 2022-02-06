package myProject;

import javax.swing.*;
import java.util.ArrayList;

public class Usuario {
    private ArrayList<String> usuario = new ArrayList<String>();
    private ArrayList<String> usuarioRegistrado = new ArrayList<String>();
    private int unUsuario;
    private String usuarioIngresado, nivelUsuario;

    public Usuario() {

        FileManager fileManager = new FileManager();
        usuario = fileManager.lecturaUsuario();
        fileManager.escribirUsuario(usuarioIngresado);

        unUsuario = 0;
        nivelUsuario = "1";
        usuarioIngresado = " ";

    }

    public void registrarUsuario(){
        usuarioIngresado = JOptionPane.showInputDialog(null, "Ingresa tu nombre",
                "Solicitud de datos", JOptionPane.QUESTION_MESSAGE);
        usuarioRegistrado.add(usuarioIngresado);
        usuarioRegistrado.add(nivelUsuario);
    }

    public String getNivelUsuario(String usuarioIngresado) {
        for (unUsuario = 0; unUsuario < usuario.size(); unUsuario++) {
            if (usuario.get(unUsuario) == usuarioIngresado) {
                nivelUsuario = (usuario.get(unUsuario+1));
            } else {
                nivelUsuario = "1";
            }
        }
        return nivelUsuario;
    }

}
