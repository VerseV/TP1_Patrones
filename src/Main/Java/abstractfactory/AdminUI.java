package Main.Java.abstractfactory;

import lombok.ToString;

@ToString
public class AdminUI  implements InterfazUI{
    @Override
    public void mostrarInterfaz() {
        System.out.println("Interfaz de administrador: gestión completa de la biblioteca.");
    }
}
