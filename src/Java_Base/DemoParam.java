package Java_Base;

import java.util.ArrayList;
/**
 * Décrivez votre classe DemoParam ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DemoParam
{
    public static void main(){
    ArrayList nb = new ArrayList(); nb.add(11); nb.add(111); nb.add(1111); nb.add(11111);
    System.out.println("A) " + nb);
    modifie(nb);
    System.out.println("E) " + nb); // on va se demander quelle valeur sera affiché içi
    // la valeur dans la methode n'est pas retourné, donc va afficher 12
    
    // avec les array list, que se passe-t-il : le principe est le même
    // si l'arraylist a simplement été modifié (au niveau du contenu) alors on affichera aussi les modifications
    }
    
    private static void modifie(ArrayList nb) { // passage de paramètre par valeur : on travail ici sur une copie
        
        System.out.println("C) " + nb);
        
        //nb = new ArrayList(); 
        nb.add(22); nb.add(222); nb.add(2222); nb.add(22222);
        
        System.out.println("D) " + nb);
        
        //nb est une copie de la référence, ce qui sera modifié içi sera une nouvelle zone mémoire allouée
        // si on add tout simplement des données, la même liste reste avec des nouvelles valeurs

    
    
    
    
    
    }


}
