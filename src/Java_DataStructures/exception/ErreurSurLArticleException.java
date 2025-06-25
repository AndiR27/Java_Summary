package Java_DataStructures.exception;


//créer la classe exception, l'extends, la throws à l'endroit ou elle peut être créée
public class ErreurSurLArticleException extends Exception {

    private int code;
    private String remarque;
    //on peut conserver des attributs dans notre classe erreur

    public ErreurSurLArticleException(String message, int code, String remarque) {
        super(message);
        this.code = code;
        this.remarque = remarque;
    }

    public int getCode(){
        return this.code;
    }
}
