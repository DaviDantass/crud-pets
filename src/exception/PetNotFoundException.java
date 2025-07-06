package exception;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException() {
        super("Pet não encontrado");
    }
    public PetNotFoundException(String message) {
        super(message);
    }
}
