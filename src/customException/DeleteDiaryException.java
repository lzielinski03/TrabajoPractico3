package customException;

/**
 * Created by lzielinski on 22/05/2015.
 */
public class DeleteDiaryException extends Exception {

    private static final String message = "No se pudo efectuar la operacion, fallo al eliminar, intentelo nuevamente.";

    public DeleteDiaryException() {
        super(message);
    }
}
