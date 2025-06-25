package Java_Base;

import java.util.*;
/**
 * Décrivez votre classe Hashset ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class HashsetetIterator
{
    public static void main(String[] args){
    //créer le hashset : plus simple, car chaque clé est UNIQUE, et pas de valeur :
    HashSet<String> mySet = new HashSet<>();
    
    //pour ajouter des données dans le hashset (un peu comme le hashmap et sans les valeurs)
    mySet.add("one");
    mySet.add("two");
    mySet.add("three");
    
    //parcourir avec un Iterator :
    
    Iterator<String> it = mySet.iterator();
    while(it.hasNext()){
         
        it.next(); //pour obtenir le nouvel objet et faire quelquechose avec
        
        it.hasNext(); //retourne vrai si il reste encore un élément
        
        it.remove(); //va supprimer l'élément itérée 
        
        //sur le it.next(), on peut rajouter des methodes, genre it.next().getNom(); ou faire des equals : it.next().equals(variable)
    }
     
    
    
    
    }
    
    
}
    
    
