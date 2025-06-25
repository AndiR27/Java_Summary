package Java_Base;

/** Attribut/Méthode static -
 * @author Ch. Stettler - HEG-Genève
 */

public class ArticleAvecAttributStatic {
    private int no;
    private String nom;
    private int stock;
    private double prix;
    
    // un attribut static permet de déclarer un attribut de CLASSE (et non pas d'instance)
    // toutes les instances de cette classe vont donc partager la même donnée/valeur
    private static int nbArticlesDéjàCréés = 0;
    
    public ArticleAvecAttributStatic(String nom, double prix) {
        this.no = ++nbArticlesDéjàCréés;
        this.nom = nom;
        this.prix = prix;
        this.stock = 0;
    }
    
    // une méthode static permet de l'appeler sans instancier la classe
    // on peut connaitre le nb d'articles déjà créé sans avoir aucune instance (aucun article)
    // Exemples d'appel: print(Article.getNbArticlesDéjàCréés(); Article art; print(art.getNbArticlesDéjàCréés());
    public static int getNbArticlesDéjàCréés() { return nbArticlesDéjàCréés; }
    
    public boolean equals(Object obj) {
        return (no == ((ArticleAvecAttributStatic)obj).no) && nom.equals(((ArticleAvecAttributStatic)obj).nom);
    }
    
    public String toString() {
        return "Article " + no + ": " + nom + ", " + stock + " pièces à Frs " + prix;
    }
}