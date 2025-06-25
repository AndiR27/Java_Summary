package Java_ModernFeatures.Generiques;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericMain {
    public static void main(String[] args) {
        GenericMethodExemple genMethode = new GenericMethodExemple();
        System.out.println("Avec un int : " + genMethode.addBoth(1, 2)); // affiche 3.0
        System.out.println("Avec un float : " + genMethode.addBoth(1, 1.3f)); // affiche 2.29...
        System.out.println("Avec un double " + genMethode.addBoth(1, 1.3d)); // affiche 2.29...
        System.out.println("Avec un long : " + genMethode.addBoth(1, (long) 1.3)); // affiche 2.0
        Double res = genMethode.addBoth(32, 0.343522f);
        System.out.println(res); // affiche 32.34...
        // System.out.println(genMethode.addBoth(1.1f, 1.3f)); // Compile error

        GenericClassExemple triple = new GenericClassExemple("Hello", new Date(), 15);
        Object s = triple.first();
        Object d = triple.second();
        Object i = triple.third();
        System.out.println(triple);
    }

    public void addList(){
        List l = new ArrayList<>();
        List l2 = new ArrayList<>();
    }
}
