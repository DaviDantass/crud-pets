package service;


import exception.InvalidPetException;
import exception.PetNotFoundException;
import model.Pet;
import repository.PetRepository;

import java.util.List;

public class PetService {
    private PetRepository repository;
    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public void adicionarPet(Pet pet) {
        repository.save(pet);
    }
    public void removerPetPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new PetNotFoundException("Não existe pet com id " + id);
        }
        repository.deleteById(id);
    }
    public Pet buscarPetPorId(Long id) {
        Pet pet = repository.findById(id);
        if (pet == null) {
            throw new PetNotFoundException("Pet com id " + id + "não encontrado");
        }
        return pet;
    }
    public List<Pet> buscarTodos() {
        List<Pet> pets = repository.findAll();
        if (pets.isEmpty()) {
            throw new PetNotFoundException("Nenhum pet cadastrado");
        }
        return pets;
    }
    public void validarPet(Pet pet) {
        if (pet == null) {
            throw new InvalidPetException("Pet não pode ser nulo");
        }
        if(pet.getNome() == null || pet.getNome().trim().isEmpty()) {
            throw new InvalidPetException("Nome não pode ser vazio");
        }
        if(pet.getTipo() == null || pet.getTipo().trim().isEmpty()) {
            throw new InvalidPetException("O Tipo não pode ser vazio");
        }
    }
    public void atualizarPet(Long id, Pet novoPet) {
        if(!repository.existsById(id)) {
            throw new PetNotFoundException("Não existe pet com id " + id);
        }
        novoPet.setId(id);
        validarPet(novoPet);
        repository.save(novoPet);
    }
}
