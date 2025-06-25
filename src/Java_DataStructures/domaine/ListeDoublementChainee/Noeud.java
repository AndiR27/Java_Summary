package Java_DataStructures.domaine.ListeDoublementChainee;

public class Noeud<TYPESARTICLES> {
    private TYPESARTICLES val;

    //liste doublement chainée
    private Noeud next;
    private Noeud prec;

    //on a deux constructeurs, une fois pour si liste simplement chainée, le deuxième pour la liste doublement chainée
    public Noeud(TYPESARTICLES val, Noeud next) {
        this.val = val;
        this.next = next;
    }

    public Noeud(TYPESARTICLES val, Noeud next, Noeud prec) {
        this.val = val;
        this.next = next;
        this.prec = prec;
    }



    public TYPESARTICLES getVal() {
        return val;
    }

    public Noeud getNext() {
        return next;
    }

    public Noeud getPrec() {
        return prec;
    }

    public void setVal(TYPESARTICLES val) {
        this.val = val;
    }

    public void setNext(Noeud next) {
        this.next = next;
    }

    public void setPrec(Noeud prec) {
        this.prec = prec;
    }

}
