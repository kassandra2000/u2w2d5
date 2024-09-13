package kassandrafalsitta.u2w2d5.exceptions;

import java.util.UUID;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(UUID id){
        super("L'elemento con id " + id + " non è stato trovato!");
    }
}
