package Java_Base;

import java.util.ArrayList;
/**
 * Demo des ArrayList
 * 
 * @author Andi R.
 */
public class DemoArrayList
{
    // un tableau a une certaine taille, pas la possibilité de modifier la taille
    // ce n'est pas le cas d'une ArrayList
    
    // exemple :
    
    public static void main(){
        int[] tab = new int[5];       // taille fixe, tableau statique
        ArrayList aList1;              // déclaration d'une référence sur l'ArrayList
        aList1 = new ArrayList();     // allouer la zone mémoire
        
        ArrayList aList2 = new ArrayList();
        System.out.println("Taille de mon arraylist : " + aList2.size());
        
        // on peut ajouter ce que l'on veut dans un array list
        aList2.add("Texte");
        aList2.add(111);
        aList2.add(22.22);
        aList2.add(true);
        aList2.set(3, 33.33); //on modifie à la position 3, l'élément par 33.33
        
        System.out.println("Taille de mon arraylist : " + aList2.size());
        
        // parcours de l'ArrayList : comme un tableau
        
        for(int i = 0; i<aList2.size(); i++){
        
            System.out.println(aList2.get(i));
        
        }
        
        //problème : si on veut récupérer une seule valeur 
        
        // on peut cast le string, mais on est pas assuré que le type de variable soit le même dans l'index 0
        
        String nom = (String)aList2.get(0);
        System.out.println(nom);
        
        // vrai variante des ArrayList : il faut typer l'arraylist
        ArrayList<String> aList3 = new ArrayList();
        aList3.add("Texte1");
        aList3.add("Texte2");
        aList3.add("Texte3");
        aList3.add("Texte4");
        // plus besoin de cast, l'ArrayList ne contient que des String
        
        for(String valeur : aList3){
            System.out.println(valeur);
        }
        
        
        // int comme double ne sont pas des références des Arraylist
        // on ne peux pas faire ArrayList<int> ou avec double
        // il faut faire : ArrayList<Integer>
        // int      ==> Integer
        // double   ==> Double
        // boolean  ==> Boolean
        // char     ==> Character
        ArrayList<Integer> aList4 = new ArrayList();
        aList4.add(12);
        aList4.add(42);
        aList4.add(2442);
        aList4.add(2323);
        
        for(Integer val : aList4){
            System.out.println(val);
        }
    }
}
