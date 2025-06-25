package Java_Base;

/**
 * Décrivez votre classe Client ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Client extends Personne
{
    private String entreprise;
    private String mail;
    
    public Client(int no, String nom, String prenom, String entreprise, String mail){
        super(no,nom,prenom);
        this.entreprise = entreprise;
        this.mail = mail;
    
    
    }
    
    public String toString(){
        return super.toString() + ", mail : " + mail + ", entreprise : " + entreprise;
    
    }
    
    public String infoDeContact(){
        return "envoyer un mail à " + mail;
    }
}
