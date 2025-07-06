package exception;

public class InvalidPetException extends RuntimeException {
    public InvalidPetException() {
        super("Pet inválido");
    }
    public InvalidPetException(String message) {
        super(message);
    }
}
