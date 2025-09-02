import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String tipoUsuario; // Ej: "Admin", "Cliente"
    private Integer edad;
}
