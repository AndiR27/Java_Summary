package Java_ModernFeatures.Stream;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Qu'est-ce que les streams ? ==> Interface dispo avec un ensemble de fonctions (utilisable sur listes, tableaux, et bien d'autres)
 * ==> On pourra filtrer, recupérer, ordonner la liste de façon plus efficiente
 * ==> très très rapide
 */
public class StreamMain {
    public static void main(String[] args) {
        List<StreamHumain> humainList = Arrays.asList(
                new StreamHumain("Ramiqi", "Andi", Arrays.asList("Harry"), 26, new Date(), 123123123),
                new StreamHumain("Choen", "Anita", Arrays.asList("Stephanie"), 25, new Date(), 12312455)
                );
        //AnyMatch
        //On prends la liste d'humains, on la transforme en streams contenant nos objets, et grâce à la fonction anyMatch, on va tester l'age
        humainList.stream().anyMatch(humain -> humain.getAge()>= 20);

        //filter -> renvoi un stream, permet de nouveaux appels de fonctions
        //On va récupérer une liste d'humain selon un filtre particulier
        humainList.stream().filter(humain -> humain.getAge() >= 20).collect(Collectors.toList());

        //Map : transformation
        //Avec l'exemple de dessus cela donne :
        humainList.stream().filter(humain -> humain.getAge() >= 20).map(StreamHumain::getNumeroSocial).collect(Collectors.toList());

        //Flat map : mettre à plat les elements des streams (si on a une liste de liste de stream par exemple)
        //Exemple avec la liste des autresPrenoms
        humainList.stream().filter(humain -> humain.getAge() >= 20).flatMap(humain -> humain.getAutresPrenomsList().stream()).collect(Collectors.toList());

        //Autres petites fonctions rapides :
        //Count : compter le nombre d'éléments dans notre stream : .count()
        //distinct : récupérer un stream avec des éléments que distincts : .distincts()
        //findFirst : trouver le premier élément selon le paramètre .findFirst(....)

        //On peut aussi stocker du contenu sous une variable stream comme les exercices
        //Stream<Person> s1 = persons.stream().filter(person -> person.getLastName().equals("Doe"));
    }
}
