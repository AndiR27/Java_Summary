package Java_Patterns.vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmRechercher extends JFrame{
    private JPanel panel;
    private JButton btnRetourner;
    private JLabel lblRechercher;
    private JLabel lblValeur;
    private JTextField tfValeurARetourner;

    private FrmRechercher(String texte) {
        lblValeur.setText(texte);
        //mettre le panel sur la Jframe
        setContentPane(panel);
        //positionner les champs correctement
        pack();
        //Va centrer la fenêtre
        setLocationRelativeTo(null);
        //Ferme l'application quand on clique sur la croix rouge
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnRetourner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //retour();

            }
        });
    }

    private static FrmRechercher uniqueInstance = null;
    public static FrmRechercher getInstance(String texte){ //on utilise getInstance comme si c'était le constructeur !
        //avec le texte en param, la recherche va marcher une seule fois, on veut pouvoir reinitialiser la recherche en cas d'un nouveau texte

        if(uniqueInstance == null){uniqueInstance = new FrmRechercher(texte);}
        //l'idéee est bonne de vouloir passer le texte par içi, mais en pratique ça ne marchera pas (car Static)
        //---> Version Facile
        uniqueInstance.lblValeur.setText(texte);
        return uniqueInstance;

    }

    private void autreMethode(String texte){
        this.lblValeur.setText(texte);
    }
/**
    private void retour() {
        System.out.println("clique sur le bouton retour....");
        String valeurDeRetour = tfValeurARetourner.getText();
        FrmPrincipale.recupererDesValeurs(valeurDeRetour);
        dispose();
    }
 */
}
