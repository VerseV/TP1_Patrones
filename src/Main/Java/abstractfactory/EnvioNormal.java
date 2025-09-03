package Main.Java.abstractfactory;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
public class EnvioNormal implements MetodoEnvio{

    @Override
    public void enviar(){
        System.out.println("Envío normal: llegará en 5 días.");
    }
}