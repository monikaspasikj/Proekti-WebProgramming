package mk.ukim.finki.proekti.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CallNotFoundException extends RuntimeException {

    public CallNotFoundException() {
        super("Call not found!");
    }
}
