package Java_DataStructures.domaine.File;

public class FileTableau<TYPESARTICLES> implements File<TYPESARTICLES>{

    private TYPESARTICLES[] tab;
    private int in, out;
    /*
    public FileTableau() {tab = (TYPESARTICLES[]) new Object[10]; in=out=0;}

    public void add(TYPESARTICLES val){tab[in]=val;incr(in);}
    public TYPESARTICLES remove(){TYPESARTICLES v = tab[out]; incr(out);return v;}
    private int incr(int i){return (i+1) % tab.length;}
    public boolean isEmpty(){return out == 0;}
    */

    public FileTableau(){tab = (TYPESARTICLES[]) new Object[10]; in=out=0;}
    public void add(TYPESARTICLES val){
        tab[in++]=val;
        in = incr(in);
        /*
        [val1, val2, val3]
        in = 0 au départ
        incr(in) -> in = (0+1)%1
        in = 0
         */
    }
    public TYPESARTICLES remove(){
        TYPESARTICLES v = tab[out];
        out = incr(out);
        return v;
    }

    public boolean isEmpty(){return out == 0;}

    private int incr(int i){return (i+1)%tab.length;}
}
