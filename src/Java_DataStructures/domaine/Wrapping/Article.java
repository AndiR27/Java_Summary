package Java_DataStructures.domaine.Wrapping;
import exception.*;

public class Article{
    private int no;
    private String nom;

    public Article(int no, String nom) throws ErreurSurLArticleException {
        if(no < 0){ throw new ErreurSurLArticleException("erreur de numéro", no, "votre numéro doit être suppérieur à 0");}
        this.no = no;
        this.nom = nom;
    }

    public boolean estDeCetteCategorie(String cat){
        return true;
    }
}

