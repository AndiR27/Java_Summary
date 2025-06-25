package Java_Patterns.vue.Strategy;

public class PersonneStrat {
    private int no;
    private String nom;
    private String prenom;
    //private String moyenDeContact;
    //private String contact;
    private ContactStrategy strategieDeContact; //Va garder les données de contact

    public PersonneStrat(int no, String nom, String prenom) {
        this.no = no;
        this.nom = nom;
        this.prenom = prenom;

    }

    public void contacter(){
        //Inconveniant, si on veut rjaouter des moyens de contact, on remplace tout ça par un appel à StrategyDeContact
        /**
        switch (moyenDeContact){
            case "mail":
                //voilà quoi faire
                break;
            case "tel":
                break;
        }
         */
        strategieDeContact.contacter();
    }

    @Override
    public String toString() {
        return "PersonneStrat{" +
                "no=" + no +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
