package Java_DataStructures.domaine.TypesGeneriques;

//on va lui spécifier les types d'articles spécifiés
public class ListeDArticles<TYPESARTICLES> {

    private TYPESARTICLES[] tab;

    public TYPESARTICLES[] getListe(){
        return tab;
    }

    public TYPESARTICLES getUnArtcile(int no){
        return tab[no];
    }

    //

    //restrictions : ce qu'on ne peut pas faire avec des types génériques :

    //private static TYPESARTICLES art; impossible de mettre en static

    public void method(){
        TYPESARTICLES var;
        //var = new TYPESARTICLES();    // pas de new
        //la solution :
        var = (TYPESARTICLES) new Object();  //il faut bypass en castant
    }

    //problème d'ambiguité si on a 2 Types génériques, problème de surcharge pour les methodes, il ne sait pas si c'est le premier param ou le deuxième
    public void methode(TYPESARTICLES param){

    }
}
