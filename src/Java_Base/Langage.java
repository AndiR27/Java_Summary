package Java_Base; /**
 * Décrivez votre classe Langage ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */


// Commentaires de fin de ligne (privé)
/* Commentaire sur plusieurs lignes (privé)
 * 
 * suite du commentaire sur plusieurs lignes
 * 
 */
 /** commentaire public pour l'utilisateur (de cette classe)
  * se met AVANT la déclaration
  * indispensable pour tout élément PUBLIC
  * @auteur (MOI)
  */

public class Langage{        // ceci est la définition de la classe Langage
    /* Déclaration de méthode (procédure (ne retourne rien)/fonction)
     *  - visibilité (public/private/...)
     *  - type de méthode : méthode de classe (statique) ou méthode d'instance (rien)
     *  - type retourné (void(procedure qui du coup ne retourne rien)/int/String/boolean/...)
     *  - nomDeLaMéthode : si procédure, commence par un verbe à l'infinitif
     *                     si fonction, indique ce qu'elle retourne
     *  - paramètres(s) (entre parenthèses) fourni à cette méthode : type et le nom de chaque param
     *  
     *  
     */
    
    public static void testerLangage(){
        /* types primitifs
         * - entier : byte / short / int / long
         * - flottant : float / double
         * - caractère : char (1 seul caractère !)
         * - booléen : boolean
         * 
         * autre types d'Objet ===> à des classes
         * 
         * - String (S majuscule pour l'objet) : chaine de caractère
         * 
         */
        
        int nombre;
        int x, y, z;
        int compteur = 0;
        double prix = 123.75;
        char initiale = 'S';
        boolean ok = true;
        
        // Affichage dans le log
        
        nombre = 3;
        System.out.print("du texte quelconque..."); // les string en double "", les char en guillemets simples
        System.out.println("Idem, avec un saut de la ligne à la fin du texte");
        System.out.println("Nombre = " + nombre + ", et le prix est de " + prix);
        
        /*Opérateurs
         * 
         * - Affectaction : =
         * - comparaison : == <  > <=  >=   !=
         * - arithmétique : + - * /
         * -affectation+ : += -= *= ++ --
         * 
         */
        
        nombre = 0;
        nombre = nombre + 5;
        nombre += 3;
        nombre *= 2;
        nombre++;
        System.out.println("nombre = " + nombre);
        
        // Formants algorithmiques :
        // - la séquence : instruction; instruction;
        // - l'altérnative : if (condition) {instruction;} else {instruction;}
        if (nombre == 15) {
            System.out.println("juste");
        } else{
            System.out.println("Faux");
        }
        
        
        // - la boucle : for (initialisation ; condition de continuation; incrémentation) {instruction;}
        for (int i=0; i<10; i++){ //le i est déclaré dans la boucle
            System.out.println(i);
        }
        
        
        int i = 0;
        while(i < 10) {
         System.out.println(i);
         i++;
        }
    }
    
    public static int nbRoues(){
        autreMethode();
        return 4;
        
        
    }
    
    private static void autreMethode() { // ne sera pas visible dans le programme
        
    }
    
    public void derniereMethode() { // methode seulement sur l'instance, à mettre en public static pour être vu par la classe
        
    }
    
    public static void autreOperateurs(){
        int nb = 7;
        nb = nb - 1;
        nb -= 1;
        --nb;
        nb--;
        
        nb = 7;
        nb *= 2;
        nb += 7;
        nb /=3;
        
        nb = 7; System.out.println(nb--);
        nb = 7; System.out.println(--nb);
        
    }
    
    public static void gestionDesTypes(){
        int nb = 7;
        nb = nb / 2;
        System.out.println("nb = " + nb);
        
        double nbre = 7;
        nbre = nbre / 2;
        System.out.println("Nbre = " + nbre);
        
        int nombre = 7;
        double result = (double)nombre / 2;  //type-cast ==> considérer un attrib 
                                     //comme étant d'un certain type
        System.out.println("Result = " + result);
        System.out.println("Resultat comme étant un int = " + (int)result);
        
        
        
    }
}
