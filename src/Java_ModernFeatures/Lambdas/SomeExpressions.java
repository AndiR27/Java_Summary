package Java_ModernFeatures.Lambdas;

import java.util.Arrays;
import java.util.List;

public class SomeExpressions {
    public static void executer(TestInterfaceVoid monInterface) {
        monInterface.executer();
    }


    public static void main(String[] args) {
        //Methode 1 void et sans params :
        //() -> System.out.println("Zero parameter lambda");
        //Dans cet exemple, la méthode étant créée dans la même classe, il est possible
        // d'y faire appel sans avoir à typer avec l'interface comme les exemples suivants
        TestInterfaceVoid test1 = () -> System.out.println("test");
        test1.executer();

        executer(() -> System.out.println("test"));

        //Methode 2 : void et avec params :
        // param -> System.out.println("One parameter: " + param);
        TestInterfaceVoidParams test2 = System.out::println;
        TestInterfaceVoidParams test2_2 = a -> System.out.println(a + 5);
        test2.executer(10);
        test2_2.executer(10);
        //M1 : ça affiche
        //M2 : ça affiche le res + 5


        //  ON PEUT ENLEVER LES {} SI ON A QU'UNE INSTRU.
        // LES () AUSSI DU PARAMETRE SI ON A UN SEUL PARAMETRE

        //Methode 3 : void et avec multiples params
        //(p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);
        TestInterfaceVoidParamsMult test3 = (a, b) -> {
            System.out.println("test : " + b);
        };
        test3.executer(10, "test3");

        //Methode 4 : return et sans params
        TestInterfaceReturnNoParams<String> test4 = () -> "test4";
        System.out.println(test4.executer());

        //Methode 5 : return avec params
        TestInterfaceReturnParams test5 = (a, b) -> a + b;
        //Simplification :
        //TestInterfaceReturnParams test5 = Integer::sum;
        //Autre façon de faire : TestInterfaceReturnParams test5 = Integer::sum;
        System.out.println("test5 : " + test5.executer(10, 5));

        /**
         * Proposez une expression lambda utilisant l'interface I_Concatenator telle que
         * le code ci-dessous s'exécute et affiche en console : 1-2-3
         *      concatenator.afficheElements(Arrays.asList(1, 2, 3));
         */
        I_Concatenator concatenator = list -> {
            String s = "";
            for (int i : list) {
                String number = Integer.toString(i);
                if (i != list.size()) {
                    s += number + "-";
                } else {
                    s += number;
                }

            }
            System.out.println(s);
        };
        concatenator.afficheElements(Arrays.asList(1, 2, 3));

    }
    interface I_Concatenator {
        void afficheElements(List<Integer> list);
    }
}
