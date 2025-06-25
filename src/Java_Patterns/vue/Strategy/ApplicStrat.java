package Java_Patterns.vue.Strategy;

public class ApplicStrat {
    public ApplicStrat() {
        System.out.println("Design Pattern Strategy : Permet de permuter dynamiquement une méthode");
        for (PersonneStrat pers : PersonnesStratDao.lirePersonnes()){
            System.out.println(pers);

        }
    }
}
