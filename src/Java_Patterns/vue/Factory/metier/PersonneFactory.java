package Java_Patterns.vue.Factory.metier;

public abstract class PersonneFactory {
    private String nom;
    private String prenom;

    public PersonneFactory(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "PersonneFactory{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
    public void definirHoraire(){}
    public void definirBureau(){}
}
