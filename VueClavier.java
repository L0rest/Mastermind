package ProjetJava.Mastermind;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class VueClavier extends Panel implements Observer {

    Modele modl;
    Button[] listeboutons = new Button[Modele.COULEURS.length];


    public VueClavier(ActionListener l, Modele m) {
        super();
        this.modl = m;

        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(Modele.DIFFICULTE*80 + 40, 50));
        for (int i = 0; i < Modele.COULEURS.length; i++) {
            Button bouton = new Button();
            bouton.setPreferredSize(new Dimension(35,35));
            bouton.setBackground(Modele.COULEURS[i]);
            bouton.setActionCommand(String.valueOf(Modele.COULEURS[i].getRGB()));
            this.listeboutons[i] = bouton;
            this.listeboutons[i].addActionListener(l);
            this.add(bouton);
        }

        this.modl.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (this.modl.état == Modele.Etat.GAGNE) {
            this.removeAll();
            this.add(new Label("Gagné"));
            repaint();
        }
        else if (this.modl.état == Modele.Etat.PERDU) {
            this.removeAll();
            this.add(new Label("Perdu"));
            repaint();
        }
    }
}
