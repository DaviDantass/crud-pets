package application;

import repository.PetRepository;
import service.PetService;

public class Program {
    public static void main(String[] args) {
        PetRepository repo = new PetRepository();
        PetService service = new PetService(repo);
    }
}
