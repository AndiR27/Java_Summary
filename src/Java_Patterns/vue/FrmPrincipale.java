package Java_Patterns.vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipale extends JFrame{ //notre fenêtre va extends toutes les fonctionnalités de Jframe

    private JPanel panel;
    private JTextField tfNom;
    private JButton btnXyz;
    private JLabel lblResultat;

    public FrmPrincipale() {
        //mettre le panel sur la Jframe
        setContentPane(panel);
        //positionner les champs correctement
        pack();
        //Va centrer la fenêtre
        setLocationRelativeTo(null);
        //Ferme l'application quand on clique sur la croix rouge
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnXyz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rechercher();
            }
        });
    }

    private void rechercher() {
        System.out.println("J'ai cliqué sur le bouton......");
        //new FrmRechercher().setVisible(true);
        //fenêtre de recherche est en Singleton, comme ça lorsqu'on reclique dessus, n'en ouvre pas une 2ème
        FrmRechercher.getInstance(tfNom.getText()).setVisible(true);

    }

    //on veut récupérer des valeurs depuis la fenêtre recherche dans notre fenêtre principale
    //on peut faire une methode static, comme ça possibilité d'appel dans la methode retour, mais pas le meilleur choix

    public void recupererDesValeurs(String val){}
}
