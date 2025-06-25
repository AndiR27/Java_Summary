package Java_Patterns.vue.Observer;

import java.util.Observable;
import java.util.Observer;

public class ClasseAbonneTauxObs2 implements Observer {
    String nomMagasin;

    public ClasseAbonneTauxObs2(String nomMagasin) {
        this.nomMagasin = nomMagasin;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Le taux" + o + " a changé...." + arg + "pour le magasin : " + nomMagasin);
    }
}
