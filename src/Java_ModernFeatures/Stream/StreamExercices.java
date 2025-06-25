package Java_ModernFeatures.Stream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExercices {

    List<Person> persons = Arrays.asList(
            new Person(1, "Andi", "Ramiqi", LocalDate.of(1995,2,27)),
            new Person(2, "Anita", "Choen", LocalDate.of(1996,1,31)),
            new Person(3, "John", "Doe", LocalDate.now())
    );

    //3.1
    public void operationsStreams(){
        //1
        Stream<Person> s1 = persons.stream().filter(person -> person.getLastName().equals("Doe"));

        //2
        Stream<Person> s2 = persons.stream().filter(person -> person.getBirthDate().isBefore(LocalDate.of(2004,01,19)));

        //3
        Stream<Person> s3 = persons.stream().filter(person -> person.getLastName().equals(person.getFirstName()));

        //4
        Stream<String> s4 = persons.stream().map(person -> person.getLastName().toUpperCase()).distinct();

        //5
        Stream<Person> s5 = persons.stream().sorted((p1, p2) -> {
            if(p1.getBirthDate().isBefore(p2.getBirthDate())){
                return 1;
            }
            else{
                return 0;
            }
        });
    }

    public void operationCollections(){
        //1
        List<Person> s1 = persons.stream().filter(person -> person.getBirthDate().isBefore(LocalDate.of(2004,01,19))).collect(Collectors.toList());

        //2
        OptionalDouble s2 = persons.stream().mapToInt(n -> 2022 - n.getBirthDate().getYear()).average();

        //3
        String s3 = persons.stream().map(p -> p.getLastName() + " ").collect(Collectors.joining());

        //4
        Map<String, List<Person>> s4 = persons.stream().collect(Collectors.groupingBy(Person::getFirstName));

    }

    public void divers(){
        //Factorielle de n
        int n = 5;
        LongStream.rangeClosed(1, n).reduce(1, (long x, long y) -> x * y);

        //new int[]{0, 1} et n + 1 dans la limite car théoriquement la suite de fibonacci commence à n = 0
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(n + 1)
                .map(t -> t[0])
                .forEach(x -> System.out.println(x));

    }



    //Classe interne
    public class Person {

        private final long id;
        private final String firstName;
        private final String lastName;
        private final LocalDate birthDate;

        public Person(long id, String firstName, String lastName, LocalDate birthDate) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
        }

        // Getters for fields

        public long getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }
    }
}
