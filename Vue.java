package ProjetJava.Mastermind;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Vue extends Frame implements Observer  {

    Panel VueClavier;
    Canvas VuePropositions;

    public Vue() {
        super();
        this.VueClavier = new Panel();

        for (int i = 0; i < Modele.COULEURS.length; i++) {
            Button bouton = new Button();
            bouton.setPreferredSize(new Dimension(35,35));
            bouton.setBackground(Modele.COULEURS[i]);
            this.VueClavier.add(bouton);
        }

        this.add(this.VueClavier);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
