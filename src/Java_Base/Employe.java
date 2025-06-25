package Java_Base;

/**
 * Décrivez votre classe Personne ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Employe extends Personne
{
   
   private String dept;   
   private String noTelInterne;
   
   //la classe en extends reçoit aussi tous les param dans le constructeur
   // super.no = le numéro de la classe mère
   //super.toString() appele le toString de la classe mère
   public Employe(int no, String nom,String prenom, String dept, String noTelInterne){
       super(no, nom, prenom);  //appelle le constructeur de la classe mère
       this.dept = dept;
       this.noTelInterne = noTelInterne;
   }
    
   public String toString(){ // on veut afficher les infos de classe mère + le département
        return super.toString() + ", Département = " + dept + ", Téléphone : " + noTelInterne;
    
   }
    
   //pas besoin de faire la methode equals car on compare le numéro qui est faut au niveau de la personne
   //les autres methodes doivent être spécifiques à la classe Employe
   public double chiffreAffaire(){
       return 1234.56;
    
   }
   
   public String nomDuResponsable(){ return ".....";}
   
   public String infoDeContact(){   //methode est en abstract chez Personne, elle doit être présente dans les classes filles
       return "Tél au " + noTelInterne;
    
   }
}