package ProjetJava.Mastermind;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;
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
    }

    public void evaluer(Rangee r) {
        modif_blancs_noirs(r);
        archiver(r);
        this.tentative++;

        if (Arrays.toString(r.jetons).equals(Arrays.toString(this.combinaison.jetons))) {
            this.état = Etat.GAGNE;
        } else if (this.tentative == Modele.N_TENTATIVES) {
            this.état = Etat.PERDU;
        } else {
            new_prop();
        }
    }

    public void modif_blancs_noirs(Rangee r) {
        for (int i = 0; i < r.jetons.length; i++) {
            if (Objects.equals(r.jetons[i].toString(), this.combinaison.jetons[i].toString())) {
                r.noirs++;
            }
            boolean contenu = false;
            int j = 0;
            while (!contenu && j < this.combinaison.jetons.length) {
                if (Objects.equals(r.jetons[i].toString(), this.combinaison.jetons[j].toString())) {
                    contenu = true;
                    r.blancs ++;
                }
                else {j++;}
            }
        }
        r.blancs -= r.noirs;
    }

    public void new_prop() {
        this.propositions[this.tentative] = new Rangee();
    }

    public void completer_prop(Color c) {
        Rangee rangee_cour = this.propositions[this.tentative];

        rangee_cour.jetons[rangee_cour.indiceJeton] = c;
        if (rangee_cour.indiceJeton < 3) {
            rangee_cour.indiceJeton ++;
        }
        else {
            evaluer(rangee_cour);
        }

        this.setChanged();
        this.notifyObservers(this.propositions);
    }

    public void annuler() {
        Rangee rangee_cour = this.propositions[this.tentative];

        if (rangee_cour.indiceJeton > 0) {
            rangee_cour.indiceJeton --;
            rangee_cour.jetons[rangee_cour.indiceJeton] = null;
            archiver(rangee_cour);

            this.setChanged();
            this.notifyObservers(this.propositions);
        }

    }

}
