package Java_DataStructures.domaine.Graphes;

public class GrapheMatrice{
    private boolean[][] matrice;

    public GrapheMatrice(int nbNoeuds) {
        this.matrice = new boolean[nbNoeuds][nbNoeuds];
    }

    public void addRelation(int source, int destination) {
        matrice[source][destination] = true;
        matrice[destination][source] = true;	// si graphe non-orient�, donc relation dans les 2 sens
    }


    public boolean existeRelation(int source, int destination) {
        return matrice[source][destination];
    }

    public void affiRelations() {
        for (int i=0; i<matrice.length; i++) {
            System.out.print(i + " a des relations avec : ");
            for (int j=0; j<matrice[i].length; j++) {
                if (matrice[i][j]) { System.out.print(j + " "); }
            }
            System.out.println();
        }
    }

    public void printMatrice() {
        for (int i=0; i<matrice.length; i++) {
            for (int j=0; j<matrice[i].length; j++) {
                if (matrice[i][j]) { System.out.print("   X"); } else { System.out.print("   -"); }
            }
            System.out.println();
        }
    }


}