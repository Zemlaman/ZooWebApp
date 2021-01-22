package cz.educanet.webik;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AnimalManager {

    public static ArrayList<Animal> animals = new ArrayList<>();
    private int id = 0;

    public Animal addNewAnimal(Animal animal) {
        id ++;
        animal.setId(id);
        animals.add(animal);
        return animal;
    }

    public boolean editAnimal(int id, Animal animal){
        Animal animalToChange = getAnimal(id);

        if(animalCheck(id)){
            animal.setName(animalToChange.getName());
            animal.setAge(animalToChange.getAge());
            animal.setWeight(animalToChange.getWeight());
            animal.setGender(animalToChange.getGender());
            return true;
        }else{
            return false;
        }
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
        if (animalCheck(id) == true) {
            return animals.remove(animalCheck(id));
        }return false;
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


