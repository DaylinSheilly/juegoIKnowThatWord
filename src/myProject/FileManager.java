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

}