package ProjetJava.Mastermind;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Vue extends Frame implements Observer  {

    Panel VueClavier;
    Canvas VuePropositions;
    Modele modl;

    public Vue(Modele m) {
        super();
        this.modl = m;

        this.setLayout(new BorderLayout());

        this.VueClavier = new Panel();
        this.VueClavier.setLayout(new FlowLayout());
        for (int i = 0; i < Modele.COULEURS.length; i++) {
            Button bouton = new Button();
            bouton.setPreferredSize(new Dimension(35,35));
            bouton.setBackground(Modele.COULEURS[i]);
            this.VueClavier.add(bouton);
        }
        this.add(this.VueClavier, BorderLayout.SOUTH);

        this.VuePropositions = new Canvas();
        this.VuePropositions.setPreferredSize(new Dimension(Modele.DIFFICULTE*80 + 40,Modele.N_TENTATIVES*50));
        this.add(this.VuePropositions, BorderLayout.NORTH);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
