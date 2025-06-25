package Java_Patterns.vue.Strategy;

import java.util.ArrayList;
import java.util.List;

public class LoadDataDurStrat implements LoadDataStrategy{
    public List<PersonneStrat> lirePersonnes(){
        List<PersonneStrat> lstStrat = new ArrayList<>();

        lstStrat.add(new PersonneStrat(11, "Stettler", "Christiant"));
        lstStrat.add(new PersonneStrat(12, "Ramiqi", "Andi"));


        return lstStrat;
    };
}
