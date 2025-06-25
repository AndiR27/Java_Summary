package Java_Patterns.vue.Threads;

import java.util.concurrent.Callable;

public class Traitement6 implements Callable<Integer> {
    private int code;

    public Traitement6(int code) {
        this.code = code;
    }

    public Integer call() throws Exception{
        for(int i=0; i<20; i++){
            System.out.println("" + i);

        }
        return code;
    }


}
