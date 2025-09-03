package Main.Java.abstractfactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EnvioExpress implements MetodoEnvio {

    @Override
    public void enviar(){
        System.out.println("Envío express: llegará en 24 horas.");
    }
}