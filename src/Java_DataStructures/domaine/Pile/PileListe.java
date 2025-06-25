package Java_DataStructures.domaine.Pile;

import domaine.ListeDoublementChainee.Noeud;

public class PileListe<TYPESARTICLES> implements Pile<TYPESARTICLES> {
    Noeud lst;

    public PileListe(){lst = null;}

    public void push(TYPESARTICLES val){
        lst = new Noeud((TYPESARTICLES) val, lst);

    }

    public TYPESARTICLES pop(){
        TYPESARTICLES v = (TYPESARTICLES) lst.getVal();
        //on conserve la valeur du premier
        lst = lst.getNext();
        //on se positionne au suivant
        return v;
        //on retourne la valeur
    }

    public boolean isEmpty(){
        return lst == null;
    }

}
