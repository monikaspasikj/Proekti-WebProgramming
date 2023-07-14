package mk.ukim.finki.proekti.models.exceptions;

public class NationalProjectNotFoundException extends RuntimeException {

    public NationalProjectNotFoundException() {
        super("National Project not found!");
    }

}
