package Java_DataStructures.domaine.Arbres;

public class ArbreListe implements ArbreInt{

    private NoeudArbre racine;

    // Constructeur par défaut
    public ArbreListe(){

        this.racine = null;
    }

    // Permet d'inserer un nouveau noeud dans l'arbre - lorsque c'est le noeud racine, pere == null, tous les autres insertions auront un père
    public NoeudArbre inserer(int valeur, NoeudArbre pere){

        // Création d'un nouveau noeud avec le contenu
        NoeudArbre n = new NoeudArbre(valeur);

        // On verifie si il y un père
        // Si il n'y à pas de père, on assigne le nouveau noeud en tant que racine
        if(pere == null){
            return racine = n;
        }

        // Verifie si le père a un fils ainé et s'il est égal a null, si c'est le cas, alors le nouveau Noeud est le fils ainé (en gros premier fils)
        if(pere.getFilsAine() == null){
            return pere.setFilsAine(n);
        }

        // Une fois passé tous les if
        // l'ajout correspond donc à un nouveau frère, il faut ainsi récupèrer le fils ainé et lier le nouveau noeud à celui-ci en tant que frère

        NoeudArbre fils = pere.getFilsAine();

        // Tant qu'il n'as pas de frère on recherche un frère, cela permet d'avoir le dernier frère en tête pour l'ajouter à la suite, le noeud retourné sera ainsi le nouveau frère
        while(fils.getFrere() != null){
            fils = fils.getFrere();
        }

        // On retorune le nouveau noeud (Avec setFrere, on ajoute un noeud à la liste des frère du fils ainé)
        return fils.setFrere(n);
    }

    public void parcoursPostfixe(){

        parcoursPostFixe(this.racine);
    }
    private void parcoursPostFixe(NoeudArbre n){
        if (n == null) return;

        // On parcours le fils Ainé
        parcoursPostFixe(n.getFilsAine());

        // on affiche le noeud
        System.out.println(n.getContenu() + " ");

        // on parcours ces frères
        parcoursPostFixe(n.getFrere());
    }

    public void parcoursPrefixe(){

        parcoursPreFixe(this.racine);
    }

    private void parcoursPreFixe(NoeudArbre n){
        if (n == null) return;
        // on affiche le noeud
        System.out.println(n.getContenu() + " ");

        // On parcours le fils Ainé
        parcoursPostFixe(n.getFilsAine());

        // on parcours ces frères
        parcoursPostFixe(n.getFrere());
    }

    public NoeudArbre chercher(int contenu){

        return this.chercher(contenu, this.racine);
    }

    private NoeudArbre chercher(int contenu, NoeudArbre n){
        if (n == null || contenu == n.getContenu()){
            return n;
        }

        //on cherche d'abord chaque fils ainé
        NoeudArbre f = chercher(contenu, n.getFilsAine());

        if(f != null){
            return f;
        }
        //pour chaque fils ainé, on check ses frères
        return chercher(contenu, n.getFrere());
    }

    public boolean supprimer(int contenu){
        return supprimer(contenu, racine);
    }
    private boolean supprimer(int contenu, NoeudArbre n){
        return false;
    }

    public int taille(){
        return this.taille(this.racine);
    }
    private int taille(NoeudArbre n){
        if(n == null) {
            return 0;
        }
        return 1 + taille(n.getFilsAine()) + this.taille(n.getFrere());
    }

    public String toString(){
        return this.racine.toString();
    }
}
