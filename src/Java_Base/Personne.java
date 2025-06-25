package Java_Base;

/**
 * Décrivez votre classe Personne ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public abstract class Personne implements Evaluable //interdit de faire un new Personne(...) !
{
    private int no;
    private String nom;
    private String prenom;
    private String dept;
    private int eval;
    // 1) ne pas faire de modification dessus, trop de changement à faire dans l'application
    // 2) Autre classe copie/colle ou on y rajoute les nouvelles fonctionnalités, mais pas la bonne solution
    // Mettre les variables en privé
    // Toutes les methodes dans personnes seront valables dans client et employe

    public Personne(int no, String nom, String prenom){this.no = no; this.nom = nom; this.prenom = prenom;}

    public String toString() { return nom + " " + prenom;}

    public boolean equals(Object obj){ return this.no == ((Personne)obj).no;}

    public char initialeDuPrenom(){
        return prenom.charAt(0);
    }

    public abstract String infoDeContact(); //Force les classes dérivées à coder cette methode, ne peut que exister dans une classe abstact
    // n'as pas besoin de code, les classe filles auront la même methode avec le code 

    public void evaluer(){eval = 5;}
}

