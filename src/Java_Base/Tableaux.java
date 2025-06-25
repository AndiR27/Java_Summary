package Java_Base;

/**
 * Gestion des Tableaux
 */
public class Tableaux
{
    // un tableau se déclarre comme : int[] tab;
    public static void demoTableau(){
        int nb;
        int[] tab;                  //déclaration d'une réfèrence
        tab = new int[5];          // allocation de la zone mémoire
        
        int[] tableau = new int[5];  // déclaration et allocation
        
        tableau[0] = 11;
        tableau[1] = 22;
        tableau[2] = 33;
        tableau[3] = 44;
        tableau[4] = 55;     // si pas de données, la taille ne change pas, la valeur devient juste 0;
        
        
        int[] autreTableau = {5,8, 3,9,-2,55,123};      //même chose que plus haut, mais en plus rapide
        System.out.println("Taille du tableau (nb de cellules() : " + tableau.length);
        
        for (int i=0; i<tableau.length; i++){
            if(tableau[i] < 0){
                System.out.println("Il y a des négatifs...");
            
            }
            System.out.print(i + " " );
            
        }
        
        afficherTableau(autreTableau);
        
        afficherTableau(tableau);
        
        
    }
    
    
    public static void afficherTableau(int[] tab) {
        for(int i=0; i<tab.length; i++) {System.out.print(tab[i] + " ");}
        
        
        }
}
