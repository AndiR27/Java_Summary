package Java_Patterns.vue.FactoryAbstractBuilder;

public class ApplicFAB {
    public static void main(String[] args){
        System.out.println("Tour d'horizons des design patterns de créations");
        //Singleton
        //On peut facilement créer des personnes
        //PersonneFAB p1 = new PersonneFAB(1, "Jean", "michel");
        //mais on ne veut plus de new, on utilise getInstance -> SINGLETON
        //PersonneFAB p2 =  PersonneFAB.getInstance(2, "Jean", "onche");

        //Factory :

        //Version 1:
        //Static factory method ==> externaliser le new (Il faut travailler avec une classe Abstraite de personne)
        //On demande à la fabrique une nouvelle instance de PersonneFAB
        PersonneFAB prof1 = FabriqueStaticDePersonneFAB.newProf(1, "Jean", "luc");
        PersonneFAB assi1 = FabriqueStaticDePersonneFAB.newAssistant(2, "Jean", "pierre");
        //La version static est inconvéniante si il y a des modifs à faire plus tard -> On utilisera plutôt une Factory Simple

        //Version 2:
        //Simple Factory ==> Une seule méthode qui effectue le switch pour savoir quelle sous-classe retourner
        PersonneFAB prof2 = FabriqueSimpleDePersonneFAB.newPersonne("PROF", 1, "Jean", "luc");
        PersonneFAB assistant2 = FabriqueSimpleDePersonneFAB.newPersonne("PROF", 2, "Jean", "pierre");
        //Si on veut rajouter une gestion des étudiants, il faudra modifier la fabrique

        //Version 3:
        //Factory Methode selon le Pattern ==> On travaille avec une Fabrique abstraite (pour pouvoir la changer)
        //On peut ainsi récupèrer la fabrique (ou la créer)
        FabriqueAbstraitePersonneFAB fabrique = new FabriqueConcretePersonneFAB();
        PersonneFAB prof3 = fabrique.newPersonne("PROF", 1, "Jean", "luc");
        PersonneFAB assistant3 = fabrique.newPersonne("PROF", 2, "Jean", "pierre");

        //Version 4:
        //Abstract Factory ==>On travaille aussi avec une fabrique abstraite, mais on permet de retourner un ensemble d'objets consistants
        //Peu de changements, mais on introduit la création d'horaires et bureaux spécifiques à la fabrique (dans notre cas pour la HEG)
        PersonneFAB prof4 = fabrique.newPersonne("PROF", 1, "Jean", "luc");
        PersonneFAB assistant4 = fabrique.newPersonne("PROF", 2, "Jean", "pierre");
        //Ainsi, si l'on veut travailler avec des données d'une autre HES, on créera une nouvelle Fabrique avec comme
        //une fabrique concrète de personne autour de l'HEPIA par exemple



    }
}
