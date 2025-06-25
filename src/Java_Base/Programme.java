package Java_Base;

/**
 * Application de gestion des Articlev2s
 * - les attributs et les méthodes sont en général static ==> peuvent être appelées sans avoir d'instance
 * - travaille sur un ensemble d'Articlev2s ==> un tableau ou un ArrayList ou ...
 * - peut contenir la méthode main() ==> méthode appelée lors du lancement de l'application
 *
 * @author Ch. Stettler - HEG-Genève
 */
public class Programme  // Capsule pour les programmes
{
    public static void main(String[] args) {
        int nb;                         // définition d'un int
        nb = 123;                       // initialisation d'un int
        
        int[] tabDeNb;                  // définition d'un tableau d'int
        tabDeNb = new int[4];           // allocation d'un tableau d'int
        tabDeNb[0]=11; tabDeNb[1]=22;   // remplissage d'un tableau d'int
        tabDeNb[2]=33; tabDeNb[3]=44;
        
        Articlev2 Articlev2;                // définition d'un Articlev2
        Articlev2 = new Articlev2(1, "PC", 1234.5, 11); // initialisation d'un Articlev2v2
        
        Articlev2[] Articlev2s;             // définition d'un tableau d'Articlev2s
        Articlev2s = new Articlev2[4];      // allocation d'un tableau d'Articlev2s
                                        // remplissage d'un tableau d'Articlev2s
        Articlev2s[0] = new Articlev2(1, "PC", 1234.5, 11);
        Articlev2s[1] = new Articlev2(2, "Clavier", 22.2, 22);
        Articlev2s[2] = new Articlev2(3, "Souris", 33.3, 33);
        Articlev2s[3] = new Articlev2(4, "Ecran", 44.4, 44);
        
        afficherListeDesArticlev2s(Articlev2s);
        vendreUnArticlev2DeChaque(Articlev2s);
        afficherListeDesArticlev2s(Articlev2s);
        
        Articlev2 art1 = new Articlev2(1, "PC", 1234.5, 11);
        Articlev2 art2 = new Articlev2(1, "PC", 3456.7, 88);
        if (art1 == art2)      { System.out.println("Les références sont identiques"); } else { System.out.println("Les références sont différentes"); }
        if (art1.equals(art2)) { System.out.println("Les Articlev2s sont identiques"); } else { System.out.println("Les Articlev2s sont différents"); }
    }
    
    private static void afficherListeDesArticlev2s(Articlev2[] tab) {
        for (int i=0; i<tab.length; i++) {
            System.out.println(tab[i]);
        }
    }
    
    private static void vendreUnArticlev2DeChaque(Articlev2[] tab) {
        for (int i=0; i<tab.length; i++) {
            tab[i].vend(1);
        }
    }
}