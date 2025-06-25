package Java_Patterns.vue.Factory.metier;

import vue.Singleton.Personne;

public class Applic {
    public Applic(Ecole ecole) {
        System.out.println("Gestion des personnes....");
        //Récuperer la liste de toutes les personnes et les traiter :
        // Version 1 : faire les new dans les applic
        for(String[] data : dao.PersonnesDao.lirePersonnes()){
            PersonneFactory pers = null;

            //inconvenient : une seule catégorie de Personne ?

            // Version 2 : on sous-classe les personnes
            switch (data[0]){
                case "PROF" : pers = new Prof(data[1], data[2], data[3]); break;
                case "ASSISTANT" : pers = new Assistant(data[1], data[2], data[3]); break;

            }
            pers.definirHoraire();
            pers.definirHoraire();
            //Inconvenient : Chaque fois qu'on veut faire un new, on doit faire ces instructions


            //Version 3 : On peut déjà mettre ce code dans une méthode
            pers = nouvellePersonne(data);
            //Inconveniant : si on veut rajouter une nouvelle catégorie, il faut modifier la methode/application


            //Version 4 : On sort cette méthode dans une nouvelle classe ==> dans une FabriqueDePersonne
            //pers = new Fabrique().nouvellePersonne(data);

            //Version 5 : décomposer le new des autres traitements
            //Dans Fabrique
            //Pour ne pas avoir de methode static : pers = new Fabrique().nouvellePersonne(data);
            pers = new Fabrique().nouvellePersonne(data);
            //pers = ecole.nouvellePersonne(data);
            //===> Pseudo-design Pattern ==> SimpleFactory / FabriqueSimple
            //Nouveau but, ne plus se préocupper des classes concrètes

            System.out.println(pers);
        }
    }

    private PersonneFactory nouvellePersonne(String[] data){
        PersonneFactory pers = null;
        switch (data[0]){
            case "PROF" : pers = new Prof(data[1], data[2], data[3]); break;
            case "ASSISTANT" : pers = new Assistant(data[1], data[2], data[3]); break;

        }
        return pers;

    }
}
