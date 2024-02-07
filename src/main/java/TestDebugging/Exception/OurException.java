package TestDebugging.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OurException {
    private static final Logger logger = LoggerFactory.getLogger(OurException.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> comexception(Exception e)
    {

        return new ResponseEntity<String>(e.getMessage()+"----custom exception", HttpStatus.BAD_REQUEST);
    }
}
