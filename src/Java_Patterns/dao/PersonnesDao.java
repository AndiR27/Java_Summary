package Java_Patterns.dao;

import java.util.ArrayList;
import java.util.List;

public class PersonnesDao {
    public static List<String[]> lirePersonnes(){
        List<String[]> lst = new ArrayList<>();
        //données différentes selon le type de Personnes
        lst.add(new String[] {"PROF", "Stettler", "Christian", "IG"});
        lst.add(new String[] {"PROF", "Billard", "David", "IG"});
        lst.add(new String[] {"PROF", "Kalousis", "Alexandros", "IG"});
        lst.add(new String[] {"ASSISTANT", "Loutan", "Baptiste", "PROG"});
        return lst;
    }

}
