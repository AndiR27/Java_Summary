package Java_DataStructures.dao;

import domaine.Wrapping.Article;
import exception.ErreurSurLArticleException;

import java.util.ArrayList;
import java.util.List;

public class Bdd {
    public static List<Article> lireArticles(){
        List<Article> aLst = new ArrayList<>();
        try {
            aLst.add(new Article(11, "PC"));
            aLst.add(new Article(22, "Clavier"));
            aLst.add(new Article(33, "Ecran"));
        } catch(ErreurSurLArticleException e){
            return null;
        }
        return aLst;

    }
}
