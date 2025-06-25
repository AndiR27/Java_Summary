package Java_Patterns.vue.FactoryAbstractBuilder;

public abstract class PersonneFAB {
    private int no;
    private String nom;
    private String prenom;
    //Cette classe pourrait avoir plus d'infos (Souvent le type sera une classe qui les gère)
    private HoraireFAB horaire;
    private BureauFAB bureau;


    private static PersonneFAB instance = null;

    public PersonneFAB(int no, String nom, String prenom) {
        this.no = no;
        this.nom = nom;
        this.prenom = prenom;
    }
    public void setHoraire(HoraireFAB horaire) {
        this.horaire = horaire;
    }

    public void setBureau(BureauFAB bureau) {
        this.bureau = bureau;
    }

    /**
    public static PersonneFAB getInstance(int no, String nom, String prenom){
        if(instance == null){
            instance = new PersonneFAB(no, nom, prenom);
        }
        return instance;
    }
    */
    @Override
    public String toString() {
        return "PersonneFAB{" +
                "no=" + no +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
