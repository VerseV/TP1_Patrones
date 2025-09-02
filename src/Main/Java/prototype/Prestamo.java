package Main.Java.prototype;

import Main.Java.builder.Usuario;
import Main.Java.factory.Libro;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class Prestamo implements Cloneable{
    private Libro libros;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Override //sobreescribo metodo que viene de clase padre(Object), para que use esa version y no la por defecto
              //en este caso sobreescribimos clone(), esta en Object(clase importada automaticamente)
    public Prestamo clone(){
        try{
            return (Prestamo) super.clone(); //SHALLOW
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
