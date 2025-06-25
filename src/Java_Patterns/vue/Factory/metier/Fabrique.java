package Java_Patterns.vue.Factory.metier;

import vue.Singleton.Personne;

public class Fabrique {
    private FabriqueDePersonne fabriqueDePersonne;

    public PersonneFactory nouvellePersonne(String[] data){
        //Cette nouvelle methode fait 2 traitements : le new + les setter ==> L'idée serait de décomposer tout cela
        //Version 5 : décomposer le new des autres traitements et travailler avec des methodes non-static
        PersonneFactory pers = fabriqueDePersonne.creerPersonne(data);

        pers.definirHoraire();
        pers.definirHoraire();
        return pers;
    }

    public Fabrique() {
        this.fabriqueDePersonne = new FabriqueDePersonne();
    }

}
