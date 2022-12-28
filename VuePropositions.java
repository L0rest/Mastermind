package ProjetJava.Mastermind;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VuePropositions extends Canvas implements Observer {

    Modele modl;

    public VuePropositions(Modele m) {
        super();
        this.modl = m;
        this.setPreferredSize(new Dimension(Modele.DIFFICULTE*80 + 40,Modele.N_TENTATIVES*50));
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
