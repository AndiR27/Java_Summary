package Java_DataStructures.metier;
import domaine.Arbres.ArbreT;
import domaine.File.File;
import domaine.File.FileListe;
import domaine.Graphes.*;
import domaine.ListeDoublementChainee.DList;
import domaine.ListeDoublementChainee.ListeDblCh;
import domaine.Pile.Pile;
import domaine.Pile.PileListe;
import domaine.Pile.PileTableau;
import domaine.Wrapping.Article;
import exception.*;
import dao.*;
import domaine.Arbres.ArbreListe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main<TYPESARTICLES> {

    /*
     * Ne pas oublier de décomposer en : domaine(les différentes classes utilisés dans le main), metier(principalement le main),exception(qui contient les exceptions), vue(tout ce qui est design,pas nécessaire) , dao(qui est la bdd) (pour le code de l'application) !!!
     * Pensez à définir les articles du Domaine en PRIVATE !
     * Laisser la responsabilité aux classes du domaine pour les différents test
     * Travailler avec les exception pour les cas d'erreur
     *
     * lorsqu'on veut ajouter qqchose sur du existant : genre une couleur dans l'article, au lieu de faire une variable, on rajoute plutôt un Wrapper ou une Interface
     * -> Généralement on rajoute les 2
     *
     * */
    public static void main(String[] args) {
        System.out.println("Partie Pile et File");
        testPileetFile();
        System.out.println();
        System.out.println("Partie Graphe (Avec une map et des Noeud)");
        showGraphe();
        System.out.println();

        System.out.println("Partie Graphe (Avec une matrice)");
        showGrapheMatrice();
        System.out.println();

        System.out.println("Partie Arbres");
        showArbreListe();
        System.out.println();
        showArbresTableau();
        System.out.println();


        System.out.println("Partie Liste doublement chainée");
        ListeDoublementChaineTest();
    }

    public static void testPileetFile(){
        List lstArt = Bdd.lireArticles();
        try {
            Article art = new Article(1,"Pomme");
        }
        catch (ErreurSurLArticleException e){
            System.out.println("erreur " + e.getCode() +" = " + e.getMessage());
        }
        //executer cette instruction dans tous les cas
        finally {
            System.out.println("instruction qui s'execute dans tous les cas");
        }

        ArrayList<Integer> aLst = new ArrayList<>(); //il faut penser à rajouter les crochets pour le typage
        aLst.add(1212); aLst.add(111); aLst.add(1250); //tant qu'on connait les types de données, ArrayList peut être utilisé
        int nb = (int)aLst.get(0);
        System.out.println(nb);

        int[] tab = new int[10];
        tab[0] = 11; tab[1]=22;
        System.out.println(tab);

        Pile p = new PileTableau();
        p.push(1);
        p.push(2);
        p.push(5);
        p.push(10);
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
        p.push(12);
        p.push(15);
        p.push(20);
        p.push(30);
        while(!p.isEmpty()){
            System.out.println(p.pop() + " ");

        }

        Pile<String> pileString = new PileListe<>();
        pileString.push("hello");
        pileString.push("salut");
        pileString.push("coucou");
        while(!pileString.isEmpty()){
            System.out.println(pileString.pop()+ " ");
        }
        System.out.println();

        File f = new FileListe();
        f.add(1);
        f.add(10);
        f.add(20);
        f.add(30);
        System.out.println(f.remove());
        System.out.println(f.remove());
        System.out.println(f.remove());


    }

    public void testDico(){
        Map<Integer, TYPESARTICLES> hMap = new HashMap<>();
        TYPESARTICLES value = null;
        hMap.put(1, value);
        hMap.put(2, value);
        hMap.put(3, value);

        //index ==> se calculera selon la clé : key % tab.length (Il peut y avoir des collisions ==>LinkedList)

        //parcourir le dico :
        hMap.keySet(); //va retourner toutes les clés
        hMap.values(); //va retourner toutes les valeurs
        hMap.entrySet(); //va retourner les pairs

        for(TYPESARTICLES val : hMap.values()){
            System.out.println(val);
        }
    }

    public static void showGraphe(){
        Graphe gr = new GrapheMap();

        NoeudGraphe a = new NoeudGraphe("a");
        NoeudGraphe b = new NoeudGraphe("b");
        NoeudGraphe c = new NoeudGraphe("c");
        NoeudGraphe d = new NoeudGraphe("d");
        NoeudGraphe e = new NoeudGraphe("e");
        NoeudGraphe f = new NoeudGraphe("f");
        NoeudGraphe g = new NoeudGraphe("g");
        NoeudGraphe h = new NoeudGraphe("h");

        gr.addRelation(a,b);
        gr.addRelation(b,c);
        gr.addRelation(a,d);
        gr.addRelation(b,d);
        gr.addRelation(b,e);
        gr.addRelation(d,e);
        gr.addRelation(f,g);
        gr.addRelation(g,h);

        System.out.println("a --> b : " + gr.existeRelation(a,b));  // gr.addRelation(a,b);
        System.out.println("b --> c: " + gr.existeRelation(b,c));   // gr.addRelation(b,c);
        System.out.println("a --> e : " + gr.existeRelation(a,e));  // Aucune relation créée
        System.out.println("b --> a : " + gr.existeRelation(b,e));  // gr.addRelation(a,b);

        System.out.println("chemin a --> e : " + gr.existeChemin(a,e)); // a -> b -> e
        System.out.println("chemin a --> h : " + gr.existeChemin(a,h)); // aucune relation
    }

    public static void showGrapheMatrice(){
        //n'implement pas l'interface, mais devrait, je l'ai pas fait parce qu'on a pas vu en détail les graphs matrices (donc certaines methodes ne jouent pas)
        GrapheMatrice graphe = new GrapheMatrice(6);
        graphe.addRelation(1,3);
        graphe.addRelation(2,5);
        graphe.addRelation(0,4);
        graphe.addRelation(4,1);

        System.out.println(graphe.existeRelation(2,5));
        System.out.println(graphe.existeRelation(2,4));

        graphe.affiRelations();
        graphe.printMatrice();
    }

    public static void showArbreListe(){
        ArbreListe al = new ArbreListe();
        al.inserer(0, null);
        al.inserer(1, al.chercher(0));
        al.inserer(2, al.chercher(0));
        al.inserer(3, al.chercher(0));
        al.inserer(4, al.chercher(0));

        al.inserer(11,al.chercher(1));
        al.inserer(12,al.chercher(1));
        al.inserer(13,al.chercher(1));
        al.inserer(14,al.chercher(1));

        al.inserer(121, al.chercher(11));
        al.inserer(122, al.chercher(12));
        al.inserer(123, al.chercher(11));
        al.inserer(124, al.chercher(12));

        al.parcoursPrefixe(); // Afficher tout le labyrinthe

        System.out.println("Chercher 12 : \n" + al.chercher(12));
        System.out.println("Taille : " + al.taille());

        System.out.println("Supprimer 122 : " + al.supprimer(122));
        System.out.println(al);
    }

    public static void showArbresTableau() {
        System.out.println("Arbres avec tableau de fils");
        ArbreT a = new ArbreT();
        a.inserer(0, null); a.inserer(1, a.chercher(0)); a.inserer(2, a.chercher(0)); a.inserer(3, a.chercher(0)); a.inserer(4, a.chercher(0));
        a.inserer(11, a.chercher(1)); a.inserer(12, a.chercher(1)); a.inserer(13, a.chercher(1)); a.inserer(14, a.chercher(1));
        a.inserer(121, a.chercher(12)); a.inserer(122, a.chercher(12)); a.inserer(123, a.chercher(12));
        a.inserer(1221, a.chercher(122));
        a.inserer(31, a.chercher(3)); a.inserer(32, a.chercher(3));
        a.inserer(311, a.chercher(31)); a.inserer(312, a.chercher(31)); a.inserer(313, a.chercher(31));
        a.inserer(41, a.chercher(4));

        a.parcoursPrefixe();  System.out.println();
        a.parcoursPostfixe(); System.out.println();

        System.out.println("Chercher 12: " + a.chercher(12));
        System.out.println("Taille: " + a.taille());

        System.out.println("Supprimer 12: " + a.supprimer(12));
        a.parcoursPrefixe(); System.out.println();
    }

    public static void ListeDoublementChaineTest() {
        DList<Integer> lst = new ListeDblCh<>();
        remplirDEntiers(lst);
        traiterToutDepuisLePremier(lst);
        remplirDEntiers(lst);
        traiterToutDepuisLeDernier(lst);
        DList<String> lst2 = new ListeDblCh<>();

        remplirDeString(lst2);
        traiterToutDepuisLePremier(lst2);
        remplirDeString(lst2);
        traiterToutDepuisLeDernier(lst2);
    }

    private static void remplirDEntiers(DList<Integer> lst) {
        lst.addFirst(1); lst.addFirst(2); lst.addFirst(3); lst.addFirst(4);
        lst.addLast(6); lst.addLast(7); lst.addLast(8); lst.addLast(9);
    }

    private static void remplirDeString(DList<String> lst) {
        lst.addFirst("Ana"); lst.addFirst("Bob"); lst.addFirst("Cloe"); lst.addFirst("Dan");
        lst.addLast("Ryan"); lst.addLast("Sam"); lst.addLast("Tara"); lst.addLast("Ugo");
    }

    private static void traiterToutDepuisLePremier(DList lst) {
        while (!lst.isEmpty()) {
            System.out.print(lst.removeFirst() + " ");
        }
        System.out.println();
    }
    private static void traiterToutDepuisLeDernier(DList lst) {
        while (!lst.isEmpty()) {
            System.out.print(lst.removeLast() + " ");
        }
        System.out.println();
    }
}

