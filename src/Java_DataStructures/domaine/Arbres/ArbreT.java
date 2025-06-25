package Java_DataStructures.domaine.Arbres;

/**
 * Structures de donn�es : Les Arbres n-aires
 *    Version : fils impl�ment�s dans un ArrayList
 * @author Ch. Stettler - HEG-Gen�ve
 */
import java.util.ArrayList;

/**
 * Version Arbre avec racines = un noeud contenant un tableau, chaque branche est relié à un noeud contenant un tableau de Noeuds
 *
 */
public class ArbreT implements ArbreInt {

    private Noeud racine;

    public ArbreT() { racine=null; }

    //Cette version de l'arbre utilise un noeud contenant une liste de fils (cette classe devrait être créée exterieurement pour faire ça plus simplement
    static class Noeud {
        //création d'un Node contenant un tableau de fils
        //le node a un contenu + est relié à une liste de fils
        private int contenu;
        private ArrayList<Noeud> fils;

        public Noeud(int contenu) {
            this(contenu, new ArrayList<>());
        }

        public Noeud(int contenu, ArrayList<Noeud> fils) {
            this.contenu=contenu; this.fils=fils;
        }

        public String toString() {
            return "Noeud{" +
                    "contenu=" + contenu +
                    ", fils=" + fils +
                    '}';
        }
    }

    public Noeud inserer(int x, Noeud pere) {
        //Lorsqu'on insère un node, il faut instancier le node en question avec sa valeur
        //si pas de père, alors c'est le noeud racine, sinon on ajoute ce noeud en tant que fils du père
        Noeud n = new Noeud(x);
        if (pere == null) { return racine = n; }
        //on prends le fils du père et on lui ajoute n
        pere.fils.add(n);
        return n;
    }

    public void parcoursPrefixe() {
        //on appèle une autre methode pour commencer le parcours depuis la racine
        parcoursPrefixe(racine);
    }
    private void parcoursPrefixe(Noeud n) {
        //utilisation de la récursivitée pour parcourir tout l'arbre en entier -> Lorqu'il arrive au bout d'une branche, le fils est null, on passe ainsi à la branche suivante
        if (n == null) { return; }
        //parcours prefixe = affichage du node avant de parcourir ses fils
        System.out.print(n.contenu + " ");
        for (Noeud f : n.fils) { parcoursPrefixe(f); }
    }
    public void parcoursPostfixe() {
        parcoursPostfixe(racine);
    }

    private void parcoursPostfixe(Noeud n) {
        if (n == null) { return; }
        //parcours postfix = affichage du node après avoir parcouru ses fils
        for (Noeud f : n.fils) { parcoursPostfixe(f); }
        System.out.print(n.contenu + " ");
    }

    public Noeud chercher(int x) {
        //pour chercher une valeur précise, on commence tjr à partir de la racine
        return chercher(x, racine);
    }

    private Noeud chercher(int x, Noeud n) {
        //Recherche en récursif, parcours de l'arbre tant que la valeur n'a pas été trouvée
        //si n est null ou que son contenu vaut x, on retourne le Noeud contenant notre valeur
        if (n == null || x == n.contenu) {
            return n;
        }
        //parcours des fils, recherche
        for (Noeud f : n.fils) {
            Noeud tmp = chercher(x, f);
            if (tmp != null) {
                return tmp;
            }
        }
        return null;
    }

    public  boolean supprimer(int x) {
        return supprimer(x, racine);
    }

    private boolean supprimer(int x, Noeud n) {
        //Pour supprimer une valeur:

        //Si la valeur n'existe pas, FALSE
        if (n == null) { return false; }

        //si x est trouvée, on supprime le noeud en question comprenant la valeur et étant la racine à ce stade de la récursivitée
        if (x == n.contenu) {
            racine=null; return true;
        }

        //parcours des fils pour chercher la valeur à supprimer
        for (int i=0; i<n.fils.size(); i++) {
            Noeud f = n.fils.get(i);
            if (x == f.contenu) {
                n.fils.remove(i);
                return true;
            }
            if (supprimer(x, f)) {
                return true;
            }
        }
        return false;
    }

    public  int taille() {
        return taille(racine);
    }

    private int taille(Noeud n) {
        //pour la taille de l'arbre, on parcours récursivement l'arbre et on t+=1 à chaque fois qu'un noeud a des fils
        if (n == null) { return 0; }
        int t=1;
        for (int i=0; i<n.fils.size(); i++) {
            t += taille(n.fils.get(i));
        }
        return t;
    }

    public String toString() { return racine.toString(); }

}