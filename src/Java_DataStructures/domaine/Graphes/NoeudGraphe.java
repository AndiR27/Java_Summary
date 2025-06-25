package Java_DataStructures.domaine.Graphes;

import java.util.Objects;

public class NoeudGraphe {
    private String nom;
    private String descr;
    private boolean visit;

    // Constructeur par défaut d'un noeud
    // Prend en paramètre un nom et une description
    public NoeudGraphe(String a_nom, String a_desc){
        this.nom = a_nom;
        this.descr = a_desc;
    }

    // Constructeur d'un noeud avec un seul paramètre : le nom
    public NoeudGraphe(String a_nom){
        this.nom = a_nom;
    }

    // HashCode du nom du Graphe.Noeud
    public int hashCode(){
        return Objects.hash(this.nom);
    }

    // Compare le nom de 2 noeuds
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null ||getClass() != o.getClass()) return false;
        NoeudGraphe noeudGraphe = (NoeudGraphe) o;
        return Objects.equals(this.nom, noeudGraphe.nom);
    }

    // Affichage en string du Graphe.Noeud
    public String toString(){
        return this.nom;
    }

    // Retourne le fait que le noeud à été visité ou non
    // True si visité
    // False si non
    public boolean isVisit(){
        return this.visit;
    }

    // Règle le paramètre de visite
    public void setVisit(boolean a_visit){
        this.visit = a_visit;
    }


}
