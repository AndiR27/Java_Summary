package Java_DataStructures.domaine.ListeDoublementChainee;

public interface DList<E> {
    void addFirst(E val);
    void addLast(E val);
    E removeFirst();
    E removeLast();
    boolean isEmpty();
}