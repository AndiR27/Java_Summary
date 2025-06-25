package Java_ModernFeatures.Generiques;

import java.util.Date;

public class GenericClassExemple<F, S, T> {
    private F first;
    private S second;
    private T third;

    public GenericClassExemple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public F first() {
        return this.first;
    }

    public S second() {
        return this.second;
    }

    public T third() {
        return this.third;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "first='" + first + '\'' +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
