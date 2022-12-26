package ProjetJava.Mastermind;

import java.awt.*;

public class Modele {

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


}
