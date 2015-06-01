package customException;

/**
 * Created by lzielinski on 22/05/2015.
 */
public class PersistDiaryException extends Exception {

    private static final String message = "No se pudo efectuar la operacion, fallo en la persistencia, intentelo nuevamente.";

    public PersistDiaryException() {
        super(message);
    }
}
