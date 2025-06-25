package Java_Base;

import java.util.ArrayList;
/**
 * Décrivez votre classe Employe2 ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Dept
{
   
    private int no;
    private  String nom;
    //2ème méthode avec liste des employés du côté du département
    private ArrayList<Employe2> listEmployes;
    // avec cette méthode, on travaille généralement sans la liste en tant que param dans le Constructeur, trop compliqué
    
    public Dept(int no, String nom /* ArrayList listEmployes*/){
        this.no = no;
        this.nom = nom;
        // this.listEmployes = listEmployes;
        
        // le mieux à faire, sans passer par les param, le constructeur va juste créer la liste
        this.listEmployes = new ArrayList<>();
    }
    
    public void addEmploye(Employe2 emp){
        listEmployes.add(emp);
    }
    
    public String toString(){
        return no + " : " + nom;
    }
    public boolean equals(Object obj){
        return this.no == ((Dept)obj).no;
    }
    
    public String getNom(){return nom;}
    
    public ArrayList<Employe2> getListeEmployes(){
        return listEmployes;
    }
    
}