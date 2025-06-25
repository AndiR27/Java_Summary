package Java_DataStructures.domaine.File;

public interface File<TYPESARTICLES> {
    void add(TYPESARTICLES val);
    TYPESARTICLES remove();
    boolean isEmpty();
}
