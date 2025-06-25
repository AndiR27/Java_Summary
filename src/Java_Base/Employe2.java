package Java_Base;

/**
 * Décrivez votre classe Employe2 ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Employe2
{
   
    private int no;
    private  String nom;
    private int noDept; //on pourrait faire comme en bdd, noDept = FK dans Employe, mais pas possible d'utiliser le nom de l'employe
    // private Dept dept;  //le mieux c'est de stocker une référence de Dept dans Employe
    
    public Employe2(int no, String nom){
        this.no = no;
        this.nom = nom;
        
    }
    public String toString(){
        return no + " : " + nom;
    }
    public boolean equals(Object obj){
        return this.no == ((Employe2)obj).no;
    }
    
    public String getNom(){return nom;}
    
    // public Dept getDept() {return dept;}
    
    public char initiale(){return nom.charAt(0);}
}
