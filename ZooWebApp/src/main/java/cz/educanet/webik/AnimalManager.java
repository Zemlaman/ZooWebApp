package cz.educanet.webik;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AnimalManager {

    Animal animal = null;

    public static List<Animal> animals = new ArrayList<Animal>();

    public Animal getAnimal(int id) {
        for(int i = 0; i < animals.size(); i++){
            if(id == animals.get(i).id){
                return animals.get(i);
            }
        } return null;
    }

    public Boolean animalCheck(Animal animal) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equals(animal.getName())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
