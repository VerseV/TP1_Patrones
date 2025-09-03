package Main.Java.builder;

import lombok.*;

@Builder
@Getter
@ToString

public class Usuario {
    //Campos obligatorios
    @NonNull
    private String nombre;
    @NonNull
    private String email;
    //Campos opcionales
    private String apellido;
    private String tipoUsuario; // Ej: "Admin", "Cliente"
    private Integer edad;
}