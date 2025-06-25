package Java_Base;

import java.util.*;
/**
 * Décrivez votre classe Hashmap ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Hashmap
{
    public static void main(String[] args) 
    { 
        //créer le hashmap
        HashMap<String, Integer> motsDico = new HashMap<>(); //dans les <>, on précise le type de variable pour la clé, et la valeur
        
        String motTest = "test";
        //check si une clé existe dans le dico
        motsDico.put("test",1);
        motsDico.put("test2",2);
        motsDico.put("test3",3);
        if(motsDico.containsKey(motTest)){
           Integer count = motsDico.get(motTest);
           motsDico.put(motTest, count + 1);
           // alors on change le compte (qu'on récupère selon la clé) et on y ajoute +1
           // .put(clé, valeur) pour ajouter
           // .get(clé) pour chercher une clé spécifique
           // .remove(clé) pour supprimer une clé et sa valeur
                    
                
        }
        
        //Pour boucler sur un hashmap
        for(String cle : motsDico.keySet()){
            //à chaque clé, on execute une action
            System.out.println(cle + motsDico.get(cle));
            
        
        }
        
    }
}
