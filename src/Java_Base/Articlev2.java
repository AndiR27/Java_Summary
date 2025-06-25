package Java_Base;

/** Création de nouvelle classe :
 *
 * Class Article : capsule pour des données/attributs/propriétés & leurs traitements/méthodes
 * - on définit ses ATTRIBUTS/PROPRIÉTÉS (en général private)
 * - un (ou plusieurs) CONSTRUCTEUR ==> pour initialiser les attributs de l'instance
 *   ce constructeur est appelé à chaque instruction new Article()
 * - on crée des instances en faisant des new Article() ==> ce qui appelle le constructeur
 * - on ajoute toutes les méthodes de traitements (sur ses attributs)
 * - tous les attributs/méthodes ne sont (en général) PAS static
 *
 * @author Ch. Stettler - HEG-Genève
 */

public class Articlev2 { // Capsule pour les données et les traitements d'un Article
    
    // 1) définition des ATTRIBUTS/PROPRIÉTÉS de chaque Article
    // ======================================
    private int no;
    private String nom;
    private double prix;
    private int stock;
    
    // 2) Définition du/des CONSTRUCTEURs : méthode appelée lors de la création d'une nouvelle instance (new)
    // ==================================
    // - Porte le même nom que la classe
    // - Son code est exécuté au moment de la création d'une instance (new)
    // - Responsabilité: initialiser l'instance, en particulier ses attributs
    public Articlev2(int no, String nom, double prix, int stock) {
        this.no = no;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }
    
    public Articlev2(int no, String nom) {    // Constructeur, sans obligatoirement tous les champs
        this.no = no;
        this.nom = nom;
    }
    
    // Responsabilités importantes de toutes les classes :
    // =================================================
    
    // 3) la méthode toString() : retourne le contenu de l'instance sous format textuel
    // ========================     
    // - tout objet est capable de fournir une représentation sous forme d'un String de lui-même
    public String toString() {
        return "Article " + this.no + ": " + this.nom + ", " + this.stock + " pièces à Frs " + this.prix;
    }
    
    // 4) Méthode equals() : tout objet est capable de dire s'il est ou non égal à un autre
    // =================== 
    // - equals() est particulièrement importante car elle est employée par toutes les classes de la bibliothèque 
    // - lorsqu'il est nécessaire de comparer deux instances pour déterminer si elles sont égales.
    // - Par exemple: méthodes contains() ou indexOf() de ArrayList.
    
    // Version 0 : uniquement si on reçoit un objet de type Article :
    
    public boolean equals(Articlev2 art) {
    // Si la règle de gestion indique que 2 articles ayant le même numéro doivent être considérés comme identique
    // on peut ne tester que l'égalité du numéro :
        return (this.no == art.no);

    // dans le cas où 2 articles sont identiques s'ils ont le même no et le même prix, on teste les 2 champs :
    //  return (this.no == art.no) && (this.prix == art.prix);
    
    // dans le cas où 2 articles sont identiques s'ils ont le même no et le même NOM (qui est un String)
    // on NE PEUT PAS tester ainsi !!
    //  return (this.no == art.no) && (this.nom == art.nom);    // str1==str2 compare les références, et non pas les valeurs !!
    
    // on doit utiliser la méthode .equals() :
    //  return (this.no == art.no) && this.nom.equals(art.nom);
    
    // Enfin, si on veut que tous les champs soient identiques pour que 2 articles soient considérés comme identiques, 
    // on doit tout tester :
    //  return (this.no == art.no) && this.nom.equals(art.nom) && (this.prix == art.prix) && (this.stock == art.stock);
    }
    
    // Version correcte : on reçoit un objet de n'importe quel type, pour autant qu'il contienne un Article !
    public boolean equals(Object obj) {
    //  return (this.no == ((Article)obj).no);  // il faut caster obj pour indiquer qu'il contient un Article
    
    // ou, si 2 articles ayant le même no et le même doivent être considérés comme identiques :
        return (this.no == ((Articlev2)obj).no) && this.nom.equals(((Articlev2)obj).nom);
    }
    
    // 5) toutes les méthodes nécessaires au traitement d'un Article
    // ==================================
    
    // Définition de Getter : méthodes d'accès aux attributs ==> permettent de récupérer la valeur des attributs
    public int getNo()     { return no; }
    public String getNom() { return nom; }
    public double getPrix(){ return prix; }
    public int getStock()  { return stock; }
    
    // Définition de Setter : méthodes de mise-à-jour des attributs ==> permettent de modifier la valeur des attributs
    public void setNom(String nom)  { this.nom = nom; }
    public void setPrix(double prix){ this.prix = prix; }
    public void achete(int nb)      { this.stock += nb; }
    public void vend(int nb)        { this.stock -= nb; }
}