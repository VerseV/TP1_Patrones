package Main;

import Main.Java.abstractfactory.*;
import Main.Java.prototype.Prestamo;
import Main.Java.singleton.DataBase;
import Main.Java.factory.Libro;
import Main.Java.factory.LogisticalLibro;
import Main.Java.builder.Usuario;


public class Main {
    public static void main(String[] args) {

        // Obtenemos la "instancia única" del Singleton
        DataBase db1 = DataBase.getInstance();
        DataBase db2 = DataBase.getInstance();

        // Verificamos que es la misma instancia
        System.out.println("¿Es la misma instancia? " + (db1 == db2));

        //NO FUNCIONA MÁS PORQUE SE APLICÓ FACTORY METHOD
        // Agregamos libros (usamos db1 y db2 indistintamente, es la misma instancia)
        //db1.agregarLibro(new Libro("El Principito", "Antoine de Saint-Exupéry"));
        //db2.agregarLibro(new Libro("Ficciones", "Jorge Luis Borges"));

        // ==============================
        // PARTE 2 - Factory Method + Singleton
        // ==============================
        System.out.println("\n=== PARTE 2: Factory Method + Singleton ===");

        // Crear libros usando el Factory Method
        Libro lib1 = LogisticalLibro.crearLibro("Digital", "El Principito", "Antoine de Saint-Exupéry");
        Libro lib2 = LogisticalLibro.crearLibro("Fisico", "Ficciones", "Jorge Luis Borges");

        // Agregar los libros a la base de datos
        db1.agregarLibro(lib1);
        db2.agregarLibro(lib2);


        // Listamos los libros (da lo mismo con db1 o db2)
        System.out.println("Libros en la BD:");
        db1.getLibros().forEach(System.out::println);
        // ==============================
        // PARTE 3 - Abstract Factory
        // ==============================
        AbstractFactory adminFactory = new AdminFactory();
        AbstractFactory usuarioFactory = new UsuarioFactory();

        // Crear objetos de Admin
        InterfazUI adminUI = adminFactory.crearUI();
        MetodoEnvio adminEnvio = adminFactory.crearEnvio();

        // Crear objetos de Usuario
        InterfazUI usuarioUI = usuarioFactory.crearUI();
        MetodoEnvio usuarioEnvio = usuarioFactory.crearEnvio();

        // Mostrar comportamientos
        System.out.println("\n=== PARTE 3: ADMIN ===");
        adminUI.mostrarInterfaz();
        adminEnvio.enviar();

        System.out.println("\n=== PARTE 3: USUARIO ===");
        usuarioUI.mostrarInterfaz();
        usuarioEnvio.enviar();
        // ==============================
        // PARTE 4 - Builder
        // ==============================
        System.out.println("\n=== PARTE 4: Builder ===");

        Usuario usuario1 = Usuario.builder()
                .nombre("Lucía")
                .apellido("Gómez")
                .email("lucia.gomez@example.com")
                .tipoUsuario("Admin")
                .edad(30)
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Tomás")
                .apellido("Pérez")
                .email("tomas.perez@example.com")
                .tipoUsuario("Cliente")
                .build(); // Edad opcional

        System.out.println("Usuario 1: " + usuario1);
        System.out.println("Usuario 2: " + usuario2);


          // ==============================
         // PARTE 5 - Prototype
        // ==============================
       System.out.println("\n=== PARTE 5: Prototype ===");

      // Crear un préstamo original
        Prestamo prestamoOriginal = new Prestamo(
            lib1,                     // usamos el libro digital creado antes
            usuario1,                 // usamos el usuario creado con Builder
            java.time.LocalDate.now(),
            java.time.LocalDate.now().plusDays(7)
    );

      // Clonar el préstamo
        Prestamo prestamoClon1 = prestamoOriginal.clone();
        Prestamo prestamoClon2 = prestamoOriginal.clone();

      // Modificar los clones
        prestamoClon1.setUsuario(usuario2); // prestamo con otro usuario
        prestamoClon2.setFechaFin(java.time.LocalDate.now().plusDays(14));

      // Mostrar resultados
        System.out.println("Original: "+prestamoOriginal);
        System.out.println("Clon 1:   "+prestamoClon1);
        System.out.println("Clon 2:   "+prestamoClon2);

}
}

