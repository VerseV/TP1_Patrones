package Main.Java.abstractfactory;

public class AdminFactory implements Main.Java.abstractfactory.AbstractFactory {
    @Override
    public InterfazUI crearUI() {
        return new AdminUI();
    }

    @Override
    public MetodoEnvio crearEnvio() {
        return new EnvioExpress(); // el admin tiene privilegios de envío rápido
    }
}