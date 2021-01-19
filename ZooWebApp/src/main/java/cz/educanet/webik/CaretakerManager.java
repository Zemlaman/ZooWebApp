package cz.educanet.webik;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CaretakerManager {

    Caretaker caretaker = null;

    public static List<Caretaker> caretakers = new ArrayList<Caretaker>();

    public Caretaker getCaretaker(int id) {
        for(int i = 0; i < caretakers.size(); i++){
            if(id == caretakers.get(i).id){
                return caretakers.get(i);
            }
        } return null;
    }

    public Boolean caretakerCheck(Caretaker caretaker) {
        for (int i = 0; i < caretakers.size(); i++) {
            if (caretakers.get(i).getFirstName().equals(caretaker.getFirstName())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
