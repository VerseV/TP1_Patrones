package Main.Java.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

import Main.Java.factory.*;   // Para Libro, LibroDigital, LibroFisico
import Main.Java.builder.Usuario;

@Getter
@Setter
@AllArgsConstructor
public class Prestamo implements Cloneable {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Override
    public Prestamo clone() {
        try {
            // Shallow copy (copia solo referencias)
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    // Deep copy (clona también objetos internos)
    public Prestamo deepClone() {
        try {
            Prestamo cloned = (Prestamo) super.clone();

            // Clonar Libro según su tipo concreto
            if (libro instanceof LibroDigital) {
                cloned.libro = new LibroDigital(libro.getTitulo(), libro.getAutor());
            } else if (libro instanceof LibroFisico) {
                cloned.libro = new LibroFisico(libro.getTitulo(), libro.getAutor());
            }

            // Clonar Usuario usando Builder
            cloned.usuario = Usuario.builder()
                    .nombre(usuario.getNombre())
                    .apellido(usuario.getApellido())
                    .email(usuario.getEmail())
                    .tipoUsuario(usuario.getTipoUsuario())
                    .edad(usuario.getEdad())
                    .build();

            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

