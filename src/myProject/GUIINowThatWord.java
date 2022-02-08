package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 *
 * (ejemplo v.17.3.8 se lee: versión 17 del sofware, la tercera actualización del software
 *  * y la octava corrección de errores)
 */
public class GUIINowThatWord extends JFrame {

    private Header headerProject;
    private JPanel panelPalabras, panelEspacioEnBlanco1, panelEspacioEnBlanco2, panelEspacioEnBlanco3, panelEspacioEnBlanco4, panelEspacioEnBlanco5, panelInfo, panelInstrucciones;
    private JButton ayuda, salir, botonSI, botonNO;
    private JTextArea nivel, aciertos,errores, instrucciones;

    int numeroNivel, numeroAciertos, numeroErrores = 0;
    String INSTRUCCIONES = "instrucciones"; //RELLENAR

    private ModelINowThatWord game;
    private Escucha escucha;

    /**
     * Constructor of GUI class
     */
    public GUIINowThatWord(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I Know That Word");
        //this.setSize(200,100);
        this.pack();
        //this.setUndecorated(true);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 230, 153));
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     *
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object and Control Object
        escucha = new Escucha();
        game = new ModelINowThatWord();
        //Set up JComponents

        panelInstrucciones = new JPanel();
        panelInstrucciones.setPreferredSize(new Dimension(410,1005));
        panelInstrucciones.setBackground(Color.WHITE);
        panelInstrucciones.setBorder(BorderFactory.createTitledBorder("Instrucciones del juego."));
        panelInstrucciones.setLayout(new BorderLayout());

        instrucciones = new JTextArea();
        instrucciones.setText(INSTRUCCIONES);
        instrucciones.setLineWrap(true);
        instrucciones.setPreferredSize(new Dimension(408, 1000));
        instrucciones.setWrapStyleWord(true);
        instrucciones.setLineWrap(true);
        instrucciones.setEditable(false);


        game.palabrasPorNivel(2);

        //createPalabrasAMemorizarGUI(constraints);
        //createPalabrasAVerificarGUI(constraints);
        //createConclusionGUI(constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates the GUI that show the words to memorize.
     * @param constraints
     */

    public void createPalabrasAMemorizarGUI(GridBagConstraints constraints) {

        createHeader(constraints);
        createHelpButton(constraints);
        createLevelCounter(constraints);
        createExitButton(constraints);
        createSpace1(constraints);
        createSpace2(constraints);
        createPanelPalabrasAMemorizar(constraints);

        revalidate();
        repaint();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates the header.
     * @param constraints
     */

    public void createHeader(GridBagConstraints constraints) {
        headerProject = new Header("I Know that Word", new Color(128, 96, 0));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(headerProject, constraints); //Change this line if you change JFrame Container's Layout
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates the ayuda button.
     * @param constraints
     */

    public void createHelpButton(GridBagConstraints constraints) {
        ayuda = new JButton(" ? ");
        ayuda.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        ayuda.setForeground(Color.white);
        ayuda.removeMouseListener(escucha);
        ayuda.addMouseListener(escucha);
        ayuda.setBackground(new Color(0, 112, 192));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.FIRST_LINE_START;
        constraints.anchor = GridBagConstraints.LINE_START;

        add(ayuda, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates white space to separate the ayuda button and nivel text area.
     * @param constraints
     */

    public void createSpace1(GridBagConstraints constraints) {
        panelEspacioEnBlanco1 = new JPanel();
        panelEspacioEnBlanco1.setOpaque(false);
        panelEspacioEnBlanco1.setPreferredSize(new Dimension(130, 5));


        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;

        add(panelEspacioEnBlanco1, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates white space to separate the nivel text area and salir button.
     * @param constraints
     */

    public void createSpace2(GridBagConstraints constraints) {
        panelEspacioEnBlanco2 = new JPanel();
        panelEspacioEnBlanco2.setOpaque(false);
        panelEspacioEnBlanco2.setPreferredSize(new Dimension(115, 5));

        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;

        add(panelEspacioEnBlanco2, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------


    /**
     * This function creates the text area to display the actually level.
     * @param constraints
     */

    public void createLevelCounter(GridBagConstraints constraints) {
        nivel = new JTextArea(1, 2);
        nivel.setMinimumSize(new Dimension(5, 5));
        nivel.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        nivel.setText("Nivel: " + numeroNivel);
        nivel.setBackground(new Color(255, 242, 204));
        nivel.setEditable(false);
        nivel.setBorder(BorderFactory.createRaisedBevelBorder());

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(nivel, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * This function creates the salir button.
     * @param constraints
     */

    public void createExitButton(GridBagConstraints constraints) {
        salir = new JButton("Salir");
        salir.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        salir.setForeground(Color.WHITE);
        salir.removeMouseListener(escucha);
        salir.addMouseListener(escucha);
        salir.setBackground(new Color(192, 0, 0));
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.LINE_END;

        add(salir, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates the PanelPalabras panel.
     * @param constraints
     */
    public void createPanelPalabrasAMemorizar(GridBagConstraints constraints)
    {
        panelPalabras = new JPanel();
        panelPalabras.setPreferredSize(new Dimension(390, 240));
        panelPalabras.setBorder(BorderFactory.createTitledBorder("Palabras"));
        panelPalabras.setBackground(new Color(0,0,0,0));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        add(panelPalabras, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates the GUI that show the all words of level and the player will to choose the correct answer.
     * @param constraints
     */

    public void createPalabrasAVerificarGUI(GridBagConstraints constraints) {

        createHeader(constraints);
        createHelpButton(constraints);
        createSpace1(constraints);
        createLevelCounter(constraints);
        createSpace2(constraints);
        createExitButton(constraints);
        createPanelPalabrasAVerificar(constraints);
        createSpace3(constraints);
        createBotonSI(constraints);
        createBotonNO(constraints);
        createSpace4(constraints);

        revalidate();
        repaint();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function repaint the PanelPalabras panel.
     * @param constraints
     */
    public void createPanelPalabrasAVerificar(GridBagConstraints constraints)
    {
        panelPalabras = new JPanel();
        panelPalabras.setPreferredSize(new Dimension(390, 140));
        panelPalabras.setBorder(BorderFactory.createTitledBorder("Palabras"));
        panelPalabras.setBackground(new Color(0,0,0,0));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        add(panelPalabras, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function create the BotonSI button.
     * @param constraints
     */
    public void createBotonSI(GridBagConstraints constraints)
    {
        botonSI = new JButton("\uF0FC\n");
        botonSI.setPreferredSize(new Dimension(100, 40));
        botonSI.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 25));
        botonSI.setForeground(new Color(32, 50, 20));
        botonSI.removeMouseListener(escucha);
        botonSI.addMouseListener(escucha);
        botonSI.setBackground(new Color(146, 208, 80));

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        add(botonSI, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function create the BotonNO button.
     * @param constraints
     */
    public void createBotonNO(GridBagConstraints constraints)
    {
        botonNO = new JButton("\uF0FB");
        botonNO.setPreferredSize(new Dimension(100, 40));
        botonNO.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 25));
        botonNO.setForeground(new Color(62, 0, 0));
        botonNO.removeMouseListener(escucha);
        botonNO.addMouseListener(escucha);
        botonNO.setBackground(new Color(255, 0, 0));

        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        add(botonNO, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates white space to separate the panelPalabras pane to botonSI button and botonNO button.
     * @param constraints
     */

    public void createSpace3(GridBagConstraints constraints) {
        panelEspacioEnBlanco3 = new JPanel();
        panelEspacioEnBlanco3.setOpaque(false);
        panelEspacioEnBlanco3.setPreferredSize(new Dimension(115, 5));

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;

        add(panelEspacioEnBlanco3, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates white space to separate the botonSI button, botonNO button and the GUI border.
     * @param constraints
     */

    public void createSpace4(GridBagConstraints constraints) {
        panelEspacioEnBlanco4 = new JPanel();
        panelEspacioEnBlanco4.setOpaque(false);
        panelEspacioEnBlanco4.setPreferredSize(new Dimension(115, 5));

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;

        add(panelEspacioEnBlanco4, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates the GUI that show the all words of level and the player will to choose the correct answer.
     * @param constraints
     */

    public void createConclusionGUI(GridBagConstraints constraints) {

        createHeader(constraints);
        createHelpButton(constraints);
        createSpace1(constraints);
        createLevelCounter(constraints);
        createSpace2(constraints);
        createExitButton(constraints);
        createSpace5(constraints);
        createSuccessCounter(constraints);
        createMistakesCounter(constraints);
        createPanelInfo(constraints);

        revalidate();
        repaint();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function creates white space to separate the ayuda button, salir button and nivel text counter to aciertos button and errores boton.
     * @param constraints
     */

    public void createSpace5(GridBagConstraints constraints) {
        panelEspacioEnBlanco5 = new JPanel();
        panelEspacioEnBlanco5.setOpaque(false);
        panelEspacioEnBlanco5.setPreferredSize(new Dimension(115, 5));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;

        add(panelEspacioEnBlanco5, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------


    /**
     * This function creates the text area to display the right answers in the level.
     * @param constraints
     */

    public void createSuccessCounter(GridBagConstraints constraints) {
        aciertos = new JTextArea(1, 2);
        aciertos.setMinimumSize(new Dimension(50, 15));
        aciertos.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        aciertos.setText("Aciertos: " + numeroAciertos);
        aciertos.setBackground(new Color(146, 208, 80));
        aciertos.setEditable(false);
        aciertos.setBorder(BorderFactory.createRaisedBevelBorder());

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(aciertos, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------


    /**
     * This function creates the text area to display the wrong answers in the level.
     * @param constraints
     */

    public void createMistakesCounter(GridBagConstraints constraints) {
        errores = new JTextArea(1, 2);
        errores.setMinimumSize(new Dimension(50, 15));
        errores.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        errores.setText("Errores: " + numeroErrores);
        errores.setBackground(new Color(255,0,0));
        errores.setEditable(false);
        errores.setBorder(BorderFactory.createRaisedBevelBorder());

        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(errores, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This function create the PanelInfo pane.
     * @param constraints
     */
    public void createPanelInfo(GridBagConstraints constraints)
    {
        panelInfo = new JPanel();
        panelInfo.setPreferredSize(new Dimension(390, 170));
        panelInfo.setBorder(BorderFactory.createTitledBorder("Información"));
        panelInfo.setBackground(new Color(0,0,0,0));

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;

        add(panelInfo, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIINowThatWord miProjectGUIINowThatWord = new GUIINowThatWord();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource()==salir)
            {
                System.exit(0);
            }
            else if(e.getSource()==ayuda)
            {
                panelInstrucciones.add(instrucciones, BorderLayout.LINE_START);

                JScrollPane scroll = new JScrollPane(panelInstrucciones);
                scroll.setPreferredSize(new Dimension(440, 455));

                JOptionPane.showMessageDialog(null, scroll, "Instrucciones del juego", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
