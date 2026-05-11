package l14.colelctions.inclass.s6;

import java.io.IOException;

public class InsufficientStockException extends RuntimeException {

    public InsufficientStockException(String message) {
        super(message);
    }

}