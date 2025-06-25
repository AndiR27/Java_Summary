package Java_Patterns.vue.Observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ClasseAbonneTauxObs implements PropertyChangeListener {
    /**
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Le taux" + o + " a changé...." + arg);
    }
    */

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //Possibilité de jouer avec evt.donnée selon ce qui a été envoyé au Fire
        System.out.println("Le taux" + evt.getOldValue() + " a changé, nouvelle value : " + evt.getNewValue());

    }
}
