package Main;

import Main.Java.singleton.DataBase;
import Main.Java.factory.Libro;

public class Main {
    public static void main(String[] args) {
        // Obtenemos la "instancia única" del Singleton
        DataBase db1 = DataBase.getInstance();
        DataBase db2 = DataBase.getInstance();

        // Verificamos que es la misma instancia
        System.out.println("¿Es la misma instancia? " + (db1 == db2));

        // Agregamos libros (usamos db1 y db2 indistintamente, es la misma instancia)
        db1.agregarLibro(new Libro("El Principito", "Antoine de Saint-Exupéry"));
        db2.agregarLibro(new Libro("Ficciones", "Jorge Luis Borges"));

        // Listamos los libros (da lo mismo con db1 o db2)
        System.out.println("Libros en la BD:");
        db1.getLibros().forEach(System.out::println);
    }
}
