package Java_ModernFeatures.Lambdas;

public class InterfaceFonctionnelExerciceExemple {

    /**
     * Etant donné une interface appellée I_Multi,
     * Etant donné les informations suivantes :
     *
     * 1.   I_Multi multi = s -> System.out.println("Hello "+s);
     * 2.   multi.Goodbye();  // sortie console : Goodbye !
     * 3.   I_Multi.HelloBuddy("Jack");  // sortie console : Hello buddy Jack
     *
     * Codez l'interface I_Multi afin que le code ci-dessus
     * soit compilable et exécutable avec les même résultats
     * qu'en commentaires.
     *
     * De plus, implémentez les 3 possibilités quand c'est possible :
     *          - fonction anonyme
     *          - lambda
     *          - référence de méthode
     */
    public static void main(String[] args) {
        //Points 1, 2 et 3
        I_Multi multi = s -> System.out.println("Hello "+s);
        multi.Hello("monsieur");

        multi.Goodbye();  // sortie console : Goodbye !

        I_Multi.HelloBuddy("Jack");  // sortie console : Hello buddy Jack

        //3 Possibilités
        //Fonction annonyme :
        I_Multi multiAno = s -> {
            System.out.println("Hello " + s);
        };
        multiAno.Hello("Ano");


        //Lambda :
        I_Multi multiLambda = s -> System.out.println("Hello" + s);
        multiLambda.Hello("Lambda"); // sortie console : Hello Sonia !

        //référence de méthode
        I_Multi multiRef = System.out::println;
        multiRef.Hello("Reference");

    }


    @FunctionalInterface
    public interface I_Multi {
        void Hello(String s);
        //Possible d'avoir une interface fonctionnelle ayant des methodes non abstraites en plus
        default void Goodbye (){
            System.out.println("Goodbye !");
        }

        static void HelloBuddy(String s){
            System.out.println("Hello buddy "+s);
        }

    }
}
