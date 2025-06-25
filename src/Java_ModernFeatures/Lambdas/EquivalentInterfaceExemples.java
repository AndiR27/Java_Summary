package Java_ModernFeatures.Lambdas;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class EquivalentInterfaceExemples {
    public static void main(String[] args) {
        //Liste des interfaces fonctionnelles équivalentes
        //1)L'interface Supplier
        //Faire un lambda avec : () -> "Hello world";
        Supplier<String> supp = () -> "Hello world";
        supp.get();

        //2)L'interface UnaryOperator
        UnaryOperator<Integer> unary = s -> s;
        unary.apply(10);

        //3)L'interface Comparator
        Comparator<String> comp = (s1, s2) -> s1.compareToIgnoreCase(s2);
        comp.compare("test", "fauxtest");

        //4) L'interface Predicate
        Predicate<String> pred = f -> "Hello".equals(f);
        pred.test("Hello");

        //5)L'interface Runnable
        Runnable run = () -> System.out.println("Hello world");
        run.run();

        //6)L'interface Function
        Function<String, Integer> apply = o -> o.hashCode();
        apply.apply("test");

    }
}
