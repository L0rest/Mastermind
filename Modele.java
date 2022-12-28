package ProjetJava.Mastermind;

import java.awt.*;
import java.util.Observable;

public class Modele extends Observable {

    static final Color[] COULEURS = {Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.RED, Color.ORANGE, Color.WHITE, Color.BLACK};
    static final int N_TENTATIVES = 10;
    static final int DIFFICULTE = 4;

    public enum Etat {
        EN_COURS, GAGNE, PERDU
    }

    public Etat état;
    public Rangee combinaison;
    public Rangee[] propositions;
    public int tentative;

    public Modele() {
        this.état = Etat.EN_COURS;
        this.combinaison = new Rangee();
        this.propositions = new Rangee[N_TENTATIVES];
        this.tentative = 0;
    }

    public void archiver(Rangee r) {
        this.propositions[this.tentative] = r;
        this.setChanged();
        this.notifyObservers(this.propositions);
    }

    public void evaluer(Rangee r) {
        archiver(r);
        this.tentative++;

        if (r.jetons == this.combinaison.jetons) {
            this.état = Etat.GAGNE;
        } else if (this.tentative == Modele.N_TENTATIVES) {
            this.état = Etat.PERDU;
        } else {
            modif_blancs_noirs(r);
            new_prop();
        }
    }

    public void modif_blancs_noirs(Rangee r) {
        for (int i = 0; i < r.jetons.length; i++) {
            if (r.jetons[i] == this.combinaison.jetons[i]) {
                r.noirs++;
            }
            for (int j = 0; j < this.combinaison.jetons.length; j++) {
                if (r.jetons[i] == this.combinaison.jetons[j]) {
                    r.blancs++;
                }
            }
        }
    }

    public void new_prop() {
        this.propositions[this.tentative] = new Rangee();
        this.setChanged();
        this.notifyObservers(this.propositions);
    }

}
