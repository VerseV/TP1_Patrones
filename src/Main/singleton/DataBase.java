package Main.singleton;

import java.util.ArrayList;
import java.util.List;
import Main.factory.Libro;

public class DataBase {
    private static DataBase instance;
    private List<Libro> libros;

    private DataBase() {
        libros = new ArrayList<>();
    }

    public static synchronized DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> getLibros() {
        return libros;
    }
}