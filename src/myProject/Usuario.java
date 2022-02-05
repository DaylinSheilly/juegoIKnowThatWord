package myProject;

import java.util.ArrayList;

public class Usuario {
    private ArrayList<String> usuario = new ArrayList<String>();
    private ArrayList<String> usuarioRegistrado = new ArrayList<String>();
    private int unUsuario, nivelUsuario;
    private String usuarioIngresado;

    public Usuario() {

        FileManager fileManager = new FileManager();
        usuario = fileManager.lecturaUsuario();
        usuarioRegistrado = fileManager.escribirUsuario(String usuarioIngresado);

        unUsuario = 0;
        nivelUsuario = 0;
        usuarioIngresado = " ";

    }

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

    public void registrarUsuario(String usuarioIngresado){
        usuarioRegistrado;
    }
}
