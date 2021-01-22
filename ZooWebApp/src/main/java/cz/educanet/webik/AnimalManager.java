package cz.educanet.webik;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AnimalManager {

    ArrayList<Animal> animals = new ArrayList<>();
    private int id = 0;

    public void addNewAnimal(Animal animal) {
        id ++;
        animal.setId(id);
        animals.add(animal);
    }

    public Animal getAnimal(int id) {
        for (int i = 0; i < animals.size(); i++) {
            if (id == animals.get(i).id) {
                return animals.get(i);
            }
        }
        return null;
    }

    public ArrayList<Animal> getAllAnimals() {
        return animals;
    }

    public boolean deleteAnimal(int id) {
        return animals.remove(animalCheck(id));
    }

    public boolean animalCheck(int id) {
        for (int i = 0; i < animals.size(); i++) {
            if (id == animals.get(i).id) {
                return true;
            } else {
                return false;
            }
        } return false;
    }
}


