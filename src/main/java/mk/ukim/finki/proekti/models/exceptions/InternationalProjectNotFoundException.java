package mk.ukim.finki.proekti.models.exceptions;

public class InternationalProjectNotFoundException extends RuntimeException {

    public InternationalProjectNotFoundException() {
        super("International Project not found!");
    }

}
