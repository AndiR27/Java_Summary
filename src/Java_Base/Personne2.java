package Java_Base;

/**
 * Classe représentant une Personne.
 * - l'identifiant est son no (méthode equals)
 * - les personnes sont triées par no (méthode compareTo)
 * 
 * @author Ch. Stettler - HEG-Genève
 */
public class Personne2 implements Comparable
{
    private int no;
    private String nom;
    private String prenom;
    
    public Personne2(int no, String nom, String prenom) { this.no=no; this.nom=nom; this.prenom=prenom;}
    public String toString() { return no+": "+prenom+" "+nom; }
    public boolean equals(Object obj) { return this.no == ((Personne2)obj).no; }

    public String getNom() { return nom; }
    
    public int compareTo(Object obj) { 
        if (this.no < ((Personne2)obj).no) {
            return -1; 
        } else if (this.no > ((Personne2)obj).no) {
            return 1; 
        } else { 
            return 0; 
        }
        // Ces tests peuvent être remplacés par l'instruction suivante :
        // return this.no - ((Personne)obj).no;     // qui ne retourne pas -1;0;+1  mais  négatif/0/positif
    }
}