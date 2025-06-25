package Java_Patterns.vue.Singleton;

public class Parametre {
    private String nomEcole = "HEG"; //valeur par défaut
    private int npa = 1227;
    private String adresse = "Carouge";

    //Etapes pour le singleton
    private Parametre(){ }   // 1) Constructeur en private ==> plus personne ne peut faire de new


    private static Parametre uneInstanceUnique = null;
    public static Parametre getInstance(){            // 2) Methode static qui fait le new : en static pour que dans le main, cette methode soit appelée
        if(uneInstanceUnique == null) {uneInstanceUnique = new Parametre();}    // 3) S'assurer qu'on ait pas déjà une instance
        return uneInstanceUnique;                                                 // 4) retourner une instance de vue.Singleton.Parametre
    }

    public String getNomEcole() {
        return nomEcole;
    }

    public int getNpa() {
        return npa;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNomEcole(String nomEcole) {
        this.nomEcole = nomEcole;
    }

    public void setNpa(int npa) {
        this.npa = npa;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
