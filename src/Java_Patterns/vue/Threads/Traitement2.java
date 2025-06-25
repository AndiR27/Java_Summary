package Java_Patterns.vue.Threads;

public class Traitement2 implements Runnable{
    private Thread thread;
    public void run(){
        for(int i=0;i<200; i++){
            System.out.println("     " + i);
        }
    }

    public Traitement2() {
        this.thread = new Thread(this);
    }

    public void start(){
        thread.start();
    }

    public void join() throws InterruptedException {
        thread.join();
    }
}
