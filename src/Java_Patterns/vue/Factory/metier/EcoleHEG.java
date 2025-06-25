package Java_Patterns.vue.Factory.metier;

public class EcoleHEG extends Ecole{

    @Override
    public PersonneFactory creerPersonne(String[] data) {
        PersonneFactory pers = null;

        switch (data[0]){
            case "PROF" : pers = new Prof(data[1], data[2], data[3]); break;
            case "ASSISTANT" : pers = new Assistant(data[1], data[2], data[3]); break;

        }
        return pers;
    }
}
