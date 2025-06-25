package Java_Patterns.vue.FactoryAbstractBuilder;

public class FabriqueStaticDePersonneFAB {
    public static PersonneFAB newProf(int no, String nom, String prenom){

        return new ProfFAB(no, nom, prenom);
    }

    public static PersonneFAB newAssistant(int no, String nom, String prenom) {
        return new AssistantFAB(no, nom, prenom);
    }
}
