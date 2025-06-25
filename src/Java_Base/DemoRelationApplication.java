package Java_Base;

import java.util.ArrayList;
/**
 * Décrivez votre classe DemoRelationApplication ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DemoRelationApplication
{
   public static void main(){ //methode principale avec String[] args dans la Machine java, mieux que main()...
       Employe2 emp1 = new Employe2(1, "Dupond");
       Employe2 emp2 = new Employe2(2, "Durant");
       Employe2 emp3 = new Employe2(3, "Dufour");
       ArrayList<Employe2> liste = new ArrayList<>();
       liste.add(emp1);
       liste.add(emp2);
       liste.add(emp3);
       System.out.println("test : " + liste);
       //plus de travail du côté de Dept avec une liste
       Dept dept1 = new Dept(11, "Informatique");
       Dept dept2 = new Dept(22, "Ventes");
       Dept dept3 = new Dept(33, "Marketing");
       
       dept1.addEmploye(new Employe2(4, "Ramiqi"));
       dept1.addEmploye(emp1);
       dept1.addEmploye(emp2);
       dept3.addEmploye(emp3);
       
       System.out.println("Dans le dépt : " + dept1 + " se trouve les employés suivants : " + dept1.getListeEmployes());
       
       System.out.println(dept1);
       System.out.println(emp1);
       System.out.println(emp2);
       System.out.println(emp3);
       
       System.out.println("Initiale : " + emp1.initiale());
       // Dept dep = emp1.getDept();
       // String nomDuDep = dep.getNom();
       // System.out.println(nomDuDep);
       
       // Avantages de Dept dans Employe : Pour chaque employé, on connait immédiatement son département
       
       //Inconvéniants : Afficher tous les employés qui sont dans un certain département ==> Dans dept1 par exemple
       // Il faudra parcour tous les employé, comparer leur département,...
       // -> pour un département donné, on ne connait donc pas la liste des employés
       
       // Autre variante, infos des tous les employés dans une ArrayList dans Dept (le contraire)
       
       // Autre variante 2, avec les deux solutions précédentes, mais hardcore en cas de modification
   }
}
