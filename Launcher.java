package ProjetJava.Mastermind;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Launcher extends Frame implements WindowListener {

    Modele modl;
    Controleur control;
    VueClavier partieBasse;
    VuePropositions partieHaute;

    public Launcher() {
        super("Mastermind");
        this.setLayout(new BorderLayout());

        this.modl = new Modele();
        this.control = new Controleur(modl);
        this.partieBasse = new VueClavier(control, modl);
        this.partieHaute = new VuePropositions(modl);

        this.add(this.partieBasse, BorderLayout.SOUTH);
        this.add(this.partieHaute, BorderLayout.NORTH);
        this.addWindowListener(this);
        partieHaute.addMouseListener(control);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {

        new Launcher();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
