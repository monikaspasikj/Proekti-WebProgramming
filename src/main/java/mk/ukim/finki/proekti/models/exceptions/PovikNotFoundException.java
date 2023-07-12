package mk.ukim.finki.proekti.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PovikNotFoundException extends RuntimeException{

    public PovikNotFoundException() {
        super("Povik not found!");
    }
}
