package myProject;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static final String PATH_DICCIONARIO = "src/files/diccionario.txt";
    public static final String PATH_USUARIO = "src/files/usuario.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    /**
     * This function reads the words to memorize that are in dictionary.
     * @return the word
     */

    public ArrayList <String> lecturaDiccionario() {
        ArrayList <String> palabra = new ArrayList<String>();
        try {
            fileReader = new FileReader(PATH_DICCIONARIO);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null){
                palabra.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return palabra;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function reads the saved information of the user.
     * @return
     */

    public ArrayList <String> lecturaUsuario() {
        ArrayList <String> usuario = new ArrayList<String>();

        try {
            fileReader = new FileReader(PATH_USUARIO);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line != null){
                usuario.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function writes a new user name in usuario.txt
     * @param linea
     */

    public void escribirUsuario(String linea){
        try {
            fileWriter = new FileWriter(PATH_USUARIO,true);
            output = new BufferedWriter(fileWriter);
            output.write(linea);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function change the level of an old user in usuario.txt
     * @param linea
     */

    public void escribirUsuarioConocido(String linea, boolean conservarTxt)
    {
        try {
            fileWriter = new FileWriter(PATH_USUARIO,conservarTxt);
            output = new BufferedWriter(fileWriter);
            output.write(linea);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function writes the user level in usuario.txt
     * @param linea
     */

    public void escribirNivelUsuario(int linea){
        String nivel = String.valueOf(linea);
        try {
            fileWriter = new FileWriter(PATH_USUARIO,true);
            output = new BufferedWriter(fileWriter);
            output.write(nivel);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}