package Java_Patterns.vue.FactoryAbstractBuilder;

import vue.Singleton.Personne;

public abstract class FabriqueAbstraitePersonneFAB {

    //C'est les fabrique concrètes qui feront les traitements
    //newPersonne sera un standard
    public PersonneFAB newPersonne(String type, int no, String nom, String prenom){
        PersonneFAB pers = creerPersonne(type, no, nom, prenom);
        //Autres traitements se feront à ce niveau après la création de la personne
        //Horaire et bureau seront spécifiques, il faudra gérer cela selon la fabrique utilisé par exemple
        //Il faudra fournir ainsi des nouveaux horaires et nouveaux bureaux
        HoraireFAB h1 = creerHoraire();
        BureauFAB b1 = creerBureau();
        pers.setHoraire(h1);
        pers.setBureau(b1);
        return pers;
    }

    //On va ainsi fournir plusieurs methodes pour creer des personnes, des bureaux, des horaires, etc....
    protected abstract PersonneFAB creerPersonne(String type, int no, String nom, String prenom);
    protected abstract HoraireFAB creerHoraire();
    protected abstract BureauFAB creerBureau();
}
