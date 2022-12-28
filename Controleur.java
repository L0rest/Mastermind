package ProjetJava.Mastermind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Controleur implements ActionListener {

    Modele modl;
    Random rand;

    public Controleur(Modele m) {
        this.modl = m;
        this.rand = new Random();
        for (int i = 0; i < Modele.DIFFICULTE; i++) {
            this.modl.combinaison.jetons[i] = Modele.COULEURS[rand.nextInt(Modele.COULEURS.length)];
        }
        this.modl.propositions[0] = new Rangee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.modl.état == Modele.Etat.EN_COURS) {
            this.modl.completer_prop();
        }
    }
}
