package Java_Base;

import java.util.ArrayList;
/**
 * Décrivez votre classe DemoHeritage ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DemoHeritageApplication
{
    public static void main(){
        // Personne pers = new Personne(1, "Dumoulin", "Peter");        // va bug si on rajoute des attributs sur la classe personne
        // System.out.println(pers);
        Employe emp1 = new Employe(1, "Durand", "Marc", "Marketing", "077 777 77 77");
        Employe emp2 = new Employe(2, "Durand", "Eric", "Informatique", "66");
        Employe emp3 = new Employe(3, "Dupont", "Dan", "Informatique", "555");

        Client cli1 = new Client(4, "chong", "pong", "apple", "yin@mail.com");
        Client cli2 = new Client(5, "Dutoit", "john", "Dell", "john@mail.com");
        
        ArrayList<Personne> list = new ArrayList();         //liste de personne, on peut y ajouter des employé et/ou client
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(cli1);
        list.add(cli2);
        
        
        
        Personne pers;              //déclaration d'une référence
        pers = list.get(0);         // On peut travailler avec la classe personne pour les affectations, mais impossible de faire new Personne();
        System.out.println(pers);   //va appeler les methodes d'employé car pers devient emp1
        
        System.out.println(emp1);
        System.out.println(cli1);
        
        System.out.println("Initiale de l'employé : " + emp1.initialeDuPrenom());
        System.out.println("Infos de contact :");
        for(Personne personne : list){
            System.out.println(personne + " ==> " + personne.infoDeContact());
        
        }
        
        // Si on veut qu'une personne puisse évaluer un produit
        Produit prod1 = new Produit(11, "PC", 1111);
        Produit prod2 = new Produit(22, "Smartphone", 2222);
        
        
        prod1.evaluer();
        Personne pers1;
        pers1 = list.get(3);
        
        // création d'une liste d'objects contenants personne + produit :
        
        ArrayList<Evaluable> objets = new ArrayList<>();             //avoir une arrayliste typé commun à produit et personne
        //Lien entre les deux, ils peuvent les 2 être évalués
        objets.add(prod1);   //ajout du produit
        objets.add(pers1);  //ajout d'une personne
        
        for(Evaluable ev : objets){
            ev.evaluer();
        }
        
        //les interfaces serviront à trier par exemple : comparaison 
        ArrayList<Produit> listeProdTri = new ArrayList<>();
        listeProdTri.add(prod1);
        listeProdTri.add(prod2);
        listeProdTri.sort(null);    
        System.out.println(listeProdTri);
    }
    
    
}
