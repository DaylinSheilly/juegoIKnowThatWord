package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelPalabrasNivel extends JPanel {
    private String palabra = "";

    private PalabrasDelNivel palabras;

    public PanelPalabrasNivel()
    {
        palabras = new PalabrasDelNivel();
        setBackground(new Color(0,0,0,0));
    }

    public String determinateNextWord(int cantidadPalabras)
    {
        int flag = 0;

        if(flag < cantidadPalabras)
        {
            palabra = palabras.getUnaPalabra(flag);
            flag++;
        }
        else
        {
            palabra = "| Esas han sido todas las palabras |";
        }
        return palabra;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int cantidadPalabras = palabras.getCantidadPalabrasDelNivel();

        g.setFont(new Font(Font.DIALOG,Font.BOLD,27));

        g.drawString(determinateNextWord(cantidadPalabras), 100, 100);
    }
}

