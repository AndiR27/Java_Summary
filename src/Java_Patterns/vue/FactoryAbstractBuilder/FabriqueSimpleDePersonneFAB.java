package Java_Patterns.vue.FactoryAbstractBuilder;

public class FabriqueSimpleDePersonneFAB {

    public static PersonneFAB newPersonne(String type, int no, String nom, String prenom){
        switch (type){
            case "PROF": return new ProfFAB(no, nom, prenom);
            case "ASSISTANT": return new AssistantFAB(no, nom, prenom);
        }
        //Mieux vaut déclencher des exceptions plutôt que de retourner un null
        throw new RuntimeException("Type de personne non traité par la fabrique");
    }
}
