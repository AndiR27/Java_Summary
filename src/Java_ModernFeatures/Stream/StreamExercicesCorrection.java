package Java_ModernFeatures.Stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class StreamExercicesCorrection {
    List<Person> personList =
            Arrays.asList(new Person(1, "Jonathan", "Joestar", LocalDate.of(1868, 4, 4)),
                    new Person(1, "Joseph", "Joestar", LocalDate.of(1920, 9, 27)),
                    new Person(1, "John", "Doe", LocalDate.of(1996, 1, 13)),
                    new Person(1, "Jolyne", "Cujoh", LocalDate.of(1998, 5, 8)),
                    new Person(1, "Dylan", "Doe", LocalDate.of(2016, 8, 12)),
                    new Person(1, "Natacha", "Doeson", LocalDate.of(2012, 1, 28)),
                    new Person(1, "Donatien", "Montazac", LocalDate.of(1986, 12, 25)),
                    new Person(1, "Mathis", "Smith", LocalDate.of(2020, 12, 25)),
                    new Person(1, "Covid", "Coronavirus", LocalDate.of(2020, 2, 15)),
                    new Person(1, "Alfred", "Doe", LocalDate.of(2006, 8, 15)),
                    new Person(1, "Doe", "Doe", LocalDate.of(2020, 2, 14)),
                    new Person(1, "Joestar", "Joestar", LocalDate.of(2003, 12, 7)),
                    new Person(1, "Mathis", "Snow", LocalDate.of(1978, 12, 1))
            );

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
