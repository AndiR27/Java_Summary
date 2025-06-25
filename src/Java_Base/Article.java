package Java_Base;

/**
     * Décrivez votre classe Article ici.
     *
     * @author (votre nom)
     * @version (un numéro de version ou une date)
     */
    public class Article
    {
        // définir les attributs, les types, la visibilité
        private int numero;
        private String nom;
        private double prix;
        
        // définir un constructor ==> méthode qui est appelée lors du new()
        //          ==> s'occupe d'initialiser les attributs
        
        public Article(int numero, String nom, double prix) {
            this.numero = numero;
            this.nom = nom;
            this.prix = prix;
    
    
    
    }
    
    // methode qui retourne une représentation textuelle de cet article
    public String toString() { //methode qui sera appelé à chaque fois que qqun
        //voudra afficher un article
        return "article : " + numero + " : " + this.nom;
                               
    }
    
    // créer une méthode permettant de comparer 2 articles - unique, comme toString
    public boolean equals(Article art2){
        return(this.numero == art2.numero);
        /**
            if(this.numero == art2.numero){
                return true;
            
            
            
            }
            else {
                return false;
            }
        *
        */
    
    
    }
}
