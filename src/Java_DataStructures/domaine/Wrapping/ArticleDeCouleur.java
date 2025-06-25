package Java_DataStructures.domaine.Wrapping;

import exception.ErreurSurLArticleException;

public class ArticleDeCouleur {
    private Article art;
    private String couleur;

    //dans un wrapper, on lui fourni directement les params de l'article dans le constructeur


    public ArticleDeCouleur(int no, String nom, String couleur) throws ErreurSurLArticleException {
        this.art = new Article(no, nom);
        this.couleur = couleur;
    }
}
