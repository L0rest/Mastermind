package ProjetJava.Mastermind;

import java.awt.*;

public class Modele {

    static final Color[] COULEURS = {
        Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.RED, Color.ORANGE, Color.WHITE, Color.BLACK
    };
    static final int N_TENTATIVES = 10;
    static final int DIFFICULTE = 4;
    public enum ETAT {
        EN_COURS, GAGNE, PERDU
    }
}
