package Java_DataStructures.domaine.Graphes;

import java.util.*;

public class GrapheMap implements Graphe{

    //Différentes implémentations possibles, on pourrait aussi avoir une map<NoeudGraphe, List<NoeudGraphe>>, etc...
    //ATTENTION, avec un Map, il faut une methode hashCode() dans la classe NoeudGraphe !
    private Map<NoeudGraphe, Set<NoeudGraphe>> lstNoeuds;   //Notre map contenant notre noeud comme clé, et un Set de noeud étant toutes les noeuds auquel le noeud source est relié
    private List<NoeudGraphe> lstNoeudGrapheVisited = new ArrayList<NoeudGraphe>();   //à la place de travailler avec un attribut visité, on travaille avec la liste des noeuds visités ou pas

    public GrapheMap(){
        //pas besoin de définir lors du constructeur
        this.lstNoeuds = new HashMap<>();
    }

    @Override
    public void addRelation(NoeudGraphe source, NoeudGraphe dest) {
        //Il faut s'assurer que la relation soit faite des deux côtés
        this.createRelation(source, dest);
        this.createRelation(dest, source);
    }

    private void createRelation(NoeudGraphe a, NoeudGraphe b){
        // Gestion de la relation du coté de la source

        //on ajoute à la clé un noeud en plus pour sa liste de voisins
        Set<NoeudGraphe> relations = lstNoeuds.get(a);

        // On vérifie si les relations sont nulles ou pas
        if(relations == null){
            relations = new HashSet<>();
        }

        // Ajout de la destination dans les relations
        relations.add(b);

        // Mise a jour de la liste des noeuds
        this.lstNoeuds.put(a, relations);
    }

    @Override
    public boolean existeRelation(NoeudGraphe source, NoeudGraphe dest) {
        //simple check si une source et une dest sont liés
        return this.lstNoeuds.get(source).contains(dest);
    }

    @Override
    public void parcourirProfondeur(NoeudGraphe noeudGraphe) {
        // On verifie si le noeud à déjà été visité
        if(noeudGraphe.isVisit()) return;

        // On met le noeud en tant que visité
        noeudGraphe.setVisit(true);

        // On affiche le noeud
        System.out.println(noeudGraphe);

        // On parcours tous ces relations en recurcif
        for (NoeudGraphe rel : this.lstNoeuds.get(noeudGraphe)){
            this.parcourirProfondeur(rel);
        }
    }

    @Override
    public boolean existeChemin(NoeudGraphe source, NoeudGraphe dest) {
        return parcourirProfondeurUntilDest(source, dest);
    }

    private boolean parcourirProfondeurUntilDest(NoeudGraphe noeudGraphe, NoeudGraphe dest) {
        // On verifie si le noeud à déjà été visité
        if (noeudGraphe.isVisit()) return false;

        // On met le noeud en tant que visité
        noeudGraphe.setVisit(true);

        // On vérifie si le noeud actuel = au noeud des destination
        if(noeudGraphe.equals(dest)) return true;

        // On parcours tous ces relations en recurcif
        for (NoeudGraphe rel : lstNoeuds.get(noeudGraphe)){
            if(parcourirProfondeurUntilDest(rel, dest)) return true;
        }

        // On retourne False si aucune relation n'as été trouvée
        return false;
    }
}
