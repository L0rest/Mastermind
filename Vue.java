package ProjetJava.Mastermind;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Vue implements Observer  {

    Panel VueClavier;
    Canvas VuePropositions;
    Modele modl;

    public Vue(Modele m) {
        this.modl = m;

        this.VueClavier = new Panel();
        this.VueClavier.setLayout(new FlowLayout());
        for (int i = 0; i < Modele.COULEURS.length; i++) {
            Button bouton = new Button();
            bouton.setPreferredSize(new Dimension(35,35));
            bouton.setBackground(Modele.COULEURS[i]);
            this.VueClavier.add(bouton);
        }

        this.VuePropositions = new Canvas();
        this.VuePropositions.setPreferredSize(new Dimension(Modele.DIFFICULTE*80 + 40,Modele.N_TENTATIVES*50));

    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
