package nl.scheveschilder.techiteasybackend.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }
    public RecordNotFoundException(long id) {
        super("Dit ID " + id + " niet gevonden");
    }
}
