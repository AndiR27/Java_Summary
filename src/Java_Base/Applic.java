package Java_Base;

import java.util.ArrayList;
/**
 * Démo Comparable & Comparator
 * @author Ch. Stettler - HEG-Genève
 */
public class Applic
{
    public static void main() {
        // ArrayList d'Integer : utilisation de print==>toString / contains==>equals / sort==>compareTo 
        ArrayList<Integer> aLst = new ArrayList<>();
        aLst.add(11); aLst.add(55); aLst.add(33); aLst.add(99); aLst.add(22);
        
        for (Integer nb : aLst) { System.out.print(nb + " "); } System.out.println();
        aLst.sort(null);
        for (Integer nb : aLst) { System.out.print(nb + " "); } System.out.println();
        
        if (aLst.contains(33)) { System.out.println("Contient 33"); } else { System.out.println("Ne contient pas 33"); }
        
        // =============================================================================
        
        // Idem avec des String
        ArrayList<String> aLstStr = new ArrayList<>();
        aLstStr.add("Hello"); 
        aLstStr.add("Coucou"); 
        aLstStr.add("Bonjour"); 
        aLstStr.add("Salut"); 
        aLstStr.add("Bonsoir"); 
        
        for (String str : aLstStr) { System.out.print(str + " "); } System.out.println();
        aLstStr.sort(null);
        for (String str : aLstStr) { System.out.print(str + " "); } System.out.println();
        
        if (aLstStr.contains("Salut")) { System.out.println("Contient Salut"); } else { System.out.println("Ne contient pas Salut"); }
        
        // =============================================================================
        
        // Idem avec des Personnes
        ArrayList<Personne2> aLstPers = new ArrayList<>();
        aLstPers.add(new Personne2(11, "Dupond", "Jean"));
        aLstPers.add(new Personne2(55, "Durand", "Axel"));
        aLstPers.add(new Personne2(33, "Dufour", "Luca"));
        aLstPers.add(new Personne2(99, "Dupuis", "Evan"));
        aLstPers.add(new Personne2(22, "Dupont", "Loïc"));
        
        for (Personne2 pers : aLstPers) { System.out.print(pers + " "); } System.out.println();
        aLstPers.sort(null); // utilise le compareTo de Personne pour définir l'ordre de tri
        for (Personne2 pers : aLstPers) { System.out.print(pers + " "); } System.out.println();
        aLstPers.sort(new ComparatorParNom()); // utilise un Comparator spécifique
        for (Personne2 pers : aLstPers) { System.out.print(pers + " "); } System.out.println();
        
        if (aLstPers.contains(new Personne2(33, "", ""))) { System.out.println("Contient 33"); } else { System.out.println("Ne contient pas 33"); }
    }
}