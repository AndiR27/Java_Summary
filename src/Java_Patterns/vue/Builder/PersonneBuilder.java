package Java_Patterns.vue.Builder;

import vue.FactoryAbstractBuilder.BureauFAB;
import vue.FactoryAbstractBuilder.HoraireFAB;
//
public class PersonneBuilder {
    private int no;             //OBLIGE
    private String nom;         //OBLIGE
    private String prenom;      //OBLIGE
    //Cette classe pourrait avoir plus d'infos (Souvent le type sera une classe qui les gère)
    private String sexe;
    private String filiere;
    private String horaire;
    private String bureau;
    private String adresse;
    private String canton;

    private PersonneBuilder(Builder build){
        this.no = build.no;
        this.nom = build.nom;
        this.prenom = build.prenom;
        this.sexe = build.sexe;
        this.filiere = build.filiere;
        this.horaire = build.horaire;
        this.bureau = build.bureau;
        this.adresse = build.adresse;
        this.canton = build.canton;
    }

    public static class Builder{
        private int no;             //OBLIGE
        private String nom;         //OBLIGE
        private String prenom;      //OBLIGE
        //Cette classe pourrait avoir plus d'infos (Souvent le type sera une classe qui les gère)
        private String sexe;
        private String filiere;
        private String horaire;
        private String bureau;
        private String adresse;
        private String canton;

        //Constructeur avec les champs obligatoires
        public Builder(int no, String nom, String prenom){
            this.no = no;
            this.nom = nom;
            this.prenom = prenom;
        }

        public PersonneBuilder build(){
            return new PersonneBuilder(this);
        }

        public Builder setNo(int no) {
            this.no = no;
            return this;
        }

        public Builder setNom(String nom) {
            this.nom = nom;
            return this;

        }

        public Builder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;

        }

        public Builder setSexe(String sexe) {
            this.sexe = sexe;
            return this;

        }

        public Builder setFiliere(String filiere) {
            this.filiere = filiere;
            return this;

        }

        public Builder setHoraire(String horaire) {
            this.horaire = horaire;
            return this;

        }

        public Builder setBureau(String bureau) {
            this.bureau = bureau;
            return this;

        }

        public Builder setAdresse(String adresse) {
            this.adresse = adresse;
            return this;

        }

        public Builder setCanton(String canton) {
            this.canton = canton;
            return this;

        }
    }

    @Override
    public String toString() {
        return "PersonneFAB{" +
                "no=" + no +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
