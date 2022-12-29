package ProjetJava.Mastermind;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VuePropositions extends Canvas implements Observer {

    Modele modl;

    public VuePropositions(Modele m) {
        super();
        this.modl = m;
        this.setPreferredSize(new Dimension(Modele.DIFFICULTE*80 + 40,Modele.N_TENTATIVES*80));

        this.modl.addObserver(this);

    }

    public void paint(Graphics g) {
        for (int i = 0; i < this.modl.propositions.length; i++) {
            if (this.modl.propositions[i] != null) {
                for (int j = 0; j < Modele.DIFFICULTE; j++) {
                    if (this.modl.propositions[i].jetons[j] != null) {
                        g.setColor(this.modl.propositions[i].jetons[j]);
                        g.fillOval((60*j) + 30, (60*i) + 10, 40, 40);
                    }
                    g.setColor(Color.BLACK);
                    g.drawOval((60*j) + 30, (60*i) + 10, 40, 40);
                }
            }
        }


    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
