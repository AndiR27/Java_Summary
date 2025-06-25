package Java_DataStructures.domaine.Arbres;

public interface ArbreInt{
    //Il faut normalement toutes ces methodes, mais le type de Noeud change selon le type d'arbre (Noeud avec tableau de fils ou Noeud avec fils aine et liste des freres)
    //public NoeudArbre inserer(int valeur, NoeudArbre pere);
    public void parcoursPostfixe();
    public void parcoursPrefixe();
    //public NoeudArbre chercher(int contenu);
    boolean supprimer(int contenu);
}
