package Java_DataStructures.domaine.Pile;

public interface Pile<TYPESARTICLES> {
    void push(TYPESARTICLES val);
    TYPESARTICLES pop();
    boolean isEmpty();
}
