package customException;

/**
 * Created by lzielinski on 22/05/2015.
 */
public class LoadDiaryException extends Exception{

    private static final String message = "No se pudo efectuar la operacion, fallo al obtener el diario, intentelo nuevamente.";

    public LoadDiaryException() {
        super(message);
    }
}
