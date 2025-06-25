package Java_DataStructures.domaine.Graphes;

public interface Graphe {
    // Ajoute une relation entre 2 noeuds
    void addRelation(NoeudGraphe source, NoeudGraphe dest);

    // Verifie si il existe une relation entre 2 noeuds
    boolean existeRelation(NoeudGraphe source, NoeudGraphe dest);

    // Parcours le graphe en profondeur
    void parcourirProfondeur(NoeudGraphe noeudGraphe);

    // Verifie si il existe un chemin entre 2 noeuds
    boolean existeChemin(NoeudGraphe source, NoeudGraphe dest);
}
