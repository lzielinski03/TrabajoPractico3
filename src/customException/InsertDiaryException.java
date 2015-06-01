package customException;

/**
 * Created by lzielinski on 22/05/2015.
 */
public class InsertDiaryException extends Exception{

    private static final String message = "No se pudo efectuar la operacion, fallo en la insercion, intentelo nuevamente.";

    public InsertDiaryException() {
        super(message);
    }
}
