package Java_Patterns.vue.Factory.metier;

public class Prof extends PersonneFactory{
    private String filiere;
    public Prof(String nom, String prenom, String filiere) {
        super(nom, prenom);
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Prof{" +
                "filiere='" + filiere + '\'' +
                '}';
    }
}
