package Java_Patterns.vue.Observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;

public class TauxChangeObs extends Observable {
    private double taux;
    //Le PCS va préciser que c'est la classe TauxChangeObs qui devra être écoutée
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public double getTaux() {
        return taux;
    }

    public void addObserver(PropertyChangeListener listener){
        //Conserver les observers
        //Avec le PCS, juste à ajouter dans la liste
        pcs.addPropertyChangeListener(listener);
    }

    public void setTaux(double newTaux) {
        double oldTaux = this.taux;
        this.taux = newTaux;
        //Prévenir tout ceux qui sont intéressé par une modification du taux
        setChanged();
        notifyObservers("Valeur quelqconque");

        //Avec PCS : on va envoyer la notif aux classes qui écoutent la classe taux
        pcs.firePropertyChange("Le taux a changé", oldTaux, newTaux);
    }

    @Override
    public String toString() {
        return "TauxChangeObs{" +
                "taux=" + taux +
                '}';
    }
}
