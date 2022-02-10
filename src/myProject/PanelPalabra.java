package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelPalabra extends JPanel {
    private String palabra = "";

    private PalabrasDelNivel palabras;

    public PanelPalabra()
    {
        setBackground(new Color(0,0,0,0));
    }

    public String determinateNextWord()
    {
        int cualPalabra = 0;
        int flag = 0;
        int cantidadPalabras = palabras.getCantidadPalabrasDelNivel();

        if(flag < cantidadPalabras)
        {
            palabra = palabras.getUnaPalabra(flag);
            flag++;
        }
        else
        {
            palabra = "| Esas han sido todas las palabras |";
            //timer.stop();
        }
        return palabra;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setFont(new Font(Font.DIALOG,Font.BOLD,27));
        g.drawString(determinateNextWord(),100,100);
    }
}
