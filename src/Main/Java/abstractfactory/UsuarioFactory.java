package Main.Java.abstractfactory;

public class UsuarioFactory implements Main.Java.abstractfactory.AbstractFactory {
    @Override
    public Main.Java.abstractfactory.InterfazUI crearUI() {
        return new UsuarioUI();
    }

    @Override
    public Main.Java.abstractfactory.MetodoEnvio crearEnvio() {
        return new Main.Java.abstractfactory.EnvioNormal();
    }
}
