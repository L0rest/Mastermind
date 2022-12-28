package ProjetJava.Mastermind;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VueClavier extends Panel implements Observer {

    Modele modl;

    public VueClavier(Modele m) {
        super();
        this.modl = m;

        this.setLayout(new FlowLayout());
        for (int i = 0; i < Modele.COULEURS.length; i++) {
            Button bouton = new Button();
            bouton.setPreferredSize(new Dimension(35,35));
            bouton.setBackground(Modele.COULEURS[i]);
            this.add(bouton);
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
