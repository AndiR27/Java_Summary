package Java_ModernFeatures.Stream;

import java.util.Date;
import java.util.List;

public class StreamHumain {
    String nom;
    String prenom;
    List<String> autresPrenomsList;

    int age;

    Date datenaissance;

    long numeroSocial;

    public StreamHumain(String nom, String prenom, List<String> autresPrenomsList, int age, Date datenaissance, long numeroSocial) {
        this.nom = nom;
        this.prenom = prenom;
        this.autresPrenomsList = autresPrenomsList;
        this.age = age;
        this.datenaissance = datenaissance;
        this.numeroSocial = numeroSocial;
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<String> getAutresPrenomsList() {
        return autresPrenomsList;
    }

    public void setAutresPrenomsList(List<String> autresPrenomsList) {
        this.autresPrenomsList = autresPrenomsList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public long getNumeroSocial() {
        return numeroSocial;
    }

    public void setNumeroSocial(long numeroSocial) {
        this.numeroSocial = numeroSocial;
    }
}
