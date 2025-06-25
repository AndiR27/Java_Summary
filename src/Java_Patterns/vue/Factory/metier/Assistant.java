package Java_Patterns.vue.Factory.metier;

public class Assistant extends PersonneFactory{
    private String domaine;

    public Assistant(String nom, String prenom, String domaine) {
        super(nom, prenom);
        this.domaine = domaine;
    }

    @Override
    public String toString() {
        return "Assistant de " + domaine;
    }
}
