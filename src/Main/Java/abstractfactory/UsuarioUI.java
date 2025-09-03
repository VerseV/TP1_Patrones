package Main.Java.abstractfactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioUI implements Main.Java.abstractfactory.InterfazUI {

    @Override
    public void mostrarInterfaz(){
        System.out.println("Interfaz de usuario: búsqueda y lectura de libros.");
    }
}
