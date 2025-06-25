package Java_DataStructures.domaine.Pile;

public class PileTableau<TYPESARTICLES> implements Pile<TYPESARTICLES>{
    //attributs obligatoires :
    private TYPESARTICLES[] tab;
    private int size;

    //seule chose du constructeur, allouer le tableau et définir la taille à 0:

    public PileTableau() { tab = (TYPESARTICLES[]) new Object[10];size = 0;}
    public void push(TYPESARTICLES val){
        if(size == tab.length){resize();}
        tab[size]=val;
        size++;
    }
    public TYPESARTICLES pop(){
        int v = size - 1;
        size--;
        return tab[v];
    }
    // [val0, val1 , val2]
    //size = 3
    //push[3] et mon size augmente de 1
    // pop -> size -1 = 2
    //pop.tab[2]
    private void resize(){
        TYPESARTICLES[] newTab = (TYPESARTICLES[]) new Object[tab.length*2];
        for(int i=0; i<size; i++){
            newTab[i] = tab[i];
        }
    }

    public boolean isEmpty(){
        return size==0;
    }

}
