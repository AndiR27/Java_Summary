package Java_Patterns;

import vue.Strategy.ApplicStrat;
import vue.Builder.PersonneBuilder;
import vue.Factory.metier.Applic;
import vue.Factory.metier.EcoleHEG;
import vue.Observer.ClasseAbonneTauxObs;
import vue.Observer.ClasseAbonneTauxObs2;
import vue.Observer.LogTauxObs;
import vue.Observer.TauxChangeObs;
import vue.Singleton.Parametre;
import vue.Singleton.Personne;
import vue.Threads.*;
import vue.Strategy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    /**
     *     Les designs patterns :
     *     1: Creational : Singleton, factory, etc....
     *     2: Structural : Adapter, Composite, etc....
     *     3: Behavioral : Template Method, State, Mediator, etc...
     *
     *     Grosses utilisation des interfaces, mais pas possible de faire des new sur des interfaces, il faudra ainsi créer des classes concretes
     *     -> pour le new, il faudra ainsi préciser la classe concrete utilisé pour sortir de l'application avec les design patterns
     *
     *
     */

    /**
     * Demo Singleton :
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // SINGLETON :
        System.out.println("Dans l'application .....");
        //Dès qu'on a une classe personne : on peut naturellement faire ceci
        Personne pers1 = new Personne();
        //Pour éviter la création de personne, on peut passer la classe vue.Singleton.Personne en Abstract, ou en Interface
        //Si on veut quand même des instances de personnes (au moins une par exemple) ===> constructeur en privé, pas d'accè
        //On pourra plus faire ça : vue.Singleton.Parametre param = new vue.Singleton.Parametre();
                                // System.out.println(param.getNomEcole());

        //Param pas abstraite, on peut faire des new, mais on voudrait que la classe vue.Singleton.Parametre soit en singleton pour éviter d'avoir plusieurs instances => avec
        // cela si une instance est changée, toutes les autres instance le sont aussi
        Parametre param1 = Parametre.getInstance();
        Parametre param2 = Parametre.getInstance();

        //--------------------------------------------------------------


        //DemoGUI
        System.out.println("Lancement de l'applic principale");
        //Sur le formulaire swing : premier panel, et on pose les composants
        //sur la classe avec le code : gérer le constructeur pour adapter la fenêtre avec IntelliJ
        /** new FrmPrincipale().setVisible(true);*/

        //--------------------------------------------------------------


        //Factory
        // principe avec des classes metiers (Une classe avec des sous-classes qui gère tous les new))
        new Applic(new EcoleHEG());
        //Ainsi une ecole (celle de la HEG par exemple) peut directement travailler avec l'application, n'importe quelle autre ecole peut travailler avec l'application
        //pour autant qu'on rajoutes le type de Personne correspondant à l'ecole, ainsi que la classe EcoleType
        //Personne et Ecole ne seront ainsi jamais touchés, si il y a des traitements nécessaires, on rajoutera des classes !!!

        //--------------------------------------------------------------


        // THREADS
        //Dans le cas normal, il fait les traitements à la suite, mais dans certains cas on voudrait lancer les traitements en paralelle
        traitement1();
        traitement2();
        traitement3();

        // Creation de classes qui font le même travail : a le même impact, le code s'execute l'un après l'autre
        /**
        new Traitement1().run();
        new Traitement2().run();
        new Traitement3().run();
         */

        //Comment faire du multitask :

        //Methode 1) Traitement1 en tant que Thread (extends Thread) -> l'héritage est quand même assez inconvéniant pour le multitask

        //Methode 2) Utilisation du Wrapping -> Variable thread dans une classe Traitement2 -> Il faut implementer Runnable afin de pouvoir lancer le thread

        //Methode 3) Creation du Thread contenant le traitement3
        System.out.println("Debut du programme :");
        Traitement1 tr1 = new Traitement1();
        Traitement2 tr2 = new Traitement2();
        Traitement3 tr3 = new Traitement3(); Thread thread3 = new Thread(tr3);
        System.out.println("On va lancer les threads.....");

        tr1.start();
        tr2.start();
        thread3.start();
        System.out.println("Les threads sont lancés....");
        // Les instructions des starts ne démarrent pas tout de suite le code, on a 3 thread différents mais ils tourneront en même temps
        //Si on veut afficher le message de fin : utilisation d'une methode join de la classe Thread qui attends la fin des Threads

        tr1.join();
        tr2.join();
        thread3.join();

        System.out.println("C'est bon, tout est terminé !");

        // Utilisation d'un compteur -> 2 classes identiques travaillant avec un compte à rebours
        //Il faut ainsi déclarer un compte à rebours
        //Preparation des threads
        CountDownLatch latch = new CountDownLatch(4);
        Traitement4 tr4 = new Traitement4(latch);
        Traitement5 tr5 = new Traitement5(latch);
        Traitement4 tr4b = new Traitement4(latch);
        Traitement5 tr5b = new Traitement5(latch);

        //Demarrage des threads
        tr4.start();
        tr5.start();
        tr4b.start();
        tr5b.start();
        
        //Attends que le compte à rebours finisse (chaque latch.countDown descends le compteur)
        latch.await();

        List<Runnable> lst = new ArrayList<>();
        lst.add(tr1);
        lst.add(tr1);
        lst.add(tr1);
        lst.add(tr2);
        lst.add(tr2);
        lst.add(tr2);

        //Liste d'attente de lancement de thread (içi 4 par 4)
        ExecutorService exec = Executors.newFixedThreadPool(4);
        //Soumettre des taches à notre executeur :
        exec.submit(tr1);
        exec.submit(tr1);
        exec.submit(tr1);
        exec.submit(tr2);

        //Callable :
        Traitement6 tr6a = new Traitement6(11);
        Traitement6 tr6b = new Traitement6(22);
        Traitement6 tr6c = new Traitement6(33);

        //Pool d'executions :
        ExecutorService exec2 = Executors.newFixedThreadPool(3);
        //on va attendre les retours dans une liste d'executions

        //Pool de résultats :
        CompletionService<Integer> lstExec = new ExecutorCompletionService<>(exec);

        //On soumet les taches
        lstExec.submit(tr6a);
        lstExec.submit(tr6b);
        lstExec.submit(tr6c);

        //Take : retourne un Future (dès qu'on a une valeur, elle sera retournée)
        //Dès qu'une tache sera fini, un resultat sera affiché
        //On a 3 Traitement6 avec des code différents, c'est le premier qui fini qui aura son code de retourné
        Future<Integer> result = lstExec.take();
        System.out.println("==========> " + result.get());

        exec.shutdown();
        System.out.println("Fin des traitements6....");

        //Notions de synchronized, wait(), notify() ... :
        Compte cpt = new Compte(11, 1000);
        cpt.depose(222);
        System.out.println(cpt);

        Bancomat bancomat1 = new Bancomat(cpt, 200);
        Bancomat bancomat2 = new Bancomat(cpt, 55);

        bancomat1.start();
        bancomat2.start();

        bancomat1.join();
        bancomat2.join();
        //Avec le join, on s'assure que notre thread soit terminé avant de passer à la suite
        //Problématique si on lance les 2 thread en même temps -> On travaille 2x sur le même compte
        //Utiliser le SYNCHRONIZED sur la methode de depose dans compte -> ATOMIQUE
        //Evite d'intérompre la methode tant qu'elle n'est pas finie -> Aucun travail en paralelle ne sera effectué
        System.out.println(cpt);

        //--------------------------------------------------------------

        //Builder
        //==> à utiliser lorsque le constructeur d'une classe attend bcp de paramètres optionnels
        //PersonneBuilder pb = new PersonneBuilder(1, "test", "test", "M", "IG", "Tous les jours", "B4.14", "rte de jussy", "Geneve");

        //On pourrait ainsi avoir un constructeur avec tout, et un autre avec les valeurs obligatoires -> On rajoute les setters pour les champs non obligatoires
        //PersonneBuilder pb2 = new PersonneBuilder(2, "jean", "paul");

        //Pas très agréable à utiliser
        //On va ainsi utiliser le Design Pattern Inner Builder dans la classe PersonneBuilder
        //Il faut :
        //- Constructeur privé avec tous les champs
        //- Methode build() qui retournera une PersonneBuilder
        //- On aura une classe public (et interne) temporaire qui s'occupe de faire la création
        //- Tous les attributs seront duppliqué dans le builder
        //- Tous les setters seront aussi dans le builder ==> RETOURNE le builder
        //- Methode build() qui renvoit une Personne avec son propre constructeur et données
        //
        PersonneBuilder persb = new PersonneBuilder.Builder(5, "jean", "test")
                .setBureau("B4,14")
                .setAdresse("rte test")
                .setCanton("GE")
                .build();
        //Possibilité de construire des Builders avec des Plugins
        //Settings -> plugin -> chercher "Inner builder" et installer le premier -> Alt-insert sur la classe et on build


        //--------------------------------------------------------------

        //OBSERVER
        System.out.println("Demo Observer");
        TauxChangeObs taux = new TauxChangeObs();
        taux.setTaux(1.10);
        System.out.println(taux);
        //A chaque fois que le taux change, on devrait l'afficher (mais pas pratique de toujours afficher dans le main à chaque changement)
        //On pourrait faire le traitement dans le setter de taux, mais de nouveaux services impliquent des changement dans la classe TauxChangeObs (implique de nombreux test pour vérifier si il n'y a pas de problèmes quelque part)
        //Solution : Prévenir tout ceux qui observent le taux dans setTaux() : setChanged() + notifyObservers()
        //Classe TauxChangeObs doit extends Observable
        //Le main doit être prévenu des changements de taux (ou n'importe quelle autre classe), on l'add :
        taux.addObserver(new ClasseAbonneTauxObs());
        //Toute classe ayant accès à la classe taux sera tenu au courant des modifications
        taux.addObserver(new LogTauxObs());
        //Dans la classe observer : methode update
        //Argument o = le taux
        //Argument arg = paramètre quelconque passé à travers le notifyObservers()
        //Exemple pratique :
        String nomMagasin = "HEG"; //On veut fournir ce paramètre pour l'observer
        //Les classes qui implementent Observer vont avoir un constructeur pour conserver cette valeur
        taux.addObserver(new ClasseAbonneTauxObs2(nomMagasin));
        taux.setTaux(5.5);

        //Seul inconvéniant du Observer : le extends Observable dans la classe Taux
        //Autre façon de faire : on va ajouter une methode addObservers dans la classe Taux

        //ProperytyChangeSupport : nouvelle façon de gérer l'Observer
        //new ApplicStrat("enDur");
        //ça sera le main qui préviendra de la façon de récup les données, mais passer la source à chaque fois est pas ouf
        // --> + pas ouf si on veut de nouvelles methodes de recup de données
        // Solutions : faire des classes en dur pour chaque methode de DAO
        //Pour choisir la methode, ça sera dans l'application, lirePersonne appele la bonne classe en fonction des classes
        //On peut ainsi changer la strat içi :
        PersonnesStratDao.setLoadDataStrategy(new LoadDataCsvStrat());
        new ApplicStrat();


        //Pattern Strategy
        //Principe : avoir la possibilité de changer des traitements de façons dynamique


    }

    public static void traitement1(){
        for(int i=0;i<200; i++){
            System.out.println("" + i);
        }
    }

    public static void traitement2(){
        for(int i=0;i<200; i++){
            System.out.println("     " + i);
        }
    }

    public static void traitement3(){
        for(int i=0;i<200; i++){
            System.out.println("                " + i);
        }
    }

    private static void autreMethode(){
        //vue.Singleton.Parametre param = new vue.Singleton.Parametre();
        Parametre param3 = Parametre.getInstance();

        System.out.println("Ici, dans autreMethode, nomEcole = " + param3.getNomEcole());
        param3.setNomEcole("Nouveau nom");
    }
}
