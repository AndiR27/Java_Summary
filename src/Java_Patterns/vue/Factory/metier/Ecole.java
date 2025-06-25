package Java_Patterns.vue.Factory.metier;

public abstract class Ecole {

    public PersonneFactory nouvellePersonne(String[] data){
        //Cette nouvelle methode fait 2 traitements : le new + les setter ==> L'idée serait de décomposer tout cela
        //Version 5 : décomposer le new des autres traitements et travailler avec des methodes non-static
        PersonneFactory pers = creerPersonne(data);
        //dans Ecole, on aura besoin de qqun qui fait le new pour créer la Personne
        //==> Utilissation d'une methode abstraite pour la création de la personne

        pers.definirHoraire();
        pers.definirHoraire();
        return pers;
    }

    public abstract PersonneFactory creerPersonne(String[] data);
}
