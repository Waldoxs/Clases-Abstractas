package org.osantos.pooclasesabstractas.form.validador;

abstract public class Validador {

    protected String mensaje;

    //Metodos abstractos

    abstract public void setMensaje(String mensaje);

    abstract public String getMensaje();

    abstract public boolean esValido(String valor);
}
