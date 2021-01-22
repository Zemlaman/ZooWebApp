package cz.educanet.webik;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CaretakerManager {

    ArrayList<Caretaker> caretakers = new ArrayList<>();
    private int id = 0;

    public void addNewCartaker(Caretaker caretaker) {
        id++;
        caretaker.setId(id);
        caretakers.add(caretaker);
    }

    public Caretaker getCaretaker(int id) {
        for (int i = 0; i < caretakers.size(); i++) {
            if (id == caretakers.get(i).id) {
                return caretakers.get(i);
            }
        }
        return null;
    }

    public ArrayList<Caretaker> getAllCaretakers() {
        return caretakers;
    }

    public boolean deleteCaretaker(int id) {
        if(caretakerCheck(id) == true){
            return caretakers.remove(caretakerCheck(id));
        }return false;
    }

    public boolean caretakerCheck(int id) {
        for (int i = 0; i < caretakers.size(); i++) {
            if (id == caretakers.get(i).id) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
