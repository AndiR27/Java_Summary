package Java_DataStructures.domaine.ListeDoublementChainee;


public class ListeDblCh<E> implements DList<E> {

    class ElementDblCh {    // Classe interne
        private E val;                    // L'�l�ment
        private ElementDblCh next;    // Le suivant
        private ElementDblCh prev;    // Le pr�c�dent

        public ElementDblCh(E val, ElementDblCh next, ElementDblCh prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private ElementDblCh first, last;

    public ListeDblCh() {
        first = last = null;
    }

    public void addFirst(E val) {
        first = new ElementDblCh(val, first, null);
        if (last == null) {
            last = first;
        } else {
            first.next.prev = first;
        }
    }

    public void addLast(E val) {
        last = new ElementDblCh(val, null, last);
        if (first == null) {
            first = last;
        } else {
            last.prev.next = last;
        }
    }

    public E removeFirst() {
        if (isEmpty()) throw new RuntimeException("Liste vide !");
        E val = first.val;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        return val;
    }

    public E removeLast() {
        if (isEmpty()) throw new RuntimeException("Liste vide !");
        E val = last.val;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        return val;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
