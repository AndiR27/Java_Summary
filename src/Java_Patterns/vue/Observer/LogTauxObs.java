package Java_Patterns.vue.Observer;

import java.util.Observable;
import java.util.Observer;

public class LogTauxObs implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Le taux a changé....");
    }
}
