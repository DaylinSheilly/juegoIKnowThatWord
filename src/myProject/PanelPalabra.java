package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelPalabra extends JPanel {
    private String palabra = "";
    private boolean cambiar;

    private PalabrasDelNivel palabras;

    public PanelPalabra()
    {
        palabras = new PalabrasDelNivel();
        setBackground(new Color(0,0,0,0));
        boolean cambiar=false;
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
            //timer.stop();
        }
        return palabra;
    }

    public boolean getCambiar()
    {
        return cambiar;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int cantidadPalabras = palabras.getCantidadPalabrasDelNivel();

        g.setFont(new Font(Font.DIALOG,Font.BOLD,27));

        for(int palabras=0;palabras<cantidadPalabras/2;palabras++)
        {
            g.drawString(determinateNextWord(cantidadPalabras/2), 100, 100);
        }

        cambiar=true;

        for(int palabras=0;palabras<cantidadPalabras;palabras++)
        {
            g.drawString(determinateNextWord(cantidadPalabras), 100, 100);
        }
    }
}
