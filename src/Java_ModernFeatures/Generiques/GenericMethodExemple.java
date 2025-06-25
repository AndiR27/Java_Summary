package Java_ModernFeatures.Generiques;

import java.util.Date;

public class GenericMethodExemple {

    /**
     * En utilisant les génériques, développer une méthode unique qui permet
     * d’additionner 2 nombres donnés en paramètre.
     * - Cette méthode retourne le résultat en conservant les décimales.
     * - Le premier nombre doit être un Integer.
     * - Le second nombre peut être : int, long, float ou double.
     * Faire en sorte que le code déjà implémenté compile
     * et s'exécute correctement.
     */

    //METHODE A FAIRE :
    public <T extends Number> double addBoth(Integer n1, T n2){
        return n1 + n2.doubleValue();
    }



}

