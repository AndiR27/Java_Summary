package Java_Base;

/**
 * Décrivez votre classe Produit ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Produit implements Evaluable,Comparable      //methode évalué codé; on peut même rajouter des interfaces déjà existantes dans java, sans avoir à créer l'interface Comparable
{
    private int no;
    private String nom;
    private int prix;
    private int note;

    public Produit(int no, String nom, int prix){this.no=no;this.nom=nom ; this.prix=prix;}

    public String toString(){
        return no + " : " + nom + " au prix de " + prix + ".-";
    }

    public boolean equals(Object o){
        return this.no == ((Produit)o).no;
    }
    
    public void evaluer(){
    
        note = 5 + 2*12-11;
    }
    
    public int compareTo(Object o){return 0;}
}
