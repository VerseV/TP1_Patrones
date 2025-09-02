package Main.Java.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public abstract class Libro {
    private String titulo;
    private String autor;
}
