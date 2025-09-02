package Main;

import Main.Java.abstractfactory.*;
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
        Libro lib1 = LogisticalLibro.crearLibro("Digital", "Effective Java", "Joshua Bloch");
        Libro lib2 = LogisticalLibro.crearLibro("Fisico", "Structured Computer Organization", "Andrew S. Tanenbaum");

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
        .nombre("Mateo")
        .apellido("Espinola")
        .email("agustinschneiter19@gmail.com")
        .tipoUsuario("Admin")
        .edad(22)
        .build();

        Usuario usuario2 = Usuario.builder()
        .nombre("Victoria")
        .apellido("Acosta")
        .email("vico.ac2507@gmail.com")
        .tipoUsuario("Cliente")
        .build(); // Edad opcional

        System.out.println("Usuario 1: " + usuario1);
        System.out.println("Usuario 2: " + usuario2);

    }
}
