package Java_Patterns.vue.Threads;

public class Compte {
    private int numero;
    private int solde;

    public Compte(int numero, int solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public synchronized void depose(int montant) throws InterruptedException {
        while(solde <=0){wait();} // Attend une notification

        int soldeActuel = solde;
        for(Integer xx=0; xx<10000; xx++){
            //Simuler le temps
        }
        soldeActuel += montant;
        solde = soldeActuel;
    }

    public void autreTraitement(){
        notify(); //Si un thread est en train d'attendre, cette insctruction va la débloquer
    }
    @Override
    public String toString() {
        return "Compte{" +
                "numero=" + numero +
                ", solde=" + solde +
                '}';
    }
}
