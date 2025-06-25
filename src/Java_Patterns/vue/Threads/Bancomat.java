package Java_Patterns.vue.Threads;

public class Bancomat extends Thread{
    private Compte cpt;
    private int mt;

    public Bancomat(Compte cpt, int mt){
        this.cpt = cpt;
        this.mt = mt;

    }

    public void run(){
        //cette instruction en synchronized oblige de ne rester que dedans tant qu'elle n'est pas fini
        try {
            cpt.depose(mt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
    }
}
