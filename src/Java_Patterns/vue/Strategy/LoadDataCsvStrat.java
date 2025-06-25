package Java_Patterns.vue.Strategy;

import java.util.ArrayList;
import java.util.List;

public class LoadDataCsvStrat implements LoadDataStrategy{
    public List<PersonneStrat> lirePersonnes(){
        List<PersonneStrat> lstStrat = new ArrayList<>();

        for(String[] champs : outils.FileToStr.lireCsv("lstpers.csv")){
            lstStrat.add(new PersonneStrat(Integer.parseInt(champs[0]), champs[1], champs[2]));
        }
        return lstStrat;
    };
}
