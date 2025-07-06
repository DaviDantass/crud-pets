package repository;

import model.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetRepository {
    private final Map<Long, Pet> pets = new HashMap<>();
    private long currentId = 0;

    public void save(Pet pet) {
        if (pet.getId() == null || pet.getId() == 0) {
            pet.setId(++currentId);
        }
        pets.put(pet.getId(), pet);
    }
    public Pet findById(Long id) {
        return pets.get(id);
    }
    public List<Pet> findAll() {
        return new ArrayList<>(pets.values());
    }
    public void deleteById(Long id) {
        pets.remove(id);
    }
    public boolean existsById(Long id) {
        return pets.containsKey(id);
    }
}
