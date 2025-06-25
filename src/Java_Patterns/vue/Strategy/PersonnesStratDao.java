package Java_Patterns.vue.Strategy;

import java.util.List;

public class PersonnesStratDao {
    private static LoadDataStrategy loadDataStrategy = new LoadDataDurStrat();
    public static List<PersonneStrat> lirePersonnes(){
        //Finalement cette classe va appeller lirePersonnes de une des classes
        //Il faudra définir la source avec un LoadDataStrategy
        return loadDataStrategy.lirePersonnes();
    }

    public static void setLoadDataStrategy(LoadDataStrategy loadDataStrategy) {
        PersonnesStratDao.loadDataStrategy = loadDataStrategy;
    }
}
