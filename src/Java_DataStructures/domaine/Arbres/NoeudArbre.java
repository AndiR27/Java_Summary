package Java_DataStructures.domaine.Arbres;

public class NoeudArbre {
    private NoeudArbre filsAine; // Le plus proche de ces fils
    private int contenu;    // contenu du noeud
    private NoeudArbre frere;    // le frère du noeud

    //Dans cette version du noeud, un Node a un fils, ce même fils a un frère et un fils, etc...(Seul la racine n'a pas de frère, il n'a qu'un fils ainé)
    public NoeudArbre(NoeudArbre a_fileAine, int a_contenu, NoeudArbre a_frere){
        this.filsAine = a_fileAine;
        this.contenu = a_contenu;
        this.frere = a_frere;
    }

    public int getContenu() {
        return contenu;
    }

    public NoeudArbre getFrere() {
        return this.frere;
    }

    public NoeudArbre getFilsAine() {
        return this.filsAine;
    }

    public NoeudArbre setFilsAine(NoeudArbre filsAine) {
        this.filsAine = filsAine;
        return this.filsAine;
    }

    public NoeudArbre setFrere(NoeudArbre frere) {
        this.frere = frere;
        return this.frere;
    }

    public NoeudArbre(int a_contenu){

        this(null, a_contenu, null);
    }


    public String toString(){
        return this.contenu + "\n" + (this.filsAine != null ? filsAine.toString("\t") : "");
    }

    public String toString(String s){
        if(this.filsAine != null)
            return s + this.contenu + "\n" + filsAine.toString(s+"\t") + (this.frere == null ? "" : this.frere.toString("s"));
        return (s + this.contenu + "\n" + (this.frere == null ? "" : this.frere.toString(s)));
    }
}
