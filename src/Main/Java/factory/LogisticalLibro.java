package Main.Java.factory;

public class LogisticalLibro {
    
    public static Libro crearLibro(String tipo, String titulo, String autor) {
        if (tipo.equalsIgnoreCase("Digital")) return new LibroDigital(titulo, autor);
        else return new LibroFisico(titulo, autor);
    }
}
