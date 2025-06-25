package Java_Patterns.vue.Threads;

import java.util.concurrent.CountDownLatch;

public class Traitement4 extends Thread{
    private CountDownLatch latch;

    public Traitement4(CountDownLatch latch) {
        this.latch = latch;
    }

    public  void run(){
        for(int i=0;i<200; i++){
            System.out.println("" + i);
        }
        latch.countDown();
    }
}
