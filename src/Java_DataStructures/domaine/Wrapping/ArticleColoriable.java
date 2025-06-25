package Java_DataStructures.domaine.Wrapping;

import exception.ErreurSurLArticleException;

public class ArticleColoriable extends Article implements Coloriable {
    public ArticleColoriable(int no, String nom) throws ErreurSurLArticleException {
        super(no, nom);
    }

    @Override
    public void colorie(String couleur) {

    }
}
