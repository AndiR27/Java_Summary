package Java_DataStructures.domaine.File;

import domaine.ListeDoublementChainee.Noeud;

public class FileListe<TYPESARTICLES> implements File<TYPESARTICLES> {
    Noeud in;
    Noeud out;

    public FileListe(){in = out = null;}

    public void add(TYPESARTICLES val){
        Noeud nouveau = new Noeud((Integer) val, null);
        if(isEmpty()){
            in = out = nouveau;
        }
        else{
            in.setNext(nouveau);
            in = nouveau;
        }
    }

    public TYPESARTICLES remove(){
        TYPESARTICLES v = (TYPESARTICLES) out.getVal();
        out = out.getNext();
        return v;
    }

    public boolean isEmpty(){return out == null;}

}
