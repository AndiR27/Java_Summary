package Java_Base;

import java.util.Comparator;
/**
 * Permet de trier des Personnes par nom.
 * @author Ch. Stettler - HEG-Genève
 */
public class ComparatorParNom implements Comparator<Personne2> {
    public int compare(Personne2 pers1, Personne2 pers2) {
        return pers1.getNom().compareToIgnoreCase(pers2.getNom());
    }
}