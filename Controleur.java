package ProjetJava.Mastermind;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controleur implements ActionListener, MouseListener {

    Modele modl;

    public Controleur(Modele m) {
        this.modl = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color couleur = new Color(Integer.parseInt(e.getActionCommand()));
        if (this.modl.état == Modele.Etat.EN_COURS) {
            this.modl.completer_prop(couleur);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (e.getClickCount() == 2) {
                this.modl.annuler();
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
