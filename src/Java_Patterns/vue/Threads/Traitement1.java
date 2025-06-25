package Java_Patterns.vue.Threads;

public class Traitement1 extends Thread{

    public  void run(){
        for(int i=0;i<200; i++){
            System.out.println("" + i);
        }
    }

    public void start(){

    }
}
